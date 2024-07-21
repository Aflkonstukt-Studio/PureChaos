package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;

public class ShowSanityDisabledProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ShowSanityOverlayProcedure.execute(entity)) {
			return !entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity_enabled;
		}
		return false;
	}
}
