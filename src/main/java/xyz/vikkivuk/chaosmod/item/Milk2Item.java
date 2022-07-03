
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class Milk2Item extends BucketItem {

	public Milk2Item() {
		super(ChaosmodModFluids.MILK_2,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(ChaosmodModTabs.TAB_CHAOSTAB));
	}

}
