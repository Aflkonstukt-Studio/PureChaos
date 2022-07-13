package xyz.vikkivuk.chaosmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CccpProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(),
				event.getMessage());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String text) {
		execute(null, world, x, y, z, entity, text);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		if ((text).equals("cccp")) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent("You fool"), (false));
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private LevelAccessor world;

						public void start(LevelAccessor world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (entity instanceof Player _player && !_player.level.isClientSide())
								_player.displayClientMessage(new TextComponent("That is Latin"), (false));
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private LevelAccessor world;

								public void start(LevelAccessor world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(new TextComponent("I am code"), (false));
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private LevelAccessor world;

										public void start(LevelAccessor world, int waitTicks) {
											this.waitTicks = waitTicks;
											MinecraftForge.EVENT_BUS.register(this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(TickEvent.ServerTickEvent event) {
											if (event.phase == TickEvent.Phase.END) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											if (entity instanceof Player _player && !_player.level.isClientSide())
												_player.displayClientMessage(new TextComponent("I know all"), (false));
											new Object() {
												private int ticks = 0;
												private float waitTicks;
												private LevelAccessor world;

												public void start(LevelAccessor world, int waitTicks) {
													this.waitTicks = waitTicks;
													MinecraftForge.EVENT_BUS.register(this);
													this.world = world;
												}

												@SubscribeEvent
												public void tick(TickEvent.ServerTickEvent event) {
													if (event.phase == TickEvent.Phase.END) {
														this.ticks += 1;
														if (this.ticks >= this.waitTicks)
															run();
													}
												}

												private void run() {
													if (entity instanceof Player _player && !_player.level.isClientSide())
														_player.displayClientMessage(new TextComponent("You will die now"), (false));
													new Object() {
														private int ticks = 0;
														private float waitTicks;
														private LevelAccessor world;

														public void start(LevelAccessor world, int waitTicks) {
															this.waitTicks = waitTicks;
															MinecraftForge.EVENT_BUS.register(this);
															this.world = world;
														}

														@SubscribeEvent
														public void tick(TickEvent.ServerTickEvent event) {
															if (event.phase == TickEvent.Phase.END) {
																this.ticks += 1;
																if (this.ticks >= this.waitTicks)
																	run();
															}
														}

														private void run() {
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, 20);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, 20);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, 20);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 20);
		} else if ((text).equals("CCCP")) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent("You fool"), (false));
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private LevelAccessor world;

						public void start(LevelAccessor world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (entity instanceof Player _player && !_player.level.isClientSide())
								_player.displayClientMessage(new TextComponent("That is Latin"), (false));
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private LevelAccessor world;

								public void start(LevelAccessor world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(new TextComponent("I am code"), (false));
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private LevelAccessor world;

										public void start(LevelAccessor world, int waitTicks) {
											this.waitTicks = waitTicks;
											MinecraftForge.EVENT_BUS.register(this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(TickEvent.ServerTickEvent event) {
											if (event.phase == TickEvent.Phase.END) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											if (entity instanceof Player _player && !_player.level.isClientSide())
												_player.displayClientMessage(new TextComponent("I know all"), (false));
											new Object() {
												private int ticks = 0;
												private float waitTicks;
												private LevelAccessor world;

												public void start(LevelAccessor world, int waitTicks) {
													this.waitTicks = waitTicks;
													MinecraftForge.EVENT_BUS.register(this);
													this.world = world;
												}

												@SubscribeEvent
												public void tick(TickEvent.ServerTickEvent event) {
													if (event.phase == TickEvent.Phase.END) {
														this.ticks += 1;
														if (this.ticks >= this.waitTicks)
															run();
													}
												}

												private void run() {
													if (entity instanceof Player _player && !_player.level.isClientSide())
														_player.displayClientMessage(new TextComponent("You will die now"), (false));
													new Object() {
														private int ticks = 0;
														private float waitTicks;
														private LevelAccessor world;

														public void start(LevelAccessor world, int waitTicks) {
															this.waitTicks = waitTicks;
															MinecraftForge.EVENT_BUS.register(this);
															this.world = world;
														}

														@SubscribeEvent
														public void tick(TickEvent.ServerTickEvent event) {
															if (event.phase == TickEvent.Phase.END) {
																this.ticks += 1;
																if (this.ticks >= this.waitTicks)
																	run();
															}
														}

														private void run() {
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, 20);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, 20);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, 20);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 20);
		} else if ((text).equals("Cccp")) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent("You fool"), (false));
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private LevelAccessor world;

						public void start(LevelAccessor world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (entity instanceof Player _player && !_player.level.isClientSide())
								_player.displayClientMessage(new TextComponent("That is Latin"), (false));
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private LevelAccessor world;

								public void start(LevelAccessor world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(new TextComponent("I am code"), (false));
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private LevelAccessor world;

										public void start(LevelAccessor world, int waitTicks) {
											this.waitTicks = waitTicks;
											MinecraftForge.EVENT_BUS.register(this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(TickEvent.ServerTickEvent event) {
											if (event.phase == TickEvent.Phase.END) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											if (entity instanceof Player _player && !_player.level.isClientSide())
												_player.displayClientMessage(new TextComponent("I know all"), (false));
											new Object() {
												private int ticks = 0;
												private float waitTicks;
												private LevelAccessor world;

												public void start(LevelAccessor world, int waitTicks) {
													this.waitTicks = waitTicks;
													MinecraftForge.EVENT_BUS.register(this);
													this.world = world;
												}

												@SubscribeEvent
												public void tick(TickEvent.ServerTickEvent event) {
													if (event.phase == TickEvent.Phase.END) {
														this.ticks += 1;
														if (this.ticks >= this.waitTicks)
															run();
													}
												}

												private void run() {
													if (entity instanceof Player _player && !_player.level.isClientSide())
														_player.displayClientMessage(new TextComponent("You will die now"), (false));
													new Object() {
														private int ticks = 0;
														private float waitTicks;
														private LevelAccessor world;

														public void start(LevelAccessor world, int waitTicks) {
															this.waitTicks = waitTicks;
															MinecraftForge.EVENT_BUS.register(this);
															this.world = world;
														}

														@SubscribeEvent
														public void tick(TickEvent.ServerTickEvent event) {
															if (event.phase == TickEvent.Phase.END) {
																this.ticks += 1;
																if (this.ticks >= this.waitTicks)
																	run();
															}
														}

														private void run() {
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
																entityToSpawn.setVisualOnly(false);
																_level.addFreshEntity(entityToSpawn);
															}
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, 20);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, 20);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, 20);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 20);
		}
	}
}
