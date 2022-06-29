
package xyz.vikkivuk.chaosmod.client.gui;

import xyz.vikkivuk.chaosmod.world.inventory.WarningMenu;

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

public class WarningScreen extends AbstractContainerScreen<WarningMenu> {
	private final static HashMap<String, Object> guistate = WarningMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public WarningScreen(WarningMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 344;
		this.imageHeight = 162;
	}

	private static final ResourceLocation texture = new ResourceLocation("chaosmod:textures/warning.png");

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
		this.font.draw(poseStack, "!!! WARNING !!!", 133, 18, -65476);
		this.font.draw(poseStack, "It looks like you installed chaos mod (thanks for that btw)", 19, 41, -12829636);
		this.font.draw(poseStack, "and we just wanted to warn you that this mod can make the", 23, 59, -12829636);
		this.font.draw(poseStack, "world a bit, unstable (so to say). Please continue at your", 20, 78, -12829636);
		this.font.draw(poseStack, "own discretion and we arent responsible for any damage done", 18, 97, -12829636);
		this.font.draw(poseStack, "Thanks for the understanding !!!", 90, 122, -16730369);
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
		this.addRenderableWidget(new Button(this.leftPos + 279, this.topPos + 130, 51, 20, new TextComponent("Close"), e -> {
		}));
	}
}
