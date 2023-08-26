
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.client.gui.VikkiVukGuiScreen;
import xyz.aflkonstukt.purechaos.client.gui.ComputerGuiScreen;
import xyz.aflkonstukt.purechaos.client.gui.CheatGUIScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PurechaosModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(PurechaosModMenus.VIKKI_VUK_GUI, VikkiVukGuiScreen::new);
			MenuScreens.register(PurechaosModMenus.COMPUTER_GUI, ComputerGuiScreen::new);
			MenuScreens.register(PurechaosModMenus.CHEAT_GUI, CheatGUIScreen::new);
		});
	}
}
