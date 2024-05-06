
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.block.entity.SADsBlockEntity;
import xyz.aflkonstukt.purechaos.block.entity.PeeBlockBlockEntity;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurechaosModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PurechaosMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PEE_BLOCK = register("pee_block", PurechaosModBlocks.PEE_BLOCK, PeeBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SA_DS = register("sa_ds", PurechaosModBlocks.SA_DS, SADsBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PEE_BLOCK.get(), (blockEntity, side) -> ((PeeBlockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, PEE_BLOCK.get(), (blockEntity, side) -> ((PeeBlockBlockEntity) blockEntity).getFluidTank());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SA_DS.get(), (blockEntity, side) -> ((SADsBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, SA_DS.get(), (blockEntity, side) -> ((SADsBlockEntity) blockEntity).getEnergyStorage());
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, SA_DS.get(), (blockEntity, side) -> ((SADsBlockEntity) blockEntity).getFluidTank());
	}
}
