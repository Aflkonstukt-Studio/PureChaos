
package xyz.vikkivuk.chaosmod.block;

import xyz.vikkivuk.chaosmod.init.ChaosmodModFluids;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class OrangeFluidBlock extends LiquidBlock {
	public OrangeFluidBlock() {
		super(() -> (FlowingFluid) ChaosmodModFluids.ORANGE_FLUID.get(), BlockBehaviour.Properties.of(Material.LAVA).strength(100f)

		);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
