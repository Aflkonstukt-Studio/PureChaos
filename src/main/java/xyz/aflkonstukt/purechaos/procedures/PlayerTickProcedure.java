package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.world.inventory.AdGUIMenu;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;
import xyz.aflkonstukt.purechaos.init.PurechaosModGameRules;
import xyz.aflkonstukt.purechaos.init.PurechaosModEntities;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class PlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.speed = Math.sqrt(entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().y() * entity.getDeltaMovement().y() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z());
			_vars.syncPlayerVariables(entity);
		}
		if (Mth.nextDouble(RandomSource.create(), 1, 6000) <= 3) {
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).heart_attack_chance >= 2.5) {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.heart_attack_chance = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).heart_attack_chance - 2.5;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (!world.getLevelData().getGameRules().getBoolean(PurechaosModGameRules.MENTAL_HEALTH)) {
			if (Mth.nextInt(RandomSource.create(), 1, (int) (40000 - entity.getData(PurechaosModVariables.PLAYER_VARIABLES).breakdown_chance / 20)) <= 3) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PurechaosModMobEffects.DEPRESSED, Mth.nextInt(RandomSource.create(), 100, 400), 1, false, false));
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.breakdown_chance = 0;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7c\u00A7lWoah you just got a breakdown! \u00A7e\u00A7oDon't worry they go by quickly, usually they last like \u00A7a5-20s \u00A7e\u00A7oso just \u00A7bdrink some water!"),
							false);
			} else if (Mth.nextInt(RandomSource.create(), 1, 16000) <= 3) {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.breakdown_chance = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).breakdown_chance + 1;
					_vars.syncPlayerVariables(entity);
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 16000) <= 3) {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.breakdown_chance = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).breakdown_chance - 2;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity_enabled) {
			if (!world.getLevelData().getGameRules().getBoolean(PurechaosModGameRules.DISABLE_CAPTCHA) && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity <= 75 && Mth.nextDouble(RandomSource.create(), 1, 6000) <= 3) {
				HandleNewCaptchaProcedure.execute(world, x, y, z, entity);
			} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity <= 50) {
				if (Mth.nextInt(RandomSource.create(), (int) entity.getData(PurechaosModVariables.PLAYER_VARIABLES).dementia_chance, 2000) >= 1991 && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).dementia_chance > 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PurechaosModMobEffects.DEMENTIA, 600, 1, false, true));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 600, 1, false, false));
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7c\u00A7lUh oh! Looks like you have dementia! \u00A7e\u00A7oYour inventory will be reset when the effect expires."), false);
					{
						PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
						_vars.dementia_chance = 0;
						_vars.syncPlayerVariables(entity);
					}
				}
				if (Mth.nextDouble(RandomSource.create(), 1, 3000) <= 3) {
					if (!world.getLevelData().getGameRules().getBoolean(PurechaosModGameRules.ADBLOCKER)) {
						if (entity instanceof ServerPlayer _ent) {
							BlockPos _bpos = BlockPos.containing(x, y, z);
							_ent.openMenu(new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return Component.literal("AdGUI");
								}

								@Override
								public boolean shouldTriggerClientSideContainerClosingOnOpen() {
									return false;
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									return new AdGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
				}
			} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity <= 0) {
				SendToBackroomsProcedure.execute(x, z, entity);
			}
			if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:backrooms_dimension")))) {
				if (Mth.nextDouble(RandomSource.create(), 1, 6000 / entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity_drop_multiplier) >= 6000 / entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity_drop_multiplier
						- 5 * 2 * entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity_drop_multiplier) {
					if (Mth.nextDouble(RandomSource.create(), 1, 10) <= 2) {
						{
							PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
							_vars.sanity = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity + Mth.nextDouble(RandomSource.create(), 1, 4);
							_vars.syncPlayerVariables(entity);
						}
					} else {
						{
							PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
							_vars.sanity = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity - Mth.nextDouble(RandomSource.create(), 1, 4);
							_vars.syncPlayerVariables(entity);
						}
					}
				}
			}
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity <= 20) {
				if (Mth.nextDouble(RandomSource.create(), 1, 10000) >= 9995) {
					{
						PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
						_vars.schizophrenic = true;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).nightmare_duration > 1 && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).having_nightmare) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar set nightmare_" + ((entity.getDisplayName().getString()).toLowerCase() + "" + (" value " + Math.round(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).nightmare_duration / 20)))));
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.nightmare_duration = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).nightmare_duration - 1;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).nightmare_duration <= 1 && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).having_nightmare) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar remove nightmare_" + (entity.getDisplayName().getString()).toLowerCase()));
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.disable_backrooms = true;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
				ResourceKey<Level> destinationType = Level.OVERWORLD;
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
				_ent.teleportTo(
						((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
								? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getX() : _player.level().getLevelData().getSpawnPos().getX())
								: 0),
						((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
								? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getY() : _player.level().getLevelData().getSpawnPos().getY())
								: 0),
						((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
								? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getZ() : _player.level().getLevelData().getSpawnPos().getZ())
								: 0));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(
							((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getX() : _player.level().getLevelData().getSpawnPos().getX())
									: 0),
							((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getY() : _player.level().getLevelData().getSpawnPos().getY())
									: 0),
							((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getZ() : _player.level().getLevelData().getSpawnPos().getZ())
									: 0),
							_ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof ServerLevel _level)
				_level.setDayTime(4000);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Wakey wakey"), false);
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.having_nightmare = false;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			PurechaosMod.queueServerWork(40, () -> {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.disable_backrooms = false;
					_vars.syncPlayerVariables(entity);
				}
			});
		}
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).arthritis_time != 0) {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.arthritis_time = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).arthritis_time - 1;
					_vars.syncPlayerVariables(entity);
				}
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.arthritis = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).arthritis && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).arthritis_time == 0) {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.arthritis = false;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).rizz >= 96) {
				entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("purechaos:rizzed_up")))), 1);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
				if (!entity.getData(PurechaosModVariables.PLAYER_VARIABLES).announced_rizzed) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("purechaos:rizz")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("purechaos:rizz")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(
								Component.literal(
										"\u00A7d\u00A7lWhoa, you're totally rizzed up! \u00A7e\u00A7oYour rizzometer is off the charts! \u00A7a\u00A7lYou need to rizz someone up to get rid of the rizz! \u00A77\u00A7o(Just hit them multiple times)."),
								false);
					{
						PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
						_vars.announced_rizzed = true;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
			if (entity.isSprinting()) {
				if (Mth.nextInt(RandomSource.create(), 1, 800) <= 4) {
					{
						PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
						_vars.thirst = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).thirst - 5;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (entity.getDeltaMovement().x() != 0 && entity.getDeltaMovement().y() != 0 && entity.getDeltaMovement().z() != 0) {
				if (Mth.nextInt(RandomSource.create(), 1, 800) <= 2) {
					{
						PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
						_vars.thirst = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).thirst - 5;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).thirst < 5) {
				entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("purechaos:thirst_death")))), 1);
			}
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PurechaosModItems.OIL_BUCKET.get())) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PurechaosModItems.OIL_BUCKET.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 99, _player.inventoryMenu.getCraftSlots());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("purechaos:kilometer")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("purechaos:kilometer")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.AMERICAN_SOLDAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.AMERICAN_SOLDAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.FBI.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.FBI.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.IRS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.MURICA.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.ANCIENT_DEBRIS)) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Blocks.ANCIENT_DEBRIS);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 99, _player.inventoryMenu.getCraftSlots());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("purechaos:america_fuck_yeah")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("purechaos:america_fuck_yeah")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.IRS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.IRS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.IRS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.IRS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.IRS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PurechaosModEntities.IRS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
	}
}
