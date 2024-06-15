package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.function.BiFunction;
import java.util.UUID;

public class MobCatcherRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		PurechaosMod.queueServerWork(1, () -> {
			if (itemstack.getOrCreateTag().getBoolean("filled")) {
				if (((new BiFunction<LevelAccessor, String, Entity>() {
					@Override
					public Entity apply(LevelAccessor levelAccessor, String uuid) {
						if (levelAccessor instanceof ServerLevel serverLevel) {
							try {
								return serverLevel.getEntity(UUID.fromString(uuid));
							} catch (Exception e) {
							}
						}
						return null;
					}
				}).apply(world, (itemstack.getOrCreateTag().getString("entity_uuid")))) == null) {
					if (itemstack.getOrCreateTag().getBoolean("player")) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Player in the catcher is currently offline. Please try again when they come back online!"), false);
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Entity doesnt exist anymore! Resetting catcher..."), false);
						itemstack.getOrCreateTag().putBoolean("filled", false);
					}
				} else {
					if (itemstack.getOrCreateTag().getBoolean("player")) {
						((new BiFunction<LevelAccessor, String, Entity>() {
							@Override
							public Entity apply(LevelAccessor levelAccessor, String uuid) {
								if (levelAccessor instanceof ServerLevel serverLevel) {
									try {
										return serverLevel.getEntity(UUID.fromString(uuid));
									} catch (Exception e) {
									}
								}
								return null;
							}
						}).apply(world, (itemstack.getOrCreateTag().getString("entity_uuid")))).getPersistentData().putBoolean("kidnapped", false);
						if (((new BiFunction<LevelAccessor, String, Entity>() {
							@Override
							public Entity apply(LevelAccessor levelAccessor, String uuid) {
								if (levelAccessor instanceof ServerLevel serverLevel) {
									try {
										return serverLevel.getEntity(UUID.fromString(uuid));
									} catch (Exception e) {
									}
								}
								return null;
							}
						}).apply(world, (itemstack.getOrCreateTag().getString("entity_uuid")))) instanceof ServerPlayer _player && !_player.level().isClientSide()) {
							ResourceKey<Level> destinationType = Level.OVERWORLD;
							if (_player.level().dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
						{
							Entity _ent = ((new BiFunction<LevelAccessor, String, Entity>() {
								@Override
								public Entity apply(LevelAccessor levelAccessor, String uuid) {
									if (levelAccessor instanceof ServerLevel serverLevel) {
										try {
											return serverLevel.getEntity(UUID.fromString(uuid));
										} catch (Exception e) {
										}
									}
									return null;
								}
							}).apply(world, (itemstack.getOrCreateTag().getString("entity_uuid"))));
							_ent.teleportTo(x, y, z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
						}
						if (entity instanceof Player _player) {
							_player.getAbilities().invulnerable = false;
							_player.onUpdateAbilities();
						}
					} else {
						((new BiFunction<LevelAccessor, String, Entity>() {
							@Override
							public Entity apply(LevelAccessor levelAccessor, String uuid) {
								if (levelAccessor instanceof ServerLevel serverLevel) {
									try {
										return serverLevel.getEntity(UUID.fromString(uuid));
									} catch (Exception e) {
									}
								}
								return null;
							}
						}).apply(world, (itemstack.getOrCreateTag().getString("entity_uuid")))).getPersistentData().putBoolean("kidnapped", false);
						if (((new BiFunction<LevelAccessor, String, Entity>() {
							@Override
							public Entity apply(LevelAccessor levelAccessor, String uuid) {
								if (levelAccessor instanceof ServerLevel serverLevel) {
									try {
										return serverLevel.getEntity(UUID.fromString(uuid));
									} catch (Exception e) {
									}
								}
								return null;
							}
						}).apply(world, (itemstack.getOrCreateTag().getString("entity_uuid")))) instanceof LivingEntity _entity)
							_entity.removeAllEffects();
						{
							Entity _ent = ((new BiFunction<LevelAccessor, String, Entity>() {
								@Override
								public Entity apply(LevelAccessor levelAccessor, String uuid) {
									if (levelAccessor instanceof ServerLevel serverLevel) {
										try {
											return serverLevel.getEntity(UUID.fromString(uuid));
										} catch (Exception e) {
										}
									}
									return null;
								}
							}).apply(world, (itemstack.getOrCreateTag().getString("entity_uuid"))));
							_ent.teleportTo(x, y, z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
						}
						if (entity instanceof Player _player) {
							_player.getAbilities().invulnerable = false;
							_player.onUpdateAbilities();
						}
					}
					itemstack.getOrCreateTag().putBoolean("filled", false);
				}
			}
		});
	}
}
