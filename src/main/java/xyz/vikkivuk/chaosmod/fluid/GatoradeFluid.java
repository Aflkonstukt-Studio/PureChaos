
package xyz.vikkivuk.chaosmod.fluid;

import xyz.vikkivuk.chaosmod.init.ChaosmodModItems;
import xyz.vikkivuk.chaosmod.init.ChaosmodModFluids;
import xyz.vikkivuk.chaosmod.init.ChaosmodModBlocks;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

public abstract class GatoradeFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ChaosmodModFluids.GATORADE,
			ChaosmodModFluids.FLOWING_GATORADE, FluidAttributes.builder(new ResourceLocation("chaosmod:blocks/gatorade_normal_still"),
					new ResourceLocation("chaosmod:blocks/gatorade_normal_flowing"))

	).explosionResistance(100f)

			.bucket(ChaosmodModItems.GATORADE_BUCKET).block(() -> (LiquidBlock) ChaosmodModBlocks.GATORADE.get());

	private GatoradeFluid() {
		super(PROPERTIES);
	}

	public static class Source extends GatoradeFluid {
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

	public static class Flowing extends GatoradeFluid {
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
