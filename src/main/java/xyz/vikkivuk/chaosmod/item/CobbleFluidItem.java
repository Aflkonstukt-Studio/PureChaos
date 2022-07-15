
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class CobbleFluidItem extends BucketItem {

	public CobbleFluidItem() {
		super(ChaosmodModFluids.COBBLE_FLUID,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(ChaosmodModTabs.TAB_CHAOSTAB));
	}

}
