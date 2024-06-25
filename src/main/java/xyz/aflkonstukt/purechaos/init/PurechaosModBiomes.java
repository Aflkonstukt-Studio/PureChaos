
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import java.util.List;
import java.util.ArrayList;

import com.mojang.datafixers.util.Pair;

import com.google.common.base.Suppliers;

@Mod.EventBusSubscriber
public class PurechaosModBiomes {
	@SubscribeEvent
	public static void onServerAboutToStart(ServerAboutToStartEvent event) {
		MinecraftServer server = event.getServer();
		Registry<DimensionType> dimensionTypeRegistry = server.registryAccess().registryOrThrow(Registries.DIMENSION_TYPE);
		Registry<LevelStem> levelStemTypeRegistry = server.registryAccess().registryOrThrow(Registries.LEVEL_STEM);
		Registry<Biome> biomeRegistry = server.registryAccess().registryOrThrow(Registries.BIOME);
		for (LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
			DimensionType dimensionType = levelStem.type().value();
			if (dimensionType == dimensionTypeRegistry.getOrThrow(BuiltinDimensionTypes.OVERWORLD)) {
				ChunkGenerator chunkGenerator = levelStem.generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters().values());
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0.2f, 1.4f), Climate.Parameter.point(0.0f),
							Climate.Parameter.span(-1f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "hell_but_overworld")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0.2f, 1.4f), Climate.Parameter.point(1.0f),
							Climate.Parameter.span(-1f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "hell_but_overworld")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 1f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(-1f, 0.5f), Climate.Parameter.point(0.0f),
							Climate.Parameter.span(0f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "susus")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 1f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(-1f, 0.5f), Climate.Parameter.point(1.0f),
							Climate.Parameter.span(0f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "susus")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 0.5f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(-0.5f, 1.3f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-2f, 0f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ekesmasterbait")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 0.5f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(-0.5f, 1.3f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-2f, 0f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ekesmasterbait")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(0.2f, 1.4f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "birch_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(0.2f, 1.4f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "birch_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.point(0.0f),
							Climate.Parameter.span(0f, 0.7f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "desert")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.point(1.0f),
							Climate.Parameter.span(0f, 0.7f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "desert")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-0.2f, 1f), Climate.Parameter.span(-0.2f, 1.8f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-2f, 0.0001f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ohio")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-0.2f, 1f), Climate.Parameter.span(-0.2f, 1.8f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-2f, 0.0001f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ohio")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(0f, 1.11f), Climate.Parameter.span(0.2f, 1.4f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-0.2f, 1.1324942016f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "more_extreme_hills")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(0f, 1.11f), Climate.Parameter.span(0.2f, 1.4f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-0.2f, 1.1324942016f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "more_extreme_hills")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 1f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0.2f, 1.4f), Climate.Parameter.point(0.0f),
							Climate.Parameter.span(-2f, 0.2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "plains")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 1f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0.2f, 1.4f), Climate.Parameter.point(1.0f),
							Climate.Parameter.span(-2f, 0.2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "plains")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-2f, 0.5f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "buffalo_lake")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-2f, 0.5f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "buffalo_lake")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-2f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "dream_biome")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-2f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "dream_biome")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-1f, 0f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "fortnite_biome")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-1f, 0f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "fortnite_biome")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 1f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "fun_land")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 1f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "fun_land")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0.5f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "heaven_or_hell")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0.5f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "heaven_or_hell")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "easter")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "easter")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0.2f, 1.4f),
							Climate.Parameter.span(0.2f, 0.9f), Climate.Parameter.span(-1f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "hell_but_overworld")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 0.5f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(-0.5f, 1.3f),
							Climate.Parameter.span(0.2f, 0.9f), Climate.Parameter.span(-2f, 0f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ekesmasterbait")))));
					chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(parameters));
					chunkGenerator.featuresPerStep = Suppliers
							.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
				}
				// Inject surface rules
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
					SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
					if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
						List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
						addSurfaceRule(surfaceRules, 1, anySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "hell_but_overworld")), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(),
								Blocks.NETHERRACK.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, anySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ekesmasterbait")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(),
								Blocks.SAND.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "hell_but_overworld")), Blocks.NETHERRACK.defaultBlockState(),
								Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "susus")), Blocks.GRASS_BLOCK.defaultBlockState(),
								PurechaosModBlocks.SUS_BLOCK.get().defaultBlockState(), Blocks.OAK_PLANKS.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ekesmasterbait")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(),
								Blocks.SAND.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "birch_forest")), Blocks.POLISHED_ANDESITE.defaultBlockState(),
								Blocks.POLISHED_ANDESITE.defaultBlockState(), Blocks.POLISHED_ANDESITE.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "desert")), Blocks.YELLOW_CONCRETE.defaultBlockState(), Blocks.YELLOW_CONCRETE.defaultBlockState(),
								Blocks.YELLOW_CONCRETE.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ohio")), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(),
								Blocks.COARSE_DIRT.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "more_extreme_hills")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.STONE.defaultBlockState(),
								Blocks.STONE.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1,
								preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "plains")), Blocks.SHORT_GRASS.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "buffalo_lake")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.SAND.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "dream_biome")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.GRAVEL.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "fortnite_biome")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.GRAVEL.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1,
								preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "fun_land")), Blocks.BEDROCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "heaven_or_hell")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState(),
								Blocks.BEDROCK.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1,
								preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "easter")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
						NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(), noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(),
								noiseGeneratorSettings.noiseRouter(), SurfaceRules.sequence(surfaceRules.toArray(SurfaceRules.RuleSource[]::new)), noiseGeneratorSettings.spawnTarget(), noiseGeneratorSettings.seaLevel(),
								noiseGeneratorSettings.disableMobGeneration(), noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(), noiseGeneratorSettings.useLegacyRandomSource());
						noiseGenerator.settings = new Holder.Direct<>(moddedNoiseGeneratorSettings);
					}
				}
			}
			if (dimensionType == dimensionTypeRegistry.getOrThrow(BuiltinDimensionTypes.NETHER)) {
				ChunkGenerator chunkGenerator = levelStem.generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters().values());
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0.2f, 1.4f), Climate.Parameter.point(0.0f),
							Climate.Parameter.span(-1f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "hell_but_overworld")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(0.2f, 1.4f), Climate.Parameter.point(1.0f),
							Climate.Parameter.span(-1f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "hell_but_overworld")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 1f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(-1f, 0.5f), Climate.Parameter.point(0.0f),
							Climate.Parameter.span(0f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "susus")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 1f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(-1f, 0.5f), Climate.Parameter.point(1.0f),
							Climate.Parameter.span(0f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "susus")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 0.5f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(-0.5f, 1.3f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-2f, 0f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ekesmasterbait")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 0.5f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(-0.5f, 1.3f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-2f, 0f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ekesmasterbait")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-0.2f, 1f), Climate.Parameter.span(-0.2f, 1.8f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-2f, 0.0001f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ohio")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 0f), Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-0.2f, 1f), Climate.Parameter.span(-0.2f, 1.8f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-2f, 0.0001f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ohio")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-2f, 0.5f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "buffalo_lake")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 2f), Climate.Parameter.span(-2f, 0.5f), Climate.Parameter.span(0f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "buffalo_lake")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "easter")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "easter")))));
					chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(parameters));
					chunkGenerator.featuresPerStep = Suppliers
							.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
				}
				// Inject surface rules
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
					SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
					if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
						List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
						addSurfaceRule(surfaceRules, 2, anySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "hell_but_overworld")), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(),
								Blocks.NETHERRACK.defaultBlockState()));
						addSurfaceRule(surfaceRules, 2, anySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "susus")), Blocks.GRASS_BLOCK.defaultBlockState(), PurechaosModBlocks.SUS_BLOCK.get().defaultBlockState(),
								Blocks.OAK_PLANKS.defaultBlockState()));
						addSurfaceRule(surfaceRules, 2, anySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ekesmasterbait")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(),
								Blocks.SAND.defaultBlockState()));
						addSurfaceRule(surfaceRules, 2,
								anySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "ohio")), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState()));
						addSurfaceRule(surfaceRules, 2,
								anySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "buffalo_lake")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.SAND.defaultBlockState()));
						addSurfaceRule(surfaceRules, 2,
								anySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("purechaos", "easter")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
						NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(), noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(),
								noiseGeneratorSettings.noiseRouter(), SurfaceRules.sequence(surfaceRules.toArray(SurfaceRules.RuleSource[]::new)), noiseGeneratorSettings.spawnTarget(), noiseGeneratorSettings.seaLevel(),
								noiseGeneratorSettings.disableMobGeneration(), noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(), noiseGeneratorSettings.useLegacyRandomSource());
						noiseGenerator.settings = new Holder.Direct<>(moddedNoiseGeneratorSettings);
					}
				}
			}
		}
	}

	private static SurfaceRules.RuleSource preliminarySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
						SurfaceRules.sequence(
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
										SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock)))));
	}

	private static SurfaceRules.RuleSource anySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
								SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
						SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock))));
	}

	private static void addParameterPoint(List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters, Pair<Climate.ParameterPoint, Holder<Biome>> point) {
		if (!parameters.contains(point))
			parameters.add(point);
	}

	private static void addSurfaceRule(List<SurfaceRules.RuleSource> surfaceRules, int index, SurfaceRules.RuleSource rule) {
		if (!surfaceRules.contains(rule))
			surfaceRules.add(index, rule);
	}
}
