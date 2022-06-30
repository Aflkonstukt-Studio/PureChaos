
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class CarbonMonoxideItem extends BucketItem {

	public CarbonMonoxideItem() {
		super(ChaosmodModFluids.CARBON_MONOXIDE,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("dont use it on jews"));
	}
}
