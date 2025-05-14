
package xyz.aflkonstukt.purechaos.potion;

import xyz.aflkonstukt.purechaos.procedures.SaneEffectStartedappliedProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SaneMobEffect extends MobEffect {
	public SaneMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10027213);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		SaneEffectStartedappliedProcedure.execute(entity);
	}
}
