package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CallMeteorProcedure {
	public static void execute(LevelAccessor world, double x, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		SummonMeteorProcedure.execute(world, x, z, entity, DoubleArgumentType.getDouble(arguments, "radius"), DoubleArgumentType.getDouble(arguments, "time") * 20);
	}
}
