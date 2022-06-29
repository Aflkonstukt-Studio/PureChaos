
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class CumItem extends BucketItem {

	public CumItem() {
		super(ChaosmodModFluids.CUM,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.UNCOMMON).tab(ChaosmodModTabs.TAB_CHAOSTAB));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("JU HEV ENTERD D CUM ZONE"));
	}
}
