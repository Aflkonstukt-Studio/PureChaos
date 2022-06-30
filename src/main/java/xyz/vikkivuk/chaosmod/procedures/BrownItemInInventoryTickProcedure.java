package xyz.vikkivuk.chaosmod.procedures;

import xyz.vikkivuk.chaosmod.init.ChaosmodModItems;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class BrownItemInInventoryTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double tick = 0;
		tick = tick + 1;
		if (tick == 40) {
			tick = 0;
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ChaosmodModItems.BROWN.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
