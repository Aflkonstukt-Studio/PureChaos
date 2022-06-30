
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.level.block.Blocks;

@Mod.EventBusSubscriber
public class ChaosmodModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == ChaosmodModItems.DEEK.get())
			event.setBurnTime(1600);
		else if (event.getItemStack().getItem() == Blocks.DIORITE.asItem())
			event.setBurnTime(1000);
	}
}
