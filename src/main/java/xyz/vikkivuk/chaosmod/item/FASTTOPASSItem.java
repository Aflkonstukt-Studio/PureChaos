
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.network.chat.Component;

public class FASTTOPASSItem extends RecordItem {

	public FASTTOPASSItem() {
		super(0, ChaosmodModSounds.REGISTRY.get(new ResourceLocation("chaosmod:ahdude")),
				new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("HEHE"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		FASTTOPASSRightclickedProcedure.execute(entity);
		return ar;
	}

}
