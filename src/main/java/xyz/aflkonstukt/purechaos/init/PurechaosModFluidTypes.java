
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
import xyz.aflkonstukt.purechaos.fluid.types.CokowadaFluidType;
import xyz.aflkonstukt.purechaos.fluid.types.CobbleFluidFluidType;
import xyz.aflkonstukt.purechaos.fluid.types.CarbonMonoxideFluidType;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

public class PurechaosModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, PurechaosMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> PEE_TYPE = REGISTRY.register("pee", () -> new PeeFluidType());
	public static final DeferredHolder<FluidType, FluidType> CUM_TYPE = REGISTRY.register("cum", () -> new CumFluidType());
	public static final DeferredHolder<FluidType, FluidType> STARAVODA_TYPE = REGISTRY.register("staravoda", () -> new StaravodaFluidType());
	public static final DeferredHolder<FluidType, FluidType> ORANGE_FLUID_TYPE = REGISTRY.register("orange_fluid", () -> new OrangeFluidFluidType());
	public static final DeferredHolder<FluidType, FluidType> OIL_TYPE = REGISTRY.register("oil", () -> new OilFluidType());
	public static final DeferredHolder<FluidType, FluidType> GATORADE_TYPE = REGISTRY.register("gatorade", () -> new GatoradeFluidType());
	public static final DeferredHolder<FluidType, FluidType> CARBON_MONOXIDE_TYPE = REGISTRY.register("carbon_monoxide", () -> new CarbonMonoxideFluidType());
	public static final DeferredHolder<FluidType, FluidType> MILK_2_TYPE = REGISTRY.register("milk_2", () -> new Milk2FluidType());
	public static final DeferredHolder<FluidType, FluidType> RADIATION_LIQUID_TYPE = REGISTRY.register("radiation_liquid", () -> new RadiationLiquidFluidType());
	public static final DeferredHolder<FluidType, FluidType> COBBLE_FLUID_TYPE = REGISTRY.register("cobble_fluid", () -> new CobbleFluidFluidType());
	public static final DeferredHolder<FluidType, FluidType> COKOWADA_TYPE = REGISTRY.register("cokowada", () -> new CokowadaFluidType());
}
