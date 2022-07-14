
package xyz.vikkivuk.chaosmod.world.teleporter;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CioaoTeleporter implements ITeleporter {

	public static final TicketType<BlockPos> CUSTOM_PORTAL = TicketType.create("cioao_portal", Vec3i::compareTo, 300);

	public static PoiType poi = null;

	@SubscribeEvent
	public static void registerPointOfInterest(RegistryEvent.Register<PoiType> event) {
		poi = new PoiType("cioao_portal",
				com.google.common.collect.Sets
						.newHashSet(ImmutableSet.copyOf(ChaosmodModBlocks.CIOAO_PORTAL.get().getStateDefinition().getPossibleStates())),
				0, 1).setRegistryName("cioao_portal");
		ForgeRegistries.POI_TYPES.register(poi);
	}

	private final ServerLevel level;
	private final BlockPos entityEnterPos;

	public CioaoTeleporter(ServerLevel worldServer, BlockPos entityEnterPos) {
		this.level = worldServer;
		this.entityEnterPos = entityEnterPos;
	}

	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */

	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */

	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */

	@Override
	public Entity placeEntity(Entity entity, ServerLevel ServerLevel, ServerLevel server, float yaw, Function<Boolean, Entity> repositionEntity) {
		PortalInfo portalinfo = getPortalInfo(entity, server);

		if (entity instanceof ServerPlayer player) {
			player.setLevel(server);
			server.addDuringPortalTeleport(player);

			entity.setYRot(portalinfo.yRot % 360.0F);
			entity.setXRot(portalinfo.xRot % 360.0F);

			entity.moveTo(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z);

			return entity;
		} else {
			Entity entityNew = entity.getType().create(server);
			if (entityNew != null) {
				entityNew.restoreFrom(entity);
				entityNew.moveTo(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z, portalinfo.yRot, entityNew.getXRot());
				entityNew.setDeltaMovement(portalinfo.speed);
				server.addDuringTeleport(entityNew);
			}
			return entityNew;
		}
	}

	private PortalInfo getPortalInfo(Entity entity, ServerLevel server) {
		WorldBorder worldborder = server.getWorldBorder();
		double d0 = Math.max(-2.9999872E7D, worldborder.getMinX() + 16.);
		double d1 = Math.max(-2.9999872E7D, worldborder.getMinZ() + 16.);
		double d2 = Math.min(2.9999872E7D, worldborder.getMaxX() - 16.);
		double d3 = Math.min(2.9999872E7D, worldborder.getMaxZ() - 16.);
		double d4 = DimensionType.getTeleportationScale(entity.level.dimensionType(), server.dimensionType());
		BlockPos blockpos1 = new BlockPos(Mth.clamp(entity.getX() * d4, d0, d2), entity.getY(), Mth.clamp(entity.getZ() * d4, d1, d3));
		return this.getExitPortal(entity, blockpos1, worldborder).map(repositioner -> {
			BlockState blockstate = entity.level.getBlockState(this.entityEnterPos);
			Direction.Axis direction$axis;
			Vec3 vector3d;

			if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
				direction$axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
				BlockUtil.FoundRectangle teleportationrepositioner$result = BlockUtil.getLargestRectangleAround(this.entityEnterPos, direction$axis,
						21, Direction.Axis.Y, 21, pos -> entity.level.getBlockState(pos) == blockstate);
				vector3d = CioaoPortalShape.getRelativePosition(teleportationrepositioner$result, direction$axis, entity.position(),
						entity.getDimensions(entity.getPose()));
			} else {
				direction$axis = Direction.Axis.X;
				vector3d = new Vec3(0.5, 0, 0);
			}

			return CioaoPortalShape.createPortalInfo(server, repositioner, direction$axis, vector3d, entity.getDimensions(entity.getPose()),
					entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
		}).orElse(new PortalInfo(entity.position(), Vec3.ZERO, entity.getYRot(), entity.getXRot()));
	}

	protected Optional<BlockUtil.FoundRectangle> getExitPortal(Entity entity, BlockPos pos, WorldBorder worldBorder) {
		Optional<BlockUtil.FoundRectangle> optional = this.findPortalAround(pos, false, worldBorder);

		if (entity instanceof ServerPlayer) {
			if (optional.isPresent()) {
				return optional;
			} else {
				Direction.Axis direction$axis = entity.level.getBlockState(this.entityEnterPos).getOptionalValue(NetherPortalBlock.AXIS)
						.orElse(Direction.Axis.X);
				return this.createPortal(pos, direction$axis);
			}
		} else {
			return optional;
		}
	}

}
