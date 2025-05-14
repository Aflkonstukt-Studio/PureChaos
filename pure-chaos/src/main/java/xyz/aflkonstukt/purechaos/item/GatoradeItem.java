
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class GatoradeItem extends BucketItem {
	public GatoradeItem() {
		super(PurechaosModFluids.GATORADE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
