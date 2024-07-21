package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class YippeeRangedItemShootsProjectileProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:yippee")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("purechaos:yippee")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		PurechaosModVariables.MapVariables.get(world).ypx = entity.getLookAngle().x;
		PurechaosModVariables.MapVariables.get(world).syncData(world);
		PurechaosModVariables.MapVariables.get(world).ypz = entity.getLookAngle().z;
		PurechaosModVariables.MapVariables.get(world).syncData(world);
	}
}
