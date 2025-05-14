package xyz.aflkonstukt.purechaos.client.gui;

import xyz.aflkonstukt.purechaos.world.inventory.JGWarningMenu;
import xyz.aflkonstukt.purechaos.network.JGWarningButtonMessage;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class JGWarningScreen extends AbstractContainerScreen<JGWarningMenu> {
	private final static HashMap<String, Object> guistate = JGWarningMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;

	public JGWarningScreen(JGWarningMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 403;
		this.imageHeight = 189;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

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
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.jg_warning.label_this_is_your_last_warning"), 120, 18, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.jg_warning.label_judgment_day_will_very_likely"), 89, 33, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.jg_warning.label_melt_your_pc"), 239, 33, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.jg_warning.label_once_its_over"), 103, 47, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.jg_warning.label_this_world_will_be_unplayable"), 180, 47, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.jg_warning.label_important_epilepsy_warning"), 30, 88, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.jg_warning.label_this_event_contains_intense_flas"), 30, 102, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.jg_warning.label_screen_effects_and_extreme_chao"), 30, 113, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.purechaos.jg_warning.label_if_you_are_sensitive_to_these_w"), 31, 132, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.purechaos.jg_warning.button_empty"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new JGWarningButtonMessage(0, x, y, z));
				JGWarningButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 31, this.topPos + 160, 161, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.purechaos.jg_warning.button_empty1"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new JGWarningButtonMessage(1, x, y, z));
				JGWarningButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 224, this.topPos + 160, 161, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
