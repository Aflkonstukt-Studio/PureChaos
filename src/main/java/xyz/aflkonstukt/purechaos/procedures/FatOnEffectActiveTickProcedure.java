package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleOperations;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class FatOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ScaleTypes.WIDTH.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.WIDTH.getScaleData(entity).getTargetScale(),
				(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PurechaosModMobEffects.FAT.get()) ? _livEnt.getEffect(PurechaosModMobEffects.FAT.get()).getAmplifier() : 0)));
	}
}
