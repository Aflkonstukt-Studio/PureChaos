
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.client.model.Modelvikkivuk_plushie;
import xyz.aflkonstukt.purechaos.client.model.Modeltrident;
import xyz.aflkonstukt.purechaos.client.model.Modeltpose_smth;
import xyz.aflkonstukt.purechaos.client.model.Modelthe_rock;
import xyz.aflkonstukt.purechaos.client.model.Modelstroater;
import xyz.aflkonstukt.purechaos.client.model.Modelspongebob_boss;
import xyz.aflkonstukt.purechaos.client.model.Modelsplank;
import xyz.aflkonstukt.purechaos.client.model.Modelshep;
import xyz.aflkonstukt.purechaos.client.model.Modelpensive_cube;
import xyz.aflkonstukt.purechaos.client.model.Modelnextbot;
import xyz.aflkonstukt.purechaos.client.model.Modelmoth;
import xyz.aflkonstukt.purechaos.client.model.Modellong_leg_chicken;
import xyz.aflkonstukt.purechaos.client.model.Modellegs;
import xyz.aflkonstukt.purechaos.client.model.Modeljosipmmarket;
import xyz.aflkonstukt.purechaos.client.model.Modelikea_desk;
import xyz.aflkonstukt.purechaos.client.model.Modelgroggo;
import xyz.aflkonstukt.purechaos.client.model.Modelfish;
import xyz.aflkonstukt.purechaos.client.model.Modelfireflies;
import xyz.aflkonstukt.purechaos.client.model.Modeldog;
import xyz.aflkonstukt.purechaos.client.model.Modelcustom_model;
import xyz.aflkonstukt.purechaos.client.model.Modelcod_but_better;
import xyz.aflkonstukt.purechaos.client.model.Modelblaze;
import xyz.aflkonstukt.purechaos.client.model.Modelbaldi;
import xyz.aflkonstukt.purechaos.client.model.Modelamongus_woo;
import xyz.aflkonstukt.purechaos.client.model.Modelamiogyhus;
import xyz.aflkonstukt.purechaos.client.model.ModelCustomModel;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PurechaosModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelamiogyhus.LAYER_LOCATION, Modelamiogyhus::createBodyLayer);
		event.registerLayerDefinition(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
		event.registerLayerDefinition(Modelblaze.LAYER_LOCATION, Modelblaze::createBodyLayer);
		event.registerLayerDefinition(Modelikea_desk.LAYER_LOCATION, Modelikea_desk::createBodyLayer);
		event.registerLayerDefinition(Modelnextbot.LAYER_LOCATION, Modelnextbot::createBodyLayer);
		event.registerLayerDefinition(Modelshep.LAYER_LOCATION, Modelshep::createBodyLayer);
		event.registerLayerDefinition(Modelvikkivuk_plushie.LAYER_LOCATION, Modelvikkivuk_plushie::createBodyLayer);
		event.registerLayerDefinition(Modeltpose_smth.LAYER_LOCATION, Modeltpose_smth::createBodyLayer);
		event.registerLayerDefinition(Modeldog.LAYER_LOCATION, Modeldog::createBodyLayer);
		event.registerLayerDefinition(Modelfireflies.LAYER_LOCATION, Modelfireflies::createBodyLayer);
		event.registerLayerDefinition(Modelfish.LAYER_LOCATION, Modelfish::createBodyLayer);
		event.registerLayerDefinition(Modeltrident.LAYER_LOCATION, Modeltrident::createBodyLayer);
		event.registerLayerDefinition(Modelbaldi.LAYER_LOCATION, Modelbaldi::createBodyLayer);
		event.registerLayerDefinition(Modelstroater.LAYER_LOCATION, Modelstroater::createBodyLayer);
		event.registerLayerDefinition(Modelmoth.LAYER_LOCATION, Modelmoth::createBodyLayer);
		event.registerLayerDefinition(Modelgroggo.LAYER_LOCATION, Modelgroggo::createBodyLayer);
		event.registerLayerDefinition(Modelspongebob_boss.LAYER_LOCATION, Modelspongebob_boss::createBodyLayer);
		event.registerLayerDefinition(Modelcustom_model.LAYER_LOCATION, Modelcustom_model::createBodyLayer);
		event.registerLayerDefinition(Modelamongus_woo.LAYER_LOCATION, Modelamongus_woo::createBodyLayer);
		event.registerLayerDefinition(Modelsplank.LAYER_LOCATION, Modelsplank::createBodyLayer);
		event.registerLayerDefinition(Modelthe_rock.LAYER_LOCATION, Modelthe_rock::createBodyLayer);
		event.registerLayerDefinition(Modeljosipmmarket.LAYER_LOCATION, Modeljosipmmarket::createBodyLayer);
		event.registerLayerDefinition(Modellong_leg_chicken.LAYER_LOCATION, Modellong_leg_chicken::createBodyLayer);
		event.registerLayerDefinition(Modelcod_but_better.LAYER_LOCATION, Modelcod_but_better::createBodyLayer);
		event.registerLayerDefinition(Modellegs.LAYER_LOCATION, Modellegs::createBodyLayer);
		event.registerLayerDefinition(Modelpensive_cube.LAYER_LOCATION, Modelpensive_cube::createBodyLayer);
	}
}
