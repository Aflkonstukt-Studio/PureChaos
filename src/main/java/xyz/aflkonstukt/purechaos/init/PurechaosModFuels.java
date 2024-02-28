
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class PurechaosModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == PurechaosModItems.DEEK.get())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == Blocks.DIORITE.asItem())
			event.setBurnTime(1000);
		else if (itemstack.getItem() == PurechaosModItems.INFINITE_FUEL.get())
			event.setBurnTime(1410065407);
	}
}
