
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.block.YoutubeBlock;
import xyz.aflkonstukt.purechaos.block.WoodDimensionPortalBlock;
import xyz.aflkonstukt.purechaos.block.TombstoneBlock;
import xyz.aflkonstukt.purechaos.block.TLGHDBlock;
import xyz.aflkonstukt.purechaos.block.SusPortalBlock;
import xyz.aflkonstukt.purechaos.block.SusBlockBlock;
import xyz.aflkonstukt.purechaos.block.StaravodaBlock;
import xyz.aflkonstukt.purechaos.block.SouthBlock;
import xyz.aflkonstukt.purechaos.block.SADsBlock;
import xyz.aflkonstukt.purechaos.block.RickrollBlockBlock;
import xyz.aflkonstukt.purechaos.block.RadiationLiquidBlock;
import xyz.aflkonstukt.purechaos.block.PotatusBlock;
import xyz.aflkonstukt.purechaos.block.PolandBlockBlock;
import xyz.aflkonstukt.purechaos.block.PlanteBlock;
import xyz.aflkonstukt.purechaos.block.PeemensionPortalBlock;
import xyz.aflkonstukt.purechaos.block.PeeBlockBlock;
import xyz.aflkonstukt.purechaos.block.PeeBlock;
import xyz.aflkonstukt.purechaos.block.OrangeFluidBlock;
import xyz.aflkonstukt.purechaos.block.OilBlock;
import xyz.aflkonstukt.purechaos.block.NokiaBlockBlock;
import xyz.aflkonstukt.purechaos.block.MissingTextureBlock;
import xyz.aflkonstukt.purechaos.block.Milk2Block;
import xyz.aflkonstukt.purechaos.block.JebBlockBlock;
import xyz.aflkonstukt.purechaos.block.GreengiscreendaBlock;
import xyz.aflkonstukt.purechaos.block.GreenPlantBlock;
import xyz.aflkonstukt.purechaos.block.GraveBlock;
import xyz.aflkonstukt.purechaos.block.GatoradeBlock;
import xyz.aflkonstukt.purechaos.block.EmepeeBlock;
import xyz.aflkonstukt.purechaos.block.DepressionBlockBlock;
import xyz.aflkonstukt.purechaos.block.DeathBlock;
import xyz.aflkonstukt.purechaos.block.CyberBlockBlock;
import xyz.aflkonstukt.purechaos.block.CumBlock;
import xyz.aflkonstukt.purechaos.block.ComunisamBlockBlock;
import xyz.aflkonstukt.purechaos.block.ComputerBlock;
import xyz.aflkonstukt.purechaos.block.CobbleFluidBlock;
import xyz.aflkonstukt.purechaos.block.CioaoPortalBlock;
import xyz.aflkonstukt.purechaos.block.CarbonMonoxideBlock;
import xyz.aflkonstukt.purechaos.block.BrazilPortalBlock;
import xyz.aflkonstukt.purechaos.block.BrazilBlockBlock;
import xyz.aflkonstukt.purechaos.block.BackroomsLvl1lightBlock;
import xyz.aflkonstukt.purechaos.block.BackroomsLvl1WallBlock;
import xyz.aflkonstukt.purechaos.block.BackroomsLvl1FloorBlock;
import xyz.aflkonstukt.purechaos.block.AetherPortalBlock;
import xyz.aflkonstukt.purechaos.block.AdidasBlockBlock;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

public class PurechaosModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, PurechaosMod.MODID);
	public static final RegistryObject<Block> PEE = REGISTRY.register("pee", () -> new PeeBlock());
	public static final RegistryObject<Block> PEEMENSION_PORTAL = REGISTRY.register("peemension_portal", () -> new PeemensionPortalBlock());
	public static final RegistryObject<Block> PEE_BLOCK = REGISTRY.register("pee_block", () -> new PeeBlockBlock());
	public static final RegistryObject<Block> SA_DS = REGISTRY.register("sa_ds", () -> new SADsBlock());
	public static final RegistryObject<Block> POTATUS = REGISTRY.register("potatus", () -> new PotatusBlock());
	public static final RegistryObject<Block> EMEPEE = REGISTRY.register("emepee", () -> new EmepeeBlock());
	public static final RegistryObject<Block> DEATH = REGISTRY.register("death", () -> new DeathBlock());
	public static final RegistryObject<Block> WOOD_DIMENSION_PORTAL = REGISTRY.register("wood_dimension_portal", () -> new WoodDimensionPortalBlock());
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
	public static final RegistryObject<Block> YOUTUBE = REGISTRY.register("youtube", () -> new YoutubeBlock());
	public static final RegistryObject<Block> PLANTE = REGISTRY.register("plante", () -> new PlanteBlock());
	public static final RegistryObject<Block> MILK_2 = REGISTRY.register("milk_2", () -> new Milk2Block());
	public static final RegistryObject<Block> RICKROLL_BLOCK = REGISTRY.register("rickroll_block", () -> new RickrollBlockBlock());
	public static final RegistryObject<Block> GRAVE = REGISTRY.register("grave", () -> new GraveBlock());
	public static final RegistryObject<Block> BACKROOMS_LVL_1LIGHT = REGISTRY.register("backrooms_lvl_1light", () -> new BackroomsLvl1lightBlock());
	public static final RegistryObject<Block> BACKROOMS_LVL_1_WALL = REGISTRY.register("backrooms_lvl_1_wall", () -> new BackroomsLvl1WallBlock());
	public static final RegistryObject<Block> SOUTH = REGISTRY.register("south", () -> new SouthBlock());
	public static final RegistryObject<Block> BACKROOMS_LVL_1_FLOOR = REGISTRY.register("backrooms_lvl_1_floor", () -> new BackroomsLvl1FloorBlock());
	public static final RegistryObject<Block> COMUNISAM_BLOCK = REGISTRY.register("comunisam_block", () -> new ComunisamBlockBlock());
	public static final RegistryObject<Block> POLAND_BLOCK = REGISTRY.register("poland_block", () -> new PolandBlockBlock());
	public static final RegistryObject<Block> NOKIA_BLOCK = REGISTRY.register("nokia_block", () -> new NokiaBlockBlock());
	public static final RegistryObject<Block> CIOAO_PORTAL = REGISTRY.register("cioao_portal", () -> new CioaoPortalBlock());
	public static final RegistryObject<Block> RADIATION_LIQUID = REGISTRY.register("radiation_liquid", () -> new RadiationLiquidBlock());
	public static final RegistryObject<Block> GREENGISCREENDA = REGISTRY.register("greengiscreenda", () -> new GreengiscreendaBlock());
	public static final RegistryObject<Block> BRAZIL_BLOCK = REGISTRY.register("brazil_block", () -> new BrazilBlockBlock());
	public static final RegistryObject<Block> BRAZIL_PORTAL = REGISTRY.register("brazil_portal", () -> new BrazilPortalBlock());
	public static final RegistryObject<Block> DEPRESSION_BLOCK = REGISTRY.register("depression_block", () -> new DepressionBlockBlock());
	public static final RegistryObject<Block> CYBER_BLOCK = REGISTRY.register("cyber_block", () -> new CyberBlockBlock());
	public static final RegistryObject<Block> COMPUTER = REGISTRY.register("computer", () -> new ComputerBlock());
	public static final RegistryObject<Block> COBBLE_FLUID = REGISTRY.register("cobble_fluid", () -> new CobbleFluidBlock());
	public static final RegistryObject<Block> ADIDAS_BLOCK = REGISTRY.register("adidas_block", () -> new AdidasBlockBlock());
	public static final RegistryObject<Block> MISSING_TEXTURE = REGISTRY.register("missing_texture", () -> new MissingTextureBlock());
	public static final RegistryObject<Block> AETHER_PORTAL = REGISTRY.register("aether_portal", () -> new AetherPortalBlock());
	public static final RegistryObject<Block> JEB_BLOCK = REGISTRY.register("jeb_block", () -> new JebBlockBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			PeemensionPortalBlock.registerRenderLayer();
			PotatusBlock.registerRenderLayer();
			WoodDimensionPortalBlock.registerRenderLayer();
			SusPortalBlock.registerRenderLayer();
			GreenPlantBlock.registerRenderLayer();
			TombstoneBlock.registerRenderLayer();
			YoutubeBlock.registerRenderLayer();
			PlanteBlock.registerRenderLayer();
			GraveBlock.registerRenderLayer();
			CioaoPortalBlock.registerRenderLayer();
			BrazilPortalBlock.registerRenderLayer();
			ComputerBlock.registerRenderLayer();
			AetherPortalBlock.registerRenderLayer();
		}
	}
}
