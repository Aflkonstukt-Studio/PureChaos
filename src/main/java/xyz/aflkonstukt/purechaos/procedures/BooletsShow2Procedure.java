package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;

public class BooletsShow2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 2;
	}
}
