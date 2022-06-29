
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.item.WoodDimensionItem;
import xyz.vikkivuk.chaosmod.item.SusItem;
import xyz.vikkivuk.chaosmod.item.SpearItem;
import xyz.vikkivuk.chaosmod.item.PotatoSpudsItem;
import xyz.vikkivuk.chaosmod.item.PickaxItem;
import xyz.vikkivuk.chaosmod.item.PeemensionItem;
import xyz.vikkivuk.chaosmod.item.PeeItem;
import xyz.vikkivuk.chaosmod.item.NetheritPickaxItem;
import xyz.vikkivuk.chaosmod.item.FooditemItem;
import xyz.vikkivuk.chaosmod.item.FoodItem3Item;
import xyz.vikkivuk.chaosmod.item.FoodItem2Item;
import xyz.vikkivuk.chaosmod.item.DirtswordItem;
import xyz.vikkivuk.chaosmod.item.DipexItem;
import xyz.vikkivuk.chaosmod.item.DeekItem;
import xyz.vikkivuk.chaosmod.item.CumItem;
import xyz.vikkivuk.chaosmod.item.ComicallyLargeSpoonItem;
import xyz.vikkivuk.chaosmod.item.BrokenChestplate1Item;
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

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
