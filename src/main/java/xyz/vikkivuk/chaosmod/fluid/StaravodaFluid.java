
package xyz.vikkivuk.chaosmod.fluid;

import xyz.vikkivuk.chaosmod.init.ChaosmodModItems;
import xyz.vikkivuk.chaosmod.init.ChaosmodModFluids;
import xyz.vikkivuk.chaosmod.init.ChaosmodModBlocks;
import xyz.vikkivuk.chaosmod.fluid.attributes.StaravodaFluidAttributes;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

public abstract class StaravodaFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ChaosmodModFluids.STARAVODA,
			ChaosmodModFluids.FLOWING_STARAVODA,
			StaravodaFluidAttributes
					.builder(new ResourceLocation("chaosmod:blocks/minecraft-water"), new ResourceLocation("chaosmod:blocks/minecraft-water"))

					.sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("chaosmod:amogus"))).color(-13083194))
			.explosionResistance(100f).canMultiply()

			.slopeFindDistance(1).bucket(ChaosmodModItems.STARAVODA_BUCKET).block(() -> (LiquidBlock) ChaosmodModBlocks.STARAVODA.get());

	private StaravodaFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.BUBBLE;
	}

	public static class Source extends StaravodaFluid {
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

	public static class Flowing extends StaravodaFluid {
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
