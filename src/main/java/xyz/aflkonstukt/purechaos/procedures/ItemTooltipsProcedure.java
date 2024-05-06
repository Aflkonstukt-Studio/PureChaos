package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class ItemTooltipsProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if (itemstack.getItem() == PurechaosModItems.MELATONIN_PILL.get()) {
			tooltip.add(Component.literal(("\u00A74Your current side effect chance: " + (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).heart_attack_chance + "%"))));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(
						"\u00A77Side effects include: heart attacks, heart palpitations, migraines, recurring nightmares, weird cheese dreams, fever dreams, increased chance of dementia, hallucinations, possible chance of never waking up."));
			} else {
				tooltip.add(Component.literal("\u00A77Hold \u00A76SHIFT \u00A77for side effects"));
			}
		}
	}
}
