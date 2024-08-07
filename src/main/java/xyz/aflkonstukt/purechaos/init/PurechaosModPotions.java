
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

public class PurechaosModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, PurechaosMod.MODID);
	public static final DeferredHolder<Potion, Potion> AMONGSUS = REGISTRY.register("amongsus",
			() -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3600, 0, false, true), new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3600, 0, false, true), new MobEffectInstance(MobEffects.HARM, 3600, 0, false, true),
					new MobEffectInstance(MobEffects.JUMP, 3600, 0, false, true), new MobEffectInstance(MobEffects.INVISIBILITY, 3600, 0, false, true), new MobEffectInstance(MobEffects.HUNGER, 3600, 0, false, true),
					new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> FUCK_YOU = REGISTRY.register("fuck_you",
			() -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 0, false, false), new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3600, 0, false, false), new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0, false, false),
					new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3600, 0, false, false), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 0, false, false), new MobEffectInstance(MobEffects.HEAL, 3600, 0, false, false),
					new MobEffectInstance(MobEffects.HARM, 3600, 0, false, false), new MobEffectInstance(MobEffects.JUMP, 3600, 0, false, false), new MobEffectInstance(MobEffects.CONFUSION, 3600, 0, false, false),
					new MobEffectInstance(MobEffects.REGENERATION, 3600, 0, false, false), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 0, false, false), new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 0, false, false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 3600, 0, false, false), new MobEffectInstance(MobEffects.INVISIBILITY, 3600, 0, false, false), new MobEffectInstance(MobEffects.BLINDNESS, 3600, 0, false, false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 3600, 0, false, false), new MobEffectInstance(MobEffects.HUNGER, 3600, 0, false, false), new MobEffectInstance(MobEffects.WEAKNESS, 3600, 0, false, false),
					new MobEffectInstance(MobEffects.POISON, 3600, 0, false, false), new MobEffectInstance(MobEffects.WITHER, 3600, 0, false, false), new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600, 0, false, false),
					new MobEffectInstance(MobEffects.ABSORPTION, 3600, 0, false, false), new MobEffectInstance(MobEffects.SATURATION, 3600, 0, false, false), new MobEffectInstance(MobEffects.GLOWING, 3600, 0, false, false),
					new MobEffectInstance(MobEffects.LEVITATION, 3600, 0, false, false), new MobEffectInstance(MobEffects.LUCK, 3600, 0, false, false), new MobEffectInstance(MobEffects.UNLUCK, 3600, 0, false, false),
					new MobEffectInstance(MobEffects.SLOW_FALLING, 3600, 0, false, false), new MobEffectInstance(MobEffects.CONDUIT_POWER, 3600, 0, false, false), new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 3600, 0, false, false),
					new MobEffectInstance(MobEffects.BAD_OMEN, 3600, 0, false, false), new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 3600, 0, false, false)));
	public static final DeferredHolder<Potion, Potion> ILLEGALSUBSTANCE = REGISTRY.register("illegalsubstance",
			() -> new Potion(new MobEffectInstance(MobEffects.DARKNESS, 3600, 100, false, true), new MobEffectInstance(PurechaosModMobEffects.HIGH_EFFECT, 3600, 100, false, true),
					new MobEffectInstance(PurechaosModMobEffects.RADIATION_POISIONING, 3600, 0, false, true), new MobEffectInstance(PurechaosModMobEffects.FAT, 3600, 0, false, true),
					new MobEffectInstance(PurechaosModMobEffects.BLEACHED, 3600, 0, false, true), new MobEffectInstance(PurechaosModMobEffects.BLIND, 3600, 0, false, true), new MobEffectInstance(PurechaosModMobEffects.SICK, 3600, 100, false, true),
					new MobEffectInstance(PurechaosModMobEffects.DEMENTIA, 3600, 100, false, true), new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3600, 0, false, true), new MobEffectInstance(MobEffects.HUNGER, 3600, 0, false, true),
					new MobEffectInstance(MobEffects.CONFUSION, 3600, 0, false, true), new MobEffectInstance(MobEffects.POISON, 3600, 0, false, true), new MobEffectInstance(MobEffects.ABSORPTION, 3600, 0, false, true),
					new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600, 0, false, true), new MobEffectInstance(MobEffects.HEAL, 3600, 0, false, true), new MobEffectInstance(MobEffects.WITHER, 3600, 0, false, true),
					new MobEffectInstance(MobEffects.UNLUCK, 3600, 100, false, true), new MobEffectInstance(MobEffects.BAD_OMEN, 3600, 0, false, true), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> MODIFIED_ETHANOL = REGISTRY.register("modified_ethanol", () -> new Potion(new MobEffectInstance(PurechaosModMobEffects.BLIND, 3600, 0, false, false),
			new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3600, 0, false, true), new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3600, 0, false, true), new MobEffectInstance(MobEffects.CONFUSION, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> ETHANOL = REGISTRY.register("ethanol", () -> new Potion(new MobEffectInstance(MobEffects.WITHER, 3600, 2, false, true)));
}
