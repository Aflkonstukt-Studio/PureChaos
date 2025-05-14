package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;

public class ShowThirst9HalfProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ShowThirstBarProcedure.execute(entity)) {
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).thirst >= 85 && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).thirst <= 90) {
				return true;
			}
		}
		return false;
	}
}
