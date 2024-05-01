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
		if ((entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PurechaosModVariables.PlayerVariables())).bl == true) {
			{
				boolean _setval = true;
				entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.bl1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			PurechaosMod.queueServerWork(10, () -> {
				{
					boolean _setval = true;
					entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.bl2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				PurechaosMod.queueServerWork(10, () -> {
					{
						boolean _setval = true;
						entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.bl3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					PurechaosMod.queueServerWork(10, () -> {
						{
							boolean _setval = true;
							entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.bl4 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						PurechaosMod.queueServerWork(10, () -> {
							{
								boolean _setval = true;
								entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.bl5 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							PurechaosMod.queueServerWork(10, () -> {
								{
									boolean _setval = true;
									entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.bl6 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								PurechaosMod.queueServerWork(10, () -> {
									{
										boolean _setval = true;
										entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.bl7 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									PurechaosMod.queueServerWork(10, () -> {
										{
											boolean _setval = true;
											entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.bl8 = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										PurechaosMod.queueServerWork(10, () -> {
											{
												boolean _setval = true;
												entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.bl9 = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
											PurechaosMod.queueServerWork(10, () -> {
												{
													boolean _setval = true;
													entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.bl10 = _setval;
														capability.syncPlayerVariables(entity);
													});
												}
												PurechaosMod.queueServerWork(10, () -> {
													{
														boolean _setval = true;
														entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
															capability.bl11 = _setval;
															capability.syncPlayerVariables(entity);
														});
													}
													PurechaosMod.queueServerWork(10, () -> {
														{
															boolean _setval = true;
															entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																capability.bl12 = _setval;
																capability.syncPlayerVariables(entity);
															});
														}
														PurechaosMod.queueServerWork(10, () -> {
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl1 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl2 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl3 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl4 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl5 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl6 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl7 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl8 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl9 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl10 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl11 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl12 = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															{
																boolean _setval = false;
																entity.getCapability(PurechaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.bl = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
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
