package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import xyz.aflkonstukt.purechaos.CaptchaCode;

public class CaptchaGUIThisGUIIsClosedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;

		if (!(entity instanceof Player _player))
			return;

		if (CaptchaCode.isCaptchaInProgress()) {
			_player.displayClientMessage(Component.nullToEmpty("did you really think you could escape?"), false);
			_player.kill();
		}
	}
}
