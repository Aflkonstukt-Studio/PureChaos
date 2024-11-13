package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;
import xyz.aflkonstukt.purechaos.init.PurechaosModGameRules;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntityTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).kidnapped) {
			if (entity instanceof ServerPlayer || entity instanceof Player) {
				if (entity instanceof Player _player) {
					_player.getAbilities().invulnerable = true;
					_player.onUpdateAbilities();
				}
				if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:poland")))) {
					if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
						ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:poland"));
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
						_ent.teleportTo(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z, _ent.getYRot(), _ent.getXRot());
					}
				}
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 100, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 100, false, false));
				if (entity instanceof Player _player) {
					_player.getAbilities().invulnerable = true;
					_player.onUpdateAbilities();
				}
			}
		}
		if (!(entity instanceof ServerPlayer || entity instanceof Player)) {
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).rizz == 0) {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.rizz = Mth.nextInt(RandomSource.create(), 1, 25);
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (!world.getLevelData().getGameRules().getBoolean(PurechaosModGameRules.TICK_REPELLANT)) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SHORT_GRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TALL_GRASS) {
				if (Mth.nextInt(RandomSource.create(), 1, 2000) <= 5) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(PurechaosModItems.TICK_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PurechaosModItems.TICK_CHESTPLATE.get()));
							}
						}
					}
				}
			}
		}
	}
}
