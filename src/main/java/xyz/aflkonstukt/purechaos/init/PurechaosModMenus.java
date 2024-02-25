
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.world.inventory.VikkiVukGuiMenu;
import xyz.aflkonstukt.purechaos.world.inventory.ComputerGuiMenu;
import xyz.aflkonstukt.purechaos.world.inventory.CheatGUIMenu;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class PurechaosModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PurechaosMod.MODID);
	public static final RegistryObject<MenuType<VikkiVukGuiMenu>> VIKKI_VUK_GUI = REGISTRY.register("vikki_vuk_gui", () -> IForgeMenuType.create(VikkiVukGuiMenu::new));
	public static final RegistryObject<MenuType<ComputerGuiMenu>> COMPUTER_GUI = REGISTRY.register("computer_gui", () -> IForgeMenuType.create(ComputerGuiMenu::new));
	public static final RegistryObject<MenuType<CheatGUIMenu>> CHEAT_GUI = REGISTRY.register("cheat_gui", () -> IForgeMenuType.create(CheatGUIMenu::new));
}
