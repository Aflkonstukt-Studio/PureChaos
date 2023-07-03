package xyz.vikkivuk.chaosmod.procedures;

import xyz.vikkivuk.chaosmod.network.ChaosmodModVariables;

import net.minecraft.world.level.LevelAccessor;

public class AlmondWaterPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world) {
		ChaosmodModVariables.WorldVariables.get(world).sanity = 100;
		ChaosmodModVariables.WorldVariables.get(world).syncData(world);
	}
}
