
package xyz.vikkivuk.chaosmod.item;

import xyz.vikkivuk.chaosmod.init.ChaosmodModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class AlmondWaterItem extends Item {
	public AlmondWaterItem() {
		super(new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(10).saturationMod(20f).alwaysEat()

				.build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("A sweet almond/vanilla flavored water"));
		list.add(new TextComponent("that is a critical source of hydration"));
		list.add(new TextComponent("and slight nutritional value"));
	}
}
