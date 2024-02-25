
package xyz.aflkonstukt.purechaos.fluid;

import xyz.aflkonstukt.purechaos.init.PurechaosModItems;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluidTypes;
import xyz.aflkonstukt.purechaos.init.PurechaosModBlocks;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

public abstract class CarbonMonoxideFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> PurechaosModFluidTypes.CARBON_MONOXIDE_TYPE.get(), () -> PurechaosModFluids.CARBON_MONOXIDE.get(),
			() -> PurechaosModFluids.FLOWING_CARBON_MONOXIDE.get()).explosionResistance(100f).tickRate(10).bucket(() -> PurechaosModItems.CARBON_MONOXIDE_BUCKET.get()).block(() -> (LiquidBlock) PurechaosModBlocks.CARBON_MONOXIDE.get());

	private CarbonMonoxideFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.SPIT;
	}

	public static class Source extends CarbonMonoxideFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends CarbonMonoxideFluid {
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
