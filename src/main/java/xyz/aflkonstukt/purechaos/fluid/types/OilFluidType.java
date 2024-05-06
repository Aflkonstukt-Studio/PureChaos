
package xyz.aflkonstukt.purechaos.fluid.types;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.item.Rarity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class OilFluidType extends FluidType {
	public OilFluidType() {
		super(FluidType.Properties.create().canSwim(false).canDrown(false).pathType(BlockPathTypes.LAVA).adjacentPathType(null).motionScale(0.007D).lightLevel(15).canConvertToSource(true).rarity(Rarity.EPIC)
				.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
	}

	@Override
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {
			private static final ResourceLocation STILL_TEXTURE = new ResourceLocation("purechaos:block/oil_still"), FLOWING_TEXTURE = new ResourceLocation("purechaos:block/oil_flowing");

			@Override
			public ResourceLocation getStillTexture() {
				return STILL_TEXTURE;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return FLOWING_TEXTURE;
			}
		});
	}
}
