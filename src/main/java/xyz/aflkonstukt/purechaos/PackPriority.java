package xyz.aflkonstukt.purechaos;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@Mod.EventBusSubscriber(modid = PurechaosMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PackPriority {
    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var resourcePath = ModList.get().getModFileById(PurechaosMod.MODID).getFile().findResource("pmo");
            var pack = Pack.readMetaAndCreate("builtin/pmo", Component.literal("PMOs"), true,
                    BuiltInPackSource.fromName((path) -> new PathPackResources(path, resourcePath, true)), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
            event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
        }
    }
}
