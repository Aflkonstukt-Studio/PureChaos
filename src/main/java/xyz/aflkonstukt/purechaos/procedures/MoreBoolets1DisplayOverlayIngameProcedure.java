package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MoreBoolets1DisplayOverlayIngameProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100) {
			for (int i = (int) 0; i <= (int) 40; i++) {
				final int currentI = i;
				PurechaosMod.queueServerWork((int) (2 * currentI), () -> {
					if (currentI == 40) {
						{
							PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
							_vars.boolets = 0;
							_vars.syncPlayerVariables(entity);
						}
					} else {
						{
							PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
							_vars.boolets = currentI;
							_vars.syncPlayerVariables(entity);
						}
					}
				});
			}
		}
	}
}
