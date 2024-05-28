
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
		registration.addIngredientInfo(
				List.of(new ItemStack(PurechaosModItems.FOODITEM.get()), new ItemStack(PurechaosModItems.FOOD_ITEM_2.get()), new ItemStack(PurechaosModItems.POTATO_SPUDS.get()), new ItemStack(PurechaosModItems.WOOD_DIMENSION.get()),
						new ItemStack(PurechaosModItems.FOOD_ITEM_3.get()), new ItemStack(PurechaosModBlocks.DEATH.get()), new ItemStack(PurechaosModItems.COMICALLY_LARGE_SPOON.get()), new ItemStack(PurechaosModItems.SPEAR.get()),
						new ItemStack(PurechaosModItems.SUS.get()), new ItemStack(PurechaosModItems.STARAVODA_BUCKET.get()), new ItemStack(PurechaosModItems.AMUGUS_HELMET.get()), new ItemStack(PurechaosModItems.AMUGUS_CHESTPLATE.get()),
						new ItemStack(PurechaosModItems.AMUGUS_LEGGINGS.get()), new ItemStack(PurechaosModItems.AMUGUS_BOOTS.get()), new ItemStack(PurechaosModItems.BROWN.get()), new ItemStack(PurechaosModItems.BULLET.get()),
						new ItemStack(PurechaosModItems.USE_IN_EMERGENCIES.get()), new ItemStack(PurechaosModItems.SSSR.get()), new ItemStack(PurechaosModItems.BLEACH.get()), new ItemStack(PurechaosModBlocks.BRAZIL_BLOCK.get()),
						new ItemStack(PurechaosModBlocks.NOKIA_BLOCK.get()), new ItemStack(PurechaosModItems.IMPOSTOR_KNIFE.get()), new ItemStack(PurechaosModItems.ALMOND_WATER.get()), new ItemStack(PurechaosModItems.TOTEM_OF_DREAM.get()),
						new ItemStack(PurechaosModItems.HALF_GOLDEN_APPLE.get()), new ItemStack(PurechaosModItems.BEEF.get()), new ItemStack(PurechaosModItems.BAGUETTE.get()), new ItemStack(PurechaosModBlocks.ADIDAS_BLOCK.get()),
						new ItemStack(PurechaosModItems.XITE.get()), new ItemStack(PurechaosModItems.DORITO_NACHO.get()), new ItemStack(PurechaosModItems.KENTUCKY_FRIED_CHICKEN_FRIES.get()),
						new ItemStack(PurechaosModItems.KENTUCKY_FRIED_CHICKEN.get()), new ItemStack(PurechaosModItems.COCA_COLA.get()), new ItemStack(PurechaosModItems.SUSSY_SUS_STEW.get()), new ItemStack(PurechaosModItems.GRIMACE_SHAKE.get()),
						new ItemStack(PurechaosModItems.WATER_CUP.get()), new ItemStack(PurechaosModItems.AK_47.get()), new ItemStack(PurechaosModItems.PUFFER_BALLOON.get()), new ItemStack(PurechaosModItems.NETHERIT_PICKAX.get()),
						new ItemStack(PurechaosModItems.BRAZIL.get()), new ItemStack(PurechaosModItems.ZENITH.get()), new ItemStack(PurechaosModItems.MERCURY.get()), new ItemStack(PurechaosModItems.FRYING_PAN.get()),
						new ItemStack(PurechaosModItems.AMOGUS_GUN.get()), new ItemStack(PurechaosModItems.JAVELIN_LAUNCHER.get()), new ItemStack(PurechaosModItems.BRAKE_FLUID.get()), new ItemStack(PurechaosModItems.FISH_LAUNCHER.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.purechaos.found_in_loot"));
		registration.addIngredientInfo(List.of(new ItemStack(PurechaosModItems.SASI_AMANGAS.get()), new ItemStack(PurechaosModItems.TESTICLE_ON_STICK.get()), new ItemStack(PurechaosModItems.SSSR.get()),
				new ItemStack(PurechaosModBlocks.DEPRESSION_BLOCK.get()), new ItemStack(PurechaosModItems.IMPOSTOR_KNIFE.get()), new ItemStack(PurechaosModItems.TOTEM_OF_DREAM.get()), new ItemStack(PurechaosModItems.OBAMIUM.get()),
				new ItemStack(PurechaosModItems.BEENGOT.get()), new ItemStack(PurechaosModBlocks.ADIDAS_BLOCK.get()), new ItemStack(PurechaosModItems.APPLE_INGOT.get()), new ItemStack(PurechaosModItems.AMOGUS_GUN.get()),
				new ItemStack(PurechaosModItems.PUFFER_BALLOON.get()), new ItemStack(PurechaosModItems.BRAKE_FLUID.get()), new ItemStack(PurechaosModItems.FISH_LAUNCHER.get()), new ItemStack(PurechaosModItems.FRANCIUM.get()),
				new ItemStack(PurechaosModItems.BEER.get()), new ItemStack(PurechaosModItems.FRYING_PAN.get()), new ItemStack(PurechaosModItems.COMMUNISM_ORB.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.purechaos.found_in_josip_boss"));
	}
}
