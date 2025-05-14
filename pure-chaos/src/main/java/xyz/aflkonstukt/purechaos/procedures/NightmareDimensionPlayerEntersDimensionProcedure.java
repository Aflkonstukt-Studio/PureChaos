package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class NightmareDimensionPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.nightmare_duration = 2400;
			_vars.syncPlayerVariables(entity);
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("bossbar add nightmare_" + ((entity.getDisplayName().getString()).toLowerCase() + "" + " \"Nightmare Duration\"")));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("bossbar set nightmare_" + ((entity.getDisplayName().getString()).toLowerCase() + " max 120")));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("bossbar set nightmare_" + ((entity.getDisplayName().getString()).toLowerCase() + "" + (" players " + (entity.getDisplayName().getString()).toLowerCase()))));
		{
			Entity _ent = entity;
			_ent.teleportTo((entity.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ())), (entity.getZ()));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((entity.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ())), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
		}
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.having_nightmare = true;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 9999999, 1, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9999999, 1, false, false));
		PurechaosMod.queueServerWork(40, () -> {
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.disable_backrooms = false;
				_vars.syncPlayerVariables(entity);
			}
		});
	}
}
