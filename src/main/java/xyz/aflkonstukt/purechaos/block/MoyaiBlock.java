
package xyz.aflkonstukt.purechaos.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

public class MoyaiBlock extends FallingBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final MapCodec<MoyaiBlock> CODEC = simpleCodec(MoyaiBlock::new);

	public MapCodec<MoyaiBlock> codec() {
		return CODEC;
	}

	public MoyaiBlock(BlockBehaviour.Properties ignored) {
		this();
	}

	public MoyaiBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM)
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:vine_boom")), () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:vine_boom")),
						() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:vine_boom")), () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:vine_boom")),
						() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:vine_boom"))))
				.strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(7, 4, 11, 9, 10, 13.5), box(5, 8, 12, 11, 9, 12.25), box(6, 2, 11.75, 10, 2.5, 12.25), box(11, 2, 7, 11.25, 7, 10), box(4.75, 2, 7, 5, 7, 10));
			case NORTH -> Shapes.or(box(7, 4, 2.5, 9, 10, 5), box(5, 8, 3.75, 11, 9, 4), box(6, 2, 3.75, 10, 2.5, 4.25), box(4.75, 2, 6, 5, 7, 9), box(11, 2, 6, 11.25, 7, 9));
			case EAST -> Shapes.or(box(11, 4, 7, 13.5, 10, 9), box(12, 8, 5, 12.25, 9, 11), box(11.75, 2, 6, 12.25, 2.5, 10), box(7, 2, 4.75, 10, 7, 5), box(7, 2, 11, 10, 7, 11.25));
			case WEST -> Shapes.or(box(2.5, 4, 7, 5, 10, 9), box(3.75, 8, 5, 4, 9, 11), box(3.75, 2, 6, 4.25, 2.5, 10), box(6, 2, 11, 9, 7, 11.25), box(6, 2, 4.75, 9, 7, 5));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		if (context.getClickedFace().getAxis() == Direction.Axis.Y)
			return this.defaultBlockState().setValue(FACING, Direction.NORTH);
		return this.defaultBlockState().setValue(FACING, context.getClickedFace());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}
