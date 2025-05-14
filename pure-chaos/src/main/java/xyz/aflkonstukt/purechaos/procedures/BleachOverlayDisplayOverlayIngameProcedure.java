package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class BleachOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PurechaosModMobEffects.BLEACHED)) {
			return true;
		} else if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PurechaosModMobEffects.BLIND)) {
			return true;
		}
		return false;
	}
}
