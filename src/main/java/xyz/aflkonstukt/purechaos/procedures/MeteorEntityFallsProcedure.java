package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

public class MeteorEntityFallsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!PurechaosModVariables.WorldVariables.get(world).meteor.isEmpty()) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) (PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y(), Level.ExplosionInteraction.BLOCK);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A74Meteor exploded at \u00A72" + Math.round(x) + ", " + Math.round(y) + ", " + Math.round(z) + " \u00A74with the blast radius of "
						+ Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y()))), false);
			PurechaosModVariables.WorldVariables.get(world).meteor.put("details", (new Vec3(0, ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y()), 0)));
		}
	}
}
