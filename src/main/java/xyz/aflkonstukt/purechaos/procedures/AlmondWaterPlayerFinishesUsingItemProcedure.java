package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.level.LevelAccessor;

public class AlmondWaterPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world) {
		PurechaosModVariables.WorldVariables.get(world).sanity = 100;
		PurechaosModVariables.WorldVariables.get(world).syncData(world);
	}
}
