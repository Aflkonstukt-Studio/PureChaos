
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChaosmodModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DOJBOSSSPAWNING = GameRules.register("doJBossSpawning", GameRules.Category.SPAWNING,
			GameRules.BooleanValue.create(false));
}
