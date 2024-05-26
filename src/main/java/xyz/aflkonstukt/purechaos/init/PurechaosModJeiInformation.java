
package xyz.aflkonstukt.purechaos.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class PurechaosModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("purechaos:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(PurechaosModItems.BEER.get()), new ItemStack(PurechaosModItems.APPLE_INGOT.get()), new ItemStack(PurechaosModItems.BRAKE_FLUID.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.purechaos.how_alcohol"));
		registration.addIngredientInfo(List.of(new ItemStack(PurechaosModItems.OIL_BUCKET.get()), new ItemStack(PurechaosModItems.AK_47.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.purechaos.how_oil"));
		registration.addIngredientInfo(List.of(new ItemStack(PurechaosModItems.ALMOND_WATER.get()), new ItemStack(PurechaosModItems.POOP.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.purechaos.how_almond_water"));
	}
}
