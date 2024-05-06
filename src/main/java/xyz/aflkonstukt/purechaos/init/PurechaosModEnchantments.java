
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.enchantment.SexyEnchanetementEnchantment;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.core.registries.Registries;

public class PurechaosModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(Registries.ENCHANTMENT, PurechaosMod.MODID);
	public static final DeferredHolder<Enchantment, Enchantment> SEXY_ENCHANETEMENT = REGISTRY.register("sexy_enchanetement", () -> new SexyEnchanetementEnchantment());
}
