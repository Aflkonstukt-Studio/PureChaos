
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class PurechaosModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == Blocks.DIORITE.asItem())
			event.setBurnTime(1000);
		else if (itemstack.getItem() == PurechaosModItems.INFINITE_FUEL.get())
			event.setBurnTime(1410065407);
	}
}
