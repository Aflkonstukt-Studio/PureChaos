
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.init.PurechaosModTabs;
import xyz.aflkonstukt.purechaos.init.PurechaosModBlocks;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public abstract class AdidasArmorItem extends ArmorItem {
	public AdidasArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 30;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{2, 6, 5, 2}[slot.getIndex()];
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
				return Ingredient.of(new ItemStack(PurechaosModBlocks.ADIDAS_BLOCK.get()), new ItemStack(PurechaosModBlocks.SOUTH.get()), new ItemStack(PurechaosModBlocks.COMUNISAM_BLOCK.get()));
			}

			@Override
			public String getName() {
				return "adidas_armor";
			}

			@Override
			public float getToughness() {
				return 9f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends AdidasArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "purechaos:textures/models/armor/adidas_layer_1.png";
		}
	}

	public static class Chestplate extends AdidasArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "purechaos:textures/models/armor/adidas_layer_1.png";
		}
	}

	public static class Leggings extends AdidasArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "purechaos:textures/models/armor/adidas_layer_2.png";
		}
	}

	public static class Boots extends AdidasArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "purechaos:textures/models/armor/adidas_layer_1.png";
		}
	}
}
