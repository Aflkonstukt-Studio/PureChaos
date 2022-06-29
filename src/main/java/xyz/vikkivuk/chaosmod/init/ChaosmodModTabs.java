
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class ChaosmodModTabs {
	public static CreativeModeTab TAB_CHAOSTAB;

	public static void load() {
		TAB_CHAOSTAB = new CreativeModeTab("tabchaostab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ChaosmodModItems.PEEMENSION.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
