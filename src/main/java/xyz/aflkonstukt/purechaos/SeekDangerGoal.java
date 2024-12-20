package xyz.aflkonstukt.purechaos;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class SeekDangerGoal extends Goal {
	private final PathfinderMob mob;
	private Vec3 wantedPos;
	private final double speedModifier;
	private boolean stoppingMovement = false;

	public SeekDangerGoal(PathfinderMob mob) {
		this.mob = mob;
		this.speedModifier = 1.0D;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	@Override
	public boolean canUse() {
		if (stoppingMovement) return false; // Don't move
		// First, try to find a dangerous spot
		Vec3 dangerPos = getDangerousPosition();
		if (dangerPos != null) {
			this.wantedPos = dangerPos;
			return true; // Move to dangerous spot
		}

		// If no dangerous spot, pick a random position to wander
		Vec3 randomPos = DefaultRandomPos.getPos(this.mob, 10, 7);
		if (randomPos != null) {
			this.wantedPos = randomPos;
			return true; // Move randomly
		}

		return false; // No valid position found
	}

	@Override
	public boolean canContinueToUse() {
		if (stoppingMovement) {
			return true; // Keep Buddy still
		}
		return !this.mob.getNavigation().isDone();
	}

	@Override
	public void tick() {
		BlockPos currentPos = this.mob.blockPosition();

		// Only stop moving if Buddy is fully in a dangerous block
		if (isDangerous(currentPos) && !isCliff(currentPos.above())) {
			stoppingMovement = true;
			this.mob.getNavigation().stop();
			this.mob.setDeltaMovement(Vec3.ZERO); // Stop moving completely
		}
	}

	@Override
	public void start() {
		if (wantedPos != null) {
			this.mob.getNavigation().moveTo(wantedPos.x + 0.5, wantedPos.y, wantedPos.z + 0.5, this.speedModifier);
			this.mob.getNavigation().setCanFloat(true); // Allow the mob to fall
		}
	}


	private Vec3 getDangerousPosition() {
		BlockPos mobPos = this.mob.blockPosition();

		// Search nearby blocks for danger zones (cliffs or lava)
		for (int x = -20; x <= 20; x++) {
			for (int z = -20; z <= 20; z++) {
				for (int y = -5; y <= 5; y++) {
					BlockPos pos = mobPos.offset(x, y, z);

					// Check for cliffs (air below) or lava
					if (isDangerous(pos)) {
						return Vec3.atBottomCenterOf(pos);
					}
				}
			}
		}

		return null; // No dangerous position found
	}

	private boolean isDangerous(BlockPos pos) {
		return isCliff(pos)
				|| mob.level().getBlockState(pos).is(Blocks.LAVA) // Lava
				|| mob.level().getBlockState(pos).is(Blocks.WATER);
	}

	private boolean isCliff(BlockPos pos) {
		// Check if the block below is air, indicating a cliff
		BlockPos below1 = pos.below(1);
		BlockPos below2 = pos.below(2);

		// Ensure there’s a clear drop of at least 2 blocks
		return mob.level().getBlockState(below1).isAir();
	}
}