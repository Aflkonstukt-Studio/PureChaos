package xyz.aflkonstukt.purechaos.client.gui;

import xyz.aflkonstukt.purechaos.world.inventory.AdGUIMenu;
import xyz.aflkonstukt.purechaos.procedures.ShowMelatoninADImageProcedure;

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

public class AdGUIScreen extends AbstractContainerScreen<AdGUIMenu> {
	private final static HashMap<String, Object> guistate = AdGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_x;
	Button button_gimme_it;

	public AdGUIScreen(AdGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 180;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		if (ShowMelatoninADImageProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("purechaos:textures/screens/melatonin.png"), this.leftPos + 26, this.topPos + 27, 0, 0, 256, 128, 256, 128);
		}
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
	}

	@Override
	public void init() {
		super.init();
		button_x = Button.builder(Component.translatable("gui.purechaos.ad_gui.button_x"), e -> {
		}).bounds(this.leftPos + 252, this.topPos + 26, 30, 20).build();
		guistate.put("button:button_x", button_x);
		this.addRenderableWidget(button_x);
		button_gimme_it = Button.builder(Component.translatable("gui.purechaos.ad_gui.button_gimme_it"), e -> {
		}).bounds(this.leftPos + 121, this.topPos + 123, 66, 20).build();
		guistate.put("button:button_gimme_it", button_gimme_it);
		this.addRenderableWidget(button_gimme_it);
	}
}
