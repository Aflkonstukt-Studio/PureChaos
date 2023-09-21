
package xyz.aflkonstukt.purechaos.world.biome;

import xyz.aflkonstukt.purechaos.init.PurechaosModEntities;

import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;

public class EkesmasterbaitBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-1f, 0.7f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-0.5f, 1.3f), Climate.Parameter.point(0.0f), Climate.Parameter.span(-0.5f, 1f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-1f, 0.7f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-0.5f, 1.3f), Climate.Parameter.point(1.0f), Climate.Parameter.span(-0.5f, 1f),
					0));
	public static final List<Climate.ParameterPoint> UNDERGROUND_PARAMETER_POINTS = List.of(new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-1f, 0.7f), Climate.Parameter.span(-2f, 2f),
			Climate.Parameter.span(-0.5f, 1.3f), Climate.Parameter.span(0.2f, 0.9f), Climate.Parameter.span(-0.5f, 1f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-1).waterColor(-16763956).waterFogColor(-52429).skyColor(-1).foliageColorOverride(-16751002).grassColorOverride(-10092442)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("ambient.crimson_forest.loop"))).ambientAdditionsSound(new AmbientAdditionsSettings(new SoundEvent(new ResourceLocation("block.amethyst_cluster.step")), 0.0111D))
				.ambientParticle(new AmbientParticleSettings(ParticleTypes.FALLING_WATER, 0.005f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("purechaos:tree_ekesmasterbait",
						FeatureUtils.register("purechaos:tree_ekesmasterbait", Feature.TREE,
								new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.WARPED_STEM.defaultBlockState()), new StraightTrunkPlacer(16, 2, 0),
										BlockStateProvider.simple(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()),
						List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("purechaos:grass_ekesmasterbait", VegetationFeatures.PATCH_GRASS,
				List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("purechaos:flower_ekesmasterbait", VegetationFeatures.FLOWER_DEFAULT,
				List.of(CountPlacement.of(4), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("purechaos:patch_sugar_cane_ekesmasterbait", VegetationFeatures.PATCH_SUGAR_CANE, List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("purechaos:disk_gravel_ekesmasterbait",
						FeatureUtils.register("purechaos:disk_gravel_ekesmasterbait", Feature.DISK,
								new DiskConfiguration(Blocks.GRAVEL.defaultBlockState(), UniformInt.of(2, 5), 2, List.of(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState()))),
						List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		BiomeDefaultFeatures.addExtraEmeralds(biomeGenerationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
		BiomeDefaultFeatures.addLushCavesVegetationFeatures(biomeGenerationSettings);
		BiomeDefaultFeatures.addMossyStoneBlock(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.AENTITY.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.AMOGUS_2.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.AMOGUS_3.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.AMONG_US.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.BLAZ.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.CURSED_DOG.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.IKEA_DESK.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.JOSIP.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.JOSIP_PET.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.MOTH_OF_AGGREVATION.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.SHEP.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.SPLANK.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.TRIDENT.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.VIKKIVUK.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PurechaosModEntities.JOSIP_PETT.get(), 20, 4, 4));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.NONE).temperature(0.5f).downfall(0.6f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenerationSettings.build()).build();
	}
}