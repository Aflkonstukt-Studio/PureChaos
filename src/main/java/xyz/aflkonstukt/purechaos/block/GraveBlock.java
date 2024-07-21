
package xyz.aflkonstukt.purechaos.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class GraveBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public GraveBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.GRAVEL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
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
			default -> Shapes.or(box(2, 0, -1, 14, 4, 3), box(3, 4, -1, 13, 16, 2), box(4, 10, 1.25, 12, 14, 2.25), box(6, 12.25, 2, 6.25, 13.75, 2.26), box(5, 11.75, 2, 6.25, 12.25, 2.26), box(4.75, 13.25, 2, 6, 13.75, 2.26),
					box(4.75, 10.25, 2, 5, 13.75, 2.26), box(10.36396, 10.38604, 2, 10.61396, 12.48604, 2.26), box(7.75, 10.25, 2, 8, 13.75, 2.26), box(10, 11.75, 2, 11.25, 12.25, 2.26), box(9.75, 10.25, 2, 10, 13.75, 2.26),
					box(9.75, 13.25, 2, 11, 13.75, 2.26), box(11, 12.25, 2, 11.25, 13.75, 2.26), box(3.90685, 0, 2.65685, 12.15685, 1, 15.65685), box(2.90685, 0, 2.65685, 3.90685, 1, 14.65685), box(12.15685, 0, 2.65685, 13.15685, 1, 14.65685),
					box(4.90685, 0, 15.65685, 11.15685, 1, 16.65685));
			case NORTH -> Shapes.or(box(2, 0, 13, 14, 4, 17), box(3, 4, 14, 13, 16, 17), box(4, 10, 13.75, 12, 14, 14.75), box(9.75, 12.25, 13.74, 10, 13.75, 14), box(9.75, 11.75, 13.74, 11, 12.25, 14), box(10, 13.25, 13.74, 11.25, 13.75, 14),
					box(11, 10.25, 13.74, 11.25, 13.75, 14), box(5.38604, 10.38604, 13.74, 5.63604, 12.48604, 14), box(8, 10.25, 13.74, 8.25, 13.75, 14), box(4.75, 11.75, 13.74, 6, 12.25, 14), box(6, 10.25, 13.74, 6.25, 13.75, 14),
					box(5, 13.25, 13.74, 6.25, 13.75, 14), box(4.75, 12.25, 13.74, 5, 13.75, 14), box(3.84315, 0, 0.34315, 12.09315, 1, 13.34315), box(12.09315, 0, 1.34315, 13.09315, 1, 13.34315), box(2.84315, 0, 1.34315, 3.84315, 1, 13.34315),
					box(4.84315, 0, -0.65685, 11.09315, 1, 0.34315));
			case EAST -> Shapes.or(box(-1, 0, 2, 3, 4, 14), box(-1, 4, 3, 2, 16, 13), box(1.25, 10, 4, 2.25, 14, 12), box(2, 12.25, 9.75, 2.26, 13.75, 10), box(2, 11.75, 9.75, 2.26, 12.25, 11), box(2, 13.25, 10, 2.26, 13.75, 11.25),
					box(2, 10.25, 11, 2.26, 13.75, 11.25), box(2, 10.38604, 5.38604, 2.26, 12.48604, 5.63604), box(2, 10.25, 8, 2.26, 13.75, 8.25), box(2, 11.75, 4.75, 2.26, 12.25, 6), box(2, 10.25, 6, 2.26, 13.75, 6.25),
					box(2, 13.25, 5, 2.26, 13.75, 6.25), box(2, 12.25, 4.75, 2.26, 13.75, 5), box(2.65685, 0, 3.84315, 15.65685, 1, 12.09315), box(2.65685, 0, 12.09315, 14.65685, 1, 13.09315), box(2.65685, 0, 2.84315, 14.65685, 1, 3.84315),
					box(15.65685, 0, 4.84315, 16.65685, 1, 11.09315));
			case WEST -> Shapes.or(box(13, 0, 2, 17, 4, 14), box(14, 4, 3, 17, 16, 13), box(13.75, 10, 4, 14.75, 14, 12), box(13.74, 12.25, 6, 14, 13.75, 6.25), box(13.74, 11.75, 5, 14, 12.25, 6.25), box(13.74, 13.25, 4.75, 14, 13.75, 6),
					box(13.74, 10.25, 4.75, 14, 13.75, 5), box(13.74, 10.38604, 10.36396, 14, 12.48604, 10.61396), box(13.74, 10.25, 7.75, 14, 13.75, 8), box(13.74, 11.75, 10, 14, 12.25, 11.25), box(13.74, 10.25, 9.75, 14, 13.75, 10),
					box(13.74, 13.25, 9.75, 14, 13.75, 11), box(13.74, 12.25, 11, 14, 13.75, 11.25), box(0.34315, 0, 3.90685, 13.34315, 1, 12.15685), box(1.34315, 0, 2.90685, 13.34315, 1, 3.90685), box(1.34315, 0, 12.15685, 13.34315, 1, 13.15685),
					box(-0.65685, 0, 4.90685, 0.34315, 1, 11.15685));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.LAVA;
	}
}
