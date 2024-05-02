package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class OldSanityCommandExecutedProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		PurechaosModVariables.show_sanity_label = BoolArgumentType.getBool(arguments, "value");
	}
}
