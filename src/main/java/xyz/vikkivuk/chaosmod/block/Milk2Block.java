
package xyz.vikkivuk.chaosmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Milk2Block extends LiquidBlock {
	public Milk2Block() {
		super(() -> (FlowingFluid) ChaosmodModFluids.MILK_2.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

}