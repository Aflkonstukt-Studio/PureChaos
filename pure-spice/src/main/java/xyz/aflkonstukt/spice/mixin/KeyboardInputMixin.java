package xyz.aflkonstukt.spice.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

@Mixin(KeyboardInput.class)
public abstract class KeyboardInputMixin extends Input {
    private final Options options;
    public KeyboardInputMixin(Options p_108580_) {
        this.options = p_108580_;
    }

    @Unique
    private static float pureChaos$calculateImpulse(boolean p_205578_, boolean p_205579_) {
        if (p_205578_ == p_205579_) {
            return 0.0F;
        } else {
            return p_205578_ ? 1.0F : -1.0F;
        }
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void tick(boolean p_234118_, float p_234119_, CallbackInfo ci) {
        Entity player = Minecraft.getInstance().player;
        if (player == null)
            return;

        if (player.getData(PurechaosModVariables.PLAYER_VARIABLES).invert_controls) {
            this.up = this.options.keyDown.isDown();
            this.down = this.options.keyUp.isDown();
            this.left = this.options.keyRight.isDown();
            this.right = this.options.keyLeft.isDown();
        } else {
            this.up = this.options.keyUp.isDown();
            this.down = this.options.keyDown.isDown();
            this.left = this.options.keyLeft.isDown();
            this.right = this.options.keyRight.isDown();
        }

        this.forwardImpulse = pureChaos$calculateImpulse(this.up, this.down);
        this.leftImpulse = pureChaos$calculateImpulse(this.left, this.right);
        this.jumping = this.options.keyJump.isDown();
        this.shiftKeyDown = this.options.keyShift.isDown();
        if (p_234118_) {
            this.leftImpulse *= p_234119_;
            this.forwardImpulse *= p_234119_;
        }

        ci.cancel();
    }
}
