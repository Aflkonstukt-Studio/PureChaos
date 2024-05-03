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
