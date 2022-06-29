
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class StaravodaItem extends BucketItem {

	public StaravodaItem() {
		super(ChaosmodModFluids.STARAVODA,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(ChaosmodModTabs.TAB_CHAOSTAB));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Old water from clasic versions of the game"));
	}
}
