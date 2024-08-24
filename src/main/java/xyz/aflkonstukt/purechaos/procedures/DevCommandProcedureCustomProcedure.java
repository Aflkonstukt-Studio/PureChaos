package xyz.aflkonstukt.purechaos.procedures;

import com.mojang.blaze3d.platform.InputConstants;
import xyz.aflkonstukt.purechaos.init.PurechaosModKeyMappings;

public class DevCommandProcedureCustomProcedure {
	public static void execute(boolean run) {
		if (run) {
			PurechaosModKeyMappings.SHIT.setKey(InputConstants.UNKNOWN);
			PurechaosModKeyMappings.ONE.setKey(InputConstants.UNKNOWN);
			PurechaosModKeyMappings.TWO.setKey(InputConstants.UNKNOWN);
			PurechaosModKeyMappings.SEVEN.setKey(InputConstants.UNKNOWN);
		} else {
			PurechaosModKeyMappings.SHIT.setKey(InputConstants.getKey("key.keyboard.left.shift"));
			PurechaosModKeyMappings.ONE.setKey(InputConstants.getKey("key.keyboard.keypad.1"));
			PurechaosModKeyMappings.TWO.setKey(InputConstants.getKey("key.keyboard.keypad.2"));
			PurechaosModKeyMappings.SEVEN.setKey(InputConstants.getKey("key.keyboard.keypad.7"));
		}
	}
}
