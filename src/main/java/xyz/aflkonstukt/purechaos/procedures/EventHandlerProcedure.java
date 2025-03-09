package xyz.aflkonstukt.purechaos.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

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
			if (5 <= Mth.nextInt(RandomSource.create(), 1, 2000)) {
				if (world instanceof ServerLevel) {
					for (Entity entityiterator : ((ServerLevel) world).getAllEntities()) {
						if (entityiterator == null)
							continue;
						SummonMeteorProcedure.execute(world, entityiterator.getX(), entityiterator.getZ(), entityiterator, false, true, Mth.nextInt(RandomSource.create(), 10, 70), 3600);
					}
				}
			} else if (5 <= Mth.nextInt(RandomSource.create(), 1, 2000)) {
				if (5 <= Mth.nextInt(RandomSource.create(), 1, 50)) {
					if (world instanceof ServerLevel) {
						for (Entity entityiterator : ((ServerLevel) world).getAllEntities()) {
							if (entityiterator == null)
								continue;
							StartCommunismEventProcedure.execute(world, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), entityiterator);
						}
					}
				}
			} else if (5 <= Mth.nextInt(RandomSource.create(), 1, 2000)) {
				if (5 <= Mth.nextInt(RandomSource.create(), 1, 50)) {
					if (world instanceof ServerLevel) {
						for (Entity entityiterator : ((ServerLevel) world).getAllEntities()) {
							if (entityiterator == null)
								continue;
							StartConstipationProcedure.execute(entityiterator);
						}
					}
				}
			}
		}
	}
}
