
package xyz.aflkonstukt.purechaos.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.List;

public class SasiAmangasItem extends RecordItem {
	public SasiAmangasItem() {
		super(0, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:jusif")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 240);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("Josip is making an amogus"));
	}
}
