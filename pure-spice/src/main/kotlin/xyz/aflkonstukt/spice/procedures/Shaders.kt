package xyz.aflkonstukt.spice.procedures

import net.minecraft.client.Minecraft
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelAccessor
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import net.neoforged.bus.api.Event
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.tick.PlayerTickEvent
import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber
object Shaders {
    @SubscribeEvent
    fun onPlayerTick(event: PlayerTickEvent.Post) {
        execute(event.entity.level(), event.entity)
    }

    fun execute(world: LevelAccessor, entity: Entity?) {
        if (entity == null || !world.isClientSide) return

        val mc = Minecraft.getInstance()
        val renderer = mc.gameRenderer
        val currentEffect = renderer.currentEffect()?.name

        // Resource keys and shader locations
        val backroomsDim = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:backrooms_dimension"))
        val nightmareDim = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:nightmare_dimension"))

        val ntscShader = ResourceLocation.parse("purechaos:shaders/minecraft/ntsc.json")
        val methShader = ResourceLocation.parse("purechaos:shaders/meth.json")
        val desaturateShader = ResourceLocation.parse("purechaos:shaders/minecraft/desaturate.json")
        val artShader = ResourceLocation.parse("purechaos:shaders/minecraft/art.json")
        val paleShader = ResourceLocation.parse("purechaos:shaders/pale_shader.json")

        val playerVars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES)

        // Load shader if none is active
        if (renderer.currentEffect() == null) {
            when {
                entity.level().dimension() == backroomsDim -> renderer.loadEffect(ntscShader)
                entity is LivingEntity && entity.hasEffect(PurechaosModMobEffects.HIGH_EFFECT) -> renderer.loadEffect(methShader)
                entity.level().dimension() == nightmareDim -> renderer.loadEffect(desaturateShader)
                entity is LivingEntity && entity.hasEffect(PurechaosModMobEffects.DRUNK) -> renderer.loadEffect(artShader)
                playerVars.lobotomized -> renderer.loadEffect(paleShader)
            }
        } else {
            // Shutdown shaders if conditions are no longer met
            when (currentEffect) {
                methShader.toString() -> {
                    if (entity !is LivingEntity || !entity.hasEffect(PurechaosModMobEffects.HIGH_EFFECT)) {
                        renderer.shutdownEffect()
                    }
                }

                desaturateShader.toString() -> {
                    if (!playerVars.having_nightmare) {
                        renderer.shutdownEffect()
                        if (entity is LivingEntity) entity.removeAllEffects()
                    }
                }

                ntscShader.toString() -> {
                    if (entity.level().dimension() != backroomsDim) {
                        renderer.shutdownEffect()
                    }
                }

                artShader.toString() -> {
                    if (entity !is LivingEntity || !entity.hasEffect(PurechaosModMobEffects.DRUNK)) {
                        renderer.shutdownEffect()
                    }
                }

                paleShader.toString() -> {
                    if (!playerVars.lobotomized) {
                        renderer.shutdownEffect()
                    }
                }
            }
        }
    }
}