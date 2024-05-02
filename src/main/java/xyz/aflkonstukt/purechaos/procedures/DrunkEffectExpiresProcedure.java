package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

public class DrunkEffectExpiresProcedure {
	public static void execute() {
		PurechaosModVariables.invert_controls = false;
	}
}
