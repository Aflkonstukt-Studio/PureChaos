
package xyz.vikkivuk.chaosmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SusPortalBlock extends NetherPortalBlock {

	public SusPortalBlock() {
		super(BlockBehaviour.Properties.of(Material.PORTAL).noCollission().randomTicks().strength(-1.0F).sound(SoundType.GLASS).lightLevel(s -> 0)
				.noDrops());
	}

	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
	}

	public static void portalSpawn(Level world, BlockPos pos) {
		Optional<SusPortalShape> optional = SusPortalShape.findEmptyPortalShape(world, pos, Direction.Axis.X);
		if (optional.isPresent()) {
			optional.get().createPortalBlocks();
		}
	}

	@Override /* failed to load code for net.minecraft.world.level.block.NetherPortalBlock */

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState state, Level world, BlockPos pos, Random random) {
		for (int i = 0; i < 4; i++) {
			double px = pos.getX() + random.nextFloat();
			double py = pos.getY() + random.nextFloat();
			double pz = pos.getZ() + random.nextFloat();
			double vx = (random.nextFloat() - 0.5) / 2.;
			double vy = (random.nextFloat() - 0.5) / 2.;
			double vz = (random.nextFloat() - 0.5) / 2.;
			int j = random.nextInt(4) - 1;
			if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
				px = pos.getX() + 0.5 + 0.25 * j;
				vx = random.nextFloat() * 2 * j;
			} else {
				pz = pos.getZ() + 0.5 + 0.25 * j;
				vz = random.nextFloat() * 2 * j;
			}
			world.addParticle((SimpleParticleType) (ChaosmodModParticleTypes.CUM_DRIP.get()), px, py, pz, vx, vy, vz);
		}

		if (random.nextInt(110) == 0)
			world.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
					ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(("chaosmod:amogus"))), SoundSource.BLOCKS, 0.5f,
					random.nextFloat() * 0.4f + 0.8f);
	}

	@Override
	public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
		if (!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions() && !entity.level.isClientSide() && true) {
			if (entity.isOnPortalCooldown()) {
				entity.setPortalCooldown();
			} else if (entity.level.dimension() != ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:sus"))) {
				entity.setPortalCooldown();
				teleportToDimension(entity, pos, ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:sus")));
			} else {
				entity.setPortalCooldown();
				teleportToDimension(entity, pos, Level.OVERWORLD);
			}
		}
	}

	private void teleportToDimension(Entity entity, BlockPos pos, ResourceKey<Level> destinationType) {
		entity.changeDimension(entity.getServer().getLevel(destinationType), new SusTeleporter(entity.getServer().getLevel(destinationType), pos));
	}

}
