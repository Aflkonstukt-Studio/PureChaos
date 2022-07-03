
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.item.WoodDimensionItem;
import xyz.vikkivuk.chaosmod.item.WaterCupItem;
import xyz.vikkivuk.chaosmod.item.UseInEmergenciesItem;
import xyz.vikkivuk.chaosmod.item.TurtleArmorItem;
import xyz.vikkivuk.chaosmod.item.TesticleOnStickItem;
import xyz.vikkivuk.chaosmod.item.SusSwordItem;
import xyz.vikkivuk.chaosmod.item.SusItem;
import xyz.vikkivuk.chaosmod.item.StaravodaItem;
import xyz.vikkivuk.chaosmod.item.SpearItem;
import xyz.vikkivuk.chaosmod.item.ScratestItem;
import xyz.vikkivuk.chaosmod.item.SasiAmangasItem;
import xyz.vikkivuk.chaosmod.item.PotatoSpudsItem;
import xyz.vikkivuk.chaosmod.item.PickaxItem;
import xyz.vikkivuk.chaosmod.item.PeemensionItem;
import xyz.vikkivuk.chaosmod.item.PeeItem;
import xyz.vikkivuk.chaosmod.item.OrangeFluidItem;
import xyz.vikkivuk.chaosmod.item.OilItem;
import xyz.vikkivuk.chaosmod.item.NetheritPickaxItem;
import xyz.vikkivuk.chaosmod.item.Milk2Item;
import xyz.vikkivuk.chaosmod.item.MethItem;
import xyz.vikkivuk.chaosmod.item.KondomnepitajzastoovoradimalispoileralertonimarupuItem;
import xyz.vikkivuk.chaosmod.item.JosipRangeItem;
import xyz.vikkivuk.chaosmod.item.GatoradeItem;
import xyz.vikkivuk.chaosmod.item.FooditemItem;
import xyz.vikkivuk.chaosmod.item.FoodItem3Item;
import xyz.vikkivuk.chaosmod.item.FoodItem2Item;
import xyz.vikkivuk.chaosmod.item.FallgaysItem;
import xyz.vikkivuk.chaosmod.item.DirtswordItem;
import xyz.vikkivuk.chaosmod.item.DipexItem;
import xyz.vikkivuk.chaosmod.item.DeekItem;
import xyz.vikkivuk.chaosmod.item.CumItem;
import xyz.vikkivuk.chaosmod.item.CorruptstaffItem;
import xyz.vikkivuk.chaosmod.item.ComicallyLargeSpoonItem;
import xyz.vikkivuk.chaosmod.item.CarbonMonoxideItem;
import xyz.vikkivuk.chaosmod.item.BulletItem;
import xyz.vikkivuk.chaosmod.item.BrownItem;
import xyz.vikkivuk.chaosmod.item.BeefArmorItem;
import xyz.vikkivuk.chaosmod.item.AmugusItem;
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
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.AMOGUS_3, -16763905, -65536, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
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
	public static final RegistryObject<Item> BEEF_ARMOR_HELMET = REGISTRY.register("beef_armor_helmet", () -> new BeefArmorItem.Helmet());
	public static final RegistryObject<Item> BEEF_ARMOR_CHESTPLATE = REGISTRY.register("beef_armor_chestplate", () -> new BeefArmorItem.Chestplate());
	public static final RegistryObject<Item> BEEF_ARMOR_LEGGINGS = REGISTRY.register("beef_armor_leggings", () -> new BeefArmorItem.Leggings());
	public static final RegistryObject<Item> BEEF_ARMOR_BOOTS = REGISTRY.register("beef_armor_boots", () -> new BeefArmorItem.Boots());
	public static final RegistryObject<Item> JOSIPDVATOCKANULA = REGISTRY.register("josipdvatockanula_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.JOSIPDVATOCKANULA, -16777216, -65536,
					new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> CORRUPTSTAFF = REGISTRY.register("corruptstaff", () -> new CorruptstaffItem());
	public static final RegistryObject<Item> JOSIP_PET = REGISTRY.register("josip_pet_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.JOSIP_PET, -3407668, -26113, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
	public static final RegistryObject<Item> TURTLE_ARMOR_CHESTPLATE = REGISTRY.register("turtle_armor_chestplate",
			() -> new TurtleArmorItem.Chestplate());
	public static final RegistryObject<Item> TURTLE_ARMOR_LEGGINGS = REGISTRY.register("turtle_armor_leggings", () -> new TurtleArmorItem.Leggings());
	public static final RegistryObject<Item> TURTLE_ARMOR_BOOTS = REGISTRY.register("turtle_armor_boots", () -> new TurtleArmorItem.Boots());
	public static final RegistryObject<Item> JOSIP_RANGE = REGISTRY.register("josip_range", () -> new JosipRangeItem());
	public static final RegistryObject<Item> JOSIP_PETT = REGISTRY.register("josip_pett_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.JOSIP_PETT, -65536, -10066330, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
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
	public static final RegistryObject<Item> NOBLOCK = block(ChaosmodModBlocks.NOBLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
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

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
