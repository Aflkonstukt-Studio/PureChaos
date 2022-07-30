
package xyz.vikkivuk.chaosmod.potion;

import xyz.vikkivuk.chaosmod.procedures.HighProcedure;
import xyz.vikkivuk.chaosmod.procedures.HighEffectEffectExpiresProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class HighEffectMobEffect extends MobEffect {
	public HighEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -16737793);
	}

	@Override
	public String getDescriptionId() {
		return "effect.chaosmod.high_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		HighProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		HighEffectEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
