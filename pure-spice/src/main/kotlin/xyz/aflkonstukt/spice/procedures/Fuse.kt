package xyz.aflkonstukt.spice.procedures

import net.minecraft.core.particles.ParticleTypes
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.player.Player
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.tick.ServerTickEvent
import java.util.UUID

@EventBusSubscriber
object Fuse {
    private const val RANGE = 3.0
    private const val MAX_SCALE = 10.0
    private val SCALE_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "generic.scale")
    private val HEALTH_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "generic.max_health")

    @SubscribeEvent
    fun onServerTick(event: ServerTickEvent.Post) {
        if (event.server.tickCount % 2 != 0) return

        for (level in event.server.allLevels) {
            if (level.isClientSide) continue

            val alreadyFused = mutableSetOf<LivingEntity>()

            val entities = level.entities.all
                .filterIsInstance<LivingEntity>()
                .filter { it !is Player }

            for (entity in entities) {
                if (entity in alreadyFused) continue
                
                // Skip if entity is already at max scale
                val currentScale = getEntityScale(entity)
                if (currentScale >= MAX_SCALE) continue

                val box = entity.boundingBox.inflate(RANGE)
                val nearby = level.getEntitiesOfClass(
                    LivingEntity::class.java, box
                ) { 
                    it != entity && 
                    it !is Player && 
                    it !in alreadyFused &&
                    it.type == entity.type // Only fuse entities of the same type
                }

                val closestEntity = nearby.minByOrNull { entity.distanceTo(it) }
                val closestDistance = closestEntity?.let { entity.distanceTo(it) } ?: Double.MAX_VALUE

                if (closestEntity != null && closestDistance.toDouble() <= RANGE) {
                    // Remove the other entity (fuse it into this one)
                    closestEntity.discard()

                    // Mark both as fused this tick
                    alreadyFused.add(entity)
                    alreadyFused.add(closestEntity)

                    // Get current scales
                    val entityScale = getEntityScale(entity)
                    val otherScale = getEntityScale(closestEntity)

                    // New scale is the sum, capped at MAX_SCALE
                    val newScale = (entityScale + otherScale).coerceAtMost(MAX_SCALE)

                    // Apply scale
                    applyEntityScale(entity, newScale)
                    
                    // Scale health based on size
                    applyHealthScale(entity, newScale)

                    if (level is ServerLevel) {
                        addParticles(level, entity, closestEntity)
                    }
                }
            }
        }
    }

    private fun getEntityScale(entity: LivingEntity): Double {
        val attr = entity.getAttribute(Attributes.SCALE) ?: return 1.0
        return attr.value
    }

    fun applyEntityScale(entity: LivingEntity, scale: Double) {
        val attr = entity.getAttribute(Attributes.SCALE) ?: return
        val modifier = attr.modifiers.find { it.id == SCALE_MODIFIER_ID }
        if (modifier != null) {
            attr.removeModifier(modifier)
        }
        val newModifier = AttributeModifier(
            SCALE_MODIFIER_ID,
            scale - 1.0, // Additive to base scale of 1.0
            AttributeModifier.Operation.ADD_VALUE
        )
        attr.addTransientModifier(newModifier)
    }
    
    private fun applyHealthScale(entity: LivingEntity, scale: Double) {
        val healthAttr = entity.getAttribute(Attributes.MAX_HEALTH) ?: return
        
        // Remove existing modifier if present
        healthAttr.modifiers.find { it.id == HEALTH_MODIFIER_ID }?.let {
            healthAttr.removeModifier(it)
        }
        
        // Calculate health bonus based on scale
        // We'll double health for each doubling of scale (scale=2 -> 2x health, scale=4 -> 4x health)
        val baseHealth = healthAttr.baseValue
        val healthMultiplier = scale - 1.0 // Scale 1 is normal size, so no bonus
        
        // Add new modifier for health
        val healthModifier = AttributeModifier(
            HEALTH_MODIFIER_ID,
            baseHealth * healthMultiplier, // Add bonus health based on scale
            AttributeModifier.Operation.ADD_VALUE
        )
        healthAttr.addTransientModifier(healthModifier)
        
        // Heal entity to match new max health
        val healthPercent = entity.health / entity.maxHealth
        entity.health = entity.maxHealth * healthPercent // Preserve health percentage
    }

    private fun addParticles(level: ServerLevel, entity: LivingEntity, nearbyEntity: LivingEntity) {
        val particlePos = entity.position().add(
            (nearbyEntity.position().x - entity.position().x) / 2,
            (nearbyEntity.position().y - entity.position().y) / 2,
            (nearbyEntity.position().z - entity.position().z) / 2
        )
        level.sendParticles(
            ParticleTypes.PORTAL,
            particlePos.x,
            particlePos.y + 0.5,
            particlePos.z,
            2, 0.0, 0.0, 0.0, 0.1
        )
    }
}