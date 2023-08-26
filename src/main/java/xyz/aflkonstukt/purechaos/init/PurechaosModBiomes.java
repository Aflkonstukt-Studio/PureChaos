
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.world.biome.SususBiome;
import xyz.aflkonstukt.purechaos.world.biome.PlainsBiome;
import xyz.aflkonstukt.purechaos.world.biome.OhioBiome;
import xyz.aflkonstukt.purechaos.world.biome.MoreExtremeHillsBiome;
import xyz.aflkonstukt.purechaos.world.biome.HellButOverworldBiome;
import xyz.aflkonstukt.purechaos.world.biome.EkesmasterbaitBiome;
import xyz.aflkonstukt.purechaos.world.biome.DesertBiome;
import xyz.aflkonstukt.purechaos.world.biome.CyberBiomeBiome;
import xyz.aflkonstukt.purechaos.world.biome.BirchForestBiome;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;

import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import com.mojang.datafixers.util.Pair;

@Mod.EventBusSubscriber
public class PurechaosModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, PurechaosMod.MODID);
	public static final RegistryObject<Biome> HELL_BUT_OVERWORLD = REGISTRY.register("hell_but_overworld", () -> HellButOverworldBiome.createBiome());
	public static final RegistryObject<Biome> SUSUS = REGISTRY.register("susus", () -> SususBiome.createBiome());
	public static final RegistryObject<Biome> EKESMASTERBAIT = REGISTRY.register("ekesmasterbait", () -> EkesmasterbaitBiome.createBiome());
	public static final RegistryObject<Biome> CYBER_BIOME = REGISTRY.register("cyber_biome", () -> CyberBiomeBiome.createBiome());
	public static final RegistryObject<Biome> BIRCH_FOREST = REGISTRY.register("birch_forest", () -> BirchForestBiome.createBiome());
	public static final RegistryObject<Biome> DESERT = REGISTRY.register("desert", () -> DesertBiome.createBiome());
	public static final RegistryObject<Biome> OHIO = REGISTRY.register("ohio", () -> OhioBiome.createBiome());
	public static final RegistryObject<Biome> MORE_EXTREME_HILLS = REGISTRY.register("more_extreme_hills", () -> MoreExtremeHillsBiome.createBiome());
	public static final RegistryObject<Biome> PLAINS = REGISTRY.register("plains", () -> PlainsBiome.createBiome());

	@SubscribeEvent
	public static void onServerAboutToStart(ServerAboutToStartEvent event) {
		MinecraftServer server = event.getServer();
		Registry<DimensionType> dimensionTypeRegistry = server.registryAccess().registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY);
		Registry<Biome> biomeRegistry = server.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY);
		WorldGenSettings worldGenSettings = server.getWorldData().worldGenSettings();
		for (Map.Entry<ResourceKey<LevelStem>, LevelStem> entry : worldGenSettings.dimensions().entrySet()) {
			DimensionType dimensionType = entry.getValue().typeHolder().value();
			if (dimensionType == dimensionTypeRegistry.getOrThrow(DimensionType.OVERWORLD_LOCATION)) {
				ChunkGenerator chunkGenerator = entry.getValue().generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters.values());
					for (Climate.ParameterPoint parameterPoint : HellButOverworldBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, HELL_BUT_OVERWORLD.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : SususBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, SUSUS.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : EkesmasterbaitBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, EKESMASTERBAIT.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : BirchForestBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, BIRCH_FOREST.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : DesertBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, DESERT.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : OhioBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, OHIO.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : MoreExtremeHillsBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, MORE_EXTREME_HILLS.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : PlainsBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, PLAINS.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : HellButOverworldBiome.UNDERGROUND_PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, HELL_BUT_OVERWORLD.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : EkesmasterbaitBiome.UNDERGROUND_PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, EKESMASTERBAIT.getId()))));
					}

					MultiNoiseBiomeSource moddedNoiseSource = new MultiNoiseBiomeSource(new Climate.ParameterList<>(parameters), noiseSource.preset);
					chunkGenerator.biomeSource = moddedNoiseSource;
					chunkGenerator.runtimeBiomeSource = moddedNoiseSource;
				}
				// Inject surface rules
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
					SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
					if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
						List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
						surfaceRules.add(1, anySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, HELL_BUT_OVERWORLD.getId()), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState()));
						surfaceRules.add(1, anySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, EKESMASTERBAIT.getId()), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(), Blocks.SAND.defaultBlockState()));
						surfaceRules.add(1,
								preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, HELL_BUT_OVERWORLD.getId()), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, SUSUS.getId()), Blocks.GRASS_BLOCK.defaultBlockState(), PurechaosModBlocks.SUS_BLOCK.get().defaultBlockState(),
								Blocks.OAK_PLANKS.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, EKESMASTERBAIT.getId()), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(), Blocks.SAND.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, BIRCH_FOREST.getId()), Blocks.POLISHED_ANDESITE.defaultBlockState(), Blocks.POLISHED_ANDESITE.defaultBlockState(),
								Blocks.POLISHED_ANDESITE.defaultBlockState()));
						surfaceRules.add(1,
								preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, DESERT.getId()), Blocks.YELLOW_CONCRETE.defaultBlockState(), Blocks.YELLOW_CONCRETE.defaultBlockState(), Blocks.YELLOW_CONCRETE.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, OHIO.getId()), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, MORE_EXTREME_HILLS.getId()), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, PLAINS.getId()), Blocks.GRASS.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState()));
						NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(), noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(),
								noiseGeneratorSettings.noiseRouter(), SurfaceRules.sequence(surfaceRules.toArray(i -> new SurfaceRules.RuleSource[i])), noiseGeneratorSettings.seaLevel(), noiseGeneratorSettings.disableMobGeneration(),
								noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(), noiseGeneratorSettings.useLegacyRandomSource());
						noiseGenerator.settings = new Holder.Direct(moddedNoiseGeneratorSettings);
					}
				}
			}

			if (dimensionType == dimensionTypeRegistry.getOrThrow(DimensionType.NETHER_LOCATION)) {
				ChunkGenerator chunkGenerator = entry.getValue().generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters.values());
					for (Climate.ParameterPoint parameterPoint : HellButOverworldBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, HELL_BUT_OVERWORLD.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : EkesmasterbaitBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, EKESMASTERBAIT.getId()))));
					}
					MultiNoiseBiomeSource moddedNoiseSource = new MultiNoiseBiomeSource(new Climate.ParameterList<>(parameters), noiseSource.preset);
					chunkGenerator.biomeSource = moddedNoiseSource;
					chunkGenerator.runtimeBiomeSource = moddedNoiseSource;
				}
				// Inject surface rules
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
					SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
					if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
						List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
						surfaceRules.add(2, anySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, HELL_BUT_OVERWORLD.getId()), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState()));
						surfaceRules.add(2, anySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, EKESMASTERBAIT.getId()), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(), Blocks.SAND.defaultBlockState()));
						NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(), noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(),
								noiseGeneratorSettings.noiseRouter(), SurfaceRules.sequence(surfaceRules.toArray(i -> new SurfaceRules.RuleSource[i])), noiseGeneratorSettings.seaLevel(), noiseGeneratorSettings.disableMobGeneration(),
								noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(), noiseGeneratorSettings.useLegacyRandomSource());
						noiseGenerator.settings = new Holder.Direct(moddedNoiseGeneratorSettings);
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
}
