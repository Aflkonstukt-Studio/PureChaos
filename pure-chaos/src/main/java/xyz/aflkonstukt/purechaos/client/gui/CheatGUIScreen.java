package xyz.aflkonstukt.purechaos.client.gui;

import xyz.aflkonstukt.purechaos.world.inventory.CheatGUIMenu;
import xyz.aflkonstukt.purechaos.network.CheatGUIButtonMessage;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

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

	private static final ResourceLocation texture = ResourceLocation.parse("purechaos:textures/screens/cheat_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.cheat_gui.label_cheat_menu"), 58, 10, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_switch_gamemode = Button.builder(Component.translatable("gui.purechaos.cheat_gui.button_switch_gamemode"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CheatGUIButtonMessage(0, x, y, z));
				CheatGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 31, 103, 20).build();
		guistate.put("button:button_switch_gamemode", button_switch_gamemode);
		this.addRenderableWidget(button_switch_gamemode);
		button_switch_dimension = Button.builder(Component.translatable("gui.purechaos.cheat_gui.button_switch_dimension"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CheatGUIButtonMessage(1, x, y, z));
				CheatGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 33, this.topPos + 62, 108, 20).build();
		guistate.put("button:button_switch_dimension", button_switch_dimension);
		this.addRenderableWidget(button_switch_dimension);
		button_do_not_press = Button.builder(Component.translatable("gui.purechaos.cheat_gui.button_do_not_press"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CheatGUIButtonMessage(2, x, y, z));
				CheatGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 42, this.topPos + 129, 88, 20).build();
		guistate.put("button:button_do_not_press", button_do_not_press);
		this.addRenderableWidget(button_do_not_press);
	}
}
