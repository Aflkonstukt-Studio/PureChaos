package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.world.inventory.CaptchaGUIMenu;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;
import xyz.aflkonstukt.purechaos.init.PurechaosModGameRules;
import xyz.aflkonstukt.purechaos.init.PurechaosModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@Mod.EventBusSubscriber
public class PlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextDouble(RandomSource.create(), 1, 6000) <= 3) {
			if ((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).heart_attack_chance >= 2.5) {
				{
					double _setval = (entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).heart_attack_chance - 2.5;
					entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.heart_attack_chance = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).sanity <= 75) {
			if (Mth.nextDouble(RandomSource.create(), 1, 6000) <= 3) {
				if (!world.getLevelData().getGameRules().getBoolean(PurechaosModGameRules.DISABLE_CAPTCHA)) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("CaptchaGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new CaptchaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		}
		if ((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).sanity <= 50) {
			if (Mth.nextInt(RandomSource.create(), (int) (entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).dementia_chance, 100) >= 95
					&& (entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).dementia_chance >= 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PurechaosModMobEffects.DEMENTIA.get(), 600, 1, false, true));
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Uh oh! Looks like you have dementia! Your inventory will be reset when the effect expires."), false);
			}
		}
		if ((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).sanity <= 0) {
			SendToBackroomsProcedure.execute(x, z, entity);
		} else {
			if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:backrooms_dimension")))) {
				if (Mth.nextDouble(RandomSource.create(), 1, 6000) <= 5) {
					if (Mth.nextDouble(RandomSource.create(), 1, 7) <= 2) {
						if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).sanity >= 75)) {
							{
								double _setval = (entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).sanity + Mth.nextDouble(RandomSource.create(), 1, 3);
								entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.sanity = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else {
						{
							double _setval = (entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).sanity - Mth.nextDouble(RandomSource.create(), 1, 4);
							entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sanity = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PurechaosModItems.OIL_BUCKET.get())) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PurechaosModItems.OIL_BUCKET.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 64, _player.inventoryMenu.getCraftSlots());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("purechaos:kilometer")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("purechaos:kilometer")), SoundSource.NEUTRAL, 1, 1, false);
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
		if (world.isClientSide() && entity instanceof Player) {
			if (Minecraft.getInstance().gameRenderer.currentEffect() != null) {
				if (Minecraft.getInstance().gameRenderer.currentEffect().getName().equals("purechaos:shaders/meth.json") && !(entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(PurechaosModMobEffects.HIGH_EFFECT.get()))) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				} else if (Minecraft.getInstance().gameRenderer.currentEffect().getName().equals("minecraft:shaders/post/desaturate.json")
						&& !(entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).having_nightmare) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
					if (entity instanceof LivingEntity _entity)
						_entity.removeAllEffects();
				} else if (Minecraft.getInstance().gameRenderer.currentEffect().getName().equals("minecraft:shaders/post/ntsc.json")
						&& !((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:backrooms_dimension")))) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				} else if (Minecraft.getInstance().gameRenderer.currentEffect().getName().equals("minecraft:shaders/post/art.json") && !(entity instanceof LivingEntity _livEnt39 && _livEnt39.hasEffect(PurechaosModMobEffects.DRUNK.get()))) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
					PurechaosModVariables.invert_controls = false;
				}
			} else {
				if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:backrooms_dimension"))) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("minecraft:shaders/post/ntsc.json"));
				} else if (entity instanceof LivingEntity _livEnt45 && _livEnt45.hasEffect(PurechaosModMobEffects.HIGH_EFFECT.get())) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("purechaos:shaders/meth.json"));
				} else if (entity instanceof LivingEntity _livEnt47 && _livEnt47.hasEffect(PurechaosModMobEffects.DRUNK.get())) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("minecraft:shaders/post/art.json"));
					PurechaosModVariables.invert_controls = true;
				}
			}
		}
		if ((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).nightmare_duration > 1
				&& (entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).having_nightmare) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar set nightmare_" + ((entity.getDisplayName().getString()).toLowerCase() + ""
								+ (" value " + Math.round((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).nightmare_duration / 20)))));
			{
				double _setval = (entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).nightmare_duration - 1;
				entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.nightmare_duration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (Minecraft.getInstance().gameRenderer.currentEffect() == null) {
				Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("minecraft:shaders/post/desaturate.json"));
			}
		}
		if ((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).nightmare_duration <= 1
				&& (entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).having_nightmare) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar remove nightmare_" + (entity.getDisplayName().getString()).toLowerCase()));
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
						_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
					_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
			{
				Entity _ent = entity;
				_ent.teleportTo(
						((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
								? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getX() : _player.level().getLevelData().getXSpawn())
								: 0),
						((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
								? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getY() : _player.level().getLevelData().getYSpawn())
								: 0),
						((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
								? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getZ() : _player.level().getLevelData().getZSpawn())
								: 0));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(
							((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getX() : _player.level().getLevelData().getXSpawn())
									: 0),
							((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getY() : _player.level().getLevelData().getYSpawn())
									: 0),
							((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getZ() : _player.level().getLevelData().getZSpawn())
									: 0),
							_ent.getYRot(), _ent.getXRot());
			}
			{
				boolean _setval = false;
				entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.having_nightmare = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
	}
}
