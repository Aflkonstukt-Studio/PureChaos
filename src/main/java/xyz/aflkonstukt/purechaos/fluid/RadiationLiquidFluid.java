
package xyz.aflkonstukt.purechaos.fluid;

import xyz.aflkonstukt.purechaos.init.PurechaosModItems;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluidTypes;
import xyz.aflkonstukt.purechaos.init.PurechaosModBlocks;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

public abstract class RadiationLiquidFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> PurechaosModFluidTypes.RADIATION_LIQUID_TYPE.get(), () -> PurechaosModFluids.RADIATION_LIQUID.get(),
			() -> PurechaosModFluids.FLOWING_RADIATION_LIQUID.get()).explosionResistance(100f).bucket(() -> PurechaosModItems.RADIATION_LIQUID_BUCKET.get()).block(() -> (LiquidBlock) PurechaosModBlocks.RADIATION_LIQUID.get());

	private RadiationLiquidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends RadiationLiquidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends RadiationLiquidFluid {
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
