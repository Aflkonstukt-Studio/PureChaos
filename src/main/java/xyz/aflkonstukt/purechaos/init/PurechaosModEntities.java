
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.entity.YugoslaviaEntity;
import xyz.aflkonstukt.purechaos.entity.WaterCupProjectileEntity;
import xyz.aflkonstukt.purechaos.entity.WalterWightEntity;
import xyz.aflkonstukt.purechaos.entity.VikkivukEntity;
import xyz.aflkonstukt.purechaos.entity.TridentEntity;
import xyz.aflkonstukt.purechaos.entity.TheRockEntity;
import xyz.aflkonstukt.purechaos.entity.TechnobladeEntity;
import xyz.aflkonstukt.purechaos.entity.TPoseEntityEntity;
import xyz.aflkonstukt.purechaos.entity.StroaterEntity;
import xyz.aflkonstukt.purechaos.entity.StalinEntity;
import xyz.aflkonstukt.purechaos.entity.SpongebobBossEntity;
import xyz.aflkonstukt.purechaos.entity.SplankEntity;
import xyz.aflkonstukt.purechaos.entity.ShepEntity;
import xyz.aflkonstukt.purechaos.entity.RockProjectileEntity;
import xyz.aflkonstukt.purechaos.entity.RickAstleyEntity;
import xyz.aflkonstukt.purechaos.entity.PensiveCubesEntity;
import xyz.aflkonstukt.purechaos.entity.NerdEntity;
import xyz.aflkonstukt.purechaos.entity.MuricaEntity;
import xyz.aflkonstukt.purechaos.entity.MothOfAggrevationEntity;
import xyz.aflkonstukt.purechaos.entity.LongLegChickenEntity;
import xyz.aflkonstukt.purechaos.entity.LegsEntity;
import xyz.aflkonstukt.purechaos.entity.KondomnepitajzastoovoradimalispoileralertonimarupuProjectileEntity;
import xyz.aflkonstukt.purechaos.entity.JosipdvatockanulaEntity;
import xyz.aflkonstukt.purechaos.entity.JosipRangeProjectileEntity;
import xyz.aflkonstukt.purechaos.entity.JosipPettEntity;
import xyz.aflkonstukt.purechaos.entity.JosipPetEntity;
import xyz.aflkonstukt.purechaos.entity.JavelinLauncherProjectileEntity;
import xyz.aflkonstukt.purechaos.entity.JOSIPEntity;
import xyz.aflkonstukt.purechaos.entity.IkeaDeskEntity;
import xyz.aflkonstukt.purechaos.entity.IRSEntity;
import xyz.aflkonstukt.purechaos.entity.HerobrineEntity;
import xyz.aflkonstukt.purechaos.entity.GroggoEntity;
import xyz.aflkonstukt.purechaos.entity.FishProjectileEntity;
import xyz.aflkonstukt.purechaos.entity.FireflyEntity;
import xyz.aflkonstukt.purechaos.entity.FBIEntity;
import xyz.aflkonstukt.purechaos.entity.DreamEntity;
import xyz.aflkonstukt.purechaos.entity.DeekProjectileEntity;
import xyz.aflkonstukt.purechaos.entity.CursedDogEntity;
import xyz.aflkonstukt.purechaos.entity.CupcakkeEntity;
import xyz.aflkonstukt.purechaos.entity.CodButBetterEntity;
import xyz.aflkonstukt.purechaos.entity.BlazEntity;
import xyz.aflkonstukt.purechaos.entity.BigEntity;
import xyz.aflkonstukt.purechaos.entity.BaldiMinusEntity;
import xyz.aflkonstukt.purechaos.entity.AmongUsEntity;
import xyz.aflkonstukt.purechaos.entity.AmogusGunProjectileEntity;
import xyz.aflkonstukt.purechaos.entity.Amogus3Entity;
import xyz.aflkonstukt.purechaos.entity.Amogus2Entity;
import xyz.aflkonstukt.purechaos.entity.AmericanSoldatEntity;
import xyz.aflkonstukt.purechaos.entity.AentityEntity;
import xyz.aflkonstukt.purechaos.entity.AdolfHitlerEntity;
import xyz.aflkonstukt.purechaos.entity.AMOGUS3GRINEntity;
import xyz.aflkonstukt.purechaos.entity.AMOGUS3BLUEntity;
import xyz.aflkonstukt.purechaos.entity.AK47ProjectileEntity;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PurechaosModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, PurechaosMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<AentityEntity>> AENTITY = register("aentity",
			EntityType.Builder.<AentityEntity>of(AentityEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<TridentEntity>> TRIDENT = register("trident",
			EntityType.Builder.<TridentEntity>of(TridentEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<AmongUsEntity>> AMONG_US = register("among_us",
			EntityType.Builder.<AmongUsEntity>of(AmongUsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(69).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<Amogus2Entity>> AMOGUS_2 = register("amogus_2",
			EntityType.Builder.<Amogus2Entity>of(Amogus2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<Amogus3Entity>> AMOGUS_3 = register("amogus_3",
			EntityType.Builder.<Amogus3Entity>of(Amogus3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SplankEntity>> SPLANK = register("splank",
			EntityType.Builder.<SplankEntity>of(SplankEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<IkeaDeskEntity>> IKEA_DESK = register("ikea_desk",
			EntityType.Builder.<IkeaDeskEntity>of(IkeaDeskEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<JOSIPEntity>> JOSIP = register("josip",
			EntityType.Builder.<JOSIPEntity>of(JOSIPEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(69).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<JosipdvatockanulaEntity>> JOSIPDVATOCKANULA = register("josipdvatockanula",
			EntityType.Builder.<JosipdvatockanulaEntity>of(JosipdvatockanulaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<JosipPetEntity>> JOSIP_PET = register("josip_pet",
			EntityType.Builder.<JosipPetEntity>of(JosipPetEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<JosipPettEntity>> JOSIP_PETT = register("josip_pett",
			EntityType.Builder.<JosipPettEntity>of(JosipPettEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<MothOfAggrevationEntity>> MOTH_OF_AGGREVATION = register("moth_of_aggrevation",
			EntityType.Builder.<MothOfAggrevationEntity>of(MothOfAggrevationEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.3f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<ShepEntity>> SHEP = register("shep",
			EntityType.Builder.<ShepEntity>of(ShepEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<VikkivukEntity>> VIKKIVUK = register("vikkivuk",
			EntityType.Builder.<VikkivukEntity>of(VikkivukEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<BlazEntity>> BLAZ = register("blaz",
			EntityType.Builder.<BlazEntity>of(BlazEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CursedDogEntity>> CURSED_DOG = register("cursed_dog",
			EntityType.Builder.<CursedDogEntity>of(CursedDogEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<WalterWightEntity>> WALTER_WIGHT = register("walter_wight",
			EntityType.Builder.<WalterWightEntity>of(WalterWightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<AdolfHitlerEntity>> ADOLF_HITLER = register("adolf_hitler",
			EntityType.Builder.<AdolfHitlerEntity>of(AdolfHitlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<DreamEntity>> DREAM = register("dream",
			EntityType.Builder.<DreamEntity>of(DreamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CodButBetterEntity>> COD_BUT_BETTER = register("cod_but_better",
			EntityType.Builder.<CodButBetterEntity>of(CodButBetterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<StalinEntity>> STALIN = register("stalin",
			EntityType.Builder.<StalinEntity>of(StalinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<RickAstleyEntity>> RICK_ASTLEY = register("rick_astley",
			EntityType.Builder.<RickAstleyEntity>of(RickAstleyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<LegsEntity>> LEGS = register("legs",
			EntityType.Builder.<LegsEntity>of(LegsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<LongLegChickenEntity>> LONG_LEG_CHICKEN = register("long_leg_chicken",
			EntityType.Builder.<LongLegChickenEntity>of(LongLegChickenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FireflyEntity>> FIREFLY = register("firefly",
			EntityType.Builder.<FireflyEntity>of(FireflyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<TPoseEntityEntity>> T_POSE_ENTITY = register("t_pose_entity",
			EntityType.Builder.<TPoseEntityEntity>of(TPoseEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<StroaterEntity>> STROATER = register("stroater",
			EntityType.Builder.<StroaterEntity>of(StroaterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpongebobBossEntity>> SPONGEBOB_BOSS = register("spongebob_boss",
			EntityType.Builder.<SpongebobBossEntity>of(SpongebobBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<AMOGUS3BLUEntity>> AMOGUS_3_BLU = register("amogus_3_blu",
			EntityType.Builder.<AMOGUS3BLUEntity>of(AMOGUS3BLUEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<AMOGUS3GRINEntity>> AMOGUS_3_GRIN = register("amogus_3_grin",
			EntityType.Builder.<AMOGUS3GRINEntity>of(AMOGUS3GRINEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<TheRockEntity>> THE_ROCK = register("the_rock",
			EntityType.Builder.<TheRockEntity>of(TheRockEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BigEntity>> BIG = register("big", EntityType.Builder.<BigEntity>of(BigEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.9f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<TechnobladeEntity>> TECHNOBLADE = register("technoblade",
			EntityType.Builder.<TechnobladeEntity>of(TechnobladeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CupcakkeEntity>> CUPCAKKE = register("cupcakke",
			EntityType.Builder.<CupcakkeEntity>of(CupcakkeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BaldiMinusEntity>> BALDI_MINUS = register("baldi_minus",
			EntityType.Builder.<BaldiMinusEntity>of(BaldiMinusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<HerobrineEntity>> HEROBRINE = register("herobrine",
			EntityType.Builder.<HerobrineEntity>of(HerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<NerdEntity>> NERD = register("nerd",
			EntityType.Builder.<NerdEntity>of(NerdEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<IRSEntity>> IRS = register("irs", EntityType.Builder.<IRSEntity>of(IRSEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FBIEntity>> FBI = register("fbi", EntityType.Builder.<FBIEntity>of(FBIEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<AmericanSoldatEntity>> AMERICAN_SOLDAT = register("american_soldat",
			EntityType.Builder.<AmericanSoldatEntity>of(AmericanSoldatEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MuricaEntity>> MURICA = register("murica",
			EntityType.Builder.<MuricaEntity>of(MuricaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<DeekProjectileEntity>> DEEK_PROJECTILE = register("deek_projectile",
			EntityType.Builder.<DeekProjectileEntity>of(DeekProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<KondomnepitajzastoovoradimalispoileralertonimarupuProjectileEntity>> KONDOMNEPITAJZASTOOVORADIMALISPOILERALERTONIMARUPU_PROJECTILE = register(
			"kondomnepitajzastoovoradimalispoileralertonimarupu_projectile",
			EntityType.Builder.<KondomnepitajzastoovoradimalispoileralertonimarupuProjectileEntity>of(KondomnepitajzastoovoradimalispoileralertonimarupuProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<WaterCupProjectileEntity>> WATER_CUP_PROJECTILE = register("water_cup_projectile",
			EntityType.Builder.<WaterCupProjectileEntity>of(WaterCupProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<JosipRangeProjectileEntity>> JOSIP_RANGE_PROJECTILE = register("josip_range_projectile",
			EntityType.Builder.<JosipRangeProjectileEntity>of(JosipRangeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<AK47ProjectileEntity>> AK_47_PROJECTILE = register("ak_47_projectile",
			EntityType.Builder.<AK47ProjectileEntity>of(AK47ProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<AmogusGunProjectileEntity>> AMOGUS_GUN_PROJECTILE = register("amogus_gun_projectile",
			EntityType.Builder.<AmogusGunProjectileEntity>of(AmogusGunProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RockProjectileEntity>> ROCK_PROJECTILE = register("rock_projectile",
			EntityType.Builder.<RockProjectileEntity>of(RockProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<JavelinLauncherProjectileEntity>> JAVELIN_LAUNCHER_PROJECTILE = register("javelin_launcher_projectile",
			EntityType.Builder.<JavelinLauncherProjectileEntity>of(JavelinLauncherProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GroggoEntity>> GROGGO = register("groggo",
			EntityType.Builder.<GroggoEntity>of(GroggoEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<YugoslaviaEntity>> YUGOSLAVIA = register("yugoslavia",
			EntityType.Builder.<YugoslaviaEntity>of(YugoslaviaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FishProjectileEntity>> FISH_PROJECTILE = register("fish_projectile",
			EntityType.Builder.<FishProjectileEntity>of(FishProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PensiveCubesEntity>> PENSIVE_CUBE = register("pensive_cube",
			EntityType.Builder.<PensiveCubesEntity>of(PensiveCubesEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerEntity(Capabilities.ItemHandler.ENTITY, VIKKIVUK.get(), (living, context) -> living.getCombinedInventory());
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		AentityEntity.init(event);
		TridentEntity.init(event);
		AmongUsEntity.init(event);
		Amogus2Entity.init(event);
		Amogus3Entity.init(event);
		SplankEntity.init(event);
		IkeaDeskEntity.init(event);
		JOSIPEntity.init(event);
		JosipdvatockanulaEntity.init(event);
		JosipPetEntity.init(event);
		JosipPettEntity.init(event);
		MothOfAggrevationEntity.init(event);
		ShepEntity.init(event);
		VikkivukEntity.init(event);
		BlazEntity.init(event);
		CursedDogEntity.init(event);
		WalterWightEntity.init(event);
		AdolfHitlerEntity.init(event);
		DreamEntity.init(event);
		CodButBetterEntity.init(event);
		StalinEntity.init(event);
		RickAstleyEntity.init(event);
		LegsEntity.init(event);
		LongLegChickenEntity.init(event);
		FireflyEntity.init(event);
		TPoseEntityEntity.init(event);
		StroaterEntity.init(event);
		SpongebobBossEntity.init(event);
		AMOGUS3BLUEntity.init(event);
		AMOGUS3GRINEntity.init(event);
		TheRockEntity.init(event);
		BigEntity.init(event);
		TechnobladeEntity.init(event);
		CupcakkeEntity.init(event);
		BaldiMinusEntity.init(event);
		HerobrineEntity.init(event);
		NerdEntity.init(event);
		IRSEntity.init(event);
		FBIEntity.init(event);
		AmericanSoldatEntity.init(event);
		MuricaEntity.init(event);
		GroggoEntity.init(event);
		YugoslaviaEntity.init(event);
		PensiveCubesEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AENTITY.get(), AentityEntity.createAttributes().build());
		event.put(TRIDENT.get(), TridentEntity.createAttributes().build());
		event.put(AMONG_US.get(), AmongUsEntity.createAttributes().build());
		event.put(AMOGUS_2.get(), Amogus2Entity.createAttributes().build());
		event.put(AMOGUS_3.get(), Amogus3Entity.createAttributes().build());
		event.put(SPLANK.get(), SplankEntity.createAttributes().build());
		event.put(IKEA_DESK.get(), IkeaDeskEntity.createAttributes().build());
		event.put(JOSIP.get(), JOSIPEntity.createAttributes().build());
		event.put(JOSIPDVATOCKANULA.get(), JosipdvatockanulaEntity.createAttributes().build());
		event.put(JOSIP_PET.get(), JosipPetEntity.createAttributes().build());
		event.put(JOSIP_PETT.get(), JosipPettEntity.createAttributes().build());
		event.put(MOTH_OF_AGGREVATION.get(), MothOfAggrevationEntity.createAttributes().build());
		event.put(SHEP.get(), ShepEntity.createAttributes().build());
		event.put(VIKKIVUK.get(), VikkivukEntity.createAttributes().build());
		event.put(BLAZ.get(), BlazEntity.createAttributes().build());
		event.put(CURSED_DOG.get(), CursedDogEntity.createAttributes().build());
		event.put(WALTER_WIGHT.get(), WalterWightEntity.createAttributes().build());
		event.put(ADOLF_HITLER.get(), AdolfHitlerEntity.createAttributes().build());
		event.put(DREAM.get(), DreamEntity.createAttributes().build());
		event.put(COD_BUT_BETTER.get(), CodButBetterEntity.createAttributes().build());
		event.put(STALIN.get(), StalinEntity.createAttributes().build());
		event.put(RICK_ASTLEY.get(), RickAstleyEntity.createAttributes().build());
		event.put(LEGS.get(), LegsEntity.createAttributes().build());
		event.put(LONG_LEG_CHICKEN.get(), LongLegChickenEntity.createAttributes().build());
		event.put(FIREFLY.get(), FireflyEntity.createAttributes().build());
		event.put(T_POSE_ENTITY.get(), TPoseEntityEntity.createAttributes().build());
		event.put(STROATER.get(), StroaterEntity.createAttributes().build());
		event.put(SPONGEBOB_BOSS.get(), SpongebobBossEntity.createAttributes().build());
		event.put(AMOGUS_3_BLU.get(), AMOGUS3BLUEntity.createAttributes().build());
		event.put(AMOGUS_3_GRIN.get(), AMOGUS3GRINEntity.createAttributes().build());
		event.put(THE_ROCK.get(), TheRockEntity.createAttributes().build());
		event.put(BIG.get(), BigEntity.createAttributes().build());
		event.put(TECHNOBLADE.get(), TechnobladeEntity.createAttributes().build());
		event.put(CUPCAKKE.get(), CupcakkeEntity.createAttributes().build());
		event.put(BALDI_MINUS.get(), BaldiMinusEntity.createAttributes().build());
		event.put(HEROBRINE.get(), HerobrineEntity.createAttributes().build());
		event.put(NERD.get(), NerdEntity.createAttributes().build());
		event.put(IRS.get(), IRSEntity.createAttributes().build());
		event.put(FBI.get(), FBIEntity.createAttributes().build());
		event.put(AMERICAN_SOLDAT.get(), AmericanSoldatEntity.createAttributes().build());
		event.put(MURICA.get(), MuricaEntity.createAttributes().build());
		event.put(GROGGO.get(), GroggoEntity.createAttributes().build());
		event.put(YUGOSLAVIA.get(), YugoslaviaEntity.createAttributes().build());
		event.put(PENSIVE_CUBE.get(), PensiveCubesEntity.createAttributes().build());
	}
}
