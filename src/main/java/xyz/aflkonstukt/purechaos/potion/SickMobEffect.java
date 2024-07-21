
package xyz.aflkonstukt.purechaos.potion;

import xyz.aflkonstukt.purechaos.procedures.SickEffectStartedappliedProcedure;
import xyz.aflkonstukt.purechaos.procedures.SickEffectSlayedProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;

public class SickMobEffect extends InstantenousMobEffect {
	public SickMobEffect() {
		super(MobEffectCategory.HARMFUL, -16711885);
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		SickEffectSlayedProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		SickEffectStartedappliedProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
