package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class JudgmentDayHandlerProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (PurechaosModVariables.WorldVariables.get(world).judgment_day >= 1) {
			PurechaosModVariables.WorldVariables.get(world).judgment_day = PurechaosModVariables.WorldVariables.get(world).judgment_day + 1;
			PurechaosModVariables.WorldVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level)
				_level.setDayTime((int) (world.dayTime() + PurechaosModVariables.WorldVariables.get(world).judgment_day / 20));
			if (Mth.nextInt(RandomSource.create(), 1, (int) (2000 - PurechaosModVariables.WorldVariables.get(world).judgment_day / 20)) < 2) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (Mth.nextInt(RandomSource.create(), 1, world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) == Mth.nextInt(RandomSource.create(),
							1, world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount())) {
						SummonMeteorProcedure.execute(world, entityiterator.getX(), entityiterator.getZ(), entityiterator, true, true, Mth.nextInt(RandomSource.create(), (int) (PurechaosModVariables.WorldVariables.get(world).judgment_day / 200), 60),
								30);
					}
				}
			}
			if (PurechaosModVariables.WorldVariables.get(world).judgment_day > 200 && PurechaosModVariables.WorldVariables.get(world).judgment_day < 1200) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
				}
			}
		}
	}
}
