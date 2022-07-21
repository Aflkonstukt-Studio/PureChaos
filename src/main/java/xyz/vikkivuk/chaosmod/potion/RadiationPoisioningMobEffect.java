
package xyz.vikkivuk.chaosmod.potion;

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
		RadiationPoisioningActiveTickConditionProcedure.execute(

		);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
