package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class RizzHalf2DisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!(getEntityGameType(entity) == GameType.CREATIVE || getEntityGameType(entity) == GameType.SPECTATOR)) {
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).rizz >= 16 && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).rizz <= 32) {
				return true;
			}
		}
		return false;
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
