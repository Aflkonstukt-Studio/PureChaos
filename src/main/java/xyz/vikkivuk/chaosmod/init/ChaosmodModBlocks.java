
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.block.WoodDimensionPortalBlock;
import xyz.vikkivuk.chaosmod.block.SusPortalBlock;
import xyz.vikkivuk.chaosmod.block.SusBlockBlock;
import xyz.vikkivuk.chaosmod.block.SADsBlock;
import xyz.vikkivuk.chaosmod.block.PotatusBlock;
import xyz.vikkivuk.chaosmod.block.PeemensionPortalBlock;
import xyz.vikkivuk.chaosmod.block.PeeBlockBlock;
import xyz.vikkivuk.chaosmod.block.PeeBlock;
import xyz.vikkivuk.chaosmod.block.EmepeeBlock;
import xyz.vikkivuk.chaosmod.block.DeathBlock;
import xyz.vikkivuk.chaosmod.block.CumBlock;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

public class ChaosmodModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ChaosmodMod.MODID);
	public static final RegistryObject<Block> PEE = REGISTRY.register("pee", () -> new PeeBlock());
	public static final RegistryObject<Block> PEEMENSION_PORTAL = REGISTRY.register("peemension_portal", () -> new PeemensionPortalBlock());
	public static final RegistryObject<Block> PEE_BLOCK = REGISTRY.register("pee_block", () -> new PeeBlockBlock());
	public static final RegistryObject<Block> SA_DS = REGISTRY.register("sa_ds", () -> new SADsBlock());
	public static final RegistryObject<Block> POTATUS = REGISTRY.register("potatus", () -> new PotatusBlock());
	public static final RegistryObject<Block> EMEPEE = REGISTRY.register("emepee", () -> new EmepeeBlock());
	public static final RegistryObject<Block> DEATH = REGISTRY.register("death", () -> new DeathBlock());
	public static final RegistryObject<Block> WOOD_DIMENSION_PORTAL = REGISTRY.register("wood_dimension_portal",
			() -> new WoodDimensionPortalBlock());
	public static final RegistryObject<Block> SUS_BLOCK = REGISTRY.register("sus_block", () -> new SusBlockBlock());
	public static final RegistryObject<Block> CUM = REGISTRY.register("cum", () -> new CumBlock());
	public static final RegistryObject<Block> SUS_PORTAL = REGISTRY.register("sus_portal", () -> new SusPortalBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			PotatusBlock.registerRenderLayer();
		}
	}
}
