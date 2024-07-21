package xyz.aflkonstukt.purechaos.procedures;

import net.neoforged.fml.common.EventBusSubscriber;
import xyz.aflkonstukt.purechaos.PurechaosMod;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.gui.screens.Screen;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = PurechaosMod.MODID, value = Dist.CLIENT)
public class ItemTooltipsProcedure {
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
						"\u00A77Side effects include: heart attacks, heart palpitations, migraines, recurring nightmares, weird cheese dreams, fever dreams, increased chance of dementia, hallucinations, hardbans, possible chance of never waking up."));
			} else {
				tooltip.add(Component.literal("\u00A77Hold \u00A76SHIFT \u00A77for side effects"));
			}
		} else if (itemstack.getItem() == PurechaosModItems.MOB_CATCHER.get()) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("filled")) {
				tooltip.add(Component.literal("\u00A77Right click to place entity."));
			} else {
				tooltip.add(Component.literal("\u00A77Right click to kidnap entity."));
			}
		}
	}
}
