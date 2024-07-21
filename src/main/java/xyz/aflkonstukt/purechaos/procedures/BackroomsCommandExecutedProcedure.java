package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class BackroomsCommandExecutedProcedure {
	public static void execute(double x, double z, CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
				SendToBackroomsProcedure.execute(x, z, entityiterator);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
