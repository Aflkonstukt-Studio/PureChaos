package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class CocaColaPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("purechaos:espuma")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("purechaos:espuma")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 6, Level.ExplosionInteraction.TNT);
	}
}
