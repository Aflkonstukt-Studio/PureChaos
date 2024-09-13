
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.client.particle.YippeParticleParticle;
import xyz.aflkonstukt.purechaos.client.particle.CumDripParticle;
import xyz.aflkonstukt.purechaos.client.particle.CoughParticleParticle;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PurechaosModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(PurechaosModParticleTypes.CUM_DRIP.get(), CumDripParticle::provider);
		event.registerSpriteSet(PurechaosModParticleTypes.YIPPE_PARTICLE.get(), YippeParticleParticle::provider);
		event.registerSpriteSet(PurechaosModParticleTypes.COUGH_PARTICLE.get(), CoughParticleParticle::provider);
	}
}
