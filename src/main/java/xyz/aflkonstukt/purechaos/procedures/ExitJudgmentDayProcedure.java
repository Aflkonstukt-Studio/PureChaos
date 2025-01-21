package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.storage.PrimaryLevelData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

public class ExitJudgmentDayProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(world instanceof ServerLevel _level)) return;

		PrimaryLevelData worldData = (PrimaryLevelData) _level.getLevelData();
		// Create a new tag
		CompoundTag nbt = new CompoundTag();
		nbt.putBoolean("JudgmentDayDestroyed", true);
		// Set the tag
		worldData.createTag(RegistryAccess.EMPTY, nbt);

		// Save the world to persist changes
		_level.save(null, true, false); // Force save

		// Close the world
		try {
			_level.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
