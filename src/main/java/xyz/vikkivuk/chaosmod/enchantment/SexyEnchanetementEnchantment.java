
package xyz.vikkivuk.chaosmod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class SexyEnchanetementEnchantment extends Enchantment {
	public SexyEnchanetementEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR, slots);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}
}
