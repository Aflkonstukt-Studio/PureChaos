
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.world.features.plants.PotatusFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.SADsFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.PeeBlockFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.EmepeeFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.DeathFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.StaravodaFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.PeeFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.CumFeature;
import xyz.vikkivuk.chaosmod.world.features.WoodRuinedPortalFeature;
import xyz.vikkivuk.chaosmod.world.features.PeePoolFeature;
import xyz.vikkivuk.chaosmod.world.features.JukeBoxCaveFeature;
import xyz.vikkivuk.chaosmod.world.features.AmongUsDungeonFeature;
import xyz.vikkivuk.chaosmod.world.features.AmongUSppFeature;
import xyz.vikkivuk.chaosmod.world.features.AmongUSpORTALFeature;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;

import java.util.function.Supplier;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class ChaosmodModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, ChaosmodMod.MODID);
	private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
	public static final RegistryObject<Feature<?>> PEE = register("pee", PeeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, PeeFeature.GENERATE_BIOMES, PeeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> PEE_BLOCK = register("pee_block", PeeBlockFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, PeeBlockFeature.GENERATE_BIOMES, PeeBlockFeature::placedFeature));
	public static final RegistryObject<Feature<?>> SA_DS = register("sa_ds", SADsFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, SADsFeature.GENERATE_BIOMES, SADsFeature::placedFeature));
	public static final RegistryObject<Feature<?>> POTATUS = register("potatus", PotatusFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, PotatusFeature.GENERATE_BIOMES, PotatusFeature::placedFeature));
	public static final RegistryObject<Feature<?>> EMEPEE = register("emepee", EmepeeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, EmepeeFeature.GENERATE_BIOMES, EmepeeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DEATH = register("death", DeathFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, DeathFeature.GENERATE_BIOMES, DeathFeature::placedFeature));
	public static final RegistryObject<Feature<?>> CUM = register("cum", CumFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, CumFeature.GENERATE_BIOMES, CumFeature::placedFeature));
	public static final RegistryObject<Feature<?>> STARAVODA = register("staravoda", StaravodaFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, StaravodaFeature.GENERATE_BIOMES, StaravodaFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AMONG_U_SPP = register("among_u_spp", AmongUSppFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AmongUSppFeature.GENERATE_BIOMES, AmongUSppFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AMONG_U_SP_ORTAL = register("among_u_sp_ortal", AmongUSpORTALFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AmongUSpORTALFeature.GENERATE_BIOMES,
					AmongUSpORTALFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AMONG_US_DUNGEON = register("among_us_dungeon", AmongUsDungeonFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AmongUsDungeonFeature.GENERATE_BIOMES,
					AmongUsDungeonFeature::placedFeature));
	public static final RegistryObject<Feature<?>> JUKE_BOX_CAVE = register("juke_box_cave", JukeBoxCaveFeature::feature, new FeatureRegistration(
			GenerationStep.Decoration.SURFACE_STRUCTURES, JukeBoxCaveFeature.GENERATE_BIOMES, JukeBoxCaveFeature::placedFeature));
	public static final RegistryObject<Feature<?>> PEE_POOL = register("pee_pool", PeePoolFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, PeePoolFeature.GENERATE_BIOMES, PeePoolFeature::placedFeature));
	public static final RegistryObject<Feature<?>> WOOD_RUINED_PORTAL = register("wood_ruined_portal", WoodRuinedPortalFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, WoodRuinedPortalFeature.GENERATE_BIOMES,
					WoodRuinedPortalFeature::placedFeature));

	private static RegistryObject<Feature<?>> register(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
		FEATURE_REGISTRATIONS.add(featureRegistration);
		return REGISTRY.register(registryname, feature);
	}

	@SubscribeEvent
	public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
		for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
			if (registration.biomes() == null || registration.biomes().contains(event.getName()))
				event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
