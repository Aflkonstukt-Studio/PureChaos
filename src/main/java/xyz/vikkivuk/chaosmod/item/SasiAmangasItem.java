
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class SasiAmangasItem extends RecordItem {

	public SasiAmangasItem() {
		super(0, ChaosmodModSounds.REGISTRY.get(new ResourceLocation("chaosmod:jusif")),
				new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("josip kako drka u mikrofon"));
		list.add(new TextComponent("josip je nacist"));
	}

}
