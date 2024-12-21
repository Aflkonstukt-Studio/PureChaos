package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModEntities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class MeteorTickHandlerProcedure {
	public static void execute(LevelAccessor world) {
		if (!PurechaosModVariables.WorldVariables.get(world).meteor.isEmpty()) {
			if ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() != 0) {
				if ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() <= 100) {
					if ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).z() != 1) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList()
									.broadcastSystemMessage(Component.literal(("\u00A74Meteor at around \u00A72" + Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).x()) + ", "
											+ Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).y()) + ", " + Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).z())
											+ " \u00A74with the blast radius of " + Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y()) + " blocks. has entered the atmosphere.")), false);
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = PurechaosModEntities.METEOR.get().spawn(_level, BlockPos.containing((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).x(),
									(PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).y() + 100, (PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).z()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						PurechaosModVariables.WorldVariables.get(world).meteor.put("details",
								(new Vec3(((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() - 1), ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y()), 1)));
					}
				} else {
					PurechaosModVariables.WorldVariables.get(world).meteor.put("details",
							(new Vec3(((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() - 1), ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y()), 0)));
				}
			}
		}
	}
}
