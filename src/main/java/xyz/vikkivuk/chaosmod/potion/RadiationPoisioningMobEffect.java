
package xyz.vikkivuk.chaosmod.potion;

import xyz.vikkivuk.chaosmod.procedures.RadiationPoisioningActiveTickConditionProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class RadiationPoisioningMobEffect extends MobEffect {
	public RadiationPoisioningMobEffect() {
		super(MobEffectCategory.HARMFUL, -16711936);
	}

	@Override
	public String getDescriptionId() {
		return "effect.chaosmod.radiation_poisioning";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RadiationPoisioningActiveTickConditionProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
