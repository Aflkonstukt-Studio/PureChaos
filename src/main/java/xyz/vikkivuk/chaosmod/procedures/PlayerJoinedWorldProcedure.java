package xyz.vikkivuk.chaosmod.procedures;

import xyz.vikkivuk.chaosmod.network.ChaosmodModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerJoinedWorldProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinWorldEvent event) {
		execute(event, event.getWorld(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			ChaosmodModVariables.WorldVariables.get(world).sanity = 100;
			ChaosmodModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
