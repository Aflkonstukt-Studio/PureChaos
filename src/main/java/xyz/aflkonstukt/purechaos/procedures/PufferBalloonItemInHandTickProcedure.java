package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;

public class PufferBalloonItemInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		{
			ItemStack _ist = itemstack;
			_ist.hurtAndBreak(1, RandomSource.create(), null, () -> {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			});
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 3, 1, false, false));
	}
}
