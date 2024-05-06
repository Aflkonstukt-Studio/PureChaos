package xyz.aflkonstukt.purechaos.mixins;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Inventory.class)
public abstract class InventoryMixin {
    /**
     * @author VikkiVuk
     * @reason ich will das so
     */
    @Overwrite
    public boolean stillValid(Player p_36009_) {
        if (p_36009_.isRemoved()) {
            return false;
        } else {
            return !(p_36009_.distanceToSqr(p_36009_) > 999.0);
        }
    }
}
