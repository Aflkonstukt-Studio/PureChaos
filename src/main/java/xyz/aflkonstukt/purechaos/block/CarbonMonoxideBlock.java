
package xyz.aflkonstukt.purechaos.block;

import xyz.aflkonstukt.purechaos.procedures.CODeathProcedure;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class CarbonMonoxideBlock extends LiquidBlock {
	public CarbonMonoxideBlock() {
		super(() -> (FlowingFluid) PurechaosModFluids.CARBON_MONOXIDE.get(), BlockBehaviour.Properties.of(Material.WATER, MaterialColor.COLOR_YELLOW).strength(100f)

		);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		CODeathProcedure.execute(entity);
	}
}
