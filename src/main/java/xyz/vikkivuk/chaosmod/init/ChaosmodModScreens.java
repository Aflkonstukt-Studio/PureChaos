
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.client.gui.VikkiVukGuiScreen;
import xyz.vikkivuk.chaosmod.client.gui.ComputerGuiScreen;
import xyz.vikkivuk.chaosmod.client.gui.CheatGUIScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ChaosmodModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ChaosmodModMenus.VIKKI_VUK_GUI, VikkiVukGuiScreen::new);
			MenuScreens.register(ChaosmodModMenus.COMPUTER_GUI, ComputerGuiScreen::new);
			MenuScreens.register(ChaosmodModMenus.CHEAT_GUI, CheatGUIScreen::new);
		});
	}
}
