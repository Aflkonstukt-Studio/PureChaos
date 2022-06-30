package xyz.vikkivuk.chaosmod.procedures;

import net.minecraft.world.entity.Entity;

public class CorruptstaffLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(15);
	}
}
