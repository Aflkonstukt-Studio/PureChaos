package xyz.aflkonstukt.purechaos.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class BoomCommandExecutedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, HashMap cmdparams) {
		if (cmdparams == null)
			return;
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, (float) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : ""), Level.ExplosionInteraction.BLOCK);
	}
}
