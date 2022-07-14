
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class RadiationLiquidItem extends BucketItem {

	public RadiationLiquidItem() {
		super(ChaosmodModFluids.RADIATION_LIQUID,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(ChaosmodModTabs.TAB_CHAOSTAB));
	}

}
