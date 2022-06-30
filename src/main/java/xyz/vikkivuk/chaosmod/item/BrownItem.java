
package xyz.vikkivuk.chaosmod.item;

import xyz.vikkivuk.chaosmod.procedures.BrownItemInInventoryTickProcedure;
import xyz.vikkivuk.chaosmod.init.ChaosmodModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class BrownItem extends Item {
	public BrownItem() {
		super(new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(64).fireResistant().rarity(Rarity.RARE)
				.food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("It... multiplies?"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		BrownItemInInventoryTickProcedure.execute(entity);
	}
}
