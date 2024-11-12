
package xyz.aflkonstukt.purechaos.init;

import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;
import java.util.ArrayList;

@JeiPlugin
public class PurechaosModBrewingRecipes implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("purechaos:brewing_recipes");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
		List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();
		ItemStack potion = new ItemStack(Items.POTION);
		ItemStack potion2 = new ItemStack(Items.POTION);
		List<ItemStack> ingredientStack = new ArrayList<>();
		List<ItemStack> inputStack = new ArrayList<>();
		ingredientStack.add(new ItemStack(PurechaosModBlocks.GREEN_PLANT.get()));
		inputStack.add(new ItemStack(Items.PAPER));
		potion.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), potion.copy()));
		ingredientStack.clear();
		inputStack.clear();
		ingredientStack.add(new ItemStack(PurechaosModItems.AK_47.get()));
		inputStack.add(new ItemStack(PurechaosModItems.STARAVODA_BUCKET.get()));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), new ItemStack(PurechaosModItems.OIL_BUCKET.get())));
		inputStack.clear();
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(PurechaosModItems.BRAKE_FLUID.get()));
		potion.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER));
		potion2.set(DataComponents.POTION_CONTENTS, new PotionContents(PurechaosModPotions.MODIFIED_ETHANOL));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(PurechaosModItems.APPLE_INGOT.get()));
		potion.set(DataComponents.POTION_CONTENTS, new PotionContents(PurechaosModPotions.MODIFIED_ETHANOL));
		potion2.set(DataComponents.POTION_CONTENTS, new PotionContents(PurechaosModPotions.ETHANOL));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(PurechaosModItems.ALMOND_WATER.get()));
		potion.set(DataComponents.POTION_CONTENTS, new PotionContents(PurechaosModPotions.ETHANOL));
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), new ItemStack(PurechaosModItems.BEER.get())));
		ingredientStack.clear();
		registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
	}
}
