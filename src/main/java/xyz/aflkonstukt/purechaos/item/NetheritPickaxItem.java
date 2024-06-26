
package xyz.aflkonstukt.purechaos.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item;

public class NetheritPickaxItem extends PickaxeItem {
	public NetheritPickaxItem() {
		super(new Tier() {
			public int getUses() {
				return 1245;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 8;
			}

			public int getEnchantmentValue() {
				return 15;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 1, 12f, new Item.Properties().fireResistant());
	}
}
