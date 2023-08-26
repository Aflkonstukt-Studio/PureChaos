package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModGameRules;

import net.minecraft.world.level.LevelAccessor;

public class JosipdvatockanulaNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameRules().getBoolean(PurechaosModGameRules.DOBOSSSPAWNING);
	}
}
