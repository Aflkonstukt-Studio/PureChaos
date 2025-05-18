package xyz.aflkonstukt.purechaos.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class EventHandlerProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (5 <= Mth.nextInt(RandomSource.create(), 1, 2000)) {
			if (5 <= Mth.nextInt(RandomSource.create(), 1, 20000)) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (4 * world.players().size() == Mth.nextInt(RandomSource.create(), 1, (int) (world.players().size() * 10))) {
						SummonMeteorProcedure.execute(world, entityiterator.getX(), entityiterator.getZ(), entityiterator, false, true, Mth.nextInt(RandomSource.create(), 10, 70), 3600);
					}
				}
			} else if (5 <= Mth.nextInt(RandomSource.create(), 1, 40000)) {
				if (5 <= Mth.nextInt(RandomSource.create(), 1, 50)) {
					if (5 <= Mth.nextInt(RandomSource.create(), 1, 50)) {
						for (Entity entityiterator : new ArrayList<>(world.players())) {
							StartCommunismEventProcedure.execute(world, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), entityiterator);
						}
					}
				}
			} else if (5 <= Mth.nextInt(RandomSource.create(), 1, 10000)) {
				if (5 <= Mth.nextInt(RandomSource.create(), 1, 50)) {
					if (15 <= Mth.nextInt(RandomSource.create(), 1, 50)) {
						for (Entity entityiterator : new ArrayList<>(world.players())) {
							StartConstipationProcedure.execute(entityiterator);
						}
					}
				}
			}
		}
	}
}
