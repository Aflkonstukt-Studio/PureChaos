package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import java.util.HashMap;

public class NewMeteorProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		double expx = 0;
		double expz = 0;
		if (PurechaosModVariables.WorldVariables.get(world).meteor.size() != 0) {
			if (((new Object() {
				public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
					Vec3 vec3 = hashMap.get(key);
					return vec3 == null ? Vec3.ZERO : vec3;
				}
			}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() == 0) {
				try {
					PurechaosModVariables.WorldVariables.get(world).meteor.put("details", (new Vec3(6000, (Mth.nextInt(RandomSource.create(), 10, 80)), 0)));
				} catch (Exception e) {
				}
				expx = Mth.nextInt(RandomSource.create(), (int) x, (int) (x + 100));
				expz = Mth.nextInt(RandomSource.create(), (int) z, (int) (z + 100));
				try {
					PurechaosModVariables.WorldVariables.get(world).meteor.put("epos", (new Vec3(expx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) expx, (int) expz)), expz)));
				} catch (Exception e) {
				}
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component
							.literal(("\u00A74Meteor inbound at \u00A72[" + expx + ", " + world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) expx, (int) expz) + ", " + expz + "]\u00A74, with the blast radius of " + ((new Object() {
								public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
									Vec3 vec3 = hashMap.get(key);
									return vec3 == null ? Vec3.ZERO : vec3;
								}
							}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).y() + ". It will go boom in 5 minutes.")), false);
				return true;
			}
		} else {
			try {
				PurechaosModVariables.WorldVariables.get(world).meteor.put("details", (new Vec3(6000, (Mth.nextInt(RandomSource.create(), 10, 80)), 0)));
			} catch (Exception e) {
			}
			expx = Mth.nextInt(RandomSource.create(), (int) x, (int) (x + 100));
			expz = Mth.nextInt(RandomSource.create(), (int) z, (int) (z + 100));
			try {
				PurechaosModVariables.WorldVariables.get(world).meteor.put("epos", (new Vec3(expx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) expx, (int) expz)), expz)));
			} catch (Exception e) {
			}
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(
						Component.literal(("\u00A74Meteor inbound at \u00A72[" + expx + ", " + world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) expx, (int) expz) + ", " + expz + "]\u00A74, with the blast radius of " + ((new Object() {
							public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
								Vec3 vec3 = hashMap.get(key);
								return vec3 == null ? Vec3.ZERO : vec3;
							}
						}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).y() + "It will go boom in 5 minutes.")), false);
			return true;
		}
		return false;
	}
}
