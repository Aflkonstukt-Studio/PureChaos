package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.Difficulty;

public class HECFeatureAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world.getDifficulty() == Difficulty.PEACEFUL) {
			return false;
		}
		return true;
	}
}
