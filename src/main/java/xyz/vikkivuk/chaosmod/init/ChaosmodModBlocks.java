
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.block.PeemensionPortalBlock;
import xyz.vikkivuk.chaosmod.block.PeeBlockBlock;
import xyz.vikkivuk.chaosmod.block.PeeBlock;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class ChaosmodModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ChaosmodMod.MODID);
	public static final RegistryObject<Block> PEE = REGISTRY.register("pee", () -> new PeeBlock());
	public static final RegistryObject<Block> PEE_BLOCK = REGISTRY.register("pee_block", () -> new PeeBlockBlock());
	public static final RegistryObject<Block> PEEMENSION_PORTAL = REGISTRY.register("peemension_portal", () -> new PeemensionPortalBlock());
}
