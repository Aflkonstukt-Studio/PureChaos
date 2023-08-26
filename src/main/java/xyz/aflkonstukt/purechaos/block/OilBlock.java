
package xyz.aflkonstukt.purechaos.block;

import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class OilBlock extends LiquidBlock {
	public OilBlock() {
		super(() -> (FlowingFluid) PurechaosModFluids.OIL.get(), BlockBehaviour.Properties.of(Material.LAVA).strength(100f)

				.lightLevel(s -> 15));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
