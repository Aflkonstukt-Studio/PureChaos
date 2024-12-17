
package xyz.aflkonstukt.purechaos.potion;

import xyz.aflkonstukt.purechaos.procedures.HighProcedure;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

public class HighEffectMobEffect extends MobEffect {
	public HighEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16737793);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "effect.high_effect_0"), 2, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "effect.high_effect_1"), 2, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "effect.high_effect_2"), -2, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "effect.high_effect_3"), 10, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		HighProcedure.execute(entity);
	}
}
