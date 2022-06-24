
package xyz.vikkivuk.chaosmod.fluid;

public abstract class PeeFluid extends ForgeFlowingFluid {

	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ChaosmodModFluids.PEE,
			ChaosmodModFluids.FLOWING_PEE,
			FluidAttributes.builder(new ResourceLocation("chaosmod:blocks/pee"), new ResourceLocation("chaosmod:blocks/pee_flowing"))

	).explosionResistance(100f).canMultiply().tickRate(10)

			.bucket(ChaosmodModItems.PEE_BUCKET).block(() -> (LiquidBlock) ChaosmodModBlocks.PEE.get());

	private PeeFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.BUBBLE;
	}

	public static class Source extends PeeFluid {
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

	public static class Flowing extends PeeFluid {
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
