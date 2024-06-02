package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ConfigureShadersProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide()) {
			if (Minecraft.getInstance().gameRenderer.currentEffect() != null) {
				if (Minecraft.getInstance().gameRenderer.currentEffect().getName().equals("purechaos:shaders/meth.json") && !(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(PurechaosModMobEffects.HIGH_EFFECT.get()))) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				} else if (Minecraft.getInstance().gameRenderer.currentEffect().getName().equals("minecraft:shaders/post/desaturate.json") && !entity.getData(PurechaosModVariables.PLAYER_VARIABLES).having_nightmare) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
					if (entity instanceof LivingEntity _entity)
						_entity.removeAllEffects();
				} else if (Minecraft.getInstance().gameRenderer.currentEffect().getName().equals("minecraft:shaders/post/ntsc.json")
						&& !((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:backrooms_dimension")))) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				} else if (Minecraft.getInstance().gameRenderer.currentEffect().getName().equals("minecraft:shaders/post/art.json") && !(entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(PurechaosModMobEffects.DRUNK.get()))) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				}
			} else {
				if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:backrooms_dimension"))) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("minecraft:shaders/post/ntsc.json"));
				} else if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(PurechaosModMobEffects.HIGH_EFFECT.get())) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("purechaos:shaders/meth.json"));
				} else if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:nightmare_dimension"))) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("minecraft:shaders/post/desaturate.json"));
				} else if (entity instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(PurechaosModMobEffects.DRUNK.get())) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("minecraft:shaders/post/art.json"));
				}
			}
		}
	}
}
