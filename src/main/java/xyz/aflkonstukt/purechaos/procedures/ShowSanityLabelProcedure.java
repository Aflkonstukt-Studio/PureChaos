package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

public class ShowSanityLabelProcedure {
	public static boolean execute() {
		if (PurechaosModVariables.show_sanity_label) {
			return true;
		}
		return false;
	}
}
