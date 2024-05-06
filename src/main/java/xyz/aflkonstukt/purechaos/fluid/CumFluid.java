
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

public abstract class CumFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> PurechaosModFluidTypes.CUM_TYPE.get(), () -> PurechaosModFluids.CUM.get(), () -> PurechaosModFluids.FLOWING_CUM.get()).explosionResistance(100f)
			.tickRate(6).slopeFindDistance(1).bucket(() -> PurechaosModItems.CUM_BUCKET.get()).block(() -> (LiquidBlock) PurechaosModBlocks.CUM.get());

	private CumFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (PurechaosModParticleTypes.CUM_DRIP.get());
	}

	public static class Source extends CumFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends CumFluid {
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
