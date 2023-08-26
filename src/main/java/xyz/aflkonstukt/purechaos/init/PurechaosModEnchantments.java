
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.enchantment.SexyEnchanetementEnchantment;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

public class PurechaosModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, PurechaosMod.MODID);
	public static final RegistryObject<Enchantment> SEXY_ENCHANETEMENT = REGISTRY.register("sexy_enchanetement", () -> new SexyEnchanetementEnchantment());
}
