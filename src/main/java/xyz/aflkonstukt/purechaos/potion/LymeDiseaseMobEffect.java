
package xyz.aflkonstukt.purechaos.potion;

import xyz.aflkonstukt.purechaos.procedures.LymeDiseaseOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class LymeDiseaseMobEffect extends MobEffect {
	public LymeDiseaseMobEffect() {
		super(MobEffectCategory.HARMFUL, -16751104);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		LymeDiseaseOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
