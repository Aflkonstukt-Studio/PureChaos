
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class TOItem extends Item {
	public TOItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "to"))));
	}
}
