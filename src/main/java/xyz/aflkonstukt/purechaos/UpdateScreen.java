/*
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside xyz.aflkonstukt.purechaos as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package xyz.aflkonstukt.purechaos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.ErrorScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public class UpdateScreen extends Screen {
	private final String pcVersion;
	private final String mcVersion;
	private Button.OnPress backAction = button -> {
		assert this.minecraft != null;
		this.minecraft.setScreen(new TitleScreen());
	};

	public UpdateScreen(String pcVersion, String mcVersion) {
		super(Component.literal("Pure Chaos is outdated!"));
		this.pcVersion = pcVersion;
		this.mcVersion = mcVersion;
	}

	static boolean shownScreen = false;
	@SubscribeEvent
	static void screenEvent(ScreenEvent.Init.Post event) {
		if (!(event.getScreen() instanceof TitleScreen)) return;
		if (shownScreen) return;
		shownScreen = true;
		try {
			// Send the request
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet("https://pastebin.com/raw/rTQuWtMg");

			// Get the response
			String responseString = EntityUtils.toString(httpclient.execute(httpget).getEntity());

			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(responseString));
			JsonObject data = gson.fromJson(reader, JsonObject.class);
			System.out.println(data);
			if (!data.get("latest").getAsString().equals("PC2025")) {
				String latestMCVersion = data.get("mcv").getAsString();
				String latestPCVersion = data.get("latest").getAsString();
				PurechaosModVariables.outdated = true;

				Minecraft.getInstance().setScreen(new UpdateScreen(latestPCVersion, latestMCVersion));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void init() {
		super.init();
		this.addRenderableWidget(new Button.Builder(Component.literal("I'll take my chances"), this.backAction).pos(this.width / 2 - 100, 200).width(200).build());
	}

	@Override
	public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
		this.renderPanorama(guiGraphics, partialTick);
		PoseStack poseStack = guiGraphics.pose();
		poseStack.pushPose();
		poseStack.scale(1.2F, 1.2F, 1.2F); // Adjust the scale as needed
		guiGraphics.drawCenteredString(this.font, Component.literal(ChatFormatting.YELLOW + "⚠ Pure Chaos is outdated! ⚠"), (int) ((double) this.width / 2 / 1.2), (int) (70 / 1.2), 16777215);
		guiGraphics.drawCenteredString(this.font, Component.literal("Stay outdated, and Buddy " + ChatFormatting.ITALIC + "will" + ChatFormatting.RESET + " jump off a cliff"), (int) ((double) this.width / 2 / 1.2), (int) (85 / 1.2), 16777215);
		guiGraphics.drawCenteredString(this.font, Component.literal("while Stalin " + ChatFormatting.ITALIC + "might" + ChatFormatting.RESET + " pay you a visit."), (int) ((double) this.width / 2 / 1.2), (int) (95 / 1.2), 16777215);
		guiGraphics.drawCenteredString(this.font, Component.literal("The latest version is " + ChatFormatting.AQUA + pcVersion + " on MC" + mcVersion), (int) ((double) this.width / 2 / 1.2), (int) (120 / 1.2), 16777215);
		guiGraphics.drawCenteredString(this.font, Component.literal("Don't say we didn't warn you."), (int) ((double) this.width / 2 / 1.2), (int) (132 / 1.2), 16777215);

		poseStack.popPose();
		super.render(guiGraphics, mouseX, mouseY, partialTick);
	}

	public boolean shouldCloseOnEsc() {return false;}

	public void renderBackground(GuiGraphics guiGraphics, int p_295208_, int p_294981_, float p_294740_) {}

	protected void renderPanorama(GuiGraphics guiGraphics, float p_331140_) {
		PANORAMA.render(guiGraphics, this.width, this.height, 1.0F, p_331140_);
	}
}
