
package xyz.aflkonstukt.purechaos.potion;

import xyz.aflkonstukt.purechaos.procedures.LymeDiseaseOnEffectActiveTickProcedure;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import java.util.Set;

public class LymeDiseaseMobEffect extends MobEffect {
	public LymeDiseaseMobEffect() {
		super(MobEffectCategory.HARMFUL, -16751104);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
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
