package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;

public class BooletsSpriteIndexProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets;
	}
}
