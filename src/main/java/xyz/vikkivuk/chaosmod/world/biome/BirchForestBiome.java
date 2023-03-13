
package xyz.vikkivuk.chaosmod.world.biome;

import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;

import java.util.List;

public class BirchForestBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-0.6f, 0.6f), Climate.Parameter.span(-0.6f, 0.6f), Climate.Parameter.span(-0.08999999999999997f, 1.1099999999999999f), Climate.Parameter.span(0.20000000000000007f, 1.4f),
					Climate.Parameter.point(0.0f), Climate.Parameter.span(-0.2507407549388575f, 0.9492592450611425f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-0.6f, 0.6f), Climate.Parameter.span(-0.6f, 0.6f), Climate.Parameter.span(-0.08999999999999997f, 1.1099999999999999f), Climate.Parameter.span(0.20000000000000007f, 1.4f),
					Climate.Parameter.point(1.0f), Climate.Parameter.span(-0.2507407549388575f, 0.9492592450611425f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607).foliageColorOverride(10387789).grassColorOverride(9470285).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("chaosmod:grass_birch_forest", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("chaosmod:flower_birch_forest", VegetationFeatures.FLOWER_DEFAULT,
				List.of(CountPlacement.of(4), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.NONE).temperature(0.5f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenerationSettings.build()).build();
	}
}
