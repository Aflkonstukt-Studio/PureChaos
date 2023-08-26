
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.block.entity.TombstoneBlockEntity;
import xyz.aflkonstukt.purechaos.block.entity.SADsBlockEntity;
import xyz.aflkonstukt.purechaos.block.entity.PeeBlockBlockEntity;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class PurechaosModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PurechaosMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> PEE_BLOCK = register("pee_block", PurechaosModBlocks.PEE_BLOCK, PeeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SA_DS = register("sa_ds", PurechaosModBlocks.SA_DS, SADsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TOMBSTONE = register("tombstone", PurechaosModBlocks.TOMBSTONE, TombstoneBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
