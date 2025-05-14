
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.procedures.EdibleWaterBucketPlayerFinishesUsingItemProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class EdibleWaterBucketItem extends Item {
	public EdibleWaterBucketItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).alwaysEdible().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		EdibleWaterBucketPlayerFinishesUsingItemProcedure.execute(entity);
		return retval;
	}
}
