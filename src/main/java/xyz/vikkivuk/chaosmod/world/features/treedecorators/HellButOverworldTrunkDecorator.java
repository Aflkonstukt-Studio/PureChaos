package xyz.vikkivuk.chaosmod.world.features.treedecorators;

public class HellButOverworldTrunkDecorator extends TrunkVineDecorator {

	public static final HellButOverworldTrunkDecorator INSTANCE = new HellButOverworldTrunkDecorator();

	public static com.mojang.serialization.Codec<HellButOverworldTrunkDecorator> codec;
	public static TreeDecoratorType<?> tdt;

	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("hell_but_overworld_tree_trunk_decorator");
		ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos,
			List<BlockPos> listBlockPos2) {
		listBlockPos.forEach(blockpos -> {
			if (random.nextInt(3) > 0) {
				BlockPos bp = blockpos.below();
				if (Feature.isAir(levelReader, bp)) {
					biConsumer.accept(blockpos, Blocks.NETHER_BRICK_WALL.defaultBlockState());
				}
			}

		});
	}
}
