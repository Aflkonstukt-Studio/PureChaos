
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

public class PurechaosModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, PurechaosMod.MODID);
	public static final RegistryObject<PaintingVariant> MASTERPIECE = REGISTRY.register("masterpiece", () -> new PaintingVariant(400, 200));
	public static final RegistryObject<PaintingVariant> XMASTERWOOPAINTING = REGISTRY.register("xmasterwoopainting", () -> new PaintingVariant(16, 16));
	public static final RegistryObject<PaintingVariant> STUCK = REGISTRY.register("stuck", () -> new PaintingVariant(64, 64));
	public static final RegistryObject<PaintingVariant> HMMMM_DRIP = REGISTRY.register("hmmmm_drip", () -> new PaintingVariant(69, 60));
}
