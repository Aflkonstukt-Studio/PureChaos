package xyz.aflkonstukt.spice.procedures

import net.minecraft.world.entity.ai.attributes.Attributes
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.tick.PlayerTickEvent
import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects

@EventBusSubscriber
object FatEffectScaling {
    @SubscribeEvent
    fun onPlayerTick(event: PlayerTickEvent.Post) {
        val player = event.entity
        val fatEffect = player.getEffect(PurechaosModMobEffects.FAT)

        if (player.isSpectator) return
        if (fatEffect != null) {
            val fatLevel = fatEffect.amplifier + 1
            val scale = 1.0 + (fatLevel * 0.2)
            Fuse.applyEntityScale(player, scale)
        } else {
            // Reset scale if the effect is not present
            val currentScale = player.getAttributeValue(Attributes.SCALE)
            if (currentScale != 1.0) {
                Fuse.applyEntityScale(player, 1.0)
            }
        }
    }
}