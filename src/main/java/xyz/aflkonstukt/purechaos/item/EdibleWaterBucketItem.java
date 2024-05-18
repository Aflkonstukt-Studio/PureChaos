
package xyz.aflkonstukt.purechaos.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class EdibleWaterBucketItem extends Item {
	public EdibleWaterBucketItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).alwaysEat().build()));
	}
}
