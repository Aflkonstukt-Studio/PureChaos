
package xyz.vikkivuk.chaosmod.enchantment;

public class SexyEnchanetementEnchantment extends Enchantment {

	public SexyEnchanetementEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR, slots);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

}
