
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class DipexItem extends PickaxeItem {
	public DipexItem() {
		super(new Tier() {
			public int getUses() {
				return 982;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		},

				1, -1f,

				new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB));
	}

}
