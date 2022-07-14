package xyz.vikkivuk.chaosmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

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
		if ((text).contains("cccp")) {
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
															if (entity instanceof LivingEntity _entity)
																_entity.hurt(new DamageSource("cccp").bypassArmor(), 999999);
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
