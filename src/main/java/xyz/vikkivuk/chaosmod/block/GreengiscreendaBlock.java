
package xyz.vikkivuk.chaosmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class GreengiscreendaBlock extends Block {

	public GreengiscreendaBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(new ForgeSoundType(1.0f, 1.0f,
				() -> new SoundEvent(new ResourceLocation("chaosmod:fu-k")), () -> new SoundEvent(new ResourceLocation("chaosmod:dudeshutt")),
				() -> new SoundEvent(new ResourceLocation("chaosmod:dudeshutt")), () -> new SoundEvent(new ResourceLocation("chaosmod:dudeshutt")),
				() -> new SoundEvent(new ResourceLocation("chaosmod:dudeshutt")))).strength(1f, 10f));

	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

}
