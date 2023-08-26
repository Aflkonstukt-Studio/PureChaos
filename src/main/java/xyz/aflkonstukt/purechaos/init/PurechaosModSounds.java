
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurechaosModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("purechaos", "amogus"), new SoundEvent(new ResourceLocation("purechaos", "amogus")));
		REGISTRY.put(new ResourceLocation("purechaos", "footstep_metal_amogus"), new SoundEvent(new ResourceLocation("purechaos", "footstep_metal_amogus")));
		REGISTRY.put(new ResourceLocation("purechaos", "kill"), new SoundEvent(new ResourceLocation("purechaos", "kill")));
		REGISTRY.put(new ResourceLocation("purechaos", "amongus_ambient"), new SoundEvent(new ResourceLocation("purechaos", "amongus_ambient")));
		REGISTRY.put(new ResourceLocation("purechaos", "fallguyswooh"), new SoundEvent(new ResourceLocation("purechaos", "fallguyswooh")));
		REGISTRY.put(new ResourceLocation("purechaos", "jusif"), new SoundEvent(new ResourceLocation("purechaos", "jusif")));
		REGISTRY.put(new ResourceLocation("purechaos", "redacted"), new SoundEvent(new ResourceLocation("purechaos", "redacted")));
		REGISTRY.put(new ResourceLocation("purechaos", "scratest"), new SoundEvent(new ResourceLocation("purechaos", "scratest")));
		REGISTRY.put(new ResourceLocation("purechaos", "jumpscare"), new SoundEvent(new ResourceLocation("purechaos", "jumpscare")));
		REGISTRY.put(new ResourceLocation("purechaos", "sssr"), new SoundEvent(new ResourceLocation("purechaos", "sssr")));
		REGISTRY.put(new ResourceLocation("purechaos", "vine_boom"), new SoundEvent(new ResourceLocation("purechaos", "vine_boom")));
		REGISTRY.put(new ResourceLocation("purechaos", "eekum_bokum"), new SoundEvent(new ResourceLocation("purechaos", "eekum_bokum")));
		REGISTRY.put(new ResourceLocation("purechaos", "never_gonna_give_you_up"), new SoundEvent(new ResourceLocation("purechaos", "never_gonna_give_you_up")));
		REGISTRY.put(new ResourceLocation("purechaos", "crnidani"), new SoundEvent(new ResourceLocation("purechaos", "crnidani")));
		REGISTRY.put(new ResourceLocation("purechaos", "ahdude"), new SoundEvent(new ResourceLocation("purechaos", "ahdude")));
		REGISTRY.put(new ResourceLocation("purechaos", "fu-k"), new SoundEvent(new ResourceLocation("purechaos", "fu-k")));
		REGISTRY.put(new ResourceLocation("purechaos", "dudeshutt"), new SoundEvent(new ResourceLocation("purechaos", "dudeshutt")));
		REGISTRY.put(new ResourceLocation("purechaos", "girl_moan"), new SoundEvent(new ResourceLocation("purechaos", "girl_moan")));
		REGISTRY.put(new ResourceLocation("purechaos", "spit"), new SoundEvent(new ResourceLocation("purechaos", "spit")));
		REGISTRY.put(new ResourceLocation("purechaos", "pan_hit"), new SoundEvent(new ResourceLocation("purechaos", "pan_hit")));
		REGISTRY.put(new ResourceLocation("purechaos", "smack_my_ass"), new SoundEvent(new ResourceLocation("purechaos", "smack_my_ass")));
		REGISTRY.put(new ResourceLocation("purechaos", "ugh_cupcakke"), new SoundEvent(new ResourceLocation("purechaos", "ugh_cupcakke")));
		REGISTRY.put(new ResourceLocation("purechaos", "gulp_gulp"), new SoundEvent(new ResourceLocation("purechaos", "gulp_gulp")));
		REGISTRY.put(new ResourceLocation("purechaos", "wet_cupcakke"), new SoundEvent(new ResourceLocation("purechaos", "wet_cupcakke")));
		REGISTRY.put(new ResourceLocation("purechaos", "ruler_slap"), new SoundEvent(new ResourceLocation("purechaos", "ruler_slap")));
		REGISTRY.put(new ResourceLocation("purechaos", "fart"), new SoundEvent(new ResourceLocation("purechaos", "fart")));
		REGISTRY.put(new ResourceLocation("purechaos", "espuma"), new SoundEvent(new ResourceLocation("purechaos", "espuma")));
		REGISTRY.put(new ResourceLocation("purechaos", "nerd"), new SoundEvent(new ResourceLocation("purechaos", "nerd")));
		REGISTRY.put(new ResourceLocation("purechaos", "nerd_pacman_meme"), new SoundEvent(new ResourceLocation("purechaos", "nerd_pacman_meme")));
		REGISTRY.put(new ResourceLocation("purechaos", "rock_living"), new SoundEvent(new ResourceLocation("purechaos", "rock_living")));
		REGISTRY.put(new ResourceLocation("purechaos", "rock_death"), new SoundEvent(new ResourceLocation("purechaos", "rock_death")));
		REGISTRY.put(new ResourceLocation("purechaos", "kilometer"), new SoundEvent(new ResourceLocation("purechaos", "kilometer")));
		REGISTRY.put(new ResourceLocation("purechaos", "fbi_open"), new SoundEvent(new ResourceLocation("purechaos", "fbi_open")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
