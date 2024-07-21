package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class YippeProjectileProjectileHitsBlockProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setDeltaMovement(new Vec3((immediatesourceentity.getDeltaMovement().x()), ((-1) * immediatesourceentity.getDeltaMovement().y()), (immediatesourceentity.getDeltaMovement().z())));
	}
}
