
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class SpearItem extends SwordItem {
	public SpearItem() {
		super(new Tier() {
			public int getUses() {
				return 371;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 16f;
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

				3, 6f,

				new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB));
	}

}
