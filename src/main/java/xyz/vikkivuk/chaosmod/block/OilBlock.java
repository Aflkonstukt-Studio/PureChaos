
package xyz.vikkivuk.chaosmod.block;

import xyz.vikkivuk.chaosmod.init.ChaosmodModFluids;

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
		super(() -> (FlowingFluid) ChaosmodModFluids.OIL.get(), BlockBehaviour.Properties.of(Material.LAVA).strength(100f)

				.lightLevel(s -> 15));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
