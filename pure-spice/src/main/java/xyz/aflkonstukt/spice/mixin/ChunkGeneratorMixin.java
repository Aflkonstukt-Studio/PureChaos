package xyz.aflkonstukt.spice.mixin;

import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(NoiseBasedChunkGenerator.class)
public abstract class ChunkGeneratorMixin {
    @Unique
    private static final double VOID_CHUNK_PROBABILITY = 0.05; // 5% chance for a void chunk
    @Unique
    private final Random pureChaos$random = new Random();

    @Inject(method = "doFill", at = @At("HEAD"), cancellable = true)
    private void doFill(Blender p_224285_, StructureManager p_224286_, RandomState p_224287_, ChunkAccess p_224288_, int p_224289_, int p_224290_, CallbackInfoReturnable<ChunkAccess> cir) {
        if (pureChaos$random.nextDouble() < VOID_CHUNK_PROBABILITY) {
            cir.setReturnValue(p_224288_);
            cir.cancel();
        }
    }
}
