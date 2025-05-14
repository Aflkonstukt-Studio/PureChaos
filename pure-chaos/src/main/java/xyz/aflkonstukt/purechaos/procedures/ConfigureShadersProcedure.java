package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
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

@EventBusSubscriber
public class ConfigureShadersProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide()) {
			if (!(Minecraft.getInstance().gameRenderer.currentPostEffect() != null)) {
				if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:backrooms_dimension"))) {
					Minecraft.getInstance().gameRenderer.setPostEffect(ResourceLocation.parse("purechaos:shaders/minecraft/ntsc.json"));
				} else if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(PurechaosModMobEffects.HIGH_EFFECT)) {
					Minecraft.getInstance().gameRenderer.setPostEffect(ResourceLocation.parse("purechaos:shaders/meth.json"));
				} else if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:nightmare_dimension"))) {
					Minecraft.getInstance().gameRenderer.setPostEffect(ResourceLocation.parse("purechaos:shaders/minecraft/desaturate.json"));
				} else if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(PurechaosModMobEffects.DRUNK)) {
					Minecraft.getInstance().gameRenderer.setPostEffect(ResourceLocation.parse("purechaos:shaders/minecraft/art.json"));
				} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).lobotomized) {
					Minecraft.getInstance().gameRenderer.setPostEffect(ResourceLocation.parse("purechaos:shaders/pale_shader.json"));
				}
			} else {
				if ((Minecraft.getInstance().gameRenderer.currentPostEffect().toString() == null ? "" : Minecraft.getInstance().gameRenderer.currentPostEffect().toString()).equals("purechaos:shaders/meth.json")
						&& !(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(PurechaosModMobEffects.HIGH_EFFECT))) {
					Minecraft.getInstance().gameRenderer.clearPostEffect();
				} else if ((Minecraft.getInstance().gameRenderer.currentPostEffect().toString() == null ? "" : Minecraft.getInstance().gameRenderer.currentPostEffect().toString()).equals("purechaos:shaders/minecraft/desaturate.json")
						&& !entity.getData(PurechaosModVariables.PLAYER_VARIABLES).having_nightmare) {
					Minecraft.getInstance().gameRenderer.clearPostEffect();
					if (entity instanceof LivingEntity _entity)
						_entity.removeAllEffects();
				} else if ((Minecraft.getInstance().gameRenderer.currentPostEffect().toString() == null ? "" : Minecraft.getInstance().gameRenderer.currentPostEffect().toString()).equals("purechaos:shaders/minecraft/ntsc.json")
						&& !((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:backrooms_dimension")))) {
					Minecraft.getInstance().gameRenderer.clearPostEffect();
				} else if ((Minecraft.getInstance().gameRenderer.currentPostEffect().toString() == null ? "" : Minecraft.getInstance().gameRenderer.currentPostEffect().toString()).equals("purechaos:shaders/minecraft/art.json")
						&& !(entity instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(PurechaosModMobEffects.DRUNK))) {
					Minecraft.getInstance().gameRenderer.clearPostEffect();
				} else if ((Minecraft.getInstance().gameRenderer.currentPostEffect().toString() == null ? "" : Minecraft.getInstance().gameRenderer.currentPostEffect().toString()).equals("purechaos:shaders/pale_shader.json")
						&& !entity.getData(PurechaosModVariables.PLAYER_VARIABLES).lobotomized) {
					Minecraft.getInstance().gameRenderer.clearPostEffect();
				}
			}
		}
	}
}
