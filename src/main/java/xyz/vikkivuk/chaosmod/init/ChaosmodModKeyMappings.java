
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.network.TwoMessage;
import xyz.vikkivuk.chaosmod.network.ShitMessage;
import xyz.vikkivuk.chaosmod.network.SevenMessage;
import xyz.vikkivuk.chaosmod.network.OneMessage;
import xyz.vikkivuk.chaosmod.network.KMessage;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

import org.lwjgl.glfw.GLFW;

import org.checkerframework.checker.units.qual.K;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ChaosmodModKeyMappings {
	public static final KeyMapping ONE = new KeyMapping("key.chaosmod.one", GLFW.GLFW_KEY_1, "key.categories.gameplay");
	public static final KeyMapping K = new KeyMapping("key.chaosmod.k", GLFW.GLFW_KEY_K, "key.categories.creative");
	public static final KeyMapping SEVEN = new KeyMapping("key.chaosmod.seven", GLFW.GLFW_KEY_7, "key.categories.misc");
	public static final KeyMapping TWO = new KeyMapping("key.chaosmod.two", GLFW.GLFW_KEY_2, "key.categories.gameplay");
	public static final KeyMapping SHIT = new KeyMapping("key.chaosmod.shit", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.gameplay");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(ONE);
		ClientRegistry.registerKeyBinding(K);
		ClientRegistry.registerKeyBinding(SEVEN);
		ClientRegistry.registerKeyBinding(TWO);
		ClientRegistry.registerKeyBinding(SHIT);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == ONE.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						ChaosmodMod.PACKET_HANDLER.sendToServer(new OneMessage(0, 0));
						OneMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == K.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						ChaosmodMod.PACKET_HANDLER.sendToServer(new KMessage(0, 0));
						KMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == SEVEN.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						ChaosmodMod.PACKET_HANDLER.sendToServer(new SevenMessage(0, 0));
						SevenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == TWO.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						ChaosmodMod.PACKET_HANDLER.sendToServer(new TwoMessage(0, 0));
						TwoMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == SHIT.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						ChaosmodMod.PACKET_HANDLER.sendToServer(new ShitMessage(0, 0));
						ShitMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
