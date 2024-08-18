package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModEntities;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LobotomyHandlerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double random_pass = 0;
		double pencil_timer = 0;
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).lobotomized) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 2, false, false));
			if (Mth.nextInt(RandomSource.create(), 1, 100) < 5) {
				random_pass = Mth.nextInt(RandomSource.create(), 1, 9);
				if (random_pass == 1) {
					{
						PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
						_vars.invert_controls = true;
						_vars.syncPlayerVariables(entity);
					}
					PurechaosMod.queueServerWork(50, () -> {
						{
							PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
							_vars.invert_controls = false;
							_vars.syncPlayerVariables(entity);
						}
					});
				} else if (random_pass == 2) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 30, false, false));
				} else if (random_pass == 3) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.creeper.primed")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.creeper.primed")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				} else if (random_pass == 4) {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entityinstance = EntityType.CREEPER.create(_serverLevel, null, BlockPos.containing(x, y, z + 2), MobSpawnType.MOB_SUMMONED, false, false);
						if (entityinstance != null) {
							entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
							PurechaosMod.queueServerWork(20, () -> {
								if (!entityinstance.level().isClientSide())
									entityinstance.discard();
							});
							_serverLevel.addFreshEntity(entityinstance);
						}
					}
				} else if (random_pass == 5) {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entityinstance = PurechaosModEntities.HEROBRINE.get().create(_serverLevel, null, BlockPos.containing(x, y, z + 2), MobSpawnType.MOB_SUMMONED, false, false);
						if (entityinstance != null) {
							entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
							PurechaosMod.queueServerWork(20, () -> {
								if (!entityinstance.level().isClientSide())
									entityinstance.discard();
							});
							_serverLevel.addFreshEntity(entityinstance);
						}
					}
				} else if (random_pass == 6) {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entityinstance = EntityType.WARDEN.create(_serverLevel, null, BlockPos.containing(x, y, z + 2), MobSpawnType.MOB_SUMMONED, false, false);
						if (entityinstance != null) {
							entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
							PurechaosMod.queueServerWork(20, () -> {
								if (!entityinstance.level().isClientSide())
									entityinstance.discard();
							});
							_serverLevel.addFreshEntity(entityinstance);
						}
					}
				} else if (random_pass == 7) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.ghast.scream")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.ghast.scream")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				} else if (random_pass == 8) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.enderman.stare")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.enderman.stare")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				} else if (random_pass == 9) {
					ChangeCameraSensitivityProcedure.execute(entity);
				}
			}
		}
	}
}
