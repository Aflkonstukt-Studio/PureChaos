
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.procedures.TickChestplateTickEventProcedure;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;
import xyz.aflkonstukt.purechaos.client.model.Modeltick;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.Minecraft;
import net.minecraft.Util;

import java.util.Map;
import java.util.List;
import java.util.EnumMap;
import java.util.Collections;

import com.google.common.collect.Iterables;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class TickItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 0);
				map.put(ArmorItem.Type.LEGGINGS, 0);
				map.put(ArmorItem.Type.CHESTPLATE, 3);
				map.put(ArmorItem.Type.HELMET, 0);
				map.put(ArmorItem.Type.BODY, 3);
			}), 1, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("purechaos:bite")), () -> Ingredient.of(), List.of(new ArmorMaterial.Layer(ResourceLocation.parse("purechaos:beef_armor"))), 0f, 0f);
			registerHelper.register(ResourceLocation.parse("purechaos:tick"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			@OnlyIn(Dist.CLIENT)
			public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
				HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
						Map.of("body", new Modeltick(Minecraft.getInstance().getEntityModels().bakeLayer(Modeltick.LAYER_LOCATION)).bb_main, "left_arm",
								new Modeltick(Minecraft.getInstance().getEntityModels().bakeLayer(Modeltick.LAYER_LOCATION)).bb_main, "right_arm", new Modeltick(Minecraft.getInstance().getEntityModels().bakeLayer(Modeltick.LAYER_LOCATION)).bb_main,
								"head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg",
								new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				armorModel.crouching = living.isShiftKeyDown();
				armorModel.riding = defaultModel.riding;
				armorModel.young = living.isBaby();
				return armorModel;
			}
		}, PurechaosModItems.TICK_CHESTPLATE.get());
	}

	public TickItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Chestplate extends TickItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(0)));
		}

		@Override
		public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return ResourceLocation.parse("purechaos:textures/entities/tick.png");
		}

		@Override
		public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
			return true;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				TickChestplateTickEventProcedure.execute(entity);
			}
		}
	}
}
