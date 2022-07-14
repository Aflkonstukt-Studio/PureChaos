
package xyz.vikkivuk.chaosmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class ZenithItem extends SwordItem {
	public ZenithItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 32f;
			}

			public float getAttackDamageBonus() {
				return 188f;
			}

			public int getLevel() {
				return 32;
			}

			public int getEnchantmentValue() {
				return 100;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		},

				3, 1f,

				new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).fireResistant());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("check out Terraria"));
	}

}
