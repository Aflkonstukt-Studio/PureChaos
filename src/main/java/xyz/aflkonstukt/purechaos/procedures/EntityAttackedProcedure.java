package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.entity.StalinEntity;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			if (sourceentity instanceof StalinEntity) {
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerForEach) {
					for (int _idx = 0; _idx < _modHandlerForEach.getSlots(); _idx++) {
						ItemStack itemstackiterator = _modHandlerForEach.getStackInSlot(_idx).copy();
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = itemstackiterator;
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
				}
			}
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.rizz = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).rizz + sourceentity.getData(PurechaosModVariables.PLAYER_VARIABLES).rizz;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
			if (sourceentity.getData(PurechaosModVariables.PLAYER_VARIABLES).arthritis) {
				sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("purechaos:arthritis_death")))), 1);
			}
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).accumulated_rizz >= 96) {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.rizz = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).rizz + sourceentity.getData(PurechaosModVariables.PLAYER_VARIABLES).rizz;
					_vars.syncPlayerVariables(entity);
				}
				{
					PurechaosModVariables.PlayerVariables _vars = sourceentity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.rizz = 0;
					_vars.syncPlayerVariables(sourceentity);
				}
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.announced_rizzed = false;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.accumulated_rizz = sourceentity.getData(PurechaosModVariables.PLAYER_VARIABLES).rizz + entity.getData(PurechaosModVariables.PLAYER_VARIABLES).accumulated_rizz;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
