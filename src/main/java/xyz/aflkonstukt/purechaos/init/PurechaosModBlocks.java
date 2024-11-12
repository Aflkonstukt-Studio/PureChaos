
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.block.YoutubeBlock;
import xyz.aflkonstukt.purechaos.block.WoodDimensionPortalBlock;
import xyz.aflkonstukt.purechaos.block.WhiteBlock;
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
import xyz.aflkonstukt.purechaos.block.PuffsBlockBlock;
import xyz.aflkonstukt.purechaos.block.PotatusBlock;
import xyz.aflkonstukt.purechaos.block.PolandBlockBlock;
import xyz.aflkonstukt.purechaos.block.PlanteBlock;
import xyz.aflkonstukt.purechaos.block.PeemensionPortalBlock;
import xyz.aflkonstukt.purechaos.block.PeeBlockBlock;
import xyz.aflkonstukt.purechaos.block.PeeBlock;
import xyz.aflkonstukt.purechaos.block.OrangeFluidBlock;
import xyz.aflkonstukt.purechaos.block.OilBlock;
import xyz.aflkonstukt.purechaos.block.NokiaBlockBlock;
import xyz.aflkonstukt.purechaos.block.MoyaiBlock;
import xyz.aflkonstukt.purechaos.block.MissingTextureBlock;
import xyz.aflkonstukt.purechaos.block.Milk2Block;
import xyz.aflkonstukt.purechaos.block.JebBlockBlock;
import xyz.aflkonstukt.purechaos.block.InternetExplorerBlock;
import xyz.aflkonstukt.purechaos.block.GreengiscreendaBlock;
import xyz.aflkonstukt.purechaos.block.GreenPlantBlock;
import xyz.aflkonstukt.purechaos.block.GraveBlock;
import xyz.aflkonstukt.purechaos.block.GatoradeBlock;
import xyz.aflkonstukt.purechaos.block.EmepeeBlock;
import xyz.aflkonstukt.purechaos.block.DiscordBlock;
import xyz.aflkonstukt.purechaos.block.DepressionBlockBlock;
import xyz.aflkonstukt.purechaos.block.DeathBlock;
import xyz.aflkonstukt.purechaos.block.CyberBlockBlock;
import xyz.aflkonstukt.purechaos.block.CumBlock;
import xyz.aflkonstukt.purechaos.block.ComunisamBlockBlock;
import xyz.aflkonstukt.purechaos.block.ComputerBlock;
import xyz.aflkonstukt.purechaos.block.CokowadaBlock;
import xyz.aflkonstukt.purechaos.block.CobbleFluidBlock;
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
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

public class PurechaosModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(PurechaosMod.MODID);
	public static final DeferredBlock<Block> PEE = REGISTRY.register("pee", PeeBlock::new);
	public static final DeferredBlock<Block> PEEMENSION_PORTAL = REGISTRY.register("peemension_portal", PeemensionPortalBlock::new);
	public static final DeferredBlock<Block> PEE_BLOCK = REGISTRY.register("pee_block", PeeBlockBlock::new);
	public static final DeferredBlock<Block> POTATUS = REGISTRY.register("potatus", PotatusBlock::new);
	public static final DeferredBlock<Block> WOOD_DIMENSION_PORTAL = REGISTRY.register("wood_dimension_portal", WoodDimensionPortalBlock::new);
	public static final DeferredBlock<Block> DEATH = REGISTRY.register("death", DeathBlock::new);
	public static final DeferredBlock<Block> SA_DS = REGISTRY.register("sa_ds", SADsBlock::new);
	public static final DeferredBlock<Block> EMEPEE = REGISTRY.register("emepee", EmepeeBlock::new);
	public static final DeferredBlock<Block> SUS_BLOCK = REGISTRY.register("sus_block", SusBlockBlock::new);
	public static final DeferredBlock<Block> CUM = REGISTRY.register("cum", CumBlock::new);
	public static final DeferredBlock<Block> SUS_PORTAL = REGISTRY.register("sus_portal", SusPortalBlock::new);
	public static final DeferredBlock<Block> STARAVODA = REGISTRY.register("staravoda", StaravodaBlock::new);
	public static final DeferredBlock<Block> TLGHD = REGISTRY.register("tlghd", TLGHDBlock::new);
	public static final DeferredBlock<Block> ORANGE_FLUID = REGISTRY.register("orange_fluid", OrangeFluidBlock::new);
	public static final DeferredBlock<Block> OIL = REGISTRY.register("oil", OilBlock::new);
	public static final DeferredBlock<Block> GATORADE = REGISTRY.register("gatorade", GatoradeBlock::new);
	public static final DeferredBlock<Block> GREEN_PLANT = REGISTRY.register("green_plant", GreenPlantBlock::new);
	public static final DeferredBlock<Block> CARBON_MONOXIDE = REGISTRY.register("carbon_monoxide", CarbonMonoxideBlock::new);
	public static final DeferredBlock<Block> YOUTUBE = REGISTRY.register("youtube", YoutubeBlock::new);
	public static final DeferredBlock<Block> PLANTE = REGISTRY.register("plante", PlanteBlock::new);
	public static final DeferredBlock<Block> RICKROLL_BLOCK = REGISTRY.register("rickroll_block", RickrollBlockBlock::new);
	public static final DeferredBlock<Block> GRAVE = REGISTRY.register("grave", GraveBlock::new);
	public static final DeferredBlock<Block> MILK_2 = REGISTRY.register("milk_2", Milk2Block::new);
	public static final DeferredBlock<Block> BACKROOMS_LVL_1LIGHT = REGISTRY.register("backrooms_lvl_1light", BackroomsLvl1lightBlock::new);
	public static final DeferredBlock<Block> BACKROOMS_LVL_1_WALL = REGISTRY.register("backrooms_lvl_1_wall", BackroomsLvl1WallBlock::new);
	public static final DeferredBlock<Block> RADIATION_LIQUID = REGISTRY.register("radiation_liquid", RadiationLiquidBlock::new);
	public static final DeferredBlock<Block> BRAZIL_BLOCK = REGISTRY.register("brazil_block", BrazilBlockBlock::new);
	public static final DeferredBlock<Block> NOKIA_BLOCK = REGISTRY.register("nokia_block", NokiaBlockBlock::new);
	public static final DeferredBlock<Block> BRAZIL_PORTAL = REGISTRY.register("brazil_portal", BrazilPortalBlock::new);
	public static final DeferredBlock<Block> BACKROOMS_LVL_1_FLOOR = REGISTRY.register("backrooms_lvl_1_floor", BackroomsLvl1FloorBlock::new);
	public static final DeferredBlock<Block> SOUTH = REGISTRY.register("south", SouthBlock::new);
	public static final DeferredBlock<Block> DEPRESSION_BLOCK = REGISTRY.register("depression_block", DepressionBlockBlock::new);
	public static final DeferredBlock<Block> COMUNISAM_BLOCK = REGISTRY.register("comunisam_block", ComunisamBlockBlock::new);
	public static final DeferredBlock<Block> POLAND_BLOCK = REGISTRY.register("poland_block", PolandBlockBlock::new);
	public static final DeferredBlock<Block> CYBER_BLOCK = REGISTRY.register("cyber_block", CyberBlockBlock::new);
	public static final DeferredBlock<Block> COMPUTER = REGISTRY.register("computer", ComputerBlock::new);
	public static final DeferredBlock<Block> GREENGISCREENDA = REGISTRY.register("greengiscreenda", GreengiscreendaBlock::new);
	public static final DeferredBlock<Block> COBBLE_FLUID = REGISTRY.register("cobble_fluid", CobbleFluidBlock::new);
	public static final DeferredBlock<Block> ADIDAS_BLOCK = REGISTRY.register("adidas_block", AdidasBlockBlock::new);
	public static final DeferredBlock<Block> MISSING_TEXTURE = REGISTRY.register("missing_texture", MissingTextureBlock::new);
	public static final DeferredBlock<Block> AETHER_PORTAL = REGISTRY.register("aether_portal", AetherPortalBlock::new);
	public static final DeferredBlock<Block> JEB_BLOCK = REGISTRY.register("jeb_block", JebBlockBlock::new);
	public static final DeferredBlock<Block> BACKROOM_WALL_BOTTOM = REGISTRY.register("backroom_wall_bottom", BackroomWallBottomBlock::new);
	public static final DeferredBlock<Block> BACKROOMS_CEILING = REGISTRY.register("backrooms_ceiling", BackroomsCeilingBlock::new);
	public static final DeferredBlock<Block> RAINBOWRACK = REGISTRY.register("rainbowrack", RainbowrackBlock::new);
	public static final DeferredBlock<Block> RAINBOW_GRASS = REGISTRY.register("rainbow_grass", RainbowGrassBlock::new);
	public static final DeferredBlock<Block> INTERNET_EXPLORER = REGISTRY.register("internet_explorer", InternetExplorerBlock::new);
	public static final DeferredBlock<Block> DISCORD = REGISTRY.register("discord", DiscordBlock::new);
	public static final DeferredBlock<Block> WHITE = REGISTRY.register("white", WhiteBlock::new);
	public static final DeferredBlock<Block> MOYAI = REGISTRY.register("moyai", MoyaiBlock::new);
	public static final DeferredBlock<Block> COKOWADA = REGISTRY.register("cokowada", CokowadaBlock::new);
	public static final DeferredBlock<Block> PUFFS_BLOCK = REGISTRY.register("puffs_block", PuffsBlockBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
