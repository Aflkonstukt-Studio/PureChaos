
package xyz.aflkonstukt.purechaos.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class GreengiscreendaBlock extends Block {
	public GreengiscreendaBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM)
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:fu-k")), () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:dudeshutt")),
						() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:dudeshutt")), () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:dudeshutt")),
						() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:dudeshutt"))))
				.strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
