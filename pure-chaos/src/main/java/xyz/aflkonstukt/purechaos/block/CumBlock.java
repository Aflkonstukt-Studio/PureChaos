
package xyz.aflkonstukt.purechaos.block;

import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class CumBlock extends LiquidBlock {
	public CumBlock() {
		super(PurechaosModFluids.CUM.get(), BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(100f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).noCollission().noLootTable().liquid()
				.pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
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
