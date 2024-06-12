
package xyz.aflkonstukt.purechaos.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PingItem extends Item {
	public PingItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
