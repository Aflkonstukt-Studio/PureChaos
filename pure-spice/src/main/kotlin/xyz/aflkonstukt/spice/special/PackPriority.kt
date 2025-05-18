package xyz.aflkonstukt.spice.special

import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.packs.PackType
import net.minecraft.server.packs.repository.Pack
import net.minecraft.server.packs.repository.PackSource
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.AddPackFindersEvent
import xyz.aflkonstukt.purechaos.PurechaosMod
import xyz.aflkonstukt.spice.Spice

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Spice.ID)
object PackPriority {
    @SubscribeEvent
    fun addPackFinders(event: AddPackFindersEvent) {
        event.addPackFinders(
            ResourceLocation.fromNamespaceAndPath(Spice.ID, "pmo"),
            PackType.CLIENT_RESOURCES,
            Component.literal("PMOs"),
            PackSource.BUILT_IN,
            true,
            Pack.Position.TOP
        )
    }
}