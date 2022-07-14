
package xyz.vikkivuk.chaosmod.world.features.ores;

public class StandingBabyFeature extends OreFeature {

	public static StandingBabyFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new StandingBabyFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("chaosmod:standing_baby", FEATURE,
				new OreConfiguration(StandingBabyFeatureRuleTest.INSTANCE, ChaosmodModBlocks.STANDING_BABY.get().defaultBlockState(), 16));
		PLACED_FEATURE = PlacementUtils.register("chaosmod:standing_baby", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(10), InSquarePlacement.spread(),
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
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:brazil")));

	public StandingBabyFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class StandingBabyFeatureRuleTest extends RuleTest {

		static final StandingBabyFeatureRuleTest INSTANCE = new StandingBabyFeatureRuleTest();

		private static final com.mojang.serialization.Codec<StandingBabyFeatureRuleTest> CODEC = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		private static final RuleTestType<StandingBabyFeatureRuleTest> CUSTOM_MATCH = () -> CODEC;

		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			Registry.register(Registry.RULE_TEST, new ResourceLocation("chaosmod:standing_baby_match"), CUSTOM_MATCH);
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
