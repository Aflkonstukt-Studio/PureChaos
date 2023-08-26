
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.init.PurechaosModTabs;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public abstract class AmugusItem extends ArmorItem {
	public AmugusItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("purechaos:amogus"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.DIRT));
			}

			@Override
			public String getName() {
				return "amugus";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends AmugusItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "purechaos:textures/models/armor/dgfdgfdgfdgfdgdgfamoguws_layer_1.png";
		}
	}

	public static class Chestplate extends AmugusItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "purechaos:textures/models/armor/dgfdgfdgfdgfdgdgfamoguws_layer_1.png";
		}
	}

	public static class Leggings extends AmugusItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "purechaos:textures/models/armor/dgfdgfdgfdgfdgdgfamoguws_layer_2.png";
		}
	}

	public static class Boots extends AmugusItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "purechaos:textures/models/armor/dgfdgfdgfdgfdgdgfamoguws_layer_1.png";
		}
	}
}
