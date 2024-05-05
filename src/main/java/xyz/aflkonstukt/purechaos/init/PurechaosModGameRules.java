
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurechaosModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DOGRAVECREATION = GameRules.register("doGraveCreation", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> DOBOSSSPAWNING = GameRules.register("doBossSpawning", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> VEGANISM = GameRules.register("veganism", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> DISABLE_CAPTCHA = GameRules.register("disableCaptcha", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> ADBLOCKER = GameRules.register("adblocker", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
