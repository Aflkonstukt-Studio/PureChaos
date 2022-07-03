
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.block.YoutubeBlock;
import xyz.vikkivuk.chaosmod.block.WoodDimensionPortalBlock;
import xyz.vikkivuk.chaosmod.block.TombstoneBlock;
import xyz.vikkivuk.chaosmod.block.TLGHDBlock;
import xyz.vikkivuk.chaosmod.block.SusPortalBlock;
import xyz.vikkivuk.chaosmod.block.SusBlockBlock;
import xyz.vikkivuk.chaosmod.block.StaravodaBlock;
import xyz.vikkivuk.chaosmod.block.SADsBlock;
import xyz.vikkivuk.chaosmod.block.RickrollBlockBlock;
import xyz.vikkivuk.chaosmod.block.PotatusBlock;
import xyz.vikkivuk.chaosmod.block.PlanteBlock;
import xyz.vikkivuk.chaosmod.block.PeemensionPortalBlock;
import xyz.vikkivuk.chaosmod.block.PeeBlockBlock;
import xyz.vikkivuk.chaosmod.block.PeeBlock;
import xyz.vikkivuk.chaosmod.block.OrangeFluidBlock;
import xyz.vikkivuk.chaosmod.block.OilBlock;
import xyz.vikkivuk.chaosmod.block.NoblockBlock;
import xyz.vikkivuk.chaosmod.block.Milk2Block;
import xyz.vikkivuk.chaosmod.block.GreenPlantBlock;
import xyz.vikkivuk.chaosmod.block.GraveBlock;
import xyz.vikkivuk.chaosmod.block.GatoradeBlock;
import xyz.vikkivuk.chaosmod.block.EmepeeBlock;
import xyz.vikkivuk.chaosmod.block.DeathBlock;
import xyz.vikkivuk.chaosmod.block.CumBlock;
import xyz.vikkivuk.chaosmod.block.CarbonMonoxideBlock;
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
	public static final RegistryObject<Block> STARAVODA = REGISTRY.register("staravoda", () -> new StaravodaBlock());
	public static final RegistryObject<Block> TLGHD = REGISTRY.register("tlghd", () -> new TLGHDBlock());
	public static final RegistryObject<Block> ORANGE_FLUID = REGISTRY.register("orange_fluid", () -> new OrangeFluidBlock());
	public static final RegistryObject<Block> OIL = REGISTRY.register("oil", () -> new OilBlock());
	public static final RegistryObject<Block> GATORADE = REGISTRY.register("gatorade", () -> new GatoradeBlock());
	public static final RegistryObject<Block> GREEN_PLANT = REGISTRY.register("green_plant", () -> new GreenPlantBlock());
	public static final RegistryObject<Block> TOMBSTONE = REGISTRY.register("tombstone", () -> new TombstoneBlock());
	public static final RegistryObject<Block> CARBON_MONOXIDE = REGISTRY.register("carbon_monoxide", () -> new CarbonMonoxideBlock());
	public static final RegistryObject<Block> NOBLOCK = REGISTRY.register("noblock", () -> new NoblockBlock());
	public static final RegistryObject<Block> YOUTUBE = REGISTRY.register("youtube", () -> new YoutubeBlock());
	public static final RegistryObject<Block> PLANTE = REGISTRY.register("plante", () -> new PlanteBlock());
	public static final RegistryObject<Block> MILK_2 = REGISTRY.register("milk_2", () -> new Milk2Block());
	public static final RegistryObject<Block> RICKROLL_BLOCK = REGISTRY.register("rickroll_block", () -> new RickrollBlockBlock());
	public static final RegistryObject<Block> GRAVE = REGISTRY.register("grave", () -> new GraveBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			PotatusBlock.registerRenderLayer();
			GreenPlantBlock.registerRenderLayer();
			TombstoneBlock.registerRenderLayer();
			YoutubeBlock.registerRenderLayer();
			PlanteBlock.registerRenderLayer();
			GraveBlock.registerRenderLayer();
		}
	}
}
