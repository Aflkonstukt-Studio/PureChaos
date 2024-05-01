package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;

public class BooletsShow5Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).bl5;
	}
}
