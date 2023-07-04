
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
		REGISTRY.put(new ResourceLocation("chaosmod", "footstep_metal_amogus"), new SoundEvent(new ResourceLocation("chaosmod", "footstep_metal_amogus")));
		REGISTRY.put(new ResourceLocation("chaosmod", "kill"), new SoundEvent(new ResourceLocation("chaosmod", "kill")));
		REGISTRY.put(new ResourceLocation("chaosmod", "amongus_ambient"), new SoundEvent(new ResourceLocation("chaosmod", "amongus_ambient")));
		REGISTRY.put(new ResourceLocation("chaosmod", "fallguyswooh"), new SoundEvent(new ResourceLocation("chaosmod", "fallguyswooh")));
		REGISTRY.put(new ResourceLocation("chaosmod", "jusif"), new SoundEvent(new ResourceLocation("chaosmod", "jusif")));
		REGISTRY.put(new ResourceLocation("chaosmod", "redacted"), new SoundEvent(new ResourceLocation("chaosmod", "redacted")));
		REGISTRY.put(new ResourceLocation("chaosmod", "scratest"), new SoundEvent(new ResourceLocation("chaosmod", "scratest")));
		REGISTRY.put(new ResourceLocation("chaosmod", "jumpscare"), new SoundEvent(new ResourceLocation("chaosmod", "jumpscare")));
		REGISTRY.put(new ResourceLocation("chaosmod", "sssr"), new SoundEvent(new ResourceLocation("chaosmod", "sssr")));
		REGISTRY.put(new ResourceLocation("chaosmod", "vine_boom"), new SoundEvent(new ResourceLocation("chaosmod", "vine_boom")));
		REGISTRY.put(new ResourceLocation("chaosmod", "eekum_bokum"), new SoundEvent(new ResourceLocation("chaosmod", "eekum_bokum")));
		REGISTRY.put(new ResourceLocation("chaosmod", "never_gonna_give_you_up"), new SoundEvent(new ResourceLocation("chaosmod", "never_gonna_give_you_up")));
		REGISTRY.put(new ResourceLocation("chaosmod", "crnidani"), new SoundEvent(new ResourceLocation("chaosmod", "crnidani")));
		REGISTRY.put(new ResourceLocation("chaosmod", "ahdude"), new SoundEvent(new ResourceLocation("chaosmod", "ahdude")));
		REGISTRY.put(new ResourceLocation("chaosmod", "fu-k"), new SoundEvent(new ResourceLocation("chaosmod", "fu-k")));
		REGISTRY.put(new ResourceLocation("chaosmod", "dudeshutt"), new SoundEvent(new ResourceLocation("chaosmod", "dudeshutt")));
		REGISTRY.put(new ResourceLocation("chaosmod", "girl_moan"), new SoundEvent(new ResourceLocation("chaosmod", "girl_moan")));
		REGISTRY.put(new ResourceLocation("chaosmod", "spit"), new SoundEvent(new ResourceLocation("chaosmod", "spit")));
		REGISTRY.put(new ResourceLocation("chaosmod", "pan_hit"), new SoundEvent(new ResourceLocation("chaosmod", "pan_hit")));
		REGISTRY.put(new ResourceLocation("chaosmod", "smack_my_ass"), new SoundEvent(new ResourceLocation("chaosmod", "smack_my_ass")));
		REGISTRY.put(new ResourceLocation("chaosmod", "ugh_cupcakke"), new SoundEvent(new ResourceLocation("chaosmod", "ugh_cupcakke")));
		REGISTRY.put(new ResourceLocation("chaosmod", "gulp_gulp"), new SoundEvent(new ResourceLocation("chaosmod", "gulp_gulp")));
		REGISTRY.put(new ResourceLocation("chaosmod", "wet_cupcakke"), new SoundEvent(new ResourceLocation("chaosmod", "wet_cupcakke")));
		REGISTRY.put(new ResourceLocation("chaosmod", "ruler_slap"), new SoundEvent(new ResourceLocation("chaosmod", "ruler_slap")));
		REGISTRY.put(new ResourceLocation("chaosmod", "fart"), new SoundEvent(new ResourceLocation("chaosmod", "fart")));
		REGISTRY.put(new ResourceLocation("chaosmod", "espuma"), new SoundEvent(new ResourceLocation("chaosmod", "espuma")));
		REGISTRY.put(new ResourceLocation("chaosmod", "nerd"), new SoundEvent(new ResourceLocation("chaosmod", "nerd")));
		REGISTRY.put(new ResourceLocation("chaosmod", "nerd_pacman_meme"), new SoundEvent(new ResourceLocation("chaosmod", "nerd_pacman_meme")));
		REGISTRY.put(new ResourceLocation("chaosmod", "rock_living"), new SoundEvent(new ResourceLocation("chaosmod", "rock_living")));
		REGISTRY.put(new ResourceLocation("chaosmod", "rock_death"), new SoundEvent(new ResourceLocation("chaosmod", "rock_death")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
