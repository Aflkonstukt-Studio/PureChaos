package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModGameRules;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;

public class JosipdvatockanulaNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return world.getLevelData().getGameRules().getBoolean(PurechaosModGameRules.DOBOSSSPAWNING) && y >= world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z);
	}
}
