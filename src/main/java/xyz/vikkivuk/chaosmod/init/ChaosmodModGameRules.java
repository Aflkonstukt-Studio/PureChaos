
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChaosmodModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DOGRAVECREATION = GameRules.register("doGraveCreation", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> DROPMUMBOTOKENS = GameRules.register("dropMumboTokens", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> DOBOSSSPAWNING = GameRules.register("doBossSpawning", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
}
