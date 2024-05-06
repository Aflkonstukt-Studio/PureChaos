package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MoreBoolets1DisplayOverlayIngameProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100) {
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.boolets = 1;
				_vars.syncPlayerVariables(entity);
			}
			PurechaosMod.queueServerWork(10, () -> {
				if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
					{
						PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
						_vars.boolets = 2;
						_vars.syncPlayerVariables(entity);
					}
					PurechaosMod.queueServerWork(10, () -> {
						if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
							{
								PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
								_vars.boolets = 3;
								_vars.syncPlayerVariables(entity);
							}
							PurechaosMod.queueServerWork(10, () -> {
								if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
									{
										PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
										_vars.boolets = 4;
										_vars.syncPlayerVariables(entity);
									}
									PurechaosMod.queueServerWork(10, () -> {
										if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
											{
												PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
												_vars.boolets = 5;
												_vars.syncPlayerVariables(entity);
											}
											PurechaosMod.queueServerWork(10, () -> {
												if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
													{
														PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
														_vars.boolets = 6;
														_vars.syncPlayerVariables(entity);
													}
													PurechaosMod.queueServerWork(10, () -> {
														if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
															{
																PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
																_vars.boolets = 7;
																_vars.syncPlayerVariables(entity);
															}
															PurechaosMod.queueServerWork(10, () -> {
																if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
																	{
																		PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
																		_vars.boolets = 8;
																		_vars.syncPlayerVariables(entity);
																	}
																	PurechaosMod.queueServerWork(10, () -> {
																		if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
																			{
																				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
																				_vars.boolets = 9;
																				_vars.syncPlayerVariables(entity);
																			}
																			PurechaosMod.queueServerWork(10, () -> {
																				if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
																					{
																						PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
																						_vars.boolets = 10;
																						_vars.syncPlayerVariables(entity);
																					}
																					PurechaosMod.queueServerWork(10, () -> {
																						if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
																							{
																								PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
																								_vars.boolets = 11;
																								_vars.syncPlayerVariables(entity);
																							}
																							PurechaosMod.queueServerWork(10, () -> {
																								if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
																									{
																										PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
																										_vars.boolets = 12;
																										_vars.syncPlayerVariables(entity);
																									}
																									PurechaosMod.queueServerWork(10, () -> {
																										if (!(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).boolets == 100)) {
																											{
																												PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
																												_vars.boolets = 0;
																												_vars.syncPlayerVariables(entity);
																											}
																										}
																									});
																								}
																							});
																						}
																					});
																				}
																			});
																		}
																	});
																}
															});
														}
													});
												}
											});
										}
									});
								}
							});
						}
					});
				}
			});
		}
	}
}
