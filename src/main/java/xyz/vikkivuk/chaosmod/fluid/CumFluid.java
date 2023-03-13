
package xyz.vikkivuk.chaosmod.fluid;

import xyz.vikkivuk.chaosmod.init.ChaosmodModParticleTypes;
import xyz.vikkivuk.chaosmod.init.ChaosmodModItems;
import xyz.vikkivuk.chaosmod.init.ChaosmodModFluids;
import xyz.vikkivuk.chaosmod.init.ChaosmodModBlocks;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.Rarity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.BlockPos;

public abstract class CumFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ChaosmodModFluids.CUM, ChaosmodModFluids.FLOWING_CUM,
			FluidAttributes.builder(new ResourceLocation("chaosmod:blocks/cum"), new ResourceLocation("chaosmod:blocks/cum")).luminosity(9)

					.temperature(69420)

					.rarity(Rarity.UNCOMMON).sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.soul_soil.break"))))
			.explosionResistance(100f)

			.tickRate(6)

			.slopeFindDistance(1).bucket(ChaosmodModItems.CUM_BUCKET).block(() -> (LiquidBlock) ChaosmodModBlocks.CUM.get());

	private CumFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (ChaosmodModParticleTypes.CUM_DRIP.get());
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
