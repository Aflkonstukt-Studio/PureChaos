
package xyz.vikkivuk.chaosmod.potion;

public class FatMobEffect extends MobEffect {

	public FatMobEffect() {
		super(MobEffectCategory.HARMFUL, -3355648);
	}

	@Override
	public String getDescriptionId() {
		return "effect.chaosmod.fat";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
