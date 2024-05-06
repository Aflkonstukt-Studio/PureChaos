
package xyz.aflkonstukt.purechaos.recipes.brewing;

import xyz.aflkonstukt.purechaos.init.PurechaosModItems;

import net.neoforged.neoforge.common.brewing.IBrewingRecipe;
import net.neoforged.neoforge.common.brewing.BrewingRecipeRegistry;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OILRAAAHBrewingRecipe implements IBrewingRecipe {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(new OILRAAAHBrewingRecipe()));
	}

	@Override
	public boolean isInput(ItemStack input) {
		return Ingredient.of(new ItemStack(PurechaosModItems.STARAVODA_BUCKET.get())).test(input);
	}

	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return Ingredient.of(new ItemStack(PurechaosModItems.AK_47.get())).test(ingredient);
	}

	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if (isInput(input) && isIngredient(ingredient)) {
			return new ItemStack(PurechaosModItems.OIL_BUCKET.get());
		}
		return ItemStack.EMPTY;
	}
}
