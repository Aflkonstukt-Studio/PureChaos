
package xyz.aflkonstukt.purechaos.client.screens;

import xyz.aflkonstukt.purechaos.procedures.ShowHealthinessBarProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness9HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness9FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness8HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness8FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness7HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness7FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness6HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness6FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness5HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness5FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness4HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness4FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness3HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness3FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness2HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness2FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness1HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness1FullProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness10HalfProcedure;
import xyz.aflkonstukt.purechaos.procedures.ShowHealthiness10FullProcedure;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
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

@EventBusSubscriber({Dist.CLIENT})
public class HealthinessOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
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
			if (ShowHealthinessBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_empty.png"), w / 2 + 10, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthinessBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_empty.png"), w / 2 + 18, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthinessBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_empty.png"), w / 2 + 26, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthinessBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_empty.png"), w / 2 + 34, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthinessBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_empty.png"), w / 2 + 42, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthinessBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_empty.png"), w / 2 + 50, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthinessBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_empty.png"), w / 2 + 58, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthinessBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_empty.png"), w / 2 + 66, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthinessBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_empty.png"), w / 2 + 74, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthinessBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_empty.png"), w / 2 + 82, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness10FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_full.png"), w / 2 + 10, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness9FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_full.png"), w / 2 + 18, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness8FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_full.png"), w / 2 + 26, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness7FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_full.png"), w / 2 + 34, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness6FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_full.png"), w / 2 + 42, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness5FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_full.png"), w / 2 + 50, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness4FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_full.png"), w / 2 + 58, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness3FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_full.png"), w / 2 + 66, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness2FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_full.png"), w / 2 + 74, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness1FullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_full.png"), w / 2 + 82, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness10HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_half.png"), w / 2 + 10, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness9HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_half.png"), w / 2 + 18, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness8HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_half.png"), w / 2 + 26, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness7HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_half.png"), w / 2 + 34, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness6HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_half.png"), w / 2 + 42, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness5HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_half.png"), w / 2 + 50, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness4HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_half.png"), w / 2 + 58, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness3HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_half.png"), w / 2 + 66, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness2HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_half.png"), w / 2 + 74, h - 58, 0, 0, 7, 8, 7, 8);
			}
			if (ShowHealthiness1HalfProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("purechaos:textures/screens/healthiness_half.png"), w / 2 + 82, h - 58, 0, 0, 7, 8, 7, 8);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
