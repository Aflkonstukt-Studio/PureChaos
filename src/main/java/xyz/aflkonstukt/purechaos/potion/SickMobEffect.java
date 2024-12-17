
package xyz.aflkonstukt.purechaos.potion;

import xyz.aflkonstukt.purechaos.procedures.SickEffectStartedappliedProcedure;
import xyz.aflkonstukt.purechaos.procedures.SickEffectSlayedProcedure;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.resources.ResourceLocation;

public class SickMobEffect extends InstantenousMobEffect {
	public SickMobEffect() {
		super(MobEffectCategory.HARMFUL, -16711885);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "effect.sick_0"), -3, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "effect.sick_1"), -3, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "effect.sick_2"), -3, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "effect.sick_3"), -3, AttributeModifier.Operation.ADD_VALUE);
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
