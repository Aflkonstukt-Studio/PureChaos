package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

public class ShowSpeedometer2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double interval = 0;
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (Math.floor(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).speed / 0.0833) == 1) {
				return true;
			}
		}
		return false;
	}
}