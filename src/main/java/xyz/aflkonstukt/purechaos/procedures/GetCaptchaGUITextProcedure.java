package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;

public class GetCaptchaGUITextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getData(PurechaosModVariables.PLAYER_VARIABLES).captcha_type).equals("word_challenge")) {
			return "Spell '" + entity.getData(PurechaosModVariables.PLAYER_VARIABLES).captcha_challenge + "' backwards";
		}
		return "What is " + entity.getData(PurechaosModVariables.PLAYER_VARIABLES).captcha_challenge + "?";
	}
}
