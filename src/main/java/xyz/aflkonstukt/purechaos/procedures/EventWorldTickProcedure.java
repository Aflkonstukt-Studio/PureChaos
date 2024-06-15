package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.HashMap;

@Mod.EventBusSubscriber
public class EventWorldTickProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (((new Object() {
			public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
				Vec3 vec3 = hashMap.get(key);
				return vec3 == null ? Vec3.ZERO : vec3;
			}
		}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() > 200) {
			try {
				PurechaosModVariables.WorldVariables.get(world).meteor.put("details", (new Vec3((((new Object() {
					public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
						Vec3 vec3 = hashMap.get(key);
						return vec3 == null ? Vec3.ZERO : vec3;
					}
				}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() - 1), (((new Object() {
					public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
						Vec3 vec3 = hashMap.get(key);
						return vec3 == null ? Vec3.ZERO : vec3;
					}
				}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).y()), (((new Object() {
					public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
						Vec3 vec3 = hashMap.get(key);
						return vec3 == null ? Vec3.ZERO : vec3;
					}
				}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).z()))));
			} catch (Exception e) {
			}
		} else if (((new Object() {
			public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
				Vec3 vec3 = hashMap.get(key);
				return vec3 == null ? Vec3.ZERO : vec3;
			}
		}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() <= 200 && ((new Object() {
			public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
				Vec3 vec3 = hashMap.get(key);
				return vec3 == null ? Vec3.ZERO : vec3;
			}
		}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() > 20) {
			if (PurechaosModVariables.WorldVariables.get(world).meteor_announce >= 20) {
				PurechaosModVariables.WorldVariables.get(world).meteor_announce = 0;
				PurechaosModVariables.WorldVariables.get(world).syncData(world);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A74Meteor inbound at \u00A72[" + ((new Object() {
						public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
							Vec3 vec3 = hashMap.get(key);
							return vec3 == null ? Vec3.ZERO : vec3;
						}
					}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "epos")).x() + ", " + ((new Object() {
						public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
							Vec3 vec3 = hashMap.get(key);
							return vec3 == null ? Vec3.ZERO : vec3;
						}
					}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "epos")).y() + ", " + ((new Object() {
						public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
							Vec3 vec3 = hashMap.get(key);
							return vec3 == null ? Vec3.ZERO : vec3;
						}
					}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "epos")).z() + "]\u00A74. It will go boom in " + (((new Object() {
						public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
							Vec3 vec3 = hashMap.get(key);
							return vec3 == null ? Vec3.ZERO : vec3;
						}
					}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() / 20 >= 60 ? Math.round((((new Object() {
						public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
							Vec3 vec3 = hashMap.get(key);
							return vec3 == null ? Vec3.ZERO : vec3;
						}
					}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() / 20) / 60) : Math.round(((new Object() {
						public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
							Vec3 vec3 = hashMap.get(key);
							return vec3 == null ? Vec3.ZERO : vec3;
						}
					}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() / 20)) + (((new Object() {
						public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
							Vec3 vec3 = hashMap.get(key);
							return vec3 == null ? Vec3.ZERO : vec3;
						}
					}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() / 20 < 60 ? " seconds." : " minutes."))), false);
			} else {
				PurechaosModVariables.WorldVariables.get(world).meteor_announce = PurechaosModVariables.WorldVariables.get(world).meteor_announce + 1;
				PurechaosModVariables.WorldVariables.get(world).syncData(world);
			}
			try {
				PurechaosModVariables.WorldVariables.get(world).meteor.put("details", (new Vec3((((new Object() {
					public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
						Vec3 vec3 = hashMap.get(key);
						return vec3 == null ? Vec3.ZERO : vec3;
					}
				}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() - 1), (((new Object() {
					public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
						Vec3 vec3 = hashMap.get(key);
						return vec3 == null ? Vec3.ZERO : vec3;
					}
				}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).y()), (((new Object() {
					public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
						Vec3 vec3 = hashMap.get(key);
						return vec3 == null ? Vec3.ZERO : vec3;
					}
				}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).z()))));
			} catch (Exception e) {
			}
		} else if (PurechaosModVariables.WorldVariables.get(world).meteor.size() != 0 && ((new Object() {
			public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
				Vec3 vec3 = hashMap.get(key);
				return vec3 == null ? Vec3.ZERO : vec3;
			}
		}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() <= 20) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (((new Object() {
					public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
						Vec3 vec3 = hashMap.get(key);
						return vec3 == null ? Vec3.ZERO : vec3;
					}
				}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "epos")).x()), (((new Object() {
					public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
						Vec3 vec3 = hashMap.get(key);
						return vec3 == null ? Vec3.ZERO : vec3;
					}
				}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "epos")).y()), (((new Object() {
					public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
						Vec3 vec3 = hashMap.get(key);
						return vec3 == null ? Vec3.ZERO : vec3;
					}
				}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "epos")).z()), (float) ((new Object() {
					public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
						Vec3 vec3 = hashMap.get(key);
						return vec3 == null ? Vec3.ZERO : vec3;
					}
				}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).y(), Level.ExplosionInteraction.TNT);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A74Meteor exploded"), false);
			PurechaosModVariables.WorldVariables.get(world).meteor.clear();
		}
	}
}
