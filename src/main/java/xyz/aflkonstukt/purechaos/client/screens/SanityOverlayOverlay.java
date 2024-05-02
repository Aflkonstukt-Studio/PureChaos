
package xyz.aflkonstukt.purechaos.client.screens;

import xyz.aflkonstukt.purechaos.procedures.ShowSanityLabelProcedure;
import xyz.aflkonstukt.purechaos.procedures.Show75SanityProcedure;
import xyz.aflkonstukt.purechaos.procedures.Show50SanityProcedure;
import xyz.aflkonstukt.purechaos.procedures.Show25SanityProcedure;
import xyz.aflkonstukt.purechaos.procedures.Show100SanityProcedure;
import xyz.aflkonstukt.purechaos.procedures.SanityOverlayValueProcedure;

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
public class SanityOverlayOverlay {
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
			if (Show100SanityProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/sanity100.png"), w - 70, h - 61, 0, 0, 52, 52, 52, 52);
			}
			if (Show75SanityProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/sanity75.png"), w - 70, h - 61, 0, 0, 52, 52, 52, 52);
			}
			if (Show50SanityProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/sanity50.png"), w - 70, h - 61, 0, 0, 52, 52, 52, 52);
			}
			if (Show25SanityProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("purechaos:textures/screens/sanity25.png"), w - 70, h - 61, 0, 0, 52, 52, 52, 52);
			}
			if (ShowSanityLabelProcedure.execute())
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						SanityOverlayValueProcedure.execute(entity), 6, 8, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
