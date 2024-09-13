
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.procedures.InfectedEffectExpiresProcedure;
import xyz.aflkonstukt.purechaos.procedures.HighEffectEffectExpiresProcedure;
import xyz.aflkonstukt.purechaos.procedures.FatEffectExpiresProcedure;
import xyz.aflkonstukt.purechaos.procedures.DrunkEffectExpiresProcedure;
import xyz.aflkonstukt.purechaos.procedures.DepressedEffectExpiresProcedure;
import xyz.aflkonstukt.purechaos.procedures.DementiaEffectExpiresProcedure;
import xyz.aflkonstukt.purechaos.procedures.CurseOfFatherlessEffectExpiresProcedure;
import xyz.aflkonstukt.purechaos.potion.SickMobEffect;
import xyz.aflkonstukt.purechaos.potion.RadiationPoisioningMobEffect;
import xyz.aflkonstukt.purechaos.potion.InfectedMobEffect;
import xyz.aflkonstukt.purechaos.potion.HighEffectMobEffect;
import xyz.aflkonstukt.purechaos.potion.FatMobEffect;
import xyz.aflkonstukt.purechaos.potion.DrunkMobEffect;
import xyz.aflkonstukt.purechaos.potion.DepressedMobEffect;
import xyz.aflkonstukt.purechaos.potion.DementiaMobEffect;
import xyz.aflkonstukt.purechaos.potion.CurseOfFatherlessMobEffect;
import xyz.aflkonstukt.purechaos.potion.BlindMobEffect;
import xyz.aflkonstukt.purechaos.potion.BleachedMobEffect;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class PurechaosModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, PurechaosMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> HIGH_EFFECT = REGISTRY.register("high_effect", () -> new HighEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLEACHED = REGISTRY.register("bleached", () -> new BleachedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> RADIATION_POISIONING = REGISTRY.register("radiation_poisioning", () -> new RadiationPoisioningMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FAT = REGISTRY.register("fat", () -> new FatMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLIND = REGISTRY.register("blind", () -> new BlindMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SICK = REGISTRY.register("sick", () -> new SickMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DEMENTIA = REGISTRY.register("dementia", () -> new DementiaMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DRUNK = REGISTRY.register("drunk", () -> new DrunkMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CURSE_OF_FATHERLESS = REGISTRY.register("curse_of_fatherless", () -> new CurseOfFatherlessMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DEPRESSED = REGISTRY.register("depressed", () -> new DepressedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> INFECTED = REGISTRY.register("infected", () -> new InfectedMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(HIGH_EFFECT)) {
			HighEffectEffectExpiresProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(FAT)) {
			FatEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(DEMENTIA)) {
			DementiaEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(DRUNK)) {
			DrunkEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(CURSE_OF_FATHERLESS)) {
			CurseOfFatherlessEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(DEPRESSED)) {
			DepressedEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(INFECTED)) {
			InfectedEffectExpiresProcedure.execute(entity);
		}
	}
}
