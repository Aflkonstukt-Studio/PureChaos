
package xyz.aflkonstukt.purechaos.item;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class SusStoryItem extends RecordItem {
	public SusStoryItem() {
		super(15, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:she-beats-my-meat")), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 900);
	}
}
