package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OnSchizophrenicTickProcedure {
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
		double itemstack_slot = 0;
		boolean remove_item = false;
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).schizophrenic) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[type=!minecraft:player ] at @s run tp @s ~ ~ ~ facing entity @p[distance=..30]");
			if (Mth.nextInt(RandomSource.create(), 1, 10000) >= 9990) {
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
					for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
						ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
						itemstack_slot = itemstack_slot + 1;
						if (Mth.nextInt(RandomSource.create(), 1, 100) >= 80) {
							remove_item = true;
							break;
						}
					}
				}
				if (remove_item) {
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = new ItemStack(PurechaosModItems.PING.get()).copy();
						_setstack.setCount(1);
						_modHandler.setStackInSlot((int) itemstack_slot, _setstack);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("purechaos:ping")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("purechaos:ping")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
			}
		}
	}
}
