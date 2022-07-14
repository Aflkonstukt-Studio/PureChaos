
package xyz.vikkivuk.chaosmod.block;

import xyz.vikkivuk.chaosmod.procedures.RadiationLiquidMobplayerCollidesBlockProcedure;
import xyz.vikkivuk.chaosmod.init.ChaosmodModFluids;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class RadiationLiquidBlock extends LiquidBlock {
	public RadiationLiquidBlock() {
		super(() -> (FlowingFluid) ChaosmodModFluids.RADIATION_LIQUID.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		RadiationLiquidMobplayerCollidesBlockProcedure.execute(entity);
	}
}
