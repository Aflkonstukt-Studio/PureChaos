
package xyz.aflkonstukt.purechaos.command;

import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.aflkonstukt.purechaos.MeteorHandler;

@Mod.EventBusSubscriber
public class MeteorCommandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("meteor").requires(s -> s.hasPermission(4)).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			assert entity != null;
			MeteorHandler.ManualSpawnMeteor((ServerLevel) entity.level(), (Player) entity);
			return 0;
		}));
	}
}