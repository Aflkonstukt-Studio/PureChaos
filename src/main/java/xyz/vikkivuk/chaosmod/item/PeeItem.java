
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class PeeItem extends BucketItem {

	public PeeItem() {
		super(ChaosmodModFluids.PEE,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(ChaosmodModTabs.TAB_DELETED_MOD_ELEMENT));
	}

}
