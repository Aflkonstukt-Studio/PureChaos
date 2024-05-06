package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;

public class Show50SanityProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity <= 50 && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity >= 25 && !PurechaosModVariables.show_sanity_label) {
			return true;
		}
		return false;
	}
}
