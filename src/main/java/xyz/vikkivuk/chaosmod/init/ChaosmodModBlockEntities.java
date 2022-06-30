
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.block.entity.SADsBlockEntity;
import xyz.vikkivuk.chaosmod.block.entity.PeeBlockBlockEntity;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class ChaosmodModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ChaosmodMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> PEE_BLOCK = register("pee_block", ChaosmodModBlocks.PEE_BLOCK, PeeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SA_DS = register("sa_ds", ChaosmodModBlocks.SA_DS, SADsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TOMBSTONE = register("tombstone", ChaosmodModBlocks.TOMBSTONE, TombstoneBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
