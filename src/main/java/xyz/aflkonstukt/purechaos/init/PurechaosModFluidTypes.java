
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.fluid.types.StaravodaFluidType;
import xyz.aflkonstukt.purechaos.fluid.types.RadiationLiquidFluidType;
import xyz.aflkonstukt.purechaos.fluid.types.PeeFluidType;
import xyz.aflkonstukt.purechaos.fluid.types.OrangeFluidFluidType;
import xyz.aflkonstukt.purechaos.fluid.types.OilFluidType;
import xyz.aflkonstukt.purechaos.fluid.types.Milk2FluidType;
import xyz.aflkonstukt.purechaos.fluid.types.GatoradeFluidType;
import xyz.aflkonstukt.purechaos.fluid.types.CumFluidType;
import xyz.aflkonstukt.purechaos.fluid.types.CobbleFluidFluidType;
import xyz.aflkonstukt.purechaos.fluid.types.CarbonMonoxideFluidType;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

public class PurechaosModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, PurechaosMod.MODID);
	public static final RegistryObject<FluidType> PEE_TYPE = REGISTRY.register("pee", () -> new PeeFluidType());
	public static final RegistryObject<FluidType> CUM_TYPE = REGISTRY.register("cum", () -> new CumFluidType());
	public static final RegistryObject<FluidType> STARAVODA_TYPE = REGISTRY.register("staravoda", () -> new StaravodaFluidType());
	public static final RegistryObject<FluidType> ORANGE_FLUID_TYPE = REGISTRY.register("orange_fluid", () -> new OrangeFluidFluidType());
	public static final RegistryObject<FluidType> OIL_TYPE = REGISTRY.register("oil", () -> new OilFluidType());
	public static final RegistryObject<FluidType> GATORADE_TYPE = REGISTRY.register("gatorade", () -> new GatoradeFluidType());
	public static final RegistryObject<FluidType> CARBON_MONOXIDE_TYPE = REGISTRY.register("carbon_monoxide", () -> new CarbonMonoxideFluidType());
	public static final RegistryObject<FluidType> MILK_2_TYPE = REGISTRY.register("milk_2", () -> new Milk2FluidType());
	public static final RegistryObject<FluidType> RADIATION_LIQUID_TYPE = REGISTRY.register("radiation_liquid", () -> new RadiationLiquidFluidType());
	public static final RegistryObject<FluidType> COBBLE_FLUID_TYPE = REGISTRY.register("cobble_fluid", () -> new CobbleFluidFluidType());
}
