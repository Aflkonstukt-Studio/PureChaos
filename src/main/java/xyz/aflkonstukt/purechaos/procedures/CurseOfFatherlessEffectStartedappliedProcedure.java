package xyz.aflkonstukt.purechaos.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class CurseOfFatherlessEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("bossbar add depression_" + (entity.getDisplayName().getString()).toLowerCase() + " \"Time until depression\""));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("bossbar set depression_" + (entity.getDisplayName().getString()).toLowerCase() + " max 300"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("bossbar set depression_" + (entity.getDisplayName().getString()).toLowerCase() + " players " + (entity.getDisplayName().getString()).toLowerCase()));
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(
					"Woah, it looks like you no longer have a father figure?! You are now unloved which means that you will have to drink alcohol or do meth every 5 minutes to avoid being depressed, and sometimes will get random panic attacks out of nowhere! You also have social anxiety which makes you get a panic attack whenever you look at a player or a villager. You need to do somehow make your father come back or you will be stuck like this forever. All of your tools also got downgraded to wooden, and your armor to chainmail, because well fuck you!"),
					false);
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerForEach) {
			for (int _idx = 0; _idx < _modHandlerForEach.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerForEach.getStackInSlot(_idx).copy();
				if (itemstackiterator.is(ItemTags.create(new ResourceLocation("purechaos:axes_above_wood")))) {
					itemstackiterator.shrink(1);
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.WOODEN_AXE).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("purechaos:pickaxes_above_wood")))) {
					itemstackiterator.shrink(1);
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.WOODEN_PICKAXE).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("purechaos:shovels_above_wood")))) {
					itemstackiterator.shrink(1);
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.WOODEN_SHOVEL).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("purechaos:hoes_above_wood")))) {
					itemstackiterator.shrink(1);
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.WOODEN_HOE).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(0, new ItemStack(Items.CHAINMAIL_HELMET));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.CHAINMAIL_HELMET));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(1, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(2, new ItemStack(Items.CHAINMAIL_LEGGINGS));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_LEGGINGS));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(3, new ItemStack(Items.CHAINMAIL_BOOTS));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.CHAINMAIL_BOOTS));
			}
		}
	}
}
