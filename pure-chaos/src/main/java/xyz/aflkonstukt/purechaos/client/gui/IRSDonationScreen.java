package xyz.aflkonstukt.purechaos.client.gui;

import xyz.aflkonstukt.purechaos.world.inventory.IRSDonationMenu;
import xyz.aflkonstukt.purechaos.network.IRSDonationButtonMessage;

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

public class IRSDonationScreen extends AbstractContainerScreen<IRSDonationMenu> {
	private final static HashMap<String, Object> guistate = IRSDonationMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;

	public IRSDonationScreen(IRSDonationMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("purechaos:textures/screens/irs_donation.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.irs_donation.label_welcome_to_the_irs_idis"), 26, 14, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.purechaos.irs_donation.button_empty"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new IRSDonationButtonMessage(0, x, y, z));
				IRSDonationButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 56, 161, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
