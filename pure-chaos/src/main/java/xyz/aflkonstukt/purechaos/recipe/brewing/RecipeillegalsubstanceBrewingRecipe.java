
package xyz.aflkonstukt.purechaos.recipe.brewing;

import xyz.aflkonstukt.purechaos.init.PurechaosModPotions;
import xyz.aflkonstukt.purechaos.init.PurechaosModBlocks;

import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class RecipeillegalsubstanceBrewingRecipe implements IBrewingRecipe {
	@SubscribeEvent
	public static void init(RegisterBrewingRecipesEvent event) {
		event.getBuilder().addRecipe(new RecipeillegalsubstanceBrewingRecipe());
	}

	@Override
	public boolean isInput(ItemStack input) {
		return Ingredient.of(new ItemStack(Items.PAPER)).test(input);
	}

	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return Ingredient.of(new ItemStack(PurechaosModBlocks.GREEN_PLANT.get())).test(ingredient);
	}

	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if (isInput(input) && isIngredient(ingredient)) {
			return PotionContents.createItemStack(Items.POTION, PurechaosModPotions.ILLEGALSUBSTANCE);
		}
		return ItemStack.EMPTY;
	}
}
