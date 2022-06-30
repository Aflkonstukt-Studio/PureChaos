
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.sounds.SoundEvent;

public abstract class TurtleArmorItem extends ArmorItem {

	public TurtleArmorItem(EquipmentSlot slot, Item.Properties properties) {
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
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}

			@Override
			public String getName() {
				return "turtle_armor";
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

	public static class Chestplate extends TurtleArmorItem {

		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "chaosmod:textures/models/armor/resturtle__layer_1.png";
		}

	}

	public static class Leggings extends TurtleArmorItem {

		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "chaosmod:textures/models/armor/resturtle__layer_2.png";
		}

	}

	public static class Boots extends TurtleArmorItem {

		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "chaosmod:textures/models/armor/resturtle__layer_1.png";
		}

	}

}
