
package xyz.aflkonstukt.purechaos.fluid;

import xyz.aflkonstukt.purechaos.init.PurechaosModParticleTypes;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluidTypes;
import xyz.aflkonstukt.purechaos.init.PurechaosModBlocks;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

public abstract class OrangeFluidFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> PurechaosModFluidTypes.ORANGE_FLUID_TYPE.get(), () -> PurechaosModFluids.ORANGE_FLUID.get(), () -> PurechaosModFluids.FLOWING_ORANGE_FLUID.get())
			.explosionResistance(100f).tickRate(3).bucket(() -> PurechaosModItems.ORANGE_FLUID_BUCKET.get()).block(() -> (LiquidBlock) PurechaosModBlocks.ORANGE_FLUID.get());

	private OrangeFluidFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (PurechaosModParticleTypes.CUM_DRIP.get());
	}

	public static class Source extends OrangeFluidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends OrangeFluidFluid {
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
