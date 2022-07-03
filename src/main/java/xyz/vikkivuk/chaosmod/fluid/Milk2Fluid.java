
package xyz.vikkivuk.chaosmod.fluid;

public abstract class Milk2Fluid extends ForgeFlowingFluid {

	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ChaosmodModFluids.MILK_2,
			ChaosmodModFluids.FLOWING_MILK_2,
			FluidAttributes.builder(new ResourceLocation("chaosmod:blocks/milk2_still"), new ResourceLocation("chaosmod:blocks/milk2_flowing"))

	).explosionResistance(100f)

			.tickRate(6)

			.bucket(ChaosmodModItems.MILK_2_BUCKET).block(() -> (LiquidBlock) ChaosmodModBlocks.MILK_2.get());

	private Milk2Fluid() {
		super(PROPERTIES);
	}

	@Override
	public Vec3 getFlow(BlockGetter world, BlockPos pos, FluidState fluidstate) {
		return super.getFlow(world, pos, fluidstate).scale(10);
	}

	public static class Source extends Milk2Fluid {
		public Source() {
			super();
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends Milk2Fluid {
		public Flowing() {
			super();
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}

}
