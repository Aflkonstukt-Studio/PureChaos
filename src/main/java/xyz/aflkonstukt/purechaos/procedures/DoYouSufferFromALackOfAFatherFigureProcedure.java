package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DoYouSufferFromALackOfAFatherFigureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PurechaosModMobEffects.CURSE_OF_FATHERLESS.get()))) {
			if ((entity.getDisplayName().getString()).toLowerCase().contains("wolf") || (entity.getDisplayName().getString()).toLowerCase().contains("alpha") || (entity.getDisplayName().getString()).toLowerCase().contains("sigma")
					|| (entity.getDisplayName().getString()).toLowerCase().contains("daddy") || (entity.getDisplayName().getString()).toLowerCase().contains("mommy") || (entity.getDisplayName().getString()).toLowerCase().contains("xx")
					|| (entity.getDisplayName().getString()).toLowerCase().contains("notfound") || (entity.getDisplayName().getString()).toLowerCase().contains("dream") || (entity.getDisplayName().getString()).toLowerCase().contains("innit")
					|| (entity.getDisplayName().getString()).toLowerCase().contains("tlg") || (entity.getDisplayName().getString()).toLowerCase().contains("chan") || (entity.getDisplayName().getString()).toLowerCase().contains("kun")
					|| (entity.getDisplayName().getString()).toLowerCase().contains("senpai") || (entity.getDisplayName().getString()).toLowerCase().contains("slay") || (entity.getDisplayName().getString()).toLowerCase().contains("lone")
					|| (entity.getDisplayName().getString()).toLowerCase().contains("paw") || (entity.getDisplayName().getString()).toLowerCase().contains("playz") || (entity.getDisplayName().getString()).toLowerCase().contains("hax")
					|| (entity.getDisplayName().getString()).toLowerCase().contains("pookie") || (entity.getDisplayName().getString()).toLowerCase().contains("ttv") || (entity.getDisplayName().getString()).contains("USA")
					|| (entity.getDisplayName().getString()).toLowerCase().contains("20inch") || (entity.getDisplayName().getString()).toLowerCase().contains("gay") || (entity.getDisplayName().getString()).toLowerCase().contains("lesbian")
					|| (entity.getDisplayName().getString()).toLowerCase().contains("trans") || (entity.getDisplayName().getString()).toLowerCase().contains("lgbtq")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PurechaosModMobEffects.CURSE_OF_FATHERLESS.get(), 99999999999, 1, false, false));
			}
		}
	}
}
