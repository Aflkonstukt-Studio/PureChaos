
package xyz.aflkonstukt.purechaos.potion;

import xyz.aflkonstukt.purechaos.procedures.RadiationPoisioningActiveTickConditionProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class RadiationPoisioningMobEffect extends MobEffect {
	public RadiationPoisioningMobEffect() {
		super(MobEffectCategory.HARMFUL, -16711936);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		RadiationPoisioningActiveTickConditionProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
