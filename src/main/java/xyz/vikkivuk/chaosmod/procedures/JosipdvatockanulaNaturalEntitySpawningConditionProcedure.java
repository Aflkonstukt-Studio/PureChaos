package xyz.vikkivuk.chaosmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class JosipdvatockanulaNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameRules().getBoolean(ChaosmodModGameRules.DOJBOSSSPAWNING);
	}
}
