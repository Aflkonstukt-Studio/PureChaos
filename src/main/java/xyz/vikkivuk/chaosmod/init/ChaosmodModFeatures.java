
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.world.features.plants.YoutubeFeature;
import xyz.vikkivuk.chaosmod.world.features.plants.PotatusFeature;
import xyz.vikkivuk.chaosmod.world.features.plants.PlanteFeature;
import xyz.vikkivuk.chaosmod.world.features.plants.GreenPlantFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.SADsFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.PeeBlockFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.JebBlockFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.EmepeeFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.DeathFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.ComputerFeature;
import xyz.vikkivuk.chaosmod.world.features.ores.AdidasBlockFeature;
import xyz.vikkivuk.chaosmod.world.features.WoodRuinedPortalFeature;
import xyz.vikkivuk.chaosmod.world.features.WhiteCellFeature;
import xyz.vikkivuk.chaosmod.world.features.StoneStairFeature;
import xyz.vikkivuk.chaosmod.world.features.StaravodaFeatureFeature;
import xyz.vikkivuk.chaosmod.world.features.SecretTntFeature;
import xyz.vikkivuk.chaosmod.world.features.RickrollStairsFeature;
import xyz.vikkivuk.chaosmod.world.features.RadiationLiquidFeatureFeature;
import xyz.vikkivuk.chaosmod.world.features.PondOfCobblestoneFeature;
import xyz.vikkivuk.chaosmod.world.features.PolskaFeature;
import xyz.vikkivuk.chaosmod.world.features.PeePoolFeature;
import xyz.vikkivuk.chaosmod.world.features.PeeFeatureFeature;
import xyz.vikkivuk.chaosmod.world.features.OrangeFluidFeatureFeature;
import xyz.vikkivuk.chaosmod.world.features.OilMountainFeature;
import xyz.vikkivuk.chaosmod.world.features.OilFeatureFeature;
import xyz.vikkivuk.chaosmod.world.features.OakHouseFeature;
import xyz.vikkivuk.chaosmod.world.features.Milk2FeatureFeature;
import xyz.vikkivuk.chaosmod.world.features.JukeBoxCaveFeature;
import xyz.vikkivuk.chaosmod.world.features.JosipovDrpanjeFeature;
import xyz.vikkivuk.chaosmod.world.features.HerobrineShrineFeature;
import xyz.vikkivuk.chaosmod.world.features.HECFeature;
import xyz.vikkivuk.chaosmod.world.features.GatoradeFeatureFeature;
import xyz.vikkivuk.chaosmod.world.features.GasChamberFeature;
import xyz.vikkivuk.chaosmod.world.features.DrugVanFeature;
import xyz.vikkivuk.chaosmod.world.features.CumFeatureFeature;
import xyz.vikkivuk.chaosmod.world.features.CobbleFluidFeatureFeature;
import xyz.vikkivuk.chaosmod.world.features.CarbonMonoxideFeatureFeature;
import xyz.vikkivuk.chaosmod.world.features.CactusFeature;
import xyz.vikkivuk.chaosmod.world.features.BirchTreeFeature;
import xyz.vikkivuk.chaosmod.world.features.BirchTreeBigFeature;
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
	public static final RegistryObject<Feature<?>> PEE_BLOCK = register("pee_block", PeeBlockFeature::feature, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, PeeBlockFeature.GENERATE_BIOMES, PeeBlockFeature::placedFeature));
	public static final RegistryObject<Feature<?>> SA_DS = register("sa_ds", SADsFeature::feature, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, SADsFeature.GENERATE_BIOMES, SADsFeature::placedFeature));
	public static final RegistryObject<Feature<?>> POTATUS = register("potatus", PotatusFeature::feature, new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, PotatusFeature.GENERATE_BIOMES, PotatusFeature::placedFeature));
	public static final RegistryObject<Feature<?>> EMEPEE = register("emepee", EmepeeFeature::feature, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, EmepeeFeature.GENERATE_BIOMES, EmepeeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DEATH = register("death", DeathFeature::feature, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, DeathFeature.GENERATE_BIOMES, DeathFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AMONG_U_SPP = register("among_u_spp", AmongUSppFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AmongUSppFeature.GENERATE_BIOMES, AmongUSppFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AMONG_U_SP_ORTAL = register("among_u_sp_ortal", AmongUSpORTALFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AmongUSpORTALFeature.GENERATE_BIOMES, AmongUSpORTALFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AMONG_US_DUNGEON = register("among_us_dungeon", AmongUsDungeonFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AmongUsDungeonFeature.GENERATE_BIOMES, AmongUsDungeonFeature::placedFeature));
	public static final RegistryObject<Feature<?>> JUKE_BOX_CAVE = register("juke_box_cave", JukeBoxCaveFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, JukeBoxCaveFeature.GENERATE_BIOMES, JukeBoxCaveFeature::placedFeature));
	public static final RegistryObject<Feature<?>> PEE_POOL = register("pee_pool", PeePoolFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, PeePoolFeature.GENERATE_BIOMES, PeePoolFeature::placedFeature));
	public static final RegistryObject<Feature<?>> WOOD_RUINED_PORTAL = register("wood_ruined_portal", WoodRuinedPortalFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, WoodRuinedPortalFeature.GENERATE_BIOMES, WoodRuinedPortalFeature::placedFeature));
	public static final RegistryObject<Feature<?>> GREEN_PLANT = register("green_plant", GreenPlantFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, GreenPlantFeature.GENERATE_BIOMES, GreenPlantFeature::placedFeature));
	public static final RegistryObject<Feature<?>> JOSIPOV_DRPANJE = register("josipov_drpanje", JosipovDrpanjeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, JosipovDrpanjeFeature.GENERATE_BIOMES, JosipovDrpanjeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> HEROBRINE_SHRINE = register("herobrine_shrine", HerobrineShrineFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, HerobrineShrineFeature.GENERATE_BIOMES, HerobrineShrineFeature::placedFeature));
	public static final RegistryObject<Feature<?>> OAK_HOUSE = register("oak_house", OakHouseFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, OakHouseFeature.GENERATE_BIOMES, OakHouseFeature::placedFeature));
	public static final RegistryObject<Feature<?>> OIL_MOUNTAIN = register("oil_mountain", OilMountainFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, OilMountainFeature.GENERATE_BIOMES, OilMountainFeature::placedFeature));
	public static final RegistryObject<Feature<?>> SECRET_TNT = register("secret_tnt", SecretTntFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, SecretTntFeature.GENERATE_BIOMES, SecretTntFeature::placedFeature));
	public static final RegistryObject<Feature<?>> WHITE_CELL = register("white_cell", WhiteCellFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, WhiteCellFeature.GENERATE_BIOMES, WhiteCellFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AMBYSS = register("ambyss", AmbyssFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AmbyssFeature.GENERATE_BIOMES, AmbyssFeature::placedFeature));
	public static final RegistryObject<Feature<?>> GAS_CHAMBER = register("gas_chamber", GasChamberFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, GasChamberFeature.GENERATE_BIOMES, GasChamberFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YOUTUBE = register("youtube", YoutubeFeature::feature, new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, YoutubeFeature.GENERATE_BIOMES, YoutubeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> PLANTE = register("plante", PlanteFeature::feature, new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, PlanteFeature.GENERATE_BIOMES, PlanteFeature::placedFeature));
	public static final RegistryObject<Feature<?>> POLSKA = register("polska", PolskaFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, PolskaFeature.GENERATE_BIOMES, PolskaFeature::placedFeature));
	public static final RegistryObject<Feature<?>> HEC = register("hec", HECFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, HECFeature.GENERATE_BIOMES, HECFeature::placedFeature));
	public static final RegistryObject<Feature<?>> COMPUTER = register("computer", ComputerFeature::feature, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, ComputerFeature.GENERATE_BIOMES, ComputerFeature::placedFeature));
	public static final RegistryObject<Feature<?>> ADIDAS_BLOCK = register("adidas_block", AdidasBlockFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, AdidasBlockFeature.GENERATE_BIOMES, AdidasBlockFeature::placedFeature));
	public static final RegistryObject<Feature<?>> JEB_BLOCK = register("jeb_block", JebBlockFeature::feature, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, JebBlockFeature.GENERATE_BIOMES, JebBlockFeature::placedFeature));
	public static final RegistryObject<Feature<?>> STONE_STAIR = register("stone_stair", StoneStairFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, StoneStairFeature.GENERATE_BIOMES, StoneStairFeature::placedFeature));
	public static final RegistryObject<Feature<?>> POND_OF_COBBLESTONE = register("pond_of_cobblestone", PondOfCobblestoneFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, PondOfCobblestoneFeature.GENERATE_BIOMES, PondOfCobblestoneFeature::placedFeature));
	public static final RegistryObject<Feature<?>> RICKROLL_STAIRS = register("rickroll_stairs", RickrollStairsFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, RickrollStairsFeature.GENERATE_BIOMES, RickrollStairsFeature::placedFeature));
	public static final RegistryObject<Feature<?>> BIRCH_TREE = register("birch_tree", BirchTreeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, BirchTreeFeature.GENERATE_BIOMES, BirchTreeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> BIRCH_TREE_BIG = register("birch_tree_big", BirchTreeBigFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, BirchTreeBigFeature.GENERATE_BIOMES, BirchTreeBigFeature::placedFeature));
	public static final RegistryObject<Feature<?>> CACTUS = register("cactus", CactusFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, CactusFeature.GENERATE_BIOMES, CactusFeature::placedFeature));
	public static final RegistryObject<Feature<?>> CUM_FEATURE = register("cum_feature", CumFeatureFeature::feature, new FeatureRegistration(GenerationStep.Decoration.LAKES, CumFeatureFeature.GENERATE_BIOMES, CumFeatureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> PEE_FEATURE = register("pee_feature", PeeFeatureFeature::feature, new FeatureRegistration(GenerationStep.Decoration.LAKES, PeeFeatureFeature.GENERATE_BIOMES, PeeFeatureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> STARAVODA_FEATURE = register("staravoda_feature", StaravodaFeatureFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, StaravodaFeatureFeature.GENERATE_BIOMES, StaravodaFeatureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> ORANGE_FLUID_FEATURE = register("orange_fluid_feature", OrangeFluidFeatureFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, OrangeFluidFeatureFeature.GENERATE_BIOMES, OrangeFluidFeatureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> OIL_FEATURE = register("oil_feature", OilFeatureFeature::feature, new FeatureRegistration(GenerationStep.Decoration.LAKES, OilFeatureFeature.GENERATE_BIOMES, OilFeatureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> GATORADE_FEATURE = register("gatorade_feature", GatoradeFeatureFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, GatoradeFeatureFeature.GENERATE_BIOMES, GatoradeFeatureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> CARBON_MONOXIDE_FEATURE = register("carbon_monoxide_feature", CarbonMonoxideFeatureFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, CarbonMonoxideFeatureFeature.GENERATE_BIOMES, CarbonMonoxideFeatureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> MILK_2_FEATURE = register("milk_2_feature", Milk2FeatureFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, Milk2FeatureFeature.GENERATE_BIOMES, Milk2FeatureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> RADIATION_LIQUID_FEATURE = register("radiation_liquid_feature", RadiationLiquidFeatureFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, RadiationLiquidFeatureFeature.GENERATE_BIOMES, RadiationLiquidFeatureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> COBBLE_FLUID_FEATURE = register("cobble_fluid_feature", CobbleFluidFeatureFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.LAKES, CobbleFluidFeatureFeature.GENERATE_BIOMES, CobbleFluidFeatureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DRUG_VAN = register("drug_van", DrugVanFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DrugVanFeature.GENERATE_BIOMES, DrugVanFeature::placedFeature));

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

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes, Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
