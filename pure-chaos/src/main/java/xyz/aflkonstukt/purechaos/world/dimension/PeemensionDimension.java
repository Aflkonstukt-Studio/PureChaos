
package xyz.aflkonstukt.purechaos.world.dimension;

import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.DimensionSpecialEffects;

public class PeemensionDimension {
	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class PeemensionSpecialEffectsHandler {
		@SubscribeEvent
		public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
			DimensionSpecialEffects customEffect = new DimensionSpecialEffects(192f, true, DimensionSpecialEffects.SkyType.NORMAL, false, false) {
				@Override
				public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
					return new Vec3(1, 0.8, 0.2);
				}

				@Override
				public boolean isFoggyAt(int x, int y) {
					return true;
				}
			};
			event.register(ResourceLocation.parse("purechaos:peemension"), customEffect);
		}
	}
}
