package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class MethPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.amount_of_meth_used = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).amount_of_meth_used + 1;
			_vars.syncPlayerVariables(entity);
		}
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).meth_addiction > 0) {
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.meth_addiction = 0;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).amount_of_meth_used >= 4 && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).meth_addiction == -1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"You are now addicted to meth! You will need to take it every minecraft day (20 irl mins) or you will die!! Oh also, this will persist across all your lives in this world so.. (the addiction is paused in creative and spectator!)"),
							false);
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.meth_addiction = -2;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).last_depression == -1) {
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.last_depression = 0;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).mua_peu >= 3) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("purechaos:overdose")))), 9999);
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PurechaosModMobEffects.HIGH_EFFECT, 1200, 1, false, true));
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.mua_peu = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).mua_peu + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
