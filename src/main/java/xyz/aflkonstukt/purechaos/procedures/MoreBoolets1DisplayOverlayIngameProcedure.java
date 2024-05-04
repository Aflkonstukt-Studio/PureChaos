package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

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
		if ((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100) {
			{
				double _setval = 1;
				entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.boolets = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			PurechaosMod.queueServerWork(10, () -> {
				if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
					{
						double _setval = 2;
						entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.boolets = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					PurechaosMod.queueServerWork(10, () -> {
						if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
							{
								double _setval = 3;
								entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.boolets = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							PurechaosMod.queueServerWork(10, () -> {
								if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
									{
										double _setval = 4;
										entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.boolets = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									PurechaosMod.queueServerWork(10, () -> {
										if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
											{
												double _setval = 5;
												entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.boolets = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
											PurechaosMod.queueServerWork(10, () -> {
												if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
													{
														double _setval = 6;
														entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
															capability.boolets = _setval;
															capability.syncPlayerVariables(entity);
														});
													}
													PurechaosMod.queueServerWork(10, () -> {
														if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
															{
																double _setval = 7;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.boolets = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															PurechaosMod.queueServerWork(10, () -> {
																if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
																	{
																		double _setval = 8;
																		entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																			capability.boolets = _setval;
																			capability.syncPlayerVariables(entity);
																		});
																	}
																	PurechaosMod.queueServerWork(10, () -> {
																		if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
																			{
																				double _setval = 9;
																				entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																					capability.boolets = _setval;
																					capability.syncPlayerVariables(entity);
																				});
																			}
																			PurechaosMod.queueServerWork(10, () -> {
																				if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
																					{
																						double _setval = 10;
																						entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																							capability.boolets = _setval;
																							capability.syncPlayerVariables(entity);
																						});
																					}
																					PurechaosMod.queueServerWork(10, () -> {
																						if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
																							{
																								double _setval = 11;
																								entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																									capability.boolets = _setval;
																									capability.syncPlayerVariables(entity);
																								});
																							}
																							PurechaosMod.queueServerWork(10, () -> {
																								if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																										.orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
																									{
																										double _setval = 12;
																										entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																											capability.boolets = _setval;
																											capability.syncPlayerVariables(entity);
																										});
																									}
																									PurechaosMod.queueServerWork(10, () -> {
																										if (!((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																												.orElse(new PurechaosModVariables.PlayerVariables())).boolets == 100)) {
																											{
																												double _setval = 0;
																												entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																													capability.boolets = _setval;
																													capability.syncPlayerVariables(entity);
																												});
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
