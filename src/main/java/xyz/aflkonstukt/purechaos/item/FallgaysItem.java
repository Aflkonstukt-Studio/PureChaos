
package xyz.aflkonstukt.purechaos.item;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class FallgaysItem extends RecordItem {
	public FallgaysItem() {
		super(0, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:fallguyswooh")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1160);
	}
}
