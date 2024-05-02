package xyz.aflkonstukt.purechaos.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
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
        }

        // If the block is not lava, the original method will be called
    }

    @Unique
    private static BlockHitResult pureChaos$getPlayerPOVHitResult(Level p_41436_, Player p_41437_, ClipContext.Fluid p_41438_) {
        float f = p_41437_.getXRot();
        float f1 = p_41437_.getYRot();
        Vec3 vec3 = p_41437_.getEyePosition();
        float f2 = Mth.cos(-f1 * 0.017453292F - 3.1415927F);
        float f3 = Mth.sin(-f1 * 0.017453292F - 3.1415927F);
        float f4 = -Mth.cos(-f * 0.017453292F);
        float f5 = Mth.sin(-f * 0.017453292F);
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = p_41437_.getBlockReach();
        Vec3 vec31 = vec3.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
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
