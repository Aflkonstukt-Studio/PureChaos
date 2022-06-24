
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.item.PeemensionItem;
import xyz.vikkivuk.chaosmod.item.PeeItem;
import xyz.vikkivuk.chaosmod.item.DirtswordItem;
import xyz.vikkivuk.chaosmod.item.DeekItem;
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
	public static final RegistryObject<Item> PEE_BLOCK = block(ChaosmodModBlocks.PEE_BLOCK, ChaosmodModTabs.TAB_CHAOSTAB);
	public static final RegistryObject<Item> PEEMENSION = REGISTRY.register("peemension", () -> new PeemensionItem());
	public static final RegistryObject<Item> AENTITY = REGISTRY.register("aentity_spawn_egg",
			() -> new ForgeSpawnEggItem(ChaosmodModEntities.AENTITY, -13434625, -10040065, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB)));

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
