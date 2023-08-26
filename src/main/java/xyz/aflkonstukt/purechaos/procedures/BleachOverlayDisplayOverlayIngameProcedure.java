package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class BleachOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(PurechaosModMobEffects.BLEACHED.get()) : false) {
			return true;
		} else if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(PurechaosModMobEffects.BLIND.get()) : false) {
			return true;
		}
		return false;
	}
}
