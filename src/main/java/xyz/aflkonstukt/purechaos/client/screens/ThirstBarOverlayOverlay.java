
package xyz.aflkonstukt.purechaos.client.screens;

import xyz.aflkonstukt.purechaos.procedures.ShowThirstBarProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst9HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst9FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst8HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst8FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst7HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst7FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst6HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst6FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst5HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst5FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst4HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst4FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst3HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst3FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst2HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst2FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst1HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst1FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst10HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowThirst10FullProcedure;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ThirstBarOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (ShowThirstBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_empty.png"), w / 2 + 9, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirstBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_empty.png"), w / 2 + 17, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirstBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_empty.png"), w / 2 + 25, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirstBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_empty.png"), w / 2 + 33, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirstBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_empty.png"), w / 2 + 41, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirstBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_empty.png"), w / 2 + 49, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirstBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_empty.png"), w / 2 + 57, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirstBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_empty.png"), w / 2 + 65, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirstBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_empty.png"), w / 2 + 73, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirstBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_empty.png"), w / 2 + 81, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst10FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_full.png"), w / 2 + 9, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst9FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_full.png"), w / 2 + 17, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst8FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_full.png"), w / 2 + 25, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst7FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_full.png"), w / 2 + 33, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst6FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_full.png"), w / 2 + 41, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst5FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_full.png"), w / 2 + 49, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst4FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_full.png"), w / 2 + 57, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst3FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_full.png"), w / 2 + 65, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst2FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_full.png"), w / 2 + 73, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst1FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_full.png"), w / 2 + 81, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst10HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_half.png"), w / 2 + 9, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst9HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_half.png"), w / 2 + 17, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst8HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_half.png"), w / 2 + 25, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst7HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_half.png"), w / 2 + 33, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst6HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_half.png"), w / 2 + 41, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst5HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_half.png"), w / 2 + 49, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst4HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_half.png"), w / 2 + 57, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst3HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_half.png"), w / 2 + 65, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst2HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_half.png"), w / 2 + 73, h - 49, 0, 0, 9, 9, 9, 9);
			}
			if (ShowThirst1HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/thirst_half.png"), w / 2 + 81, h - 49, 0, 0, 9, 9, 9, 9);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
