
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.block.YoutubeBlock;
import xyz.aflkonstukt.purechaos.block.WoodDimensionPortalBlock;
import xyz.aflkonstukt.purechaos.block.TLGHDBlock;
import xyz.aflkonstukt.purechaos.block.SusPortalBlock;
import xyz.aflkonstukt.purechaos.block.SusBlockBlock;
import xyz.aflkonstukt.purechaos.block.StaravodaBlock;
import xyz.aflkonstukt.purechaos.block.SouthBlock;
import xyz.aflkonstukt.purechaos.block.SADsBlock;
import xyz.aflkonstukt.purechaos.block.RickrollBlockBlock;
import xyz.aflkonstukt.purechaos.block.RainbowrackBlock;
import xyz.aflkonstukt.purechaos.block.RainbowGrassBlock;
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
import xyz.aflkonstukt.purechaos.block.BackroomsCeilingBlock;
import xyz.aflkonstukt.purechaos.block.BackroomWallBottomBlock;
import xyz.aflkonstukt.purechaos.block.AetherPortalBlock;
import xyz.aflkonstukt.purechaos.block.AdidasBlockBlock;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

public class PurechaosModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK, PurechaosMod.MODID);
	public static final DeferredHolder<Block, Block> PEE = REGISTRY.register("pee", () -> new PeeBlock());
	public static final DeferredHolder<Block, Block> PEEMENSION_PORTAL = REGISTRY.register("peemension_portal", () -> new PeemensionPortalBlock());
	public static final DeferredHolder<Block, Block> PEE_BLOCK = REGISTRY.register("pee_block", () -> new PeeBlockBlock());
	public static final DeferredHolder<Block, Block> POTATUS = REGISTRY.register("potatus", () -> new PotatusBlock());
	public static final DeferredHolder<Block, Block> WOOD_DIMENSION_PORTAL = REGISTRY.register("wood_dimension_portal", () -> new WoodDimensionPortalBlock());
	public static final DeferredHolder<Block, Block> DEATH = REGISTRY.register("death", () -> new DeathBlock());
	public static final DeferredHolder<Block, Block> SA_DS = REGISTRY.register("sa_ds", () -> new SADsBlock());
	public static final DeferredHolder<Block, Block> EMEPEE = REGISTRY.register("emepee", () -> new EmepeeBlock());
	public static final DeferredHolder<Block, Block> SUS_BLOCK = REGISTRY.register("sus_block", () -> new SusBlockBlock());
	public static final DeferredHolder<Block, Block> CUM = REGISTRY.register("cum", () -> new CumBlock());
	public static final DeferredHolder<Block, Block> SUS_PORTAL = REGISTRY.register("sus_portal", () -> new SusPortalBlock());
	public static final DeferredHolder<Block, Block> STARAVODA = REGISTRY.register("staravoda", () -> new StaravodaBlock());
	public static final DeferredHolder<Block, Block> TLGHD = REGISTRY.register("tlghd", () -> new TLGHDBlock());
	public static final DeferredHolder<Block, Block> ORANGE_FLUID = REGISTRY.register("orange_fluid", () -> new OrangeFluidBlock());
	public static final DeferredHolder<Block, Block> OIL = REGISTRY.register("oil", () -> new OilBlock());
	public static final DeferredHolder<Block, Block> GATORADE = REGISTRY.register("gatorade", () -> new GatoradeBlock());
	public static final DeferredHolder<Block, Block> GREEN_PLANT = REGISTRY.register("green_plant", () -> new GreenPlantBlock());
	public static final DeferredHolder<Block, Block> CARBON_MONOXIDE = REGISTRY.register("carbon_monoxide", () -> new CarbonMonoxideBlock());
	public static final DeferredHolder<Block, Block> YOUTUBE = REGISTRY.register("youtube", () -> new YoutubeBlock());
	public static final DeferredHolder<Block, Block> PLANTE = REGISTRY.register("plante", () -> new PlanteBlock());
	public static final DeferredHolder<Block, Block> RICKROLL_BLOCK = REGISTRY.register("rickroll_block", () -> new RickrollBlockBlock());
	public static final DeferredHolder<Block, Block> GRAVE = REGISTRY.register("grave", () -> new GraveBlock());
	public static final DeferredHolder<Block, Block> MILK_2 = REGISTRY.register("milk_2", () -> new Milk2Block());
	public static final DeferredHolder<Block, Block> BACKROOMS_LVL_1LIGHT = REGISTRY.register("backrooms_lvl_1light", () -> new BackroomsLvl1lightBlock());
	public static final DeferredHolder<Block, Block> BACKROOMS_LVL_1_WALL = REGISTRY.register("backrooms_lvl_1_wall", () -> new BackroomsLvl1WallBlock());
	public static final DeferredHolder<Block, Block> RADIATION_LIQUID = REGISTRY.register("radiation_liquid", () -> new RadiationLiquidBlock());
	public static final DeferredHolder<Block, Block> BRAZIL_BLOCK = REGISTRY.register("brazil_block", () -> new BrazilBlockBlock());
	public static final DeferredHolder<Block, Block> NOKIA_BLOCK = REGISTRY.register("nokia_block", () -> new NokiaBlockBlock());
	public static final DeferredHolder<Block, Block> BRAZIL_PORTAL = REGISTRY.register("brazil_portal", () -> new BrazilPortalBlock());
	public static final DeferredHolder<Block, Block> BACKROOMS_LVL_1_FLOOR = REGISTRY.register("backrooms_lvl_1_floor", () -> new BackroomsLvl1FloorBlock());
	public static final DeferredHolder<Block, Block> SOUTH = REGISTRY.register("south", () -> new SouthBlock());
	public static final DeferredHolder<Block, Block> DEPRESSION_BLOCK = REGISTRY.register("depression_block", () -> new DepressionBlockBlock());
	public static final DeferredHolder<Block, Block> COMUNISAM_BLOCK = REGISTRY.register("comunisam_block", () -> new ComunisamBlockBlock());
	public static final DeferredHolder<Block, Block> POLAND_BLOCK = REGISTRY.register("poland_block", () -> new PolandBlockBlock());
	public static final DeferredHolder<Block, Block> CYBER_BLOCK = REGISTRY.register("cyber_block", () -> new CyberBlockBlock());
	public static final DeferredHolder<Block, Block> COMPUTER = REGISTRY.register("computer", () -> new ComputerBlock());
	public static final DeferredHolder<Block, Block> CIOAO_PORTAL = REGISTRY.register("cioao_portal", () -> new CioaoPortalBlock());
	public static final DeferredHolder<Block, Block> GREENGISCREENDA = REGISTRY.register("greengiscreenda", () -> new GreengiscreendaBlock());
	public static final DeferredHolder<Block, Block> COBBLE_FLUID = REGISTRY.register("cobble_fluid", () -> new CobbleFluidBlock());
	public static final DeferredHolder<Block, Block> ADIDAS_BLOCK = REGISTRY.register("adidas_block", () -> new AdidasBlockBlock());
	public static final DeferredHolder<Block, Block> MISSING_TEXTURE = REGISTRY.register("missing_texture", () -> new MissingTextureBlock());
	public static final DeferredHolder<Block, Block> AETHER_PORTAL = REGISTRY.register("aether_portal", () -> new AetherPortalBlock());
	public static final DeferredHolder<Block, Block> JEB_BLOCK = REGISTRY.register("jeb_block", () -> new JebBlockBlock());
	public static final DeferredHolder<Block, Block> BACKROOM_WALL_BOTTOM = REGISTRY.register("backroom_wall_bottom", () -> new BackroomWallBottomBlock());
	public static final DeferredHolder<Block, Block> BACKROOMS_CEILING = REGISTRY.register("backrooms_ceiling", () -> new BackroomsCeilingBlock());
	public static final DeferredHolder<Block, Block> RAINBOWRACK = REGISTRY.register("rainbowrack", () -> new RainbowrackBlock());
	public static final DeferredHolder<Block, Block> RAINBOW_GRASS = REGISTRY.register("rainbow_grass", () -> new RainbowGrassBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
