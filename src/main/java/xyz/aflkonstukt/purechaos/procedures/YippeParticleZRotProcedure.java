package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.level.LevelAccessor;

public class YippeParticleZRotProcedure {
	public static double execute(LevelAccessor world) {
		return PurechaosModVariables.MapVariables.get(world).ypz;
	}
}
