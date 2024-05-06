/**
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

import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = "purechaos", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MeteorHandler {
    private static final List<Meteor> meteors = new ArrayList<>();
    private static final Random random = new Random();
    private static final int METEOR_CHANCE = 100;
    private static final int MAX_BLAST_RADIUS = 80;
    private static long lastMeteorTime = 0;
    private static final long METEOR_COOLDOWN = 15 * 60; // 15 minutes
    private static final int METEOR_TIME = 5 * 60; // 5 minutes
    private static int METEOR_ANNOUNCMENT_COOLDOWN = 0;
    private static long lastUpdate = System.currentTimeMillis();

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdate < 1000) return;
        lastUpdate = currentTime;

        if (!meteors.isEmpty()) {
            Meteor meteor = meteors.get(0);

            meteor.timeUntilImpact--;
            if (meteor.timeUntilImpact <= 10) {
                if (METEOR_ANNOUNCMENT_COOLDOWN == 0) {
                    announceMeteor(meteor, meteor.timeUntilImpact + "s");
                    METEOR_ANNOUNCMENT_COOLDOWN = 1;
                } else {
                    METEOR_ANNOUNCMENT_COOLDOWN--;
                }
            }

            if (meteor.timeUntilImpact < 1) {
                meteor.world.explode(null, meteor.position.getX(), meteor.position.getY(), meteor.position.getZ(), meteor.blastRadius, Level.ExplosionInteraction.BLOCK);
                meteors.remove(0);
            }
        } else {
            if (random.nextInt(METEOR_CHANCE) == 0 && lastMeteorTime - METEOR_COOLDOWN < currentTime) {
                if (event.getServer().getPlayerList().getPlayers().size() == 1) {
                    generateMeteor((ServerLevel) event.getServer().getPlayerList().getPlayers().get(0).level());
                } else if (event.getServer().getPlayerList().getPlayers().size() > 1) {
                    generateMeteor((ServerLevel) event.getServer().getPlayerList().getPlayers().get(random.nextInt(event.getServer().getPlayerList().getPlayers().size())).level());
                }
                lastMeteorTime = currentTime;
            }
        }
    }

    private static void generateMeteor(ServerLevel world) {
        Entity potentialTarget = findMeteorTarget(world);
        if (potentialTarget != null) {
            BlockPos targetPos = potentialTarget.blockPosition().offset(randomOffset(), 100, randomOffset());
            targetPos = findGroundPosition(world, targetPos);
            int blastRadius = random.nextInt(25, MAX_BLAST_RADIUS);

            Meteor meteor = new Meteor(targetPos, blastRadius, METEOR_TIME, world);
            meteors.add(meteor);
            announceMeteor(meteor, METEOR_TIME / 60 + " minutes");
            lastMeteorTime = System.currentTimeMillis();
        }
    }

    private static void announceMeteor(Meteor meteor, String timeRemaining) {
        for (ServerPlayer player : meteor.world.players()) {
            BlockPos pos = meteor.position;
            Component component = Component.literal(Arrays.toString(new Object[]{pos.getX(),pos.getY(), pos.getZ()})).withStyle((p_214489_) -> p_214489_.withColor(ChatFormatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " +  pos.getX() + " " + pos.getY() + " " +  pos.getZ())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("chat.coordinates.tooltip"))));

            player.sendSystemMessage(Component.literal("Meteor inbound at: ").append(component).append(Component.literal(", blast radius: " + meteor.blastRadius + ". Impact in " + timeRemaining)).withStyle(ChatFormatting.RED));
        }
    }

    private static BlockPos findGroundPosition(Level world, BlockPos startPos) {
        int y = world.getMaxBuildHeight();
        while (y > 0) {
            BlockPos pos = new BlockPos(startPos.getX(), y, startPos.getZ());
            if (!world.getBlockState(pos).isAir()) {
                return pos; // Return the first non-air block from the top
            }
            y--;
        }
        return startPos; // Return the original position if no non-air block is found
    }

    private static int randomOffset() {
        return random.nextInt(100) - 50;
    }

    private static Entity findMeteorTarget(ServerLevel world) {
        List<Entity> nearbyPlayers = world.getEntities((Entity) null, new AABB(0 , 0, 0, world.getMaxBuildHeight(), world.getMaxBuildHeight(), world.getMaxBuildHeight()), Entity::isAlive);
        if (nearbyPlayers.isEmpty()) return null;
        return nearbyPlayers.get(random.nextInt(nearbyPlayers.size()));
    }

    public static void ManualSpawnMeteor(ServerLevel world, Player player) {
        if (meteors.isEmpty()) {
            generateMeteor(world);
        } else {
            BlockPos pos = meteors.get(0).position;
            Component component = Component.literal(Arrays.toString(new Object[]{pos.getX(),pos.getY(), pos.getZ()})).withStyle((p_214489_) -> p_214489_.withColor(ChatFormatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " +  pos.getX() + " " + pos.getY() + " " +  pos.getZ())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("chat.coordinates.tooltip"))));

            player.sendSystemMessage(Component.literal("Meteor already inbound at: ").append(component).append(Component.literal(", blast radius: " + meteors.get(0).blastRadius + ". Impact in " + meteors.get(0).timeUntilImpact + "s")).withStyle(ChatFormatting.RED));
        }
    }
}
