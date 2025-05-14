package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModGameRules;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GolpProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() <= 0.1) {
			if (!world.getLevelData().getGameRules().getBoolean(PurechaosModGameRules.DISABLE_CAPTCHA)) {
				HandleNewCaptchaProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
