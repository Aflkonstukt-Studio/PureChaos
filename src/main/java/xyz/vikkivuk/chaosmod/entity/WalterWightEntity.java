
package xyz.vikkivuk.chaosmod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;

public class WalterWightEntity extends Monster {

	public WalterWightEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(ChaosmodModEntities.WALTER_WIGHT.get(), world);
	}

	public WalterWightEntity(EntityType<WalterWightEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);

		setCustomName(new TextComponent("Walter White"));
		setCustomNameVisible(true);

		setPersistenceRequired();

		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChaosmodModItems.PICKAX.get()));
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ChaosmodModItems.METH.get()));

	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new TemptGoal(this, 1, Ingredient.of(ChaosmodModItems.METH.get()), false));
		this.goalSelector.addGoal(2, new PanicGoal(this, 1.2));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, true, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, JosipdvatockanulaEntity.class, true, true));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, JOSIPEntity.class, true, true));
		this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float) 0.5));
		this.goalSelector.addGoal(7, new MeleeAttackGoal(this, 1.2, false) {

			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}

		});
		this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(9, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(ChaosmodModItems.METH.get()));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source == DamageSource.CACTUS)
			return false;
		return super.hurt(source, amount);
	}

	public static void init() {

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);

		return builder;
	}

}
