package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.entity.PensiveCubeEntity;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

@Mod.EventBusSubscriber
public class EntityAnimationFactory {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		if (event != null && event.getEntity() != null) {
			if (event.getEntity() instanceof PensiveCubeEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
		}
	}
}
