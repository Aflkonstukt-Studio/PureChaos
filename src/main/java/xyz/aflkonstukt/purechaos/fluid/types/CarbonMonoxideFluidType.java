
package xyz.aflkonstukt.purechaos.fluid.types;

import xyz.aflkonstukt.purechaos.init.PurechaosModFluidTypes;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CarbonMonoxideFluidType extends FluidType {
	public CarbonMonoxideFluidType() {
		super(FluidType.Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).motionScale(0.007D).temperature(4000).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
				.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
	}

	@SubscribeEvent
	public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
		event.registerFluidType(new IClientFluidTypeExtensions() {
			private static final ResourceLocation STILL_TEXTURE = ResourceLocation.parse("purechaos:block/cum");
			private static final ResourceLocation FLOWING_TEXTURE = ResourceLocation.parse("purechaos:block/cum");

			@Override
			public ResourceLocation getStillTexture() {
				return STILL_TEXTURE;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return FLOWING_TEXTURE;
			}
		}, PurechaosModFluidTypes.CARBON_MONOXIDE_TYPE.get());
	}
}
