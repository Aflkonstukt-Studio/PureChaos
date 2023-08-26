
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.init.PurechaosModTabs;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class Milk2Item extends BucketItem {
	public Milk2Item() {
		super(PurechaosModFluids.MILK_2, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(PurechaosModTabs.TAB_CHAOSTAB));
	}
}
