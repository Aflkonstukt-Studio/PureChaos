package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class SendToBackroomsProcedure {
	public static void execute(double x, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
			ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:backrooms_dimension"));
			if (_player.level().dimension() == destinationType)
				return;
			ServerLevel nextLevel = _player.server.getLevel(destinationType);
			if (nextLevel != null) {
				_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
				_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
				_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
				for (MobEffectInstance _effectinstance : _player.getActiveEffects())
					_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
				_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
			}
		}
		{
			Entity _ent = entity;
			_ent.teleportTo(x, 10, z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, 10, z, _ent.getYRot(), _ent.getXRot());
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Looks like you are now in the backrooms! To get out, you can either drink almond water or kill yourse-"), false);
	}
}
