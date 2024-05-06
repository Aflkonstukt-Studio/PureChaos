
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.world.inventory.VikkiVukGuiMenu;
import xyz.aflkonstukt.purechaos.world.inventory.ComputerGuiMenu;
import xyz.aflkonstukt.purechaos.world.inventory.CheatGUIMenu;
import xyz.aflkonstukt.purechaos.world.inventory.CaptchaGUIMenu;
import xyz.aflkonstukt.purechaos.world.inventory.AdGUIMenu;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

public class PurechaosModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, PurechaosMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<VikkiVukGuiMenu>> VIKKI_VUK_GUI = REGISTRY.register("vikki_vuk_gui", () -> IMenuTypeExtension.create(VikkiVukGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ComputerGuiMenu>> COMPUTER_GUI = REGISTRY.register("computer_gui", () -> IMenuTypeExtension.create(ComputerGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CheatGUIMenu>> CHEAT_GUI = REGISTRY.register("cheat_gui", () -> IMenuTypeExtension.create(CheatGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CaptchaGUIMenu>> CAPTCHA_GUI = REGISTRY.register("captcha_gui", () -> IMenuTypeExtension.create(CaptchaGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdGUIMenu>> AD_GUI = REGISTRY.register("ad_gui", () -> IMenuTypeExtension.create(AdGUIMenu::new));
}
