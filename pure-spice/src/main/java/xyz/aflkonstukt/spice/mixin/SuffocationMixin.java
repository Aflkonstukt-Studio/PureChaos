package xyz.aflkonstukt.spice.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.procedures.SendToBackroomsProcedure;

@Mixin(Player.class)
public abstract class SuffocationMixin {
    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void hurt(DamageSource damagesource, float f, CallbackInfoReturnable<Boolean> cir) {
        if (damagesource.is(DamageTypes.IN_WALL) || damagesource.is(DamageTypes.CRAMMING) || damagesource.is(DamageTypes.FALLING_BLOCK) || damagesource.is(DamageTypes.FALLING_ANVIL) || damagesource.is(DamageTypes.FELL_OUT_OF_WORLD) || damagesource.is(DamageTypes.FIREWORKS) || damagesource.is(DamageTypes.FLY_INTO_WALL) || damagesource.is(DamageTypes.SONIC_BOOM)) {
            Entity entity = Player.class.cast(this);

            if (entity != null) {
                if (!entity.getData(PurechaosModVariables.PLAYER_VARIABLES).disable_backrooms) {
                    double x = entity.getX();
                    double z = entity.getZ();
                    SendToBackroomsProcedure.execute(x, z, entity);

                    entity.resetFallDistance();

                    cir.setReturnValue(false);
                    cir.cancel();
                }
            }
        }
    }
}
