
package xyz.vikkivuk.chaosmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CumBlock extends LiquidBlock {
	public CumBlock() {
		super(() -> (FlowingFluid) ChaosmodModFluids.CUM.get(), BlockBehaviour.Properties.of(Material.LAVA, MaterialColor.DEEPSLATE).strength(100f)
				.hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)

		);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 9;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 12;
	}

}