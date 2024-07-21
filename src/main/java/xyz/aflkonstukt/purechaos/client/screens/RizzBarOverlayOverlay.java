
package xyz.aflkonstukt.purechaos.client.screens;

import xyz.aflkonstukt.purechaos.procedures.ShowRizzBarProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzHalf6DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzHalf5DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzHalf4DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzHalf3DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzHalf2DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzHalf1DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzFull6DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzFull5DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzFull4DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzFull3DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzFull2DisplayProcedure;
import xyz.aflkonstukt.purechaos.procedures.RizzFull1DisplayProcedure;

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
public class RizzBarOverlayOverlay {
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
			if (ShowRizzBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_empty.png"), w / 2 + 93, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (ShowRizzBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_empty.png"), w / 2 + 103, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (ShowRizzBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_empty.png"), w / 2 + 113, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (ShowRizzBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_empty.png"), w / 2 + 123, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (ShowRizzBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_empty.png"), w / 2 + 133, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (ShowRizzBarProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_empty.png"), w / 2 + 143, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzFull1DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_full.png"), w / 2 + 93, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzFull2DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_full.png"), w / 2 + 103, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzFull3DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_full.png"), w / 2 + 113, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzFull4DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_full.png"), w / 2 + 123, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzFull5DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_full.png"), w / 2 + 133, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzFull6DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_full.png"), w / 2 + 143, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzHalf1DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_half.png"), w / 2 + 93, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzHalf2DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_half.png"), w / 2 + 103, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzHalf3DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_half.png"), w / 2 + 113, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzHalf4DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_half.png"), w / 2 + 123, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzHalf5DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_half.png"), w / 2 + 133, h - 33, 0, 0, 9, 9, 9, 9);
			}
			if (RizzHalf6DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/rizz_half.png"), w / 2 + 143, h - 33, 0, 0, 9, 9, 9, 9);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
