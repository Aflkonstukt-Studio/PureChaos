package xyz.aflkonstukt.purechaos.meteors;

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
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = "purechaos", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MeteorHandler {
    private static final List<Meteor> meteors = new ArrayList<>();
    private static final Random random = new Random();
    private static final int METEOR_CHANCE = 1000;
    private static final int MAX_BLAST_RADIUS = 50;
    private static long lastMeteorTime = 0;
    private static final long METEOR_COOLDOWN = 15 * 60 * 1000; // 10 minutes
    private static final int METEOR_TIME = 5 * 60 * 20; // 5 minutes
    private static int METEOR_ANNOUNCMENT_COOLDOWN = 0;

    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {
        if (event.level instanceof ClientLevel) return; // Don't run on client (dedicated server only)
        Level world = event.level;
        meteors.removeIf(meteor -> {
            if (event.level.getGameTime() % 20 != 0) return false;
            meteor.timeUntilImpact--;

            if (meteor.timeUntilImpact / 20 <= 20) {
                if (METEOR_ANNOUNCMENT_COOLDOWN == 0) {
                    announceMeteor(meteor, meteor.timeUntilImpact / 20 + "s");
                    METEOR_ANNOUNCMENT_COOLDOWN = 20;
                } else {
                    METEOR_ANNOUNCMENT_COOLDOWN--;
                }
            }

            if (meteor.timeUntilImpact / 20 <= 0) {
                triggerMeteorExplosion(world, meteor);
                return true;
            }
            return false;
        });
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (random.nextInt(METEOR_CHANCE) == 0 && System.currentTimeMillis() - lastMeteorTime >= METEOR_COOLDOWN) {
            if (meteors.isEmpty()) {
                if (event.getServer().getPlayerList().getPlayers().size() == 1) {
                    generateMeteor((ServerLevel) event.getServer().getPlayerList().getPlayers().get(0).level());
                } else if (event.getServer().getPlayerList().getPlayers().size() > 1) {
                    generateMeteor((ServerLevel) event.getServer().getPlayerList().getPlayers().get(random.nextInt(event.getServer().getPlayerList().getPlayers().size())).level());
                }
                lastMeteorTime = System.currentTimeMillis();
            }
        }
    }

    private static void generateMeteor(ServerLevel world) {
        Entity potentialTarget = findMeteorTarget(world);
        if (potentialTarget != null) {
            BlockPos targetPos = potentialTarget.blockPosition().offset(randomOffset(), 200, randomOffset());
            int blastRadius = random.nextInt(10, MAX_BLAST_RADIUS);

            Meteor meteor = new Meteor(targetPos, blastRadius, METEOR_TIME, world);
            meteors.add(meteor);
            announceMeteor(meteor, METEOR_TIME / 20 / 60 + " minutes");
            lastMeteorTime = System.currentTimeMillis();
        }
    }

    private static void triggerMeteorExplosion(Level world, Meteor meteor) {
        meteor.position = findGroundPosition(world, meteor.position); // Adjust position to the ground
        world.explode(null, meteor.position.getX(), meteor.position.getY(), meteor.position.getZ(), meteor.blastRadius, Level.ExplosionInteraction.BLOCK);
    }

    private static void announceMeteor(Meteor meteor, String timeRemaining) {
        for (ServerPlayer player : meteor.world.players()) {
            BlockPos pos = findGroundPosition(meteor.world, meteor.position);
            Component component = Component.literal(Arrays.toString(new Object[]{pos.getX(),pos.getY(), pos.getZ()})).withStyle((p_214489_) -> p_214489_.withColor(ChatFormatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " +  pos.getX() + " " + pos.getY() + " " +  pos.getZ())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("chat.coordinates.tooltip"))));

            player.sendSystemMessage(Component.literal("Meteor inbound at: ").append(component).append(Component.literal(", blast radius: " + meteor.blastRadius + ". Impact in " + timeRemaining)).withStyle(ChatFormatting.RED));
        }
    }

    private static BlockPos findGroundPosition(Level world, BlockPos startPos) {
        BlockPos pos = startPos.below();
        while(pos.getY() > 0 && !world.getBlockState(pos).isSolidRender(world, pos)) {
            pos = pos.below();
        }
        return pos.above(); // Move up one block for the explosion
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
            BlockPos pos = findGroundPosition(meteors.get(0).world, meteors.get(0).position);
            Component component = Component.literal(Arrays.toString(new Object[]{pos.getX(),pos.getY(), pos.getZ()})).withStyle((p_214489_) -> p_214489_.withColor(ChatFormatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " +  pos.getX() + " " + pos.getY() + " " +  pos.getZ())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("chat.coordinates.tooltip"))));

            player.sendSystemMessage(Component.literal("Meteor already inbound at: ").append(component).append(Component.literal(", blast radius: " + meteors.get(0).blastRadius + ". Impact in " + meteors.get(0).timeUntilImpact / 20 + "s")).withStyle(ChatFormatting.RED));
        }
    }
}
