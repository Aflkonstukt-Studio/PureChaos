
package xyz.vikkivuk.chaosmod.fluid;

public abstract class CumFluid extends ForgeFlowingFluid {

	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ChaosmodModFluids.CUM,
			ChaosmodModFluids.FLOWING_CUM,
			FluidAttributes.builder(new ResourceLocation("chaosmod:blocks/ppppppppppp-alpha"), new ResourceLocation("chaosmod:blocks/walk"))
					.luminosity(9)

					.temperature(69420)

					.rarity(Rarity.UNCOMMON).sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.soul_soil.break"))))
			.explosionResistance(100f)

			.tickRate(100)

			.slopeFindDistance(1).bucket(ChaosmodModItems.CUM_BUCKET).block(() -> (LiquidBlock) ChaosmodModBlocks.CUM.get());

	private CumFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (ChaosmodModParticleTypes.DELETED_MOD_ELEMENT.get());
	}

	@Override
	public Vec3 getFlow(BlockGetter world, BlockPos pos, FluidState fluidstate) {
		return super.getFlow(world, pos, fluidstate).scale(3);
	}

	public static class Source extends CumFluid {
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

	public static class Flowing extends CumFluid {
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
