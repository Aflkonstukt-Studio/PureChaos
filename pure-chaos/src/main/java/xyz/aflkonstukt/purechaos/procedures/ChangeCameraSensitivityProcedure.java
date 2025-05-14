package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import xyz.aflkonstukt.purechaos.PurechaosMod;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

public class ChangeCameraSensitivityProcedure {
	static double originalSensitivity = 0.0;

	public static void execute(Entity entity) {
		if (entity == null)
			return;
		assert entity instanceof Player;

		if (entity.level().isClientSide()) {
			Options options = Minecraft.getInstance().options;
			originalSensitivity = options.sensitivity().get();

			System.out.println("Changing sensitivity");

			double newSensitivity = options.sensitivity().get() * (1.5 + Math.random() * 0.5);
			options.sensitivity().set(newSensitivity);

			PurechaosMod.queueServerWork(10, () -> {
				entity.sendSystemMessage(Component.literal("Your mouse sensitivity has been changed and we can't change it back :face_with_hand_over_mouth:").withStyle(ChatFormatting.RED));
			});
		} else {
			System.out.println("ChangeCameraSensitivityProcedure can only be called on the client side");
		}
	}
}