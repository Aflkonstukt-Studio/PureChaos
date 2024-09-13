package xyz.aflkonstukt.purechaos.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;

@Mixin(BottleItem.class)
public class BottleMixinMixin {
    public BottleMixinMixin() {
    }

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void use(Level p_40656_, Player p_40657_, InteractionHand p_40658_, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        // If the block is lava, the bottle in the player's hand will be replaced with a Lava Bottle
        BlockHitResult blockhitresult = pureChaos$getPlayerPOVHitResult(p_40656_, p_40657_, ClipContext.Fluid.SOURCE_ONLY);
        ItemStack itemstack = p_40657_.getItemInHand(p_40658_);

        if (blockhitresult.getType() != HitResult.Type.MISS) {
            if (blockhitresult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockpos = blockhitresult.getBlockPos();
                if (!p_40656_.mayInteract(p_40657_, blockpos)) {
                    cir.setReturnValue(InteractionResultHolder.fail(itemstack));
                    cir.cancel();
                }

                if (p_40656_.getFluidState(blockpos).is(FluidTags.LAVA)) {
                    p_40656_.playSound(p_40657_, p_40657_.getX(), p_40657_.getY(), p_40657_.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                    p_40656_.gameEvent(p_40657_, GameEvent.FLUID_PICKUP, blockpos);

                    ItemStack lavaBottle = new ItemStack(PurechaosModItems.LAVA_BOTTLE.get());

                    cir.setReturnValue(InteractionResultHolder.sidedSuccess(pureChaos$createFilledResult(itemstack, p_40657_, lavaBottle, false), p_40656_.isClientSide()));
                    cir.cancel();
                }
            }
        } else {
            if (p_40657_.isShiftKeyDown()) {
                ItemStack pissBottle = new ItemStack(PurechaosModItems.BOTTLE_OF_PISS.get());
                cir.setReturnValue(InteractionResultHolder.sidedSuccess(pureChaos$createFilledResult(itemstack, p_40657_, pissBottle, false), p_40656_.isClientSide()));
                cir.cancel();
            }
        }

        // If the block is not lava or not holding shift, the original method will be called
    }

    @Unique
    private static BlockHitResult pureChaos$getPlayerPOVHitResult(Level p_41436_, Player p_41437_, ClipContext.Fluid p_41438_) {
        Vec3 vec3 = p_41437_.getEyePosition();
        Vec3 vec31 = vec3.add(p_41437_.calculateViewVector(p_41437_.getXRot(), p_41437_.getYRot()).scale(p_41437_.blockInteractionRange()));
        return p_41436_.clip(new ClipContext(vec3, vec31, net.minecraft.world.level.ClipContext.Block.OUTLINE, p_41438_, p_41437_));
    }

    @Unique
    private static ItemStack pureChaos$createFilledResult(ItemStack p_41818_, Player p_41819_, ItemStack p_41820_, boolean p_41821_) {
        boolean flag = p_41819_.getAbilities().instabuild;
        if (p_41821_ && flag) {
            if (!p_41819_.getInventory().contains(p_41820_)) {
                p_41819_.getInventory().add(p_41820_);
            }

            return p_41818_;
        } else {
            if (!flag) {
                p_41818_.shrink(1);
            }

            if (p_41818_.isEmpty()) {
                return p_41820_;
            } else {
                if (!p_41819_.getInventory().add(p_41820_)) {
                    p_41819_.drop(p_41820_, false);
                }

                return p_41818_;
            }
        }
    }
}
