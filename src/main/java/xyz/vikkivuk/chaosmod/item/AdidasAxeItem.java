
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class AdidasAxeItem extends AxeItem {
	public AdidasAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 250;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 0f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 14;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(ChaosmodModBlocks.ADIDAS_BLOCK.get()));
			}
		},

				1, -3f,

				new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
	}

}