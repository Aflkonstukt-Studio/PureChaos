
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.client.renderer.WalterWightRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.VikkivukRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.TridentRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.SplankRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.ShepRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.MothOfAggrevationRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.JosipdvatockanulaRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.JosipPettRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.JosipPetRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.JOSIPRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.IkeaDeskRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.DreamRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.CursedDogRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.CodButBetterRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.BlazRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.AmongUsRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.Amogus3Renderer;
import xyz.vikkivuk.chaosmod.client.renderer.Amogus2Renderer;
import xyz.vikkivuk.chaosmod.client.renderer.AentityRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.AdolfHitlerRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ChaosmodModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ChaosmodModEntities.DEEK.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.AENTITY.get(), AentityRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.TRIDENT.get(), TridentRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.AMONG_US.get(), AmongUsRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.AMOGUS_2.get(), Amogus2Renderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.AMOGUS_3.get(), Amogus3Renderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.KONDOMNEPITAJZASTOOVORADIMALISPOILERALERTONIMARUPU.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.WATER_CUP.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.SPLANK.get(), SplankRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.IKEA_DESK.get(), IkeaDeskRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.JOSIP.get(), JOSIPRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.JOSIPDVATOCKANULA.get(), JosipdvatockanulaRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.JOSIP_PET.get(), JosipPetRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.JOSIP_PETT.get(), JosipPettRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.JOSIP_RANGE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.MOTH_OF_AGGREVATION.get(), MothOfAggrevationRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.AK_47.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.CURSED_DOG.get(), CursedDogRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.BLAZ.get(), BlazRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.SHEP.get(), ShepRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.VIKKIVUK.get(), VikkivukRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.DREAM.get(), DreamRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.ADOLF_HITLER.get(), AdolfHitlerRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.WALTER_WIGHT.get(), WalterWightRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.COD_BUT_BETTER.get(), CodButBetterRenderer::new);
	}
}
