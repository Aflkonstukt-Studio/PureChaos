
package xyz.aflkonstukt.purechaos.client.screens;

import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer9Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer8Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer7Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer6Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer5Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer4Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer3Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer2Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer1Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer12Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer11Procedure;
import xyz.aflkonstukt.purechaos.procedures.ShowSpeedometer10Procedure;

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
public class SpeedometerOverlayOverlay {
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
			if (ShowSpeedometer1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_0.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_1.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_2.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_3.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_4.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_5.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_6.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_7.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_8.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_9.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_10.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
			if (ShowSpeedometer12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/speedometer_11.png"), w / 2 + -110, h - 19, 0, 0, 15, 15, 15, 15);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
