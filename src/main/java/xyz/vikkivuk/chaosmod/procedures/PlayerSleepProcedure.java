package xyz.vikkivuk.chaosmod.procedures;

import xyz.vikkivuk.chaosmod.network.ChaosmodModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerSleepProcedure {
	@SubscribeEvent
	public static void onEntityEndSleep(PlayerWakeUpEvent event) {
		execute(event, event.getEntity().level, event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ChaosmodModVariables.WorldVariables.get(world).sanity = 100;
		ChaosmodModVariables.WorldVariables.get(world).syncData(world);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Rise and shine! Its a new day and your sanity has been restored to a 100."), (false));
	}
}
