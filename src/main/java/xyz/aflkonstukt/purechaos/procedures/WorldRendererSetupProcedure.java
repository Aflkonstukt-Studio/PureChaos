package xyz.aflkonstukt.purechaos.procedures;

import org.joml.Matrix4f;

import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Camera;

import javax.annotation.Nullable;

import java.util.function.Consumer;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import com.mojang.blaze3d.vertex.PoseStack;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldRendererSetupProcedure {
	public static class CustomDimensionEffects extends DimensionSpecialEffects {
		public static List<Consumer<Object[]>> customClouds = new ArrayList<>();
		public static List<Consumer<Object[]>> customSky = new ArrayList<>();
		public static List<Consumer<Object[]>> customWeather = new ArrayList<>();
		public static List<Consumer<Object[]>> customEffects = new ArrayList<>();

		public CustomDimensionEffects(float cloudHeight, boolean hasGround, DimensionSpecialEffects.SkyType skyType, boolean forceBrightLightmap, boolean constantAmbientLight) {
			super(cloudHeight, hasGround, skyType, forceBrightLightmap, constantAmbientLight);
		}

		@Override
		public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
			return color;
		}

		@Override
		public boolean isFoggyAt(int x, int y) {
			return false;
		}

		@Override
		public boolean renderClouds(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, double camX, double camY, double camZ, Matrix4f projectionMatrix) {
			if (customClouds != null && !customClouds.isEmpty()) {
				Iterator<Consumer<Object[]>> iterator = customClouds.iterator();
				while (iterator.hasNext()) {
					iterator.next().accept(new Object[]{level, ticks, partialTick, poseStack, camX, camY, camZ, projectionMatrix});
				}
				customClouds.clear();
			}
			return true;
		}

		@Override
		public boolean renderSky(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, Camera camera, Matrix4f projectionMatrix, boolean isFoggy, Runnable setupFog) {
			if (customSky != null && !customSky.isEmpty()) {
				Iterator<Consumer<Object[]>> iterator = customSky.iterator();
				while (iterator.hasNext()) {
					iterator.next().accept(new Object[]{level, ticks, partialTick, poseStack, camera, projectionMatrix, isFoggy, setupFog});
				}
				customSky.clear();
			}
			return true;
		}

		@Override
		public boolean renderSnowAndRain(ClientLevel level, int ticks, float partialTick, LightTexture lightTexture, double camX, double camY, double camZ) {
			if (customWeather != null && !customWeather.isEmpty()) {
				Iterator<Consumer<Object[]>> iterator = customWeather.iterator();
				while (iterator.hasNext()) {
					iterator.next().accept(new Object[]{level, ticks, partialTick, lightTexture, camX, camY, camZ});
				}
				customWeather.clear();
			}
			return true;
		}

		@Override
		public boolean tickRain(ClientLevel level, int ticks, Camera camera) {
			if (customEffects != null && !customEffects.isEmpty()) {
				Iterator<Consumer<Object[]>> iterator = customEffects.iterator();
				while (iterator.hasNext()) {
					iterator.next().accept(new Object[]{level, ticks, camera});
				}
				customEffects.clear();
			}
			return true;
		}
	}

	public static RegisterDimensionSpecialEffectsEvent provider = null;

	public static void register(ResourceKey<Level> dimension, DimensionSpecialEffects effects) {
		provider.register(dimension.location(), effects);
	}

	public static DimensionSpecialEffects createOverworldEffects(final boolean constantWhiteLight, final boolean constantAmbientLight, final boolean fog) {
		return new CustomDimensionEffects(192.0F, true, DimensionSpecialEffects.SkyType.NORMAL, constantWhiteLight, constantAmbientLight) {
			@Override
			public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
				return color.multiply(sunHeight * 0.94F + 0.06F, sunHeight * 0.94F + 0.06F, sunHeight * 0.91F + 0.09F);
			}

			@Override
			public boolean isFoggyAt(int x, int y) {
				return fog;
			}
		};
	}

	public static DimensionSpecialEffects createNetherEffects(final boolean constantWhiteLight, final boolean constantAmbientLight, final boolean fog) {
		return new CustomDimensionEffects(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, constantWhiteLight, constantAmbientLight) {
			@Override
			public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
				return color;
			}

			@Override
			public boolean isFoggyAt(int x, int y) {
				return fog;
			}
		};
	}

	public static DimensionSpecialEffects createEndEffects(final boolean constantWhiteLight, final boolean constantAmbientLight, final boolean fog) {
		return new CustomDimensionEffects(Float.NaN, false, DimensionSpecialEffects.SkyType.END, constantWhiteLight, constantAmbientLight) {
			@Override
			public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
				return color.scale(0.15F);
			}

			@Override
			public boolean isFoggyAt(int x, int y) {
				return fog;
			}
		};
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void setupDimensions(RegisterDimensionSpecialEffectsEvent event) {
		provider = event;
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		register(Level.OVERWORLD, createOverworldEffects(false, false, false));
		register(Level.NETHER, createNetherEffects(false, true, false));
		register(Level.END, createEndEffects(true, false, false));
		register(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:aether")), createOverworldEffects(false, false, false));
		register(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:backrooms_dimension")), createOverworldEffects(false, false, false));
		register(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:brazil")), createOverworldEffects(false, false, false));
		register(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:cyberspace")), createOverworldEffects(false, false, false));
		register(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:nightmare_dimension")), createOverworldEffects(false, false, false));
		register(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:peemension")), createOverworldEffects(false, false, false));
		register(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:poland")), createOverworldEffects(false, false, false));
		register(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:sus")), createOverworldEffects(false, false, false));
		register(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("purechaos:wood_dimension")), createOverworldEffects(false, false, false));
	}
}
