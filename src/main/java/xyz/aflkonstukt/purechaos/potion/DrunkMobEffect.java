
package xyz.aflkonstukt.purechaos.potion;

import xyz.aflkonstukt.purechaos.procedures.DrunkEffectStartedappliedProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DrunkMobEffect extends MobEffect {
	public DrunkMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16711885);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		DrunkEffectStartedappliedProcedure.execute();
	}
}
