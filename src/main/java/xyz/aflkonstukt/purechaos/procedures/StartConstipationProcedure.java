package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModKeyMappings;

import org.lwjgl.glfw.GLFW;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class StartConstipationProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.constipated = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).constipated + 400;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(("\u00A77tip: Press \u00A76" + ((GLFW.glfwGetKeyName(PurechaosModKeyMappings.SHIT.getKey().getValue(), GLFW.glfwGetKeyScancode(PurechaosModKeyMappings.SHIT.getKey().getValue()))).equals("null")
							? "LSHIFT"
							: GLFW.glfwGetKeyName(PurechaosModKeyMappings.SHIT.getKey().getValue(), GLFW.glfwGetKeyScancode(PurechaosModKeyMappings.SHIT.getKey().getValue()))))),
					false);
	}
}
