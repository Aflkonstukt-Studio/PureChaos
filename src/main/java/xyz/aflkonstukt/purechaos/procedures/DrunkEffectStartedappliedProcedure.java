package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class DrunkEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.amount_of_alcohol_drank = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).amount_of_alcohol_drank + 1;
			_vars.syncPlayerVariables(entity);
		}
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).alcohol_addiction > 0) {
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.alcohol_addiction = 0;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).amount_of_alcohol_drank >= 8 && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).alcohol_addiction == -1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal("Oh no you are now an alcoholic! This means you are addicted to alcohol and will need to drink it every minecraft day (20 irl mins) or die.. (this persists across lives in this world!)"), false);
				{
					PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.alcohol_addiction = -2;
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
		} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).ada_peu >= 5) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("purechaos:alcohol_death")))), 9999);
		} else {
			PurechaosModVariables.invert_controls = true;
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.ada_peu = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).ada_peu + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
