
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.item.WoodDimensionItem;
import xyz.vikkivuk.chaosmod.item.WaterCupItem;
import xyz.vikkivuk.chaosmod.item.SusSwordItem;
import xyz.vikkivuk.chaosmod.item.SusItem;
import xyz.vikkivuk.chaosmod.item.StaravodaItem;
import xyz.vikkivuk.chaosmod.item.SpearItem;
import xyz.vikkivuk.chaosmod.item.PotatoSpudsItem;
import xyz.vikkivuk.chaosmod.item.PickaxItem;
import xyz.vikkivuk.chaosmod.item.PeemensionItem;
import xyz.vikkivuk.chaosmod.item.PeeItem;
import xyz.vikkivuk.chaosmod.item.OrangeFluidItem;
import xyz.vikkivuk.chaosmod.item.OilItem;
import xyz.vikkivuk.chaosmod.item.NetheritPickaxItem;
import xyz.vikkivuk.chaosmod.item.KondomnepitajzastoovoradimalispoileralertonimarupuItem;
import xyz.vikkivuk.chaosmod.item.GatoradeItem;
import xyz.vikkivuk.chaosmod.item.FooditemItem;
import xyz.vikkivuk.chaosmod.item.FoodItem3Item;
import xyz.vikkivuk.chaosmod.item.FoodItem2Item;
import xyz.vikkivuk.chaosmod.item.DirtswordItem;
import xyz.vikkivuk.chaosmod.item.DipexItem;
import xyz.vikkivuk.chaosmod.item.DeekItem;
import xyz.vikkivuk.chaosmod.item.CumItem;
import xyz.vikkivuk.chaosmod.item.ComicallyLargeSpoonItem;
import xyz.vikkivuk.chaosmod.item.BrokenChestplate1Item;
import xyz.vikkivuk.chaosmod.item.AmugusItem;
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
	public static final RegistryObject<Item> BROKEN_CHESTPLATE_1_CHESTPLATE = REGISTRY.register("broken_chestplate_1_chestplate",
			() -> new BrokenChestplate1Item.Chestplate());
	public static final RegistryObject<Item> POTATO_SPUDS = REGISTRY.register("potato_spuds", () -> new PotatoSpudsItem());
	public static final RegistryObject<Item> POTATUS = block(ChaosmodModBlocks.POTATUS, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> SPEAR = REGISTRY.register("spear", () -> new SpearItem());
	public static final RegistryObject<Item> EMEPEE = block(ChaosmodModBlocks.EMEPEE, null);
	public static final RegistryObject<Item> DIPEX = REGISTRY.register("dipex", () -> new DipexItem());
	public static final RegistryObject<Item> DEATH = block(ChaosmodModBlocks.DEATH, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> TRIDENT = REGISTRY.register("trident_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.TRIDENT, -13641874, -15373610, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));
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
	public static final RegistryObject<Item> GREEN_PLANT = block(ChaosmodModBlocks.GREEN_PLANT, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> WATER_CUP = REGISTRY.register("water_cup", () -> new WaterCupItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
