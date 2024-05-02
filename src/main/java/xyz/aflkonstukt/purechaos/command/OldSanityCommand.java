
package xyz.aflkonstukt.purechaos.command;

import xyz.aflkonstukt.purechaos.procedures.OldSanityCommandExecutedProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.BoolArgumentType;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class OldSanityCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterClientCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("old_sanity")

				.then(Commands.argument("value", BoolArgumentType.bool()).executes(arguments -> {
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

					OldSanityCommandExecutedProcedure.execute(arguments);
					return 0;
				})));
	}
}
