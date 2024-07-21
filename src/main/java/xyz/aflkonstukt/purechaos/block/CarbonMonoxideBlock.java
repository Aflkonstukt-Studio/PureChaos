
package xyz.aflkonstukt.purechaos.block;

import xyz.aflkonstukt.purechaos.procedures.CODeathProcedure;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class CarbonMonoxideBlock extends LiquidBlock {
	public CarbonMonoxideBlock() {
		super(PurechaosModFluids.CARBON_MONOXIDE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		CODeathProcedure.execute(world, entity);
	}
}
