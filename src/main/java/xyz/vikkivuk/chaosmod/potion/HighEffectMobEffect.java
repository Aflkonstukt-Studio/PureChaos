
package xyz.vikkivuk.chaosmod.potion;

public class HighEffectMobEffect extends MobEffect {

	public HighEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -16737793);
	}

	@Override
	public String getDescriptionId() {
		return "effect.chaosmod.high_effect";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		HighProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		HighEffectEffectExpiresProcedure.execute(

		);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
