
package xyz.vikkivuk.chaosmod.fluid;

public abstract class CarbonMonoxideFluid extends ForgeFlowingFluid {

	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ChaosmodModFluids.CARBON_MONOXIDE,
			ChaosmodModFluids.FLOWING_CARBON_MONOXIDE,
			FluidAttributes
					.builder(new ResourceLocation("chaosmod:blocks/ppppppppppp-alpha"), new ResourceLocation("chaosmod:blocks/ppppppppppp-alpha"))

					.density(-1000).viscosity(10).temperature(100).gaseous()

	).explosionResistance(100f)

			.tickRate(36)

			.bucket(ChaosmodModItems.CARBON_MONOXIDE_BUCKET).block(() -> (LiquidBlock) ChaosmodModBlocks.CARBON_MONOXIDE.get());

	private CarbonMonoxideFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.SPIT;
	}

	public static class Source extends CarbonMonoxideFluid {
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

	public static class Flowing extends CarbonMonoxideFluid {
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
