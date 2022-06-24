
package xyz.vikkivuk.chaosmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PotatusBlock extends FlowerBlock {
	public PotatusBlock() {
		super(MobEffects.DIG_SLOWDOWN, 60, BlockBehaviour.Properties.of(Material.PLANT).noCollission().sound(SoundType.LILY_PAD).instabreak());
	}

	@Override
	public int getEffectDuration() {
		return 60;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(ChaosmodModItems.POTATO_SPUDS.get(), 4));
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(ChaosmodModBlocks.POTATUS.get(), renderType -> renderType == RenderType.cutout());
	}

}
