
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class ScratestItem extends RecordItem {

	public ScratestItem() {
		super(0, ChaosmodModSounds.REGISTRY.get(new ResourceLocation("chaosmod:scratest")),
				new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

}
