
package xyz.aflkonstukt.purechaos.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class ScratestItem extends RecordItem {
	public ScratestItem() {
		super(0, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:scratest")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1980);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
