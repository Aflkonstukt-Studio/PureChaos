package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModGameRules;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class DevCommandProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (BoolArgumentType.getBool(arguments, "value")) {
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.DOGRAVECREATION).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.DOBOSSSPAWNING).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.VEGANISM).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.DISABLE_CAPTCHA).set(true, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.ADBLOCKER).set(true, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.MENTAL_HEALTH).set(true, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.NO_JUMP_VINE_BOOM).set(true, world.getServer());
			world.getLevelData().getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).set(true, world.getServer());
			world.getLevelData().getGameRules().getRule(GameRules.RULE_COMMANDBLOCKOUTPUT).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(GameRules.RULE_LOGADMINCOMMANDS).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(GameRules.RULE_WEATHER_CYCLE).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.TICK_REPELLANT).set(true, world.getServer());
			PurechaosModVariables.MapVariables.get(world).dev = true;
			PurechaosModVariables.MapVariables.get(world).syncData(world);
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.sanity_enabled = false;
				_vars.syncPlayerVariables(entity);
			}
			DevCommandProcedureCustomProcedure.execute(true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7bYour keybinds have been updated."), false);
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.MOB_CAP_MULTIPLIER).set(0, world.getServer());
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/difficulty peaceful");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/kill @e[type=!player]");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/kill @e[type=!player]");
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7aThis world is now a development world!"), false);
		} else {
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.TICK_REPELLANT).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.DOGRAVECREATION).set(true, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.VEGANISM).set(true, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.DISABLE_CAPTCHA).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.ADBLOCKER).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.MENTAL_HEALTH).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.NO_JUMP_VINE_BOOM).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(true, world.getServer());
			world.getLevelData().getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).set(false, world.getServer());
			world.getLevelData().getGameRules().getRule(GameRules.RULE_COMMANDBLOCKOUTPUT).set(true, world.getServer());
			world.getLevelData().getGameRules().getRule(GameRules.RULE_LOGADMINCOMMANDS).set(true, world.getServer());
			world.getLevelData().getGameRules().getRule(GameRules.RULE_WEATHER_CYCLE).set(true, world.getServer());
			PurechaosModVariables.MapVariables.get(world).dev = false;
			PurechaosModVariables.MapVariables.get(world).syncData(world);
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.sanity_enabled = true;
				_vars.syncPlayerVariables(entity);
			}
			DevCommandProcedureCustomProcedure.execute(false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7bYour keybinds have been updated."), false);
			world.getLevelData().getGameRules().getRule(PurechaosModGameRules.MOB_CAP_MULTIPLIER).set(10, world.getServer());
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/difficulty normal");
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7aThis world is no longer a development world!"), false);
		}
	}
}
