package xyz.aflkonstukt.purechaos.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.entity.Entity;

@Mixin(Minecraft.class)
public abstract class CustomTitleMixin {
	public CustomTitleMixin() {
	}
	
    @Inject(method = "updateTitle()V", at = @At("HEAD"), cancellable = true)
    private void updateTitle(final CallbackInfo info) {
        info.cancel();
        Minecraft.getInstance().getWindow().setTitle("Pure Chaos");
    }
}