
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.init.PurechaosModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class PotatoSpudsItem extends Item {
	public PotatoSpudsItem() {
		super(new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB).stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(1f).alwaysEat()

				.build()));
	}
}
