
package xyz.vikkivuk.chaosmod.fluid.attributes;

public class StaravodaFluidAttributes extends FluidAttributes {

	public static CustomBuilder builder(ResourceLocation stillTexture, ResourceLocation flowingTexture) {
		return new CustomBuilder(stillTexture, flowingTexture, StaravodaFluidAttributes::new);
	}

	public static class CustomBuilder extends FluidAttributes.Builder {
		protected CustomBuilder(ResourceLocation stillTexture, ResourceLocation flowingTexture,
				BiFunction<FluidAttributes.Builder, Fluid, FluidAttributes> factory) {
			super(stillTexture, flowingTexture, factory);
		}
	}

	protected StaravodaFluidAttributes(Builder builder, Fluid fluid) {
		super(builder, fluid);
	}

	@Override
	public int getColor(BlockAndTintGetter world, BlockPos pos) {
		return BiomeColors.getAverageWaterColor(world, pos) | 0xFF000000;
	}

}