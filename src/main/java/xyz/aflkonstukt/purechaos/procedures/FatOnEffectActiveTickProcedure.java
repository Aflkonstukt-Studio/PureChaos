package xyz.aflkonstukt.purechaos.procedures;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleOperations;

import net.minecraft.world.entity.Entity;

public class FatOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ScaleTypes.WIDTH.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.WIDTH.getScaleData(entity).getTargetScale(), 2));
	}
}
