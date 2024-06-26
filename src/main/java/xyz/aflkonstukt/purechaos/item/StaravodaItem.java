
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;
import net.minecraft.network.chat.Component;

import java.util.List;

public class StaravodaItem extends BucketItem {
	public StaravodaItem() {
		super(PurechaosModFluids.STARAVODA, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Old water from clasic versions of the game"));
	}
}
