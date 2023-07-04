
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.client.model.Modelvikkivuk_plushie;
import xyz.vikkivuk.chaosmod.client.model.Modeltrident;
import xyz.vikkivuk.chaosmod.client.model.Modeltpose_smth;
import xyz.vikkivuk.chaosmod.client.model.Modelthe_rock;
import xyz.vikkivuk.chaosmod.client.model.Modelstroater;
import xyz.vikkivuk.chaosmod.client.model.Modelspongebob_boss;
import xyz.vikkivuk.chaosmod.client.model.Modelsplank;
import xyz.vikkivuk.chaosmod.client.model.Modelshep;
import xyz.vikkivuk.chaosmod.client.model.Modelpensive_cube;
import xyz.vikkivuk.chaosmod.client.model.Modelnextbot;
import xyz.vikkivuk.chaosmod.client.model.Modelmoth;
import xyz.vikkivuk.chaosmod.client.model.Modellong_leg_chicken;
import xyz.vikkivuk.chaosmod.client.model.Modellegs;
import xyz.vikkivuk.chaosmod.client.model.Modeljosipmmarket;
import xyz.vikkivuk.chaosmod.client.model.Modelikea_desk;
import xyz.vikkivuk.chaosmod.client.model.Modelfireflies;
import xyz.vikkivuk.chaosmod.client.model.Modeldog;
import xyz.vikkivuk.chaosmod.client.model.Modelcustom_model;
import xyz.vikkivuk.chaosmod.client.model.Modelcod_but_better;
import xyz.vikkivuk.chaosmod.client.model.Modelblaze;
import xyz.vikkivuk.chaosmod.client.model.Modelbaldi;
import xyz.vikkivuk.chaosmod.client.model.Modelamongus_woo;
import xyz.vikkivuk.chaosmod.client.model.Modelamiogyhus;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ChaosmodModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelamiogyhus.LAYER_LOCATION, Modelamiogyhus::createBodyLayer);
		event.registerLayerDefinition(Modelblaze.LAYER_LOCATION, Modelblaze::createBodyLayer);
		event.registerLayerDefinition(Modelikea_desk.LAYER_LOCATION, Modelikea_desk::createBodyLayer);
		event.registerLayerDefinition(Modelnextbot.LAYER_LOCATION, Modelnextbot::createBodyLayer);
		event.registerLayerDefinition(Modelshep.LAYER_LOCATION, Modelshep::createBodyLayer);
		event.registerLayerDefinition(Modelvikkivuk_plushie.LAYER_LOCATION, Modelvikkivuk_plushie::createBodyLayer);
		event.registerLayerDefinition(Modeltpose_smth.LAYER_LOCATION, Modeltpose_smth::createBodyLayer);
		event.registerLayerDefinition(Modeldog.LAYER_LOCATION, Modeldog::createBodyLayer);
		event.registerLayerDefinition(Modelfireflies.LAYER_LOCATION, Modelfireflies::createBodyLayer);
		event.registerLayerDefinition(Modeltrident.LAYER_LOCATION, Modeltrident::createBodyLayer);
		event.registerLayerDefinition(Modelbaldi.LAYER_LOCATION, Modelbaldi::createBodyLayer);
		event.registerLayerDefinition(Modelstroater.LAYER_LOCATION, Modelstroater::createBodyLayer);
		event.registerLayerDefinition(Modelmoth.LAYER_LOCATION, Modelmoth::createBodyLayer);
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
