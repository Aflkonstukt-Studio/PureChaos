package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class InfectedOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PurechaosModMobEffects.INFECTED) ? _livEnt.getEffect(PurechaosModMobEffects.INFECTED).getAmplifier() : 0) >= 2) {
			return true;
		}
		return false;
	}
}
