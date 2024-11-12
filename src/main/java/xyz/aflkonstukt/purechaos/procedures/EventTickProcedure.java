package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EventTickProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (!PurechaosModVariables.WorldVariables.get(world).meteor.isEmpty()) {
			if ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() > 20 && (PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() <= 200) {
				if (PurechaosModVariables.WorldVariables.get(world).meteor_announce >= 20) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList()
								.broadcastSystemMessage(Component.literal(("\u00A74Meteor inbound at \u00A72" + Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).x()) + ", "
										+ Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).y()) + ", " + Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).z())
										+ " \u00A74with the blast radius of " + Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y()) + " blocks. It will go kaboom in "
										+ ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() / 20 >= 60
												? Math.floor(((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() / 20) / 60)
												: Math.floor((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() / 20))
										+ ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() / 20 >= 60 ? " minutes." : " seconds."))), false);
					PurechaosModVariables.WorldVariables.get(world).meteor_announce = 0;
					PurechaosModVariables.WorldVariables.get(world).syncData(world);
				} else {
					PurechaosModVariables.WorldVariables.get(world).meteor_announce = PurechaosModVariables.WorldVariables.get(world).meteor_announce + 1;
					PurechaosModVariables.WorldVariables.get(world).syncData(world);
				}
				PurechaosModVariables.WorldVariables.get(world).meteor.put("details",
						(new Vec3(((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() - 1), ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y()), 0)));
			} else if ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() <= 20 && (PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() > 0) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, ((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).x()), ((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).y()),
							((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).z()), (float) (PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y(), Level.ExplosionInteraction.BLOCK);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList()
							.broadcastSystemMessage(Component.literal(("\u00A74Meteor exploded at \u00A72" + Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).x()) + ", "
									+ Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).y()) + ", " + Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("epos")).z())
									+ " \u00A74with the blast radius of " + Math.round((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y()))), false);
				PurechaosModVariables.WorldVariables.get(world).meteor.put("details", (new Vec3(0, ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y()), 0)));
			} else if ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() > 200) {
				PurechaosModVariables.WorldVariables.get(world).meteor.put("details",
						(new Vec3(((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).x() - 1), ((PurechaosModVariables.WorldVariables.get(world).meteor.get("details")).y()), 0)));
			}
		}
	}
}
