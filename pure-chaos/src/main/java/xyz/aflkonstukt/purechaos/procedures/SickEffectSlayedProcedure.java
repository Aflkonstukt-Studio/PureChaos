package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;

public class SickEffectSlayedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.healthiness = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).healthiness - 10;
			_vars.syncPlayerVariables(entity);
		}
	}
}
