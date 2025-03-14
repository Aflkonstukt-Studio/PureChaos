package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SanityCommandAddProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "name")) {
				{
					PurechaosModVariables.PlayerVariables _vars = entityiterator.getData(PurechaosModVariables.PLAYER_VARIABLES);
					_vars.sanity = entityiterator.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity + DoubleArgumentType.getDouble(arguments, "amount");
					_vars.syncPlayerVariables(entityiterator);
				}
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((entityiterator.getDisplayName().getString() + "Your sanity has been set to " + entityiterator.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity)), false);
				if (!(entityiterator == entity)) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((entityiterator.getDisplayName().getString() + "'s sanity has been set to " + entityiterator.getData(PurechaosModVariables.PLAYER_VARIABLES).sanity)), false);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
