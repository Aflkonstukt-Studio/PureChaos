package xyz.aflkonstukt.purechaos.procedures;

import virtuoel.pehkui.api.ScaleType;
import virtuoel.pehkui.api.ScaleRegistries;

import net.minecraft.world.entity.Entity;

public class FatEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		for (final ScaleType type : ScaleRegistries.SCALE_TYPES.values()) {
			type.getScaleData(entity).setPersistence(type.getScaleData(entity).getPersistence());
			type.getScaleData(entity).resetScale();
		}
	}
}
