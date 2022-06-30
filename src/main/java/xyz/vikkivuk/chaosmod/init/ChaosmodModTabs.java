
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class ChaosmodModTabs {
	public static CreativeModeTab TAB_CHAOSTAB;
	public static CreativeModeTab TAB_GFDGSFDGFDGFDGFDGFDGFDG;

	public static void load() {
		TAB_CHAOSTAB = new CreativeModeTab("tabchaostab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ChaosmodModItems.DIRTSWORD.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_GFDGSFDGFDGFDGFDGFDGFDG = new CreativeModeTab("tabgfdgsfdgfdgfdgfdgfdgfdg") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Blocks.BLACK_CONCRETE);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
