package xyz.aflkonstukt.purechaos.meteors;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

public class Meteor {
    public BlockPos position;
    public int blastRadius;
    public long timeUntilImpact;
    public ServerLevel world;

    public Meteor(BlockPos position, int blastRadius, long timeUntilImpact, ServerLevel world) {
        this.position = position;
        this.blastRadius = blastRadius;
        this.timeUntilImpact = timeUntilImpact;
        this.world = world;
    }
}

