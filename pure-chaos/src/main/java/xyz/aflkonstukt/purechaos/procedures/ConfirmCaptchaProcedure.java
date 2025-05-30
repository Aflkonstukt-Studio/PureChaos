package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

public class ConfirmCaptchaProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		PurechaosMod.queueServerWork(1, () -> {
			if ((guistate.containsKey("text:answer") ? ((EditBox) guistate.get("text:answer")).getValue() : "").equals(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).captcha_answer)) {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.captcha = false;
					_vars.syncPlayerVariables(entity);
				}
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.wrong_answers = 0;
					_vars.syncPlayerVariables(entity);
				}
				PurechaosMod.queueServerWork(2, () -> {
					if (entity instanceof Player _player)
						_player.closeContainer();
				});
			} else {
				if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).wrong_answers >= 3) {
					if (getEntityGameType(entity) == GameType.CREATIVE || getEntityGameType(entity) == GameType.SPECTATOR) {
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth(0);
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " failed the captcha")), false);
					} else {
						entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("purechaos:captcha_death")))), 999);
					}
				} else {
					{
						PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
						_vars.wrong_answers = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).wrong_answers + 1;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Incorrect. " + Math.round(4 - entity.getData(PurechaosModVariables.PLAYER_VARIABLES).wrong_answers)
								+ (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).wrong_answers == 3 ? " attempt remaining." : " attempts remaining."))), true);
				}
			}
		});
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
