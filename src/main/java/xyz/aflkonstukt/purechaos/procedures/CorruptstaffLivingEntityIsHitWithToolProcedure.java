package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.entity.Entity;

public class CorruptstaffLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.igniteForSeconds(15);
	}
}
