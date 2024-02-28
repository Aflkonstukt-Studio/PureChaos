package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;

public class AlmondWaterPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 100;
			entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.sanity = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
