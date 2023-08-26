package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.level.LevelAccessor;

public class SanityOverlayValueProcedure {
	public static String execute(LevelAccessor world) {
		return "Sanity: " + Math.round(PurechaosModVariables.WorldVariables.get(world).sanity);
	}
}
