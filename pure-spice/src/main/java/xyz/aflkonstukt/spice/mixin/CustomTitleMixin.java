package xyz.aflkonstukt.spice.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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