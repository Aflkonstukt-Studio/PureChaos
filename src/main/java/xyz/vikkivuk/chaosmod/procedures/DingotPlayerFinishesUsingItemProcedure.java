package xyz.vikkivuk.chaosmod.procedures;

import xyz.vikkivuk.chaosmod.init.ChaosmodModMobEffects;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.TextComponent;

import java.util.Random;

public class DingotPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextInt(new Random(), 1, 5) == 5) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("It was poisonous, you are now sick for a day."), (false));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(ChaosmodModMobEffects.SICK.get(), 24000, 1));
		}
	}
}
