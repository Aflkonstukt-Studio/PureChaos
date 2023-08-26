
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.init.PurechaosModTabs;
import xyz.aflkonstukt.purechaos.init.PurechaosModSounds;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class SSSRItem extends RecordItem {
	public SSSRItem() {
		super(0, PurechaosModSounds.REGISTRY.get(new ResourceLocation("purechaos:sssr")), new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.RARE));
	}
}
