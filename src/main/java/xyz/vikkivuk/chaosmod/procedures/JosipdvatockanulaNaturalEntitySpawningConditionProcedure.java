package xyz.vikkivuk.chaosmod.procedures;

import xyz.vikkivuk.chaosmod.init.ChaosmodModGameRules;

import net.minecraft.world.level.LevelAccessor;

public class JosipdvatockanulaNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameRules().getBoolean(ChaosmodModGameRules.DELETED_MOD_ELEMENT);
	}
}
