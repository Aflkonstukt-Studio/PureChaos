
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.world.features.plants.YoutubeFeature;
import xyz.vikkivuk.chaosmod.world.features.plants.PotatusFeature;
import xyz.vikkivuk.chaosmod.world.features.plants.PlanteFeature;
import xyz.vikkivuk.chaosmod.world.features.plants.GreenPlantFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.StandingBabyFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.SADsFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.PeeBlockFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.EmepeeFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.DeathFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.StaravodaFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.RadiationLiquidFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.PeeFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.OrangeFluidFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.OilFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.Milk2Feature;
import xyz.vikkivuk.chaosmod.world.features.lakes.GatoradeFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.CumFeature;
import xyz.vikkivuk.chaosmod.world.features.lakes.CarbonMonoxideFeature;
import xyz.vikkivuk.chaosmod.world.features.WoodRuinedPortalFeature;
import xyz.vikkivuk.chaosmod.world.features.WhiteCellFeature;
import xyz.vikkivuk.chaosmod.world.features.SecretTntFeature;
import xyz.vikkivuk.chaosmod.world.features.PeePoolFeature;
import xyz.vikkivuk.chaosmod.world.features.OilMountainFeature;
import xyz.vikkivuk.chaosmod.world.features.OakHouseFeature;
import xyz.vikkivuk.chaosmod.world.features.JukeBoxCaveFeature;
import xyz.vikkivuk.chaosmod.world.features.JosipovDrpanjeFeature;
import xyz.vikkivuk.chaosmod.world.features.HerobrineShrineFeature;
import xyz.vikkivuk.chaosmod.world.features.GasChamberFeature;
import xyz.vikkivuk.chaosmod.world.features.AmongUsDungeonFeature;
import xyz.vikkivuk.chaosmod.world.features.AmongUSppFeature;
import xyz.vikkivuk.chaosmod.world.features.AmongUSpORTALFeature;
import xyz.vikkivuk.chaosmod.world.features.AmbyssFeature;
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
	public static final RegistryObject<Feature<?>> ORANGE_FLUID = register("orange_fluid", OrangeFluidFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, OrangeFluidFeature.GENERATE_BIOMES, OrangeFluidFeature::placedFeature));
	public static final RegistryObject<Feature<?>> OIL = register("oil", OilFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, OilFeature.GENERATE_BIOMES, OilFeature::placedFeature));
	public static final RegistryObject<Feature<?>> GATORADE = register("gatorade", GatoradeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, GatoradeFeature.GENERATE_BIOMES, GatoradeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> GREEN_PLANT = register("green_plant", GreenPlantFeature::feature, new FeatureRegistration(
			GenerationStep.Decoration.VEGETAL_DECORATION, GreenPlantFeature.GENERATE_BIOMES, GreenPlantFeature::placedFeature));
	public static final RegistryObject<Feature<?>> JOSIPOV_DRPANJE = register("josipov_drpanje", JosipovDrpanjeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, JosipovDrpanjeFeature.GENERATE_BIOMES,
					JosipovDrpanjeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> HEROBRINE_SHRINE = register("herobrine_shrine", HerobrineShrineFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, HerobrineShrineFeature.GENERATE_BIOMES,
					HerobrineShrineFeature::placedFeature));
	public static final RegistryObject<Feature<?>> OAK_HOUSE = register("oak_house", OakHouseFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, OakHouseFeature.GENERATE_BIOMES, OakHouseFeature::placedFeature));
	public static final RegistryObject<Feature<?>> OIL_MOUNTAIN = register("oil_mountain", OilMountainFeature::feature, new FeatureRegistration(
			GenerationStep.Decoration.SURFACE_STRUCTURES, OilMountainFeature.GENERATE_BIOMES, OilMountainFeature::placedFeature));
	public static final RegistryObject<Feature<?>> SECRET_TNT = register("secret_tnt", SecretTntFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, SecretTntFeature.GENERATE_BIOMES, SecretTntFeature::placedFeature));
	public static final RegistryObject<Feature<?>> WHITE_CELL = register("white_cell", WhiteCellFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, WhiteCellFeature.GENERATE_BIOMES, WhiteCellFeature::placedFeature));
	public static final RegistryObject<Feature<?>> CARBON_MONOXIDE = register("carbon_monoxide", CarbonMonoxideFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, CarbonMonoxideFeature.GENERATE_BIOMES, CarbonMonoxideFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AMBYSS = register("ambyss", AmbyssFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AmbyssFeature.GENERATE_BIOMES, AmbyssFeature::placedFeature));
	public static final RegistryObject<Feature<?>> GAS_CHAMBER = register("gas_chamber", GasChamberFeature::feature, new FeatureRegistration(
			GenerationStep.Decoration.SURFACE_STRUCTURES, GasChamberFeature.GENERATE_BIOMES, GasChamberFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YOUTUBE = register("youtube", YoutubeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, YoutubeFeature.GENERATE_BIOMES, YoutubeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> PLANTE = register("plante", PlanteFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, PlanteFeature.GENERATE_BIOMES, PlanteFeature::placedFeature));
	public static final RegistryObject<Feature<?>> MILK_2 = register("milk_2", Milk2Feature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, Milk2Feature.GENERATE_BIOMES, Milk2Feature::placedFeature));
	public static final RegistryObject<Feature<?>> RADIATION_LIQUID = register("radiation_liquid", RadiationLiquidFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, RadiationLiquidFeature.GENERATE_BIOMES, RadiationLiquidFeature::placedFeature));
	public static final RegistryObject<Feature<?>> STANDING_BABY = register("standing_baby", StandingBabyFeature::feature, new FeatureRegistration(
			GenerationStep.Decoration.UNDERGROUND_ORES, StandingBabyFeature.GENERATE_BIOMES, StandingBabyFeature::placedFeature));

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
