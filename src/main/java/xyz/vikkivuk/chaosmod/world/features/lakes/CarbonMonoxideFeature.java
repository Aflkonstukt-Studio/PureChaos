
package xyz.vikkivuk.chaosmod.world.features.lakes;

import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class CarbonMonoxideFeature extends LakeFeature {

	public static CarbonMonoxideFeature FEATURE = null;
	public static Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new CarbonMonoxideFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("chaosmod:carbon_monoxide", FEATURE, new LakeFeature.Configuration(
				BlockStateProvider.simple(ChaosmodModBlocks.CARBON_MONOXIDE.get()), BlockStateProvider.simple(Blocks.AIR)));
		PLACED_FEATURE = PlacementUtils.register("chaosmod:carbon_monoxide", CONFIGURED_FEATURE,
				List.of(RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
						EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE), 32),
						BiomeFilter.biome()));
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD,
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:peemension")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:sus")));

	public CarbonMonoxideFeature() {
		super(LakeFeature.Configuration.CODEC);
	}

	@Override
	public boolean place(FeaturePlaceContext<LakeFeature.Configuration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}
}
