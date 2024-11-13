package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class TickChestplateTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 1, 2000) <= 10) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PurechaosModMobEffects.LYME_DISEASE, 99999, 1, false, true));
		}
	}
}
