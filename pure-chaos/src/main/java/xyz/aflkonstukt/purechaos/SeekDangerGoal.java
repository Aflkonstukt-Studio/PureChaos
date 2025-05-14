package xyz.aflkonstukt.purechaos;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class SeekDangerGoal extends Goal {
	private final PathfinderMob mob;
	private Vec3 targetPos;
	private final double speedModifier;

	public SeekDangerGoal(PathfinderMob mob) {
		this.mob = mob;
		this.speedModifier = 1.0F;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	@Override
	public boolean canUse() {
		// First, try to find a dangerous spot
		Vec3 dangerPos = findDangerousPosition();
		if (dangerPos != null) {
			this.targetPos = dangerPos;
			return true; // Move to dangerous spot
		}

		// If no dangerous spot, pick a random position to wander
		Vec3 randomPos = DefaultRandomPos.getPos(this.mob, 10, 7);
		if (randomPos != null) {
			this.targetPos = randomPos;
			return true; // Move randomly
		}

		return false; // No valid position found
	}

	@Override
	public boolean canContinueToUse() {
		return this.targetPos != null && this.mob.distanceToSqr(this.targetPos) > 1.0D;
	}

	@Override
	public void start() {
		if (this.targetPos != null) {
			// Try to move to the target using navigation
			this.mob.getNavigation().moveTo(this.targetPos.x, this.targetPos.y, this.targetPos.z, this.speedModifier);
		}
	}

	@Override
	public void tick() {
		if (this.targetPos != null) {
			Vec3 currentPos = mob.position();

			// Check if Buddy is stuck near a cliff or not moving toward danger
			if (isCliff(BlockPos.containing(currentPos)) || mob.getNavigation().isStuck()) {
				// Override navigation and use manual movement
				Vec3 direction = targetPos.subtract(currentPos).normalize().scale(speedModifier);

				// Apply manual movement toward the target
				this.mob.setDeltaMovement(direction.x, this.mob.getDeltaMovement().y, direction.z);

				// Rotate Buddy to face the target
				float yaw = (float) (Math.atan2(direction.z, direction.x) * (180 / Math.PI)) - 90;
				this.mob.setYRot(yaw);
				this.mob.yBodyRot = yaw; // Update body rotation for smooth turning
				this.mob.yHeadRot = yaw; // Update head rotation to match

				// Apply gravity if not on the ground
				if (!this.mob.onGround()) {
					this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0, -0.08, 0));
				}
			}

			// Stop if Buddy is close to the target
			if (currentPos.distanceTo(targetPos) <= 1.0D) {
				this.targetPos = null; // Clear target once reached
			}
		}
	}

	@Override
	public void stop() {
		this.targetPos = null; // Clear the target position
		this.mob.getNavigation().stop(); // Stop the navigation
	}

	private Vec3 findDangerousPosition() {
		BlockPos mobPos = this.mob.blockPosition();

		// Search nearby blocks for cliffs or lava
		for (int x = -10; x <= 10; x++) {
			for (int y = -5; y <= 5; y++) {
				for (int z = -10; z <= 10; z++) {
					BlockPos pos = mobPos.offset(x, y, z);
					if (isDangerous(pos)) {
						return Vec3.atCenterOf(pos);
					}
				}
			}
		}

		return null; // No dangerous position found
	}

	private boolean isDangerous(BlockPos pos) {
		// Check for cliffs, lava, or other dangerous blocks
		return isCliff(pos) || mob.level().getBlockState(pos).is(Blocks.LAVA);
	}

	private boolean isCliff(BlockPos pos) {
		// Check for air below the block for at least 5 blocks
		for (int i = 1; i <= 5; i++) {
			if (!mob.level().getBlockState(pos.below(i)).isAir()) {
				return false; // Not a cliff
			}
		}
		return true; // It’s a cliff
	}
}