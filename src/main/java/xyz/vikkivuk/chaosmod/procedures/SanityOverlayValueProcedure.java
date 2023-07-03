package xyz.vikkivuk.chaosmod.procedures;

import xyz.vikkivuk.chaosmod.network.ChaosmodModVariables;

import net.minecraft.world.level.LevelAccessor;

public class SanityOverlayValueProcedure {
	public static String execute(LevelAccessor world) {
		return "Sanity: " + Math.round(ChaosmodModVariables.WorldVariables.get(world).sanity);
	}
}
