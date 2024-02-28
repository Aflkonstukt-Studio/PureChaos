package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;

public class SanityOverlayValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Sanity: " + Math.round((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).sanity);
	}
}
