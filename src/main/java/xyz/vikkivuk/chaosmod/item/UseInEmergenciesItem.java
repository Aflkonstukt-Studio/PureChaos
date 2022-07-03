
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class UseInEmergenciesItem extends Item {

	public UseInEmergenciesItem() {
		super(new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Right click in case of emergencies (dont use this while in range 100 blocks of your base)"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		UseInEmergenciesRightclickedProcedure.execute(world, x, y, z);
		return ar;
	}

}
