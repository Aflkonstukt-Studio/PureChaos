
package xyz.vikkivuk.chaosmod.item;

import xyz.vikkivuk.chaosmod.init.ChaosmodModTabs;
import xyz.vikkivuk.chaosmod.init.ChaosmodModSounds;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class ScratestItem extends RecordItem {
	public ScratestItem() {
		super(0, ChaosmodModSounds.REGISTRY.get(new ResourceLocation("chaosmod:scratest")),
				new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
