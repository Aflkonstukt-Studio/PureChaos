
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class NetheritPickaxItem extends PickaxeItem {
	public NetheritPickaxItem() {
		super(new Tier() {
			public int getUses() {
				return 1245;
			}

			public float getSpeed() {
				return 9f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 15;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		},

				1, 11f,

				new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).fireResistant());
	}

}
