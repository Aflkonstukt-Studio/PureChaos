
package xyz.vikkivuk.chaosmod.entity;

import xyz.vikkivuk.chaosmod.init.ChaosmodModItems;
import xyz.vikkivuk.chaosmod.init.ChaosmodModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.Set;

@Mod.EventBusSubscriber
public class JosipdvatockanulaEntity extends Monster {
	private static final Set<ResourceLocation> SPAWN_BIOMES = Set.of(new ResourceLocation("chaosmod:hell_but_overworld"));

	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		if (SPAWN_BIOMES.contains(event.getName()))
			event.getSpawns().getSpawner(MobCategory.MONSTER)
					.add(new MobSpawnSettings.SpawnerData(ChaosmodModEntities.JOSIPDVATOCKANULA.get(), 5, 1, 2));
	}

	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.RED,
			ServerBossEvent.BossBarOverlay.PROGRESS);

	public JosipdvatockanulaEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(ChaosmodModEntities.JOSIPDVATOCKANULA.get(), world);
	}

	public JosipdvatockanulaEntity(EntityType<JosipdvatockanulaEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setCustomName(new TextComponent("||[ ?o?i?T?G ]||"));
		setCustomNameVisible(true);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChaosmodModItems.CORRUPTSTAFF.get()));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
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
		this.spawnAtLocation(new ItemStack(ChaosmodModItems.CORRUPTSTAFF.get()));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("chaosmod:redacted"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.magma_cube.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source == DamageSource.FALL)
			return false;
		if (source == DamageSource.CACTUS)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		if (source == DamageSource.ANVIL)
			return false;
		if (source == DamageSource.DRAGON_BREATH)
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level;
		for (int l = 0; l < 2; ++l) {
			double x0 = x + 0.5 + (random.nextFloat() - 0.5) * 0.5D;
			double y0 = y + 1.2 + (random.nextFloat() - 0.5) * 0.5D;
			double z0 = z + 0.5 + (random.nextFloat() - 0.5) * 0.5D;
			world.addParticle(ParticleTypes.SOUL, x0, y0, z0, 0, 0, 0);
		}
	}

	public static void init() {
		SpawnPlacements.register(ChaosmodModEntities.JOSIPDVATOCKANULA.get(), SpawnPlacements.Type.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL
						&& Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
		builder = builder.add(Attributes.MAX_HEALTH, 1000);
		builder = builder.add(Attributes.ARMOR, 7);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 4.5);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1);
		builder = builder.add(Attributes.FLYING_SPEED, 0.4);
		builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.4);
		return builder;
	}
}
