
package xyz.aflkonstukt.purechaos.recipe.brewing;

import xyz.aflkonstukt.purechaos.init.PurechaosModPotions;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;

import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Holder;

import java.util.Optional;

@EventBusSubscriber
public class BeerRecipeBrewingRecipe implements IBrewingRecipe {
	@SubscribeEvent
	public static void init(RegisterBrewingRecipesEvent event) {
		event.getBuilder().addRecipe(new BeerRecipeBrewingRecipe());
	}

	@Override
	public boolean isInput(ItemStack input) {
		Item inputItem = input.getItem();
		Optional<Holder<Potion>> optionalPotion = input.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).potion();
		return (inputItem == Items.POTION || inputItem == Items.SPLASH_POTION || inputItem == Items.LINGERING_POTION) && optionalPotion.isPresent() && optionalPotion.get().is(PurechaosModPotions.ETHANOL);
	}

	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return Ingredient.of(new ItemStack(PurechaosModItems.ALMOND_WATER.get())).test(ingredient);
	}

	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if (isInput(input) && isIngredient(ingredient)) {
			return new ItemStack(PurechaosModItems.BEER.get());
		}
		return ItemStack.EMPTY;
	}
}
