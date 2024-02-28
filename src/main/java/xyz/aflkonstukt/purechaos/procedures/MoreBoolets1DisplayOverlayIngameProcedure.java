package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MoreBoolets1DisplayOverlayIngameProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level());
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (PurechaosModVariables.bl == true) {
			PurechaosModVariables.bl1 = true;
			PurechaosMod.queueServerWork(10, () -> {
				PurechaosModVariables.bl2 = true;
				PurechaosMod.queueServerWork(10, () -> {
					PurechaosModVariables.bl3 = true;
					PurechaosMod.queueServerWork(10, () -> {
						PurechaosModVariables.bl4 = true;
						PurechaosMod.queueServerWork(10, () -> {
							PurechaosModVariables.bl5 = true;
							PurechaosMod.queueServerWork(10, () -> {
								PurechaosModVariables.bl6 = true;
								PurechaosMod.queueServerWork(10, () -> {
									PurechaosModVariables.bl7 = true;
									PurechaosMod.queueServerWork(10, () -> {
										PurechaosModVariables.bl8 = true;
										PurechaosMod.queueServerWork(10, () -> {
											PurechaosModVariables.bl9 = true;
											PurechaosMod.queueServerWork(10, () -> {
												PurechaosModVariables.bl10 = true;
												PurechaosMod.queueServerWork(10, () -> {
													PurechaosModVariables.bl11 = true;
													PurechaosMod.queueServerWork(10, () -> {
														PurechaosModVariables.bl12 = true;
														PurechaosMod.queueServerWork(10, () -> {
															PurechaosModVariables.bl1 = false;
															PurechaosModVariables.bl2 = false;
															PurechaosModVariables.bl3 = false;
															PurechaosModVariables.bl4 = false;
															PurechaosModVariables.bl5 = false;
															PurechaosModVariables.bl6 = false;
															PurechaosModVariables.bl7 = false;
															PurechaosModVariables.bl8 = false;
															PurechaosModVariables.bl9 = false;
															PurechaosModVariables.bl10 = false;
															PurechaosModVariables.bl11 = false;
															PurechaosModVariables.bl12 = false;
															PurechaosModVariables.bl = false;
														});
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			});
		}
	}
}
