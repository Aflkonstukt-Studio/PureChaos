
package xyz.aflkonstukt.purechaos.block;

import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class StaravodaBlock extends LiquidBlock {
	public StaravodaBlock() {
		super(() -> (FlowingFluid) PurechaosModFluids.STARAVODA.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
