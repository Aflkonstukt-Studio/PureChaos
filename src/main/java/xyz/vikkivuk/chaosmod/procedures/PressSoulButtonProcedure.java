package xyz.vikkivuk.chaosmod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class PressSoulButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		entity.hurt(DamageSource.MAGIC, 9999);
	}
}
