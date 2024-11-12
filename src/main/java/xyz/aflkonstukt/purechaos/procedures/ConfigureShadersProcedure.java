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
		String ShaderLocation = "";
		boolean YourSecondCondition = false;
		boolean YourFirstCondition = false;
		if (world.isClientSide()) {
			if (Minecraft.getInstance().gameRenderer.currentEffect() != null) {
				if ((Minecraft.getInstance().gameRenderer.currentEffect().getName()).equals("purechaos:shaders/meth.json") && !(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(PurechaosModMobEffects.HIGH_EFFECT))) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				} else if ((Minecraft.getInstance().gameRenderer.currentEffect().getName()).equals("purechaos:shaders/minecraft/desaturate.json") && !entity.getData(PurechaosModVariables.PLAYER_VARIABLES).having_nightmare) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
					if (entity instanceof LivingEntity _entity)
						_entity.removeAllEffects();
				} else if ((Minecraft.getInstance().gameRenderer.currentEffect().getName()).equals("purechaos:shaders/minecraft/ntsc.json")
						&& !((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:backrooms_dimension")))) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				} else if ((Minecraft.getInstance().gameRenderer.currentEffect().getName()).equals("purechaos:shaders/minecraft/art.json") && !(entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(PurechaosModMobEffects.DRUNK))) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				} else if ((Minecraft.getInstance().gameRenderer.currentEffect().getName()).equals("purechaos:shaders/pale_shader.json") && !entity.getData(PurechaosModVariables.PLAYER_VARIABLES).lobotomized) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				}
			} else {
				if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:backrooms_dimension"))) {
					Minecraft.getInstance().gameRenderer.loadEffect(ResourceLocation.parse("purechaos:shaders/minecraft/ntsc.json"));
				} else if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(PurechaosModMobEffects.HIGH_EFFECT)) {
					Minecraft.getInstance().gameRenderer.loadEffect(ResourceLocation.parse("purechaos:shaders/meth.json"));
				} else if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("purechaos:nightmare_dimension"))) {
					Minecraft.getInstance().gameRenderer.loadEffect(ResourceLocation.parse("purechaos:shaders/minecraft/desaturate.json"));
				} else if (entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(PurechaosModMobEffects.DRUNK)) {
					Minecraft.getInstance().gameRenderer.loadEffect(ResourceLocation.parse("purechaos:shaders/minecraft/art.json"));
				} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).lobotomized) {
					Minecraft.getInstance().gameRenderer.loadEffect(ResourceLocation.parse("purechaos:shaders/pale_shader.json"));
				}
			}
		}
	}
}
