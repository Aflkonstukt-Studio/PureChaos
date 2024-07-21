package xyz.aflkonstukt.purechaos.client.gui;

import xyz.aflkonstukt.purechaos.world.inventory.CaptchaGUIMenu;
import xyz.aflkonstukt.purechaos.procedures.GetCaptchaGUITextProcedure;
import xyz.aflkonstukt.purechaos.network.CaptchaGUIButtonMessage;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CaptchaGUIScreen extends AbstractContainerScreen<CaptchaGUIMenu> {
	private final static HashMap<String, Object> guistate = CaptchaGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox answer;
	Button button_empty;

	public CaptchaGUIScreen(CaptchaGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 192;
		this.imageHeight = 80;
	}

	public static HashMap<String, String> getEditBoxAndCheckBoxValues() {
		HashMap<String, String> textstate = new HashMap<>();
		if (Minecraft.getInstance().screen instanceof CaptchaGUIScreen sc) {
			textstate.put("textin:answer", sc.answer.getValue());

		}
		return textstate;
	}

	private static final ResourceLocation texture = new ResourceLocation("purechaos:textures/screens/captcha_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		answer.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (answer.isFocused())
			return answer.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String answerValue = answer.getValue();
		super.resize(minecraft, width, height);
		answer.setValue(answerValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				GetCaptchaGUITextProcedure.execute(entity), 12, 11, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		answer = new EditBox(this.font, this.leftPos + 12, this.topPos + 26, 118, 18, Component.translatable("gui.purechaos.captcha_gui.answer")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.purechaos.captcha_gui.answer").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.purechaos.captcha_gui.answer").getString());
				else
					setSuggestion(null);
			}
		};
		answer.setMaxLength(32767);
		answer.setSuggestion(Component.translatable("gui.purechaos.captcha_gui.answer").getString());
		guistate.put("text:answer", answer);
		this.addWidget(this.answer);
		button_empty = Button.builder(Component.translatable("gui.purechaos.captcha_gui.button_empty"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CaptchaGUIButtonMessage(0, x, y, z, getEditBoxAndCheckBoxValues()));
				CaptchaGUIButtonMessage.handleButtonAction(entity, 0, x, y, z, getEditBoxAndCheckBoxValues());
			}
		}).bounds(this.leftPos + 11, this.topPos + 49, 119, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
