
package xyz.vikkivuk.chaosmod.item;

import xyz.vikkivuk.chaosmod.init.ChaosmodModTabs;
import xyz.vikkivuk.chaosmod.init.ChaosmodModFluids;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class Milk2Item extends BucketItem {
	public Milk2Item() {
		super(ChaosmodModFluids.MILK_2,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(ChaosmodModTabs.TAB_CHAOSTAB));
	}
}
