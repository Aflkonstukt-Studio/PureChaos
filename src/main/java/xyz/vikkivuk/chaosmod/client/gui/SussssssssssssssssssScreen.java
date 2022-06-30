
package xyz.vikkivuk.chaosmod.client.gui;

import xyz.vikkivuk.chaosmod.world.inventory.SussssssssssssssssssMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class SussssssssssssssssssScreen extends AbstractContainerScreen<SussssssssssssssssssMenu> {
	private final static HashMap<String, Object> guistate = SussssssssssssssssssMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public SussssssssssssssssssScreen(SussssssssssssssssssMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("chaosmod:textures/sussssssssssssssssss.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("chaosmod:textures/rick_kurac.png"));
		this.blit(ms, this.leftPos + -261, this.topPos + -63, 0, 0, 660, 371, 660, 371);

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
		this.font.draw(poseStack, "ur sus", 266, -27, -12829636);
		this.font.draw(poseStack, "welcom to marketplace", 49, 10, -12829636);
		this.font.draw(poseStack, "your soul", 15, 44, -12829636);
		this.font.draw(poseStack, "mcdonalds fries", 84, 45, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 17, this.topPos + 59, 40, 20, new TextComponent("no"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 105, this.topPos + 62, 40, 20, new TextComponent("buy"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + -94, this.topPos + 5, 51, 20, new TextComponent("exit"), e -> {
		}));
	}
}
