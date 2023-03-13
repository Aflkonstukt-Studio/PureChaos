
package xyz.vikkivuk.chaosmod.block;

import xyz.vikkivuk.chaosmod.init.ChaosmodModFluids;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class CumBlock extends LiquidBlock {
	public CumBlock() {
		super(() -> (FlowingFluid) ChaosmodModFluids.CUM.get(), BlockBehaviour.Properties.of(Material.LAVA, MaterialColor.DEEPSLATE).strength(100f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)

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
