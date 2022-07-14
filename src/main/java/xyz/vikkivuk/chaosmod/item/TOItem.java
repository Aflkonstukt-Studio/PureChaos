
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class TOItem extends RecordItem {

	public TOItem() {
		super(0, ChaosmodModSounds.REGISTRY.get(new ResourceLocation("chaosmod:crnidani")),
				new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.RARE));
	}

}
