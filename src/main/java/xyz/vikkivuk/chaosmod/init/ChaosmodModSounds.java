
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChaosmodModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("chaosmod", "amogus"), new SoundEvent(new ResourceLocation("chaosmod", "amogus")));
		REGISTRY.put(new ResourceLocation("chaosmod", "footstep_metal_amogus"),
				new SoundEvent(new ResourceLocation("chaosmod", "footstep_metal_amogus")));
		REGISTRY.put(new ResourceLocation("chaosmod", "kill"), new SoundEvent(new ResourceLocation("chaosmod", "kill")));
		REGISTRY.put(new ResourceLocation("chaosmod", "amongus_ambient"), new SoundEvent(new ResourceLocation("chaosmod", "amongus_ambient")));
		REGISTRY.put(new ResourceLocation("chaosmod", "fallguyswooh"), new SoundEvent(new ResourceLocation("chaosmod", "fallguyswooh")));
		REGISTRY.put(new ResourceLocation("chaosmod", "jusif"), new SoundEvent(new ResourceLocation("chaosmod", "jusif")));
		REGISTRY.put(new ResourceLocation("chaosmod", "redacted"), new SoundEvent(new ResourceLocation("chaosmod", "redacted")));
		REGISTRY.put(new ResourceLocation("chaosmod", "scratest"), new SoundEvent(new ResourceLocation("chaosmod", "scratest")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
