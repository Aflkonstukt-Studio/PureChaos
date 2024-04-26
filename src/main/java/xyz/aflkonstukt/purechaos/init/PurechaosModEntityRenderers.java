
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.client.renderer.WalterWightRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.VikkivukRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.TridentRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.TheRockRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.TechnobladeRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.TPoseEntityRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.StroaterRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.StalinRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.SpongebobBossRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.SplankRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.ShepRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.RickAstleyRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.PensiveCubeRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.NerdRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.MuricaRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.MothOfAggrevationRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.LongLegChickenRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.LegsRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.JosipdvatockanulaRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.JosipPettRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.JosipPetRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.JOSIPRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.IkeaDeskRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.IRSRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.HerobrineRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.GroggoRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.FireflyRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.FBIRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.DreamRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.CursedDogRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.CupcakkeRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.CodButBetterRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.BlazRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.BigRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.BaldiMinusRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.AmongUsRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.Amogus3Renderer;
import xyz.aflkonstukt.purechaos.client.renderer.Amogus2Renderer;
import xyz.aflkonstukt.purechaos.client.renderer.AmericanSoldatRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.AentityRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.AdolfHitlerRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.AMOGUS3GRINRenderer;
import xyz.aflkonstukt.purechaos.client.renderer.AMOGUS3BLURenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PurechaosModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PurechaosModEntities.AENTITY.get(), AentityRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.TRIDENT.get(), TridentRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.AMONG_US.get(), AmongUsRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.AMOGUS_2.get(), Amogus2Renderer::new);
		event.registerEntityRenderer(PurechaosModEntities.AMOGUS_3.get(), Amogus3Renderer::new);
		event.registerEntityRenderer(PurechaosModEntities.SPLANK.get(), SplankRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.IKEA_DESK.get(), IkeaDeskRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.JOSIP.get(), JOSIPRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.JOSIPDVATOCKANULA.get(), JosipdvatockanulaRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.JOSIP_PET.get(), JosipPetRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.JOSIP_PETT.get(), JosipPettRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.MOTH_OF_AGGREVATION.get(), MothOfAggrevationRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.SHEP.get(), ShepRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.VIKKIVUK.get(), VikkivukRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.BLAZ.get(), BlazRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.CURSED_DOG.get(), CursedDogRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.WALTER_WIGHT.get(), WalterWightRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.ADOLF_HITLER.get(), AdolfHitlerRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.DREAM.get(), DreamRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.COD_BUT_BETTER.get(), CodButBetterRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.STALIN.get(), StalinRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.RICK_ASTLEY.get(), RickAstleyRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.LEGS.get(), LegsRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.LONG_LEG_CHICKEN.get(), LongLegChickenRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.FIREFLY.get(), FireflyRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.T_POSE_ENTITY.get(), TPoseEntityRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.STROATER.get(), StroaterRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.SPONGEBOB_BOSS.get(), SpongebobBossRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.AMOGUS_3_BLU.get(), AMOGUS3BLURenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.AMOGUS_3_GRIN.get(), AMOGUS3GRINRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.THE_ROCK.get(), TheRockRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.BIG.get(), BigRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.TECHNOBLADE.get(), TechnobladeRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.CUPCAKKE.get(), CupcakkeRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.BALDI_MINUS.get(), BaldiMinusRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.HEROBRINE.get(), HerobrineRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.NERD.get(), NerdRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.IRS.get(), IRSRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.FBI.get(), FBIRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.AMERICAN_SOLDAT.get(), AmericanSoldatRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.MURICA.get(), MuricaRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.DEEK_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.KONDOMNEPITAJZASTOOVORADIMALISPOILERALERTONIMARUPU_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.WATER_CUP_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.JOSIP_RANGE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.AK_47_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.AMOGUS_GUN_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.ROCK_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.JAVELIN_LAUNCHER_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.PENSIVE_CUBE.get(), PensiveCubeRenderer::new);
		event.registerEntityRenderer(PurechaosModEntities.GROGGO.get(), GroggoRenderer::new);
	}
}
