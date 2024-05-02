package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

public class DrunkEffectStartedappliedProcedure {
	public static void execute() {
		PurechaosModVariables.invert_controls = true;
	}
}
