
package xyz.aflkonstukt.purechaos.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FatMobEffect extends MobEffect {
	public FatMobEffect() {
		super(MobEffectCategory.HARMFUL, -3355648);
	}

	@Override
	public String getDescriptionId() {
		return "effect.purechaos.fat";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
