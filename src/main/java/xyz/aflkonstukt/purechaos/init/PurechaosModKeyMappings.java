
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.network.TwoMessage;
import xyz.aflkonstukt.purechaos.network.ShitMessage;
import xyz.aflkonstukt.purechaos.network.SevenMessage;
import xyz.aflkonstukt.purechaos.network.OneMessage;
import xyz.aflkonstukt.purechaos.network.KMessage;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import org.lwjgl.glfw.GLFW;

import org.checkerframework.checker.units.qual.K;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PurechaosModKeyMappings {
	public static final KeyMapping ONE = new KeyMapping("key.purechaos.one", GLFW.GLFW_KEY_1, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PurechaosMod.PACKET_HANDLER.sendToServer(new OneMessage(0, 0));
				OneMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping K = new KeyMapping("key.purechaos.k", GLFW.GLFW_KEY_K, "key.categories.creative") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PurechaosMod.PACKET_HANDLER.sendToServer(new KMessage(0, 0));
				KMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SEVEN = new KeyMapping("key.purechaos.seven", GLFW.GLFW_KEY_7, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PurechaosMod.PACKET_HANDLER.sendToServer(new SevenMessage(0, 0));
				SevenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TWO = new KeyMapping("key.purechaos.two", GLFW.GLFW_KEY_2, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PurechaosMod.PACKET_HANDLER.sendToServer(new TwoMessage(0, 0));
				TwoMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SHIT = new KeyMapping("key.purechaos.shit", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PurechaosMod.PACKET_HANDLER.sendToServer(new ShitMessage(0, 0));
				ShitMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ONE);
		event.register(K);
		event.register(SEVEN);
		event.register(TWO);
		event.register(SHIT);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				ONE.consumeClick();
				K.consumeClick();
				SEVEN.consumeClick();
				TWO.consumeClick();
				SHIT.consumeClick();
			}
		}
	}
}
