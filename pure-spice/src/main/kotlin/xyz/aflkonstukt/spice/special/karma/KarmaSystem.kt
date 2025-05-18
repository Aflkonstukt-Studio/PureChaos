package xyz.aflkonstukt.spice.special.karma

import net.minecraft.world.entity.player.Player
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.effect.MobEffectInstance
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent
import net.neoforged.neoforge.event.entity.player.PlayerEvent
import net.neoforged.bus.api.SubscribeEvent
import net.minecraft.world.entity.animal.Animal
import net.minecraft.world.entity.monster.Monster
import net.minecraft.world.entity.npc.Villager
import net.neoforged.fml.common.EventBusSubscriber

@EventBusSubscriber
object KarmaSystem {
    private const val KARMA_MAX = 200.0
    private const val KARMA_MIN = -100.0
    
    private fun getPlayerKarma(player: Player): Double {
        return player.getData(PurechaosModVariables.PLAYER_VARIABLES).karma
    }
    
    private fun setPlayerKarma(player: Player, value: Double) {
        val vars = player.getData(PurechaosModVariables.PLAYER_VARIABLES)
        vars.karma = value.coerceIn(KARMA_MIN, KARMA_MAX)
        vars.syncPlayerVariables(player)
        
        // Apply effects based on karma
        applyKarmaEffects(player)
    }
    
    private fun adjustKarma(player: Player, amount: Double) {
        setPlayerKarma(player, getPlayerKarma(player) + amount)
    }
    
    private fun applyKarmaEffects(player: Player) {
        val karma = getPlayerKarma(player)
        when {
            karma <= -50 -> {
                // Bad karma effects
                player.addEffect(MobEffectInstance(MobEffects.UNLUCK, 200, 1))
                player.addEffect(MobEffectInstance(MobEffects.WEAKNESS, 200, 0))
            }
            karma >= 150 -> {
                // Good karma effects
                player.addEffect(MobEffectInstance(MobEffects.LUCK, 200, 1))
                player.addEffect(MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0))
            }
        }
    }

    @SubscribeEvent
    fun onEntityDeath(event: LivingDeathEvent) {
        val source = event.source.entity
        if (source is Player) {
            when (event.entity) {
                is Villager -> adjustKarma(source, -10.0) // Killing villagers is bad
                is Animal -> adjustKarma(source, -5.0)    // Killing animals is slightly bad
                is Monster -> adjustKarma(source, 2.0)    // Killing monsters is good
            }
        }
    }

    @SubscribeEvent
    fun onPlayerRespawn(event: PlayerEvent.PlayerRespawnEvent) {
        // Reset some karma on death
        if (!event.isEndConquered) {
            val player = event.entity
            adjustKarma(player, -10.0)
        }
    }

    // Public methods for other parts of the mod to use
    fun addKarma(player: Player, amount: Double) {
        adjustKarma(player, amount)
    }

    fun removeKarma(player: Player, amount: Double) {
        adjustKarma(player, -amount)
    }

    fun getKarmaLevel(player: Player): String {
        return when (val karma = getPlayerKarma(player)) {
            in -100.0..-50.0 -> "Evil"
            in -49.0..0.0 -> "Bad"
            in 1.0..50.0 -> "Neutral"
            in 51.0..100.0 -> "Good"
            in 101.0..150.0 -> "Saintly"
            in 151.0..200.0 -> "Divine"
            else -> "Unknown"
        }
    }
} 