
package xyz.vikkivuk.chaosmod.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class JosipRangeEntity extends AbstractArrow implements ItemSupplier {

	public JosipRangeEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(ChaosmodModEntities.JOSIP_RANGE.get(), world);
	}

	public JosipRangeEntity(EntityType<? extends JosipRangeEntity> type, Level world) {
		super(type, world);
	}

	public JosipRangeEntity(EntityType<? extends JosipRangeEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public JosipRangeEntity(EntityType<? extends JosipRangeEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(ChaosmodModItems.JOSIP_RANGE.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.inGround)
			this.discard();
	}

	public static JosipRangeEntity shoot(Level world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		JosipRangeEntity entityarrow = new JosipRangeEntity(ChaosmodModEntities.JOSIP_RANGE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);

		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
				ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1,
				1f / (random.nextFloat() * 0.5f + 1) + (power / 2));

		return entityarrow;
	}

	public static JosipRangeEntity shoot(LivingEntity entity, LivingEntity target) {
		JosipRangeEntity entityarrow = new JosipRangeEntity(ChaosmodModEntities.JOSIP_RANGE.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 5f * 2, 12.0F);

		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
				ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1,
				1f / (new Random().nextFloat() * 0.5f + 1));

		return entityarrow;
	}

}