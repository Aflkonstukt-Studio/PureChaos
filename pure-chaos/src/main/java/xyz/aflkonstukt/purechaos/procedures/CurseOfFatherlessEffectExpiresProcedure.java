package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class CurseOfFatherlessEffectExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("bossbar remove depression_" + (entity.getDisplayName().getString()).toLowerCase()));
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.last_depression = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.having_nightmare = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}
