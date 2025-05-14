
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.procedures.AlmondWaterPlayerFinishesUsingItemProcedure;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class AlmondWaterItem extends Item {
	public AlmondWaterItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(10).saturationModifier(20f).alwaysEdible().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.purechaos.almond_water.description_0"));
		list.add(Component.translatable("item.purechaos.almond_water.description_1"));
		list.add(Component.translatable("item.purechaos.almond_water.description_2"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		AlmondWaterPlayerFinishesUsingItemProcedure.execute(world, entity);
		return retval;
	}
}
