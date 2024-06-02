
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurechaosModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> DOGRAVECREATION;
	public static GameRules.Key<GameRules.BooleanValue> DOBOSSSPAWNING;
	public static GameRules.Key<GameRules.BooleanValue> VEGANISM;
	public static GameRules.Key<GameRules.BooleanValue> DISABLE_CAPTCHA;
	public static GameRules.Key<GameRules.BooleanValue> ADBLOCKER;
	public static GameRules.Key<GameRules.IntegerValue> MOB_CAP_MULTIPLIER;
	public static GameRules.Key<GameRules.BooleanValue> MENTAL_HEALTH;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		DOGRAVECREATION = GameRules.register("doGraveCreation", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(true));
		DOBOSSSPAWNING = GameRules.register("doBossSpawning", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
		VEGANISM = GameRules.register("veganism", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		DISABLE_CAPTCHA = GameRules.register("disableCaptcha", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		ADBLOCKER = GameRules.register("adblocker", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		MOB_CAP_MULTIPLIER = GameRules.register("mobCapMultiplier", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(15));
		MENTAL_HEALTH = GameRules.register("mentalHealth", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	}
}
