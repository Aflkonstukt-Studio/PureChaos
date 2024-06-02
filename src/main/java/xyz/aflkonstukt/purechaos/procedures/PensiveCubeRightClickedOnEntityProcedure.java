package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModGameRules;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class PensiveCubeRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getLevelData().getGameRules().getBoolean(PurechaosModGameRules.DISABLE_CAPTCHA)) {
			HandleNewCaptchaProcedure.execute(world, x, y, z, entity);
		}
	}
}
