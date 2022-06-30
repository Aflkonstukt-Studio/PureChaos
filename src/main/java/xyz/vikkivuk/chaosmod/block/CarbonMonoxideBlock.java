
package xyz.vikkivuk.chaosmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CarbonMonoxideBlock extends LiquidBlock {
	public CarbonMonoxideBlock() {
		super(() -> (FlowingFluid) ChaosmodModFluids.CARBON_MONOXIDE.get(),
				BlockBehaviour.Properties.of(Material.WATER, MaterialColor.COLOR_YELLOW).strength(100f)

		);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 12;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		CODeathProcedure.execute(

		);
	}

}