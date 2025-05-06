
package xyz.aflkonstukt.purechaos.command;

import xyz.aflkonstukt.purechaos.procedures.SchizophreniaCommandExecutedProcedure;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.BoolArgumentType;

@EventBusSubscriber
public class SchizophreniaCommandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("schizophrenia").requires(s -> s.hasPermission(2)).then(Commands.argument("name", EntityArgument.players()).then(Commands.argument("value", BoolArgumentType.bool()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SchizophreniaCommandExecutedProcedure.execute(arguments, entity);
			return 0;
		}))));
	}

}
