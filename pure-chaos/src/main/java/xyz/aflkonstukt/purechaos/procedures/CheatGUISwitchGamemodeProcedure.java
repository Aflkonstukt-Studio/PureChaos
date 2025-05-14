package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class CheatGUISwitchGamemodeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (getEntityGameType(entity) == GameType.SURVIVAL) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.CREATIVE);
		} else if (getEntityGameType(entity) == GameType.CREATIVE) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
