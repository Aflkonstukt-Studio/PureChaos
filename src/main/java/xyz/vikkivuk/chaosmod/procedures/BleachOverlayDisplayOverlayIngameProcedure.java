package xyz.vikkivuk.chaosmod.procedures;

import xyz.vikkivuk.chaosmod.init.ChaosmodModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class BleachOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(ChaosmodModMobEffects.BLEACHED.get()) : false) {
			return true;
		} else if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(ChaosmodModMobEffects.BLIND.get()) : false) {
			return true;
		}
		return false;
	}
}
