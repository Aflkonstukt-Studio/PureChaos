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
        if (itemStack.getItem() instanceof BucketItem && ((BucketItem) itemStack.getItem()).content.isSame(Fluids.WATER)) {
            ItemStack edibleWaterbucket = new ItemStack(PurechaosModItems.EDIBLE_WATER_BUCKET.get());
            player.setItemInHand(interactionHand, edibleWaterbucket);

            cir.setReturnValue(InteractionResultHolder.pass(edibleWaterbucket));
            cir.cancel();
        } else if (itemStack.getItem() instanceof BucketItem && ((BucketItem) itemStack.getItem()).content.isSame(Fluids.EMPTY)) {
            BlockHitResult blockhitresult = pureChaos$getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
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
    private static BlockHitResult pureChaos$getPlayerPOVHitResult(Level p_41436_, Player p_41437_, ClipContext.Fluid p_41438_) {
        Vec3 vec3 = p_41437_.getEyePosition();
        Vec3 vec31 = vec3.add(p_41437_.calculateViewVector(p_41437_.getXRot(), p_41437_.getYRot()).scale(p_41437_.blockInteractionRange()));
        return p_41436_.clip(new ClipContext(vec3, vec31, net.minecraft.world.level.ClipContext.Block.OUTLINE, p_41438_, p_41437_));
    }
}
