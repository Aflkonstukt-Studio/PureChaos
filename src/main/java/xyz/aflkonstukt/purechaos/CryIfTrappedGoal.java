/*
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside xyz.aflkonstukt.purechaos as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package xyz.aflkonstukt.purechaos;

import net.minecraft.world.entity.ai.goal.Goal;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;
import xyz.aflkonstukt.purechaos.entity.BuddyEntity;
import xyz.aflkonstukt.purechaos.init.PurechaosModSounds;

import java.util.EnumSet;

public class CryIfTrappedGoal extends Goal {
	private final BuddyEntity buddy;

	public CryIfTrappedGoal(BuddyEntity buddy) {
		this.buddy = buddy;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	@Override
	public boolean canUse() {
		// If Buddy is idle or stuck, make it cry
		return buddy.getNavigation().isDone();
	}

	@Override
	public void start() {
		// Play a crying sound or emit particles
		buddy.level().playSound(null, buddy.blockPosition(), PurechaosModSounds.GIRL_SCREAMING.get(),
				net.minecraft.sounds.SoundSource.NEUTRAL, 1.0f, 1.0f);
	}
}

