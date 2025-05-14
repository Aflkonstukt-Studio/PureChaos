
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.procedures.CocaColaPlayerFinishesUsingItemProcedure;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class CocaColaItem extends Item {
	public CocaColaItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(8).saturationModifier(8f).alwaysEdible().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.purechaos.coca_cola.description_0"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(PurechaosModItems.ALMOND_WATER.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		CocaColaPlayerFinishesUsingItemProcedure.execute(world, x, y, z);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		CocaColaPlayerFinishesUsingItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return true;
	}
}
