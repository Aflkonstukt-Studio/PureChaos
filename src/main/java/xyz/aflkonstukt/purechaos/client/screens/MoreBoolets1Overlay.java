
package xyz.aflkonstukt.purechaos.client.screens;

import xyz.aflkonstukt.purechaos.procedures.MoreBoolets1DisplayOverlayIngame2Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow9Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow8Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow7Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow6Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow5Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow4Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow3Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow2Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow1Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow12Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow11Procedure;
import xyz.aflkonstukt.purechaos.procedures.BooletsShow10Procedure;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class MoreBoolets1Overlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
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
		if (MoreBoolets1DisplayOverlayIngame2Procedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/shadow.png"), 0, 0, 0, 0, w, h, w, h);
			if (BooletsShow1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-0.png"), w / 2 + -56, h / 2 + -101, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-1.png"), w / 2 + -55, h / 2 + -100, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-10.png"), w / 2 + -55, h / 2 + -100, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-11.png"), w / 2 + -55, h / 2 + -100, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-2.png"), w / 2 + -55, h / 2 + -100, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-3.png"), w / 2 + -55, h / 2 + -99, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-4.png"), w / 2 + -55, h / 2 + -100, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-5.png"), w / 2 + -56, h / 2 + -101, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-8.png"), w / 2 + -56, h / 2 + -101, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-7.png"), w / 2 + -56, h / 2 + -102, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-8.png"), w / 2 + -56, h / 2 + -102, 0, 0, 110, 199, 110, 199);
			}
			if (BooletsShow12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/ac3db2de601a410eec253f65bf069dc6obpifm8uxmg9rjte-9.png"), w / 2 + -56, h / 2 + -103, 0, 0, 110, 199, 110, 199);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
