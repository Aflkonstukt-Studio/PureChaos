
package xyz.vikkivuk.chaosmod.block;

import xyz.vikkivuk.chaosmod.init.ChaosmodModBlocks;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class GraveBlock extends Block implements SimpleWaterloggedBlock

{
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public GraveBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.GRAVEL).strength(1f, 10f).noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
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
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return Shapes.or(box(0, 0, 2, 4, 4, 14), box(0, 4, 3, 3, 16, 13), box(4, 0, 3, 18, 1, 13)).move(offset.x, offset.y, offset.z);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return this.defaultBlockState().setValue(WATERLOGGED, flag);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos,
			BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public BlockPathTypes getAiPathNodeType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.LAVA;
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(ChaosmodModBlocks.GRAVE.get(), renderType -> renderType == RenderType.cutout());
	}
}
