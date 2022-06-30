package xyz.vikkivuk.chaosmod.world.features.treedecorators;

public class EkesmasterbaitTrunkDecorator extends TrunkVineDecorator {

	public static final EkesmasterbaitTrunkDecorator INSTANCE = new EkesmasterbaitTrunkDecorator();

	public static com.mojang.serialization.Codec<EkesmasterbaitTrunkDecorator> codec;
	public static TreeDecoratorType<?> tdt;

	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("ekesmasterbait_tree_trunk_decorator");
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
					biConsumer.accept(blockpos, Blocks.AMETHYST_CLUSTER.defaultBlockState());
				}
			}

		});
	}
}
