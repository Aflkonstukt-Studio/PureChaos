package xyz.vikkivuk.chaosmod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class PressSoulButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.hurt(new DamageSource("message_too_long").bypassArmor(), 99999);
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
