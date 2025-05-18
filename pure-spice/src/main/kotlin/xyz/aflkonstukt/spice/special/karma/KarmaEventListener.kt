package xyz.aflkonstukt.spice.special.karma

import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.animal.Animal
import net.minecraft.world.entity.npc.Villager
import net.minecraft.world.entity.monster.Monster
import net.neoforged.neoforge.event.entity.player.PlayerEvent
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent
import xyz.aflkonstukt.purechaos.init.PurechaosModItems

@EventBusSubscriber
object KarmaEventListener {
    
    @SubscribeEvent
    fun onPlayerInteract(event: PlayerInteractEvent.EntityInteract) {
        val player = event.entity
        val target = event.target
        
        // Feeding animals is good
        if (target is Animal && event.itemStack.getFoodProperties(player) != null) {
            KarmaSystem.addKarma(player, 1.0)
        }
        
        // Trading with villagers is good
        if (target is Villager) {
            KarmaSystem.addKarma(player, 0.5)
        }
    }
    
    @SubscribeEvent
    fun onLivingHurt(event: LivingIncomingDamageEvent) {
        val source = event.source.entity
        val target = event.entity

        if (source is Player) {
            when (target) {
                // Attacking peaceful entities is bad
                is Animal, is Villager -> {
                    KarmaSystem.removeKarma(source, 1.0)
                }
                // Attacking monsters is slightly good
                is Monster -> {
                    KarmaSystem.addKarma(source, 0.2)
                }
            }
        }
    }
    
    @SubscribeEvent
    fun onPlayerCraft(event: PlayerEvent.ItemCraftedEvent) {
        val player = event.entity
        val item = event.crafting.item
        
        // Crafting cursed or chaotic items affects karma
        when (item) {
            PurechaosModItems.IMPOSTOR_KNIFE.get() -> KarmaSystem.removeKarma(player, 5.0)
            PurechaosModItems.TOTEM_OF_DREAM.get() -> KarmaSystem.addKarma(player, 5.0)
            PurechaosModItems.BLEACH.get() -> KarmaSystem.removeKarma(player, 2.0)
            PurechaosModItems.ALMOND_WATER.get() -> KarmaSystem.addKarma(player, 2.0)
        }
    }
} 