
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.item.ZenithItem;
import xyz.vikkivuk.chaosmod.item.XiteItem;
import xyz.vikkivuk.chaosmod.item.XSORDItem;
import xyz.vikkivuk.chaosmod.item.WoodDimensionItem;
import xyz.vikkivuk.chaosmod.item.WaterCupItem;
import xyz.vikkivuk.chaosmod.item.UseInEmergenciesItem;
import xyz.vikkivuk.chaosmod.item.TurtleArmorItem;
import xyz.vikkivuk.chaosmod.item.TotemOfDreamItem;
import xyz.vikkivuk.chaosmod.item.TotemOfAmogusItem;
import xyz.vikkivuk.chaosmod.item.TesticleOnStickItem;
import xyz.vikkivuk.chaosmod.item.TOItem;
import xyz.vikkivuk.chaosmod.item.SusSwordItem;
import xyz.vikkivuk.chaosmod.item.SusItem;
import xyz.vikkivuk.chaosmod.item.StaravodaItem;
import xyz.vikkivuk.chaosmod.item.SpearItem;
import xyz.vikkivuk.chaosmod.item.ScratestItem;
import xyz.vikkivuk.chaosmod.item.SasiAmangasItem;
import xyz.vikkivuk.chaosmod.item.SamsungNote7Item;
import xyz.vikkivuk.chaosmod.item.SSSRItem;
import xyz.vikkivuk.chaosmod.item.RockItem;
import xyz.vikkivuk.chaosmod.item.RadiationLiquidItem;
import xyz.vikkivuk.chaosmod.item.PotatoSpudsItem;
import xyz.vikkivuk.chaosmod.item.PickaxItem;
import xyz.vikkivuk.chaosmod.item.PeemensionItem;
import xyz.vikkivuk.chaosmod.item.PeeItem;
import xyz.vikkivuk.chaosmod.item.OrangeFluidItem;
import xyz.vikkivuk.chaosmod.item.OilItem;
import xyz.vikkivuk.chaosmod.item.ObamiumItem;
import xyz.vikkivuk.chaosmod.item.NetheritPickaxItem;
import xyz.vikkivuk.chaosmod.item.MumboTokenItem;
import xyz.vikkivuk.chaosmod.item.Milk2Item;
import xyz.vikkivuk.chaosmod.item.MethItem;
import xyz.vikkivuk.chaosmod.item.LavaBottleItem;
import xyz.vikkivuk.chaosmod.item.KondomnepitajzastoovoradimalispoileralertonimarupuItem;
import xyz.vikkivuk.chaosmod.item.JosipRangeItem;
import xyz.vikkivuk.chaosmod.item.JavelinLauncherItem;
import xyz.vikkivuk.chaosmod.item.ImpostorKnifeItem;
import xyz.vikkivuk.chaosmod.item.IglaItem;
import xyz.vikkivuk.chaosmod.item.HalfGoldenAppleItem;
import xyz.vikkivuk.chaosmod.item.GatoradeItem;
import xyz.vikkivuk.chaosmod.item.FortniteA1Item;
import xyz.vikkivuk.chaosmod.item.FooditemItem;
import xyz.vikkivuk.chaosmod.item.FoodItem3Item;
import xyz.vikkivuk.chaosmod.item.FoodItem2Item;
import xyz.vikkivuk.chaosmod.item.FallgaysItem;
import xyz.vikkivuk.chaosmod.item.FASTTOPASSItem;
import xyz.vikkivuk.chaosmod.item.EatableCommandBlockItem;
import xyz.vikkivuk.chaosmod.item.DirtswordItem;
import xyz.vikkivuk.chaosmod.item.DipexItem;
import xyz.vikkivuk.chaosmod.item.DeekItem;
import xyz.vikkivuk.chaosmod.item.CumItem;
import xyz.vikkivuk.chaosmod.item.CorruptstaffItem;
import xyz.vikkivuk.chaosmod.item.ComicallyLargeSpoonItem;
import xyz.vikkivuk.chaosmod.item.CobbleFluidItem;
import xyz.vikkivuk.chaosmod.item.CioaoItem;
import xyz.vikkivuk.chaosmod.item.CarbonMonoxideItem;
import xyz.vikkivuk.chaosmod.item.BulletItem;
import xyz.vikkivuk.chaosmod.item.BrownItem;
import xyz.vikkivuk.chaosmod.item.BrazilItem;
import xyz.vikkivuk.chaosmod.item.BleachItem;
import xyz.vikkivuk.chaosmod.item.BeengotItem;
import xyz.vikkivuk.chaosmod.item.BeefItem;
import xyz.vikkivuk.chaosmod.item.BeefArmorItem;
import xyz.vikkivuk.chaosmod.item.BaguetteItem;
import xyz.vikkivuk.chaosmod.item.AmugusItem;
import xyz.vikkivuk.chaosmod.item.AmogusGunItem;
import xyz.vikkivuk.chaosmod.item.AlmondWaterItem;
import xyz.vikkivuk.chaosmod.item.AdidasSwordItem;
import xyz.vikkivuk.chaosmod.item.AdidasShovelItem;
import xyz.vikkivuk.chaosmod.item.AdidasPickaxeItem;
import xyz.vikkivuk.chaosmod.item.AdidasHoeItem;
import xyz.vikkivuk.chaosmod.item.AdidasAxeItem;
import xyz.vikkivuk.chaosmod.item.AdidasArmorItem;
import xyz.vikkivuk.chaosmod.item.AK47Item;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

public class ChaosmodModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ChaosmodMod.MODID);
	public static final RegistryObject<Item> DIRTSWORD = REGISTRY.register("dirtsword", () -> new DirtswordItem());
	public static final RegistryObject<Item> DEEK = REGISTRY.register("deek", () -> new DeekItem());
	public static final RegistryObject<Item> PEE_BUCKET = REGISTRY.register("pee_bucket", () -> new PeeItem());
	public static final RegistryObject<Item> PEEMENSION = REGISTRY.register("peemension", () -> new PeemensionItem());
	public static final RegistryObject<Item> PEE_BLOCK = block(ChaosmodModBlocks.PEE_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> AENTITY = REGISTRY.register("aentity_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.AENTITY, -13434625, -10040065, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> FOODITEM = REGISTRY.register("fooditem", () -> new FooditemItem());
	public static final RegistryObject<Item> PICKAX = REGISTRY.register("pickax", () -> new PickaxItem());
	public static final RegistryObject<Item> FOOD_ITEM_2 = REGISTRY.register("food_item_2", () -> new FoodItem2Item());
	public static final RegistryObject<Item> SA_DS = block(ChaosmodModBlocks.SA_DS, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> FOOD_ITEM_3 = REGISTRY.register("food_item_3", () -> new FoodItem3Item());
	public static final RegistryObject<Item> POTATO_SPUDS = REGISTRY.register("potato_spuds", () -> new PotatoSpudsItem());
	public static final RegistryObject<Item> POTATUS = block(ChaosmodModBlocks.POTATUS, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> SPEAR = REGISTRY.register("spear", () -> new SpearItem());
	public static final RegistryObject<Item> EMEPEE = block(ChaosmodModBlocks.EMEPEE, null);
	public static final RegistryObject<Item> DIPEX = REGISTRY.register("dipex", () -> new DipexItem());
	public static final RegistryObject<Item> DEATH = block(ChaosmodModBlocks.DEATH, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> TRIDENT = REGISTRY.register("trident_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.TRIDENT, -13641874, -1, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> COMICALLY_LARGE_SPOON = REGISTRY.register("comically_large_spoon", () -> new ComicallyLargeSpoonItem());
	public static final RegistryObject<Item> NETHERIT_PICKAX = REGISTRY.register("netherit_pickax", () -> new NetheritPickaxItem());
	public static final RegistryObject<Item> WOOD_DIMENSION = REGISTRY.register("wood_dimension", () -> new WoodDimensionItem());
	public static final RegistryObject<Item> SUS_BLOCK = block(ChaosmodModBlocks.SUS_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> AMONG_US = REGISTRY.register("among_us_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.AMONG_US, -52429, -3394816, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> CUM_BUCKET = REGISTRY.register("cum_bucket", () -> new CumItem());
	public static final RegistryObject<Item> SUS = REGISTRY.register("sus", () -> new SusItem());
	public static final RegistryObject<Item> AMOGUS_2 = REGISTRY.register("amogus_2_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.AMOGUS_2, -26215, -52429, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> AMOGUS_3 = REGISTRY.register("amogus_3_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.AMOGUS_3, -52429, -39322, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> STARAVODA_BUCKET = REGISTRY.register("staravoda_bucket", () -> new StaravodaItem());
	public static final RegistryObject<Item> TLGHD = block(ChaosmodModBlocks.TLGHD, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> AMUGUS_HELMET = REGISTRY.register("amugus_helmet", () -> new AmugusItem.Helmet());
	public static final RegistryObject<Item> AMUGUS_CHESTPLATE = REGISTRY.register("amugus_chestplate", () -> new AmugusItem.Chestplate());
	public static final RegistryObject<Item> AMUGUS_LEGGINGS = REGISTRY.register("amugus_leggings", () -> new AmugusItem.Leggings());
	public static final RegistryObject<Item> AMUGUS_BOOTS = REGISTRY.register("amugus_boots", () -> new AmugusItem.Boots());
	public static final RegistryObject<Item> KONDOMNEPITAJZASTOOVORADIMALISPOILERALERTONIMARUPU = REGISTRY
			.register("kondomnepitajzastoovoradimalispoileralertonimarupu", () -> new KondomnepitajzastoovoradimalispoileralertonimarupuItem());
	public static final RegistryObject<Item> SUS_SWORD = REGISTRY.register("sus_sword", () -> new SusSwordItem());
	public static final RegistryObject<Item> ORANGE_FLUID_BUCKET = REGISTRY.register("orange_fluid_bucket", () -> new OrangeFluidItem());
	public static final RegistryObject<Item> OIL_BUCKET = REGISTRY.register("oil_bucket", () -> new OilItem());
	public static final RegistryObject<Item> GATORADE_BUCKET = REGISTRY.register("gatorade_bucket", () -> new GatoradeItem());
	public static final RegistryObject<Item> GREEN_PLANT = block(ChaosmodModBlocks.GREEN_PLANT, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> WATER_CUP = REGISTRY.register("water_cup", () -> new WaterCupItem());
	public static final RegistryObject<Item> SPLANK = REGISTRY.register("splank_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.SPLANK, -3355648, -154, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> FALLGAYS = REGISTRY.register("fallgays", () -> new FallgaysItem());
	public static final RegistryObject<Item> IKEA_DESK = REGISTRY.register("ikea_desk_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.IKEA_DESK, -13421773, -1, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> TOMBSTONE = block(ChaosmodModBlocks.TOMBSTONE, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> SASI_AMANGAS = REGISTRY.register("sasi_amangas", () -> new SasiAmangasItem());
	public static final RegistryObject<Item> JOSIP = REGISTRY.register("josip_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.JOSIP, -3407617, -16777216, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> BROWN = REGISTRY.register("brown", () -> new BrownItem());
	public static final RegistryObject<Item> CARBON_MONOXIDE_BUCKET = REGISTRY.register("carbon_monoxide_bucket", () -> new CarbonMonoxideItem());
	public static final RegistryObject<Item> JOSIPDVATOCKANULA = REGISTRY.register("josipdvatockanula_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.JOSIPDVATOCKANULA, -16777216, -65536,
					new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> BEEF_ARMOR_HELMET = REGISTRY.register("beef_armor_helmet", () -> new BeefArmorItem.Helmet());
	public static final RegistryObject<Item> BEEF_ARMOR_CHESTPLATE = REGISTRY.register("beef_armor_chestplate", () -> new BeefArmorItem.Chestplate());
	public static final RegistryObject<Item> BEEF_ARMOR_LEGGINGS = REGISTRY.register("beef_armor_leggings", () -> new BeefArmorItem.Leggings());
	public static final RegistryObject<Item> BEEF_ARMOR_BOOTS = REGISTRY.register("beef_armor_boots", () -> new BeefArmorItem.Boots());
	public static final RegistryObject<Item> CORRUPTSTAFF = REGISTRY.register("corruptstaff", () -> new CorruptstaffItem());
	public static final RegistryObject<Item> JOSIP_PET = REGISTRY.register("josip_pet_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.JOSIP_PET, -3407668, -26113, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> TURTLE_ARMOR_CHESTPLATE = REGISTRY.register("turtle_armor_chestplate",
			() -> new TurtleArmorItem.Chestplate());
	public static final RegistryObject<Item> TURTLE_ARMOR_LEGGINGS = REGISTRY.register("turtle_armor_leggings", () -> new TurtleArmorItem.Leggings());
	public static final RegistryObject<Item> TURTLE_ARMOR_BOOTS = REGISTRY.register("turtle_armor_boots", () -> new TurtleArmorItem.Boots());
	public static final RegistryObject<Item> JOSIP_PETT = REGISTRY.register("josip_pett_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.JOSIP_PETT, -65536, -10066330, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> JOSIP_RANGE = REGISTRY.register("josip_range", () -> new JosipRangeItem());
	public static final RegistryObject<Item> MOTH_OF_AGGREVATION = REGISTRY.register("moth_of_aggrevation_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.MOTH_OF_AGGREVATION, -6737152, -1,
					new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> AK_47 = REGISTRY.register("ak_47", () -> new AK47Item());
	public static final RegistryObject<Item> CURSED_DOG = REGISTRY.register("cursed_dog_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.CURSED_DOG, -1, -3355444, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> BLAZ = REGISTRY.register("blaz_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.BLAZ, -205, -39322, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> SHEP = REGISTRY.register("shep_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.SHEP, -1, -10066330, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> BULLET = REGISTRY.register("bullet", () -> new BulletItem());
	public static final RegistryObject<Item> VIKKIVUK = REGISTRY.register("vikkivuk_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.VIKKIVUK, -13369345, -13408513, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> YOUTUBE = block(ChaosmodModBlocks.YOUTUBE, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> PLANTE = block(ChaosmodModBlocks.PLANTE, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> DREAM = REGISTRY.register("dream_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.DREAM, -13369549, -1, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> MILK_2_BUCKET = REGISTRY.register("milk_2_bucket", () -> new Milk2Item());
	public static final RegistryObject<Item> USE_IN_EMERGENCIES = REGISTRY.register("use_in_emergencies", () -> new UseInEmergenciesItem());
	public static final RegistryObject<Item> SCRATEST = REGISTRY.register("scratest", () -> new ScratestItem());
	public static final RegistryObject<Item> ADOLF_HITLER = REGISTRY.register("adolf_hitler_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.ADOLF_HITLER, -52429, -3407872, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> TESTICLE_ON_STICK = REGISTRY.register("testicle_on_stick", () -> new TesticleOnStickItem());
	public static final RegistryObject<Item> RICKROLL_BLOCK = block(ChaosmodModBlocks.RICKROLL_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> METH = REGISTRY.register("meth", () -> new MethItem());
	public static final RegistryObject<Item> WALTER_WIGHT = REGISTRY.register("walter_wight_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.WALTER_WIGHT, -16777012, -16777114,
					new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> GRAVE = block(ChaosmodModBlocks.GRAVE, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> COD_BUT_BETTER = REGISTRY.register("cod_but_better_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.COD_BUT_BETTER, -13312, -13108, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> BACKROOMS_LVL_1LIGHT = block(ChaosmodModBlocks.BACKROOMS_LVL_1LIGHT, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> SSSR = REGISTRY.register("sssr", () -> new SSSRItem());
	public static final RegistryObject<Item> STALIN = REGISTRY.register("stalin_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.STALIN, -65536, -11776, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> BACKROOMS_LVL_1_WALL = block(ChaosmodModBlocks.BACKROOMS_LVL_1_WALL, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> SOUTH = block(ChaosmodModBlocks.SOUTH, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> BACKROOMS_LVL_1_FLOOR = block(ChaosmodModBlocks.BACKROOMS_LVL_1_FLOOR, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> COMUNISAM_BLOCK = block(ChaosmodModBlocks.COMUNISAM_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> TO = REGISTRY.register("to", () -> new TOItem());
	public static final RegistryObject<Item> POLAND_BLOCK = block(ChaosmodModBlocks.POLAND_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> FASTTOPASS = REGISTRY.register("fasttopass", () -> new FASTTOPASSItem());
	public static final RegistryObject<Item> NOKIA_BLOCK = block(ChaosmodModBlocks.NOKIA_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> IGLA = REGISTRY.register("igla", () -> new IglaItem());
	public static final RegistryObject<Item> CIOAO = REGISTRY.register("cioao", () -> new CioaoItem());
	public static final RegistryObject<Item> RADIATION_LIQUID_BUCKET = REGISTRY.register("radiation_liquid_bucket", () -> new RadiationLiquidItem());
	public static final RegistryObject<Item> RICK_ASTLEY = REGISTRY.register("rick_astley_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.RICK_ASTLEY, -1, -1, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> FORTNITE_A_1 = REGISTRY.register("fortnite_a_1", () -> new FortniteA1Item());
	public static final RegistryObject<Item> BLEACH = REGISTRY.register("bleach", () -> new BleachItem());
	public static final RegistryObject<Item> GREENGISCREENDA = block(ChaosmodModBlocks.GREENGISCREENDA, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> BRAZIL_BLOCK = block(ChaosmodModBlocks.BRAZIL_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> BRAZIL = REGISTRY.register("brazil", () -> new BrazilItem());
	public static final RegistryObject<Item> MUMBO_TOKEN = REGISTRY.register("mumbo_token", () -> new MumboTokenItem());
	public static final RegistryObject<Item> LEGS = REGISTRY.register("legs_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.LEGS, -26368, -205, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> LONG_LEG_CHICKEN = REGISTRY.register("long_leg_chicken_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.LONG_LEG_CHICKEN, -3355444, -16777216,
					new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> FIREFLY = REGISTRY.register("firefly_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.FIREFLY, -16777216, -13261, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> ALMOND_WATER = REGISTRY.register("almond_water", () -> new AlmondWaterItem());
	public static final RegistryObject<Item> SAMSUNG_NOTE_7 = REGISTRY.register("samsung_note_7", () -> new SamsungNote7Item());
	public static final RegistryObject<Item> DEPRESSION_BLOCK = block(ChaosmodModBlocks.DEPRESSION_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> TOTEM_OF_AMOGUS = REGISTRY.register("totem_of_amogus", () -> new TotemOfAmogusItem());
	public static final RegistryObject<Item> AMOGUS_GUN = REGISTRY.register("amogus_gun", () -> new AmogusGunItem());
	public static final RegistryObject<Item> ZENITH = REGISTRY.register("zenith", () -> new ZenithItem());
	public static final RegistryObject<Item> T_POSE_ENTITY = REGISTRY.register("t_pose_entity_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.T_POSE_ENTITY, -1, -16777216, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> IMPOSTOR_KNIFE = REGISTRY.register("impostor_knife", () -> new ImpostorKnifeItem());
	public static final RegistryObject<Item> ROCK = REGISTRY.register("rock", () -> new RockItem());
	public static final RegistryObject<Item> CYBER_BLOCK = block(ChaosmodModBlocks.CYBER_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> COMPUTER = block(ChaosmodModBlocks.COMPUTER, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> TOTEM_OF_DREAM = REGISTRY.register("totem_of_dream", () -> new TotemOfDreamItem());
	public static final RegistryObject<Item> STROATER = REGISTRY.register("stroater_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.STROATER, -6724096, -16777216, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> HALF_GOLDEN_APPLE = REGISTRY.register("half_golden_apple", () -> new HalfGoldenAppleItem());
	public static final RegistryObject<Item> BEEF = REGISTRY.register("beef", () -> new BeefItem());
	public static final RegistryObject<Item> BAGUETTE = REGISTRY.register("baguette", () -> new BaguetteItem());
	public static final RegistryObject<Item> OBAMIUM = REGISTRY.register("obamium", () -> new ObamiumItem());
	public static final RegistryObject<Item> COBBLE_FLUID_BUCKET = REGISTRY.register("cobble_fluid_bucket", () -> new CobbleFluidItem());
	public static final RegistryObject<Item> AMOGUS_3_BLU = REGISTRY.register("amogus_3_blu_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.AMOGUS_3_BLU, -52429, -13382401,
					new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> AMOGUS_3_GRIN = REGISTRY.register("amogus_3_grin_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.AMOGUS_3_GRIN, -52429, -10027162,
					new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> LAVA_BOTTLE = REGISTRY.register("lava_bottle", () -> new LavaBottleItem());
	public static final RegistryObject<Item> BEENGOT = REGISTRY.register("beengot", () -> new BeengotItem());
	public static final RegistryObject<Item> SPONGEBOB_BOSS = REGISTRY.register("spongebob_boss_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.SPONGEBOB_BOSS, -256, -3355648, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> ADIDAS_BLOCK = block(ChaosmodModBlocks.ADIDAS_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> ADIDAS_ARMOR_HELMET = REGISTRY.register("adidas_armor_helmet", () -> new AdidasArmorItem.Helmet());
	public static final RegistryObject<Item> ADIDAS_ARMOR_CHESTPLATE = REGISTRY.register("adidas_armor_chestplate",
			() -> new AdidasArmorItem.Chestplate());
	public static final RegistryObject<Item> ADIDAS_ARMOR_LEGGINGS = REGISTRY.register("adidas_armor_leggings", () -> new AdidasArmorItem.Leggings());
	public static final RegistryObject<Item> ADIDAS_ARMOR_BOOTS = REGISTRY.register("adidas_armor_boots", () -> new AdidasArmorItem.Boots());
	public static final RegistryObject<Item> ADIDAS_PICKAXE = REGISTRY.register("adidas_pickaxe", () -> new AdidasPickaxeItem());
	public static final RegistryObject<Item> ADIDAS_AXE = REGISTRY.register("adidas_axe", () -> new AdidasAxeItem());
	public static final RegistryObject<Item> ADIDAS_SWORD = REGISTRY.register("adidas_sword", () -> new AdidasSwordItem());
	public static final RegistryObject<Item> ADIDAS_SHOVEL = REGISTRY.register("adidas_shovel", () -> new AdidasShovelItem());
	public static final RegistryObject<Item> ADIDAS_HOE = REGISTRY.register("adidas_hoe", () -> new AdidasHoeItem());
	public static final RegistryObject<Item> THE_ROCK = REGISTRY.register("the_rock_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.THE_ROCK, -3394816, -52480, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> XSORD = REGISTRY.register("xsord", () -> new XSORDItem());
	public static final RegistryObject<Item> MISSING_TEXTURE = block(ChaosmodModBlocks.MISSING_TEXTURE, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> XITE = REGISTRY.register("xite", () -> new XiteItem());
	public static final RegistryObject<Item> EATABLE_COMMAND_BLOCK = REGISTRY.register("eatable_command_block", () -> new EatableCommandBlockItem());
	public static final RegistryObject<Item> JAVELIN_LAUNCHER = REGISTRY.register("javelin_launcher", () -> new JavelinLauncherItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
