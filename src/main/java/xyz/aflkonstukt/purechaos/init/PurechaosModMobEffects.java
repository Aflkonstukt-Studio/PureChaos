
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.potion.SickMobEffect;
import xyz.aflkonstukt.purechaos.potion.RadiationPoisioningMobEffect;
import xyz.aflkonstukt.purechaos.potion.HighEffectMobEffect;
import xyz.aflkonstukt.purechaos.potion.FatMobEffect;
import xyz.aflkonstukt.purechaos.potion.DementiaMobEffect;
import xyz.aflkonstukt.purechaos.potion.BlindMobEffect;
import xyz.aflkonstukt.purechaos.potion.BleachedMobEffect;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class PurechaosModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PurechaosMod.MODID);
	public static final RegistryObject<MobEffect> HIGH_EFFECT = REGISTRY.register("high_effect", () -> new HighEffectMobEffect());
	public static final RegistryObject<MobEffect> BLEACHED = REGISTRY.register("bleached", () -> new BleachedMobEffect());
	public static final RegistryObject<MobEffect> RADIATION_POISIONING = REGISTRY.register("radiation_poisioning", () -> new RadiationPoisioningMobEffect());
	public static final RegistryObject<MobEffect> FAT = REGISTRY.register("fat", () -> new FatMobEffect());
	public static final RegistryObject<MobEffect> BLIND = REGISTRY.register("blind", () -> new BlindMobEffect());
	public static final RegistryObject<MobEffect> SICK = REGISTRY.register("sick", () -> new SickMobEffect());
	public static final RegistryObject<MobEffect> DEMENTIA = REGISTRY.register("dementia", () -> new DementiaMobEffect());
}
