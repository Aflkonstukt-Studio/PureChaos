package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class HighEffectEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 280, 1, false, true));
		PurechaosMod.queueServerWork(280, () -> {
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.mua_peu = 0;
				_vars.syncPlayerVariables(entity);
			}
		});
	}
}
