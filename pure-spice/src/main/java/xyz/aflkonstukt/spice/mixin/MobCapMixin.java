package xyz.aflkonstukt.spice.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.NaturalSpawner;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

@Mixin(NaturalSpawner.SpawnState.class)
public abstract class MobCapMixin {
    @Final
    @Shadow
    private int spawnableChunkCount;
    @Final
    @Shadow
    private Object2IntOpenHashMap<MobCategory> mobCategoryCounts;

    @Inject(method = "canSpawnForCategory", at = @At("HEAD"), cancellable = true)
    private void canSpawnForCategory(MobCategory mobCategory, ChunkPos chunkPos, CallbackInfoReturnable<Boolean> cir) {
        int multiplier = (int) Math.floor(PurechaosModVariables.mob_cap_multiplier);
        int i = (mobCategory.getMaxInstancesPerChunk() * multiplier * this.spawnableChunkCount) / 300;
        if (this.mobCategoryCounts.getInt(mobCategory) >= i) {
            cir.setReturnValue(false);
        } else {
            cir.setReturnValue(true);
        }

        cir.cancel();
    }
}
