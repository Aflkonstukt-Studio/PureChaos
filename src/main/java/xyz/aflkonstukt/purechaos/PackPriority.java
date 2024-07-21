package xyz.aflkonstukt.purechaos;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@Mod(PurechaosMod.MODID)
public class PackPriority {
    public PackPriority(IEventBus modEventBus) {
        modEventBus.register(this);
    }

    @SubscribeEvent
    public void addPackFinders(AddPackFindersEvent event) {
        event.addPackFinders(new ResourceLocation(PurechaosMod.MODID, "pmo"), PackType.CLIENT_RESOURCES, Component.literal("PMOs"), PackSource.BUILT_IN, true, Pack.Position.TOP);
    }
}
