
package xyz.vikkivuk.chaosmod.client.gui;

import xyz.vikkivuk.chaosmod.world.inventory.CheatGUIMenu;
import xyz.vikkivuk.chaosmod.network.CheatGUIButtonMessage;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CheatGUIScreen extends AbstractContainerScreen<CheatGUIMenu> {
	private final static HashMap<String, Object> guistate = CheatGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_switch_gamemode;
	Button button_switch_dimension;
	Button button_do_not_press;

	public CheatGUIScreen(CheatGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("chaosmod:textures/screens/cheat_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.chaosmod.cheat_gui.label_cheat_menu"), 58, 10, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_switch_gamemode = new Button(this.leftPos + 36, this.topPos + 31, 103, 20, new TranslatableComponent("gui.chaosmod.cheat_gui.button_switch_gamemode"), e -> {
		});
		guistate.put("button:button_switch_gamemode", button_switch_gamemode);
		this.addRenderableWidget(button_switch_gamemode);
		button_switch_dimension = new Button(this.leftPos + 33, this.topPos + 62, 108, 20, new TranslatableComponent("gui.chaosmod.cheat_gui.button_switch_dimension"), e -> {
		});
		guistate.put("button:button_switch_dimension", button_switch_dimension);
		this.addRenderableWidget(button_switch_dimension);
		button_do_not_press = new Button(this.leftPos + 42, this.topPos + 129, 88, 20, new TranslatableComponent("gui.chaosmod.cheat_gui.button_do_not_press"), e -> {
			if (true) {
				ChaosmodMod.PACKET_HANDLER.sendToServer(new CheatGUIButtonMessage(2, x, y, z));
				CheatGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_do_not_press", button_do_not_press);
		this.addRenderableWidget(button_do_not_press);
	}
}
