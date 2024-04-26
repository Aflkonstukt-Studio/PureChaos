
package xyz.aflkonstukt.purechaos.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class FallgaysItem extends RecordItem {
	public FallgaysItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("purechaos:fallguyswooh")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1160);
	}
}
