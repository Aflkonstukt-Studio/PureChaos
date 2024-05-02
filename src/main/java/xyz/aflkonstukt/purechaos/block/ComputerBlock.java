
package xyz.aflkonstukt.purechaos.block;

import xyz.aflkonstukt.purechaos.world.inventory.ComputerGuiMenu;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;

public class ComputerBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public ComputerBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.GRAVEL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(-0.75, 14.5, 6.5, 16.25, 26.5, 10), box(-2, 0, -1, 18, 1, 17), box(0.75, 1, 0.5, 15.2, 7.5, 15.5), box(-1, 1, 1, 17, 7, 15), box(4, 7.5, 2, 11.5, 8.5, 8), box(6, 8.5, 2.75, 9.5, 20.5, 6.25),
					box(16.5, 14.5, 4.5, 18.25, 26.5, 10.25), box(-2, 12.75, 4.5, 18.25, 14.5, 10.25), box(-2, 26.25, 4.5, 18.25, 28, 10.25), box(-2, 14.5, 4.5, -0.25, 26.5, 10.25), box(-1.25, 14.5, 3.5, 17.5, 26.5, 5));
			case NORTH -> Shapes.or(box(-0.25, 14.5, 6, 16.75, 26.5, 9.5), box(-2, 0, -1, 18, 1, 17), box(0.8, 1, 0.5, 15.25, 7.5, 15.5), box(-1, 1, 1, 17, 7, 15), box(4.5, 7.5, 8, 12, 8.5, 14), box(6.5, 8.5, 9.75, 10, 20.5, 13.25),
					box(-2.25, 14.5, 5.75, -0.5, 26.5, 11.5), box(-2.25, 12.75, 5.75, 18, 14.5, 11.5), box(-2.25, 26.25, 5.75, 18, 28, 11.5), box(16.25, 14.5, 5.75, 18, 26.5, 11.5), box(-1.5, 14.5, 11, 17.25, 26.5, 12.5));
			case EAST -> Shapes.or(box(6.5, 14.5, -0.25, 10, 26.5, 16.75), box(-1, 0, -2, 17, 1, 18), box(0.5, 1, 0.8, 15.5, 7.5, 15.25), box(1, 1, -1, 15, 7, 17), box(2, 7.5, 4.5, 8, 8.5, 12), box(2.75, 8.5, 6.5, 6.25, 20.5, 10),
					box(4.5, 14.5, -2.25, 10.25, 26.5, -0.5), box(4.5, 12.75, -2.25, 10.25, 14.5, 18), box(4.5, 26.25, -2.25, 10.25, 28, 18), box(4.5, 14.5, 16.25, 10.25, 26.5, 18), box(3.5, 14.5, -1.5, 5, 26.5, 17.25));
			case WEST -> Shapes.or(box(6, 14.5, -0.75, 9.5, 26.5, 16.25), box(-1, 0, -2, 17, 1, 18), box(0.5, 1, 0.75, 15.5, 7.5, 15.2), box(1, 1, -1, 15, 7, 17), box(8, 7.5, 4, 14, 8.5, 11.5), box(9.75, 8.5, 6, 13.25, 20.5, 9.5),
					box(5.75, 14.5, 16.5, 11.5, 26.5, 18.25), box(5.75, 12.75, -2, 11.5, 14.5, 18.25), box(5.75, 26.25, -2, 11.5, 28, 18.25), box(5.75, 14.5, -2, 11.5, 26.5, -0.25), box(11, 14.5, -1.25, 12.5, 26.5, 17.5));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayer player) {
			NetworkHooks.openScreen(player, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Computer");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new ComputerGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}
}
