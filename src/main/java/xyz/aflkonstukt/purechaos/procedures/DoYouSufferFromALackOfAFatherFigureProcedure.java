package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DoYouSufferFromALackOfAFatherFigureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
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
					_entity.addEffect(new MobEffectInstance(PurechaosModMobEffects.CURSE_OF_FATHERLESS.get(), 999999999, 1, false, false));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @e[type=!minecraft:player ] at @s run tp @s ~ ~ ~ facing entity @p[distance=..16]");
			}
		}
	}
}
