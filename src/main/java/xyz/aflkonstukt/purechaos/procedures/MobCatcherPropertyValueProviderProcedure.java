package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.item.ItemStack;

public class MobCatcherPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getBoolean("filled") ? 1 : 0;
	}
}
