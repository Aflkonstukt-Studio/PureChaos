
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.entity.decoration.Motive;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurechaosModPaintings {
	@SubscribeEvent
	public static void registerMotives(RegistryEvent.Register<Motive> event) {
		event.getRegistry().register(new Motive(400, 200).setRegistryName("masterpiece"));
		event.getRegistry().register(new Motive(16, 16).setRegistryName("xmasterwoopainting"));
		event.getRegistry().register(new Motive(64, 64).setRegistryName("stuck"));
		event.getRegistry().register(new Motive(69, 60).setRegistryName("hmmmm_drip"));
	}
}
