package xyz.aflkonstukt.purechaos.mixins;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;

@Mixin(BucketItem.class)
public abstract class EatWaterBucketMixin {
    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void use(Level level, Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.getItem() instanceof BucketItem && ((BucketItem) itemStack.getItem()).getFluid().isSame(Fluids.WATER)) {
            ItemStack edibleWaterbucket = new ItemStack(PurechaosModItems.EDIBLE_WATER_BUCKET.get());
            player.setItemInHand(interactionHand, edibleWaterbucket);

            cir.setReturnValue(InteractionResultHolder.pass(edibleWaterbucket));
            cir.cancel();
        } else if (itemStack.getItem() instanceof BucketItem && ((BucketItem) itemStack.getItem()).getFluid().isSame(Fluids.EMPTY)) {
            BlockHitResult blockhitresult = pureChaos$getPlayerPOVHitResult(level, player);
            if (blockhitresult.getType() == BlockHitResult.Type.MISS) {
                cir.setReturnValue(InteractionResultHolder.pass(itemStack));
                cir.cancel();
            } else {
                BlockPos blockpos = blockhitresult.getBlockPos();
                Direction direction = blockhitresult.getDirection();
                BlockPos blockpos1 = blockpos.relative(direction);
                if (player.mayInteract(level, blockpos) && player.mayUseItemAt(blockpos1, direction, itemStack)) {
                    BlockState blockstate1 = level.getBlockState(blockpos);
                    Block $$10 = blockstate1.getBlock();
                    if ($$10 instanceof BucketPickup bucketpickup && blockstate1.getFluidState().is(FluidTags.WATER)) {
                        ItemStack itemstack2 = bucketpickup.pickupBlock(player, level, blockpos, blockstate1);
                        if (!itemstack2.isEmpty()) {
                            bucketpickup.getPickupSound(blockstate1).ifPresent(p_150709_ -> player.playSound(p_150709_, 1.0F, 1.0F));
                            level.gameEvent(player, GameEvent.FLUID_PICKUP, blockpos);

                            ItemStack itemstack1 = new ItemStack(PurechaosModItems.EDIBLE_WATER_BUCKET.get());
                            if (!level.isClientSide) {
                                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, itemstack2);
                            }

                            cir.setReturnValue(InteractionResultHolder.sidedSuccess(itemstack1, level.isClientSide()));
                            cir.cancel();
                        }
                    }
                }
            }
        }
    }

    @Unique
    private static BlockHitResult pureChaos$getPlayerPOVHitResult(Level p_41436_, Player p_41437_) {
        float f = p_41437_.getXRot();
        float f1 = p_41437_.getYRot();
        Vec3 vec3 = p_41437_.getEyePosition();
        float f2 = Mth.cos(-f1 * (float) (Math.PI / 180.0) - (float) Math.PI);
        float f3 = Mth.sin(-f1 * (float) (Math.PI / 180.0) - (float) Math.PI);
        float f4 = -Mth.cos(-f * (float) (Math.PI / 180.0));
        float f5 = Mth.sin(-f * (float) (Math.PI / 180.0));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = p_41437_.getBlockReach();
        if (!p_41437_.isCreative() && d0 != 0) d0 += 0.5D; // The vanilla constant here was 5.0, but the default survival block reach is 4.5. Creative default is already 5.0.
        Vec3 vec31 = vec3.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return p_41436_.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, p_41437_));
    }
}
