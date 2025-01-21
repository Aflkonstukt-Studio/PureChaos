
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.client.gui.VikkiVukGuiScreen;
import xyz.aflkonstukt.purechaos.client.gui.JGWarningScreen;
import xyz.aflkonstukt.purechaos.client.gui.IRSDonationScreen;
import xyz.aflkonstukt.purechaos.client.gui.ComputerGuiScreen;
import xyz.aflkonstukt.purechaos.client.gui.CheatGUIScreen;
import xyz.aflkonstukt.purechaos.client.gui.CaptchaGUIScreen;
import xyz.aflkonstukt.purechaos.client.gui.AdGUIScreen;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PurechaosModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(PurechaosModMenus.VIKKI_VUK_GUI.get(), VikkiVukGuiScreen::new);
		event.register(PurechaosModMenus.COMPUTER_GUI.get(), ComputerGuiScreen::new);
		event.register(PurechaosModMenus.CHEAT_GUI.get(), CheatGUIScreen::new);
		event.register(PurechaosModMenus.CAPTCHA_GUI.get(), CaptchaGUIScreen::new);
		event.register(PurechaosModMenus.AD_GUI.get(), AdGUIScreen::new);
		event.register(PurechaosModMenus.IRS_DONATION.get(), IRSDonationScreen::new);
		event.register(PurechaosModMenus.JG_WARNING.get(), JGWarningScreen::new);
	}
}
