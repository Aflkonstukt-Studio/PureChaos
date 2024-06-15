package xyz.aflkonstukt.purechaos.procedures;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleOperations;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.BuiltInRegistries;

import javax.annotation.Nullable;

import java.util.Comparator;

@Mod.EventBusSubscriber
public class FuseEntitiesProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity found_entity = null;
		if (!(entity instanceof Player) && !(entity instanceof ServerPlayer)) {
			if (!world.getEntitiesOfClass(LivingEntity.class,
					AABB.ofSize(
							new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							2, 2, 2),
					e -> true).isEmpty()) {
				found_entity = (Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(
						new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
						2, 2, 2), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
						.findFirst().orElse(null);
				if (!(found_entity == entity) && (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).equals(BuiltInRegistries.ENTITY_TYPE.getKey(found_entity.getType()).toString())) {
					if (!(ScaleTypes.HEIGHT.getScaleData(found_entity).getTargetScale() >= 10 || ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale() >= 10)) {
						if (ScaleTypes.HEIGHT.getScaleData(found_entity).getTargetScale() > ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale()) {
							if (!entity.level().isClientSide())
								entity.discard();
							ScaleTypes.HEIGHT.getScaleData(found_entity)
									.setTargetScale((float) ScaleOperations.ADD.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(found_entity).getTargetScale(), (ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale() / 2)));
							ScaleTypes.WIDTH.getScaleData(found_entity)
									.setTargetScale((float) ScaleOperations.ADD.applyAsDouble(ScaleTypes.WIDTH.getScaleData(found_entity).getTargetScale(), (ScaleTypes.WIDTH.getScaleData(entity).getTargetScale() / 2)));
						} else {
							if (!found_entity.level().isClientSide())
								found_entity.discard();
							ScaleTypes.HEIGHT.getScaleData(entity)
									.setTargetScale((float) ScaleOperations.ADD.applyAsDouble(ScaleTypes.HEIGHT.getScaleData(entity).getTargetScale(), (ScaleTypes.HEIGHT.getScaleData(found_entity).getTargetScale() / 2)));
							ScaleTypes.WIDTH.getScaleData(entity).setTargetScale((float) ScaleOperations.ADD.applyAsDouble(ScaleTypes.WIDTH.getScaleData(entity).getTargetScale(), (ScaleTypes.WIDTH.getScaleData(found_entity).getTargetScale() / 2)));
						}
					}
				}
			}
		}
	}
}
