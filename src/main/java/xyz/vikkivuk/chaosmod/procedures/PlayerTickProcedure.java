package xyz.vikkivuk.chaosmod.procedures;

import xyz.vikkivuk.chaosmod.network.ChaosmodModVariables;
import xyz.vikkivuk.chaosmod.init.ChaosmodModMobEffects;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class PlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (ChaosmodModVariables.WorldVariables.get(world).sanity <= 50) {
			if (Mth.nextDouble(new Random(), 1, 6000) <= 5) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(ChaosmodModMobEffects.DEMENTIA.get(), 600, 1, (true), (true)));
			}
		}
		if (ChaosmodModVariables.WorldVariables.get(world).sanity <= 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("sanity").bypassArmor(), 99999);
		} else {
			if (Mth.nextDouble(new Random(), 1, 6000) <= 5) {
				if (Mth.nextDouble(new Random(), 1, 7) <= 2) {
					if (!(ChaosmodModVariables.WorldVariables.get(world).sanity >= 80)) {
						ChaosmodModVariables.WorldVariables.get(world).sanity = ChaosmodModVariables.WorldVariables.get(world).sanity + Mth.nextDouble(new Random(), 1, 3);
						ChaosmodModVariables.WorldVariables.get(world).syncData(world);
					}
				} else {
					ChaosmodModVariables.WorldVariables.get(world).sanity = ChaosmodModVariables.WorldVariables.get(world).sanity - Mth.nextDouble(new Random(), 1, 4);
					ChaosmodModVariables.WorldVariables.get(world).syncData(world);
				}
			}
		}
	}
}
