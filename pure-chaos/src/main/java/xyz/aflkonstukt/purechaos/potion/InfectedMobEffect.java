
package xyz.aflkonstukt.purechaos.potion;

import xyz.aflkonstukt.purechaos.procedures.InfectedOnEffectActiveTickProcedure;
import xyz.aflkonstukt.purechaos.procedures.InfectedEffectStartedappliedProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class InfectedMobEffect extends MobEffect {
	public InfectedMobEffect() {
		super(MobEffectCategory.HARMFUL, -3407872);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		InfectedEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		InfectedOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
