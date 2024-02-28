package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;
import xyz.aflkonstukt.purechaos.CaptchaCode;

import java.util.HashMap;

public class ValidateCaptchaProcedure {
	static boolean ranAlready = false;
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (ranAlready)
			return;

		ranAlready = true;

		if (entity == null || guistate == null)
			return;

		EditBox editBox = (EditBox) guistate.get("text:answer");
		if (editBox == null)
			return;

		String answer = editBox.getValue();
		boolean result = CaptchaCode.validateAnswer(answer, entity);

		if (result) {
			ranAlready = false;
		}
	}
}
