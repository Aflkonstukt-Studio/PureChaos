
package xyz.vikkivuk.chaosmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class GggggggBlock extends Block {

	public GggggggBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.CHAIN).strength(3f, 14f).requiresCorrectToolForDrops()
				.friction(3.3000000000000003f).speedFactor(3f).jumpFactor(2f));

	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof TieredItem tieredItem)
			return tieredItem.getTier().getLevel() >= 0;
		return false;
	}

}
