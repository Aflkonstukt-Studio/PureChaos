
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class CobbleFluidItem extends BucketItem {
	public CobbleFluidItem() {
		super(PurechaosModFluids.COBBLE_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
