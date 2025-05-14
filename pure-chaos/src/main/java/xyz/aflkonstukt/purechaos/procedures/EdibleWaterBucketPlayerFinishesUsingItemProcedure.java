package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class EdibleWaterBucketPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.thirst = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).thirst + 20;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
	}
}
