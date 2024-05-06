
package xyz.aflkonstukt.purechaos.potion;

import xyz.aflkonstukt.purechaos.procedures.HighProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class HighEffectMobEffect extends MobEffect {
	public HighEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16737793);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		HighProcedure.execute(entity);
	}
}
