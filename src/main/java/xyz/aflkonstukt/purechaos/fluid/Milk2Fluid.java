
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

public abstract class Milk2Fluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> PurechaosModFluidTypes.MILK_2_TYPE.get(), () -> PurechaosModFluids.MILK_2.get(), () -> PurechaosModFluids.FLOWING_MILK_2.get())
			.explosionResistance(100f).tickRate(6).bucket(() -> PurechaosModItems.MILK_2_BUCKET.get()).block(() -> (LiquidBlock) PurechaosModBlocks.MILK_2.get());

	private Milk2Fluid() {
		super(PROPERTIES);
	}

	public static class Source extends Milk2Fluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends Milk2Fluid {
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
