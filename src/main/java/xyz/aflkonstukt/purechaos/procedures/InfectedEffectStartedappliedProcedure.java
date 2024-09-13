package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class InfectedEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.infected_stage = 1;
			_vars.syncPlayerVariables(entity);
		}
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).immune_to_infection) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
	}
}
