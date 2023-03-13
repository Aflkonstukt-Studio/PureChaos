
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.world.inventory.VikkiVukGuiMenu;
import xyz.vikkivuk.chaosmod.world.inventory.ComputerGuiMenu;
import xyz.vikkivuk.chaosmod.world.inventory.CheatGUIMenu;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChaosmodModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<VikkiVukGuiMenu> VIKKI_VUK_GUI = register("vikki_vuk_gui", (id, inv, extraData) -> new VikkiVukGuiMenu(id, inv, extraData));
	public static final MenuType<ComputerGuiMenu> COMPUTER_GUI = register("computer_gui", (id, inv, extraData) -> new ComputerGuiMenu(id, inv, extraData));
	public static final MenuType<CheatGUIMenu> CHEAT_GUI = register("cheat_gui", (id, inv, extraData) -> new CheatGUIMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
