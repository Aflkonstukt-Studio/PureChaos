package xyz.aflkonstukt.purechaos.mixins;

import com.mojang.blaze3d.platform.IconSet;
import net.minecraft.server.packs.resources.IoSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.aflkonstukt.purechaos.icon.IconStorage;

import java.io.InputStream;
import java.util.List;

@Mixin({IconSet.class})
public abstract class IconsMixin {
    public IconsMixin() {
    }

    @Inject(
            method = {"getStandardIcons"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void bringTheClassicCraftingTableIconBack_general(CallbackInfoReturnable<List<IoSupplier<InputStream>>> cir) {
        cir.setReturnValue(IconStorage.getAllPngResources());
    }
}
