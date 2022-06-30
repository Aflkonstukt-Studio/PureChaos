
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.sounds.SoundEvent;

public abstract class BeefArmorItem extends ArmorItem {

	public BeefArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 50;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{10, 15, 20, 10}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 20;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("chaosmod:fallguyswooh"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.BEEF), new ItemStack(Items.COOKED_BEEF));
			}

			@Override
			public String getName() {
				return "beef_armor";
			}

			@Override
			public float getToughness() {
				return 6f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.2f;
			}
		}, slot, properties);
	}

	public static class Helmet extends BeefArmorItem {

		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "chaosmod:textures/models/armor/beef_armor_layer_1.png";
		}

	}

	public static class Chestplate extends BeefArmorItem {

		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "chaosmod:textures/models/armor/beef_armor_layer_1.png";
		}

	}

	public static class Leggings extends BeefArmorItem {

		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "chaosmod:textures/models/armor/beef_armor_layer_2.png";
		}

	}

	public static class Boots extends BeefArmorItem {

		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "chaosmod:textures/models/armor/beef_armor_layer_1.png";
		}

	}

}
