package xyz.vikkivuk.chaosmod.procedures;

import net.minecraft.world.entity.Entity;

public class GreenPlantPlantRightClickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity((true));
	}
}
