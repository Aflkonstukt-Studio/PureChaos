
package xyz.vikkivuk.chaosmod.world.features.lakes;

import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class RadiationLiquidFeature extends LakeFeature {

	public static RadiationLiquidFeature FEATURE = null;
	public static Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new RadiationLiquidFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("chaosmod:radiation_liquid", FEATURE, new LakeFeature.Configuration(
				BlockStateProvider.simple(ChaosmodModBlocks.RADIATION_LIQUID.get()), BlockStateProvider.simple(Blocks.AIR)));
		PLACED_FEATURE = PlacementUtils.register("chaosmod:radiation_liquid", CONFIGURED_FEATURE,
				List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
						EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE), 32),
						BiomeFilter.biome()));
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public RadiationLiquidFeature() {
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
