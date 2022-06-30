
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class FallgaysItem extends RecordItem {

	public FallgaysItem() {
		super(0, ChaosmodModSounds.REGISTRY.get(new ResourceLocation("chaosmod:fallguyswooh")),
				new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.RARE));
	}

}
