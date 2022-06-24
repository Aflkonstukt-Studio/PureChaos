
package xyz.vikkivuk.chaosmod.world.features.ores;

public class SADsFeature extends OreFeature {

	public static SADsFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new SADsFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("chaosmod:sa_ds", FEATURE,
				new OreConfiguration(SADsFeatureRuleTest.INSTANCE, ChaosmodModBlocks.SA_DS.get().defaultBlockState(), 16));
		PLACED_FEATURE = PlacementUtils.register("chaosmod:sa_ds", CONFIGURED_FEATURE, List.of(CountPlacement.of(10), InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64)), BiomeFilter.biome()));
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD, Level.NETHER, Level.END,
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:peemension")));

	public SADsFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class SADsFeatureRuleTest extends RuleTest {

		static final SADsFeatureRuleTest INSTANCE = new SADsFeatureRuleTest();

		private static final com.mojang.serialization.Codec<SADsFeatureRuleTest> CODEC = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		private static final RuleTestType<SADsFeatureRuleTest> CUSTOM_MATCH = () -> CODEC;

		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			Registry.register(Registry.RULE_TEST, new ResourceLocation("chaosmod:sa_ds_match"), CUSTOM_MATCH);
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
