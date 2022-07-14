
package xyz.vikkivuk.chaosmod.world.features.ores;

public class ComputerFeature extends OreFeature {

	public static ComputerFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new ComputerFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("chaosmod:computer", FEATURE,
				new OreConfiguration(ComputerFeatureRuleTest.INSTANCE, ChaosmodModBlocks.COMPUTER.get().defaultBlockState(), 16));
		PLACED_FEATURE = PlacementUtils.register("chaosmod:computer", CONFIGURED_FEATURE, List.of(CountPlacement.of(10), InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64)), BiomeFilter.biome()));
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD, Level.NETHER, Level.END,
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:peemension")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:wood_dimension")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:sus")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:brazil")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:cyberspace")));

	public ComputerFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class ComputerFeatureRuleTest extends RuleTest {

		static final ComputerFeatureRuleTest INSTANCE = new ComputerFeatureRuleTest();

		private static final com.mojang.serialization.Codec<ComputerFeatureRuleTest> CODEC = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		private static final RuleTestType<ComputerFeatureRuleTest> CUSTOM_MATCH = () -> CODEC;

		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			Registry.register(Registry.RULE_TEST, new ResourceLocation("chaosmod:computer_match"), CUSTOM_MATCH);
		}

		private List<Block> base_blocks = null;

		public boolean test(BlockState blockAt, Random random) {
			if (base_blocks == null) {
				base_blocks = List.of(Blocks.STONE);
			}

			return base_blocks.contains(blockAt.getBlock());
		}

		protected RuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}

	}

}
