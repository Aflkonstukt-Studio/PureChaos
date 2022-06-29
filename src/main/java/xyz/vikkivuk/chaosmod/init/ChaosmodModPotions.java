
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.ChaosmodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class ChaosmodModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, ChaosmodMod.MODID);
	public static final RegistryObject<Potion> AMONGSUS = REGISTRY.register("amongsus",
			() -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3600, 0, false, true),
					new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3600, 0, false, true),
					new MobEffectInstance(MobEffects.HARM, 3600, 0, false, true), new MobEffectInstance(MobEffects.JUMP, 3600, 0, false, true),
					new MobEffectInstance(MobEffects.INVISIBILITY, 3600, 0, false, true),
					new MobEffectInstance(MobEffects.HUNGER, 3600, 0, false, true),
					new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600, 0, false, true)));
}
