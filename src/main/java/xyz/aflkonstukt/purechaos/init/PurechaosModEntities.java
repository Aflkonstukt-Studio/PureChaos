
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

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
import xyz.aflkonstukt.purechaos.entity.PensiveCubeEntity;
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

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurechaosModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PurechaosMod.MODID);
	public static final RegistryObject<EntityType<AentityEntity>> AENTITY = register("aentity",
			EntityType.Builder.<AentityEntity>of(AentityEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(AentityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TridentEntity>> TRIDENT = register("trident",
			EntityType.Builder.<TridentEntity>of(TridentEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TridentEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AmongUsEntity>> AMONG_US = register("among_us",
			EntityType.Builder.<AmongUsEntity>of(AmongUsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(69).setUpdateInterval(3).setCustomClientFactory(AmongUsEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Amogus2Entity>> AMOGUS_2 = register("amogus_2",
			EntityType.Builder.<Amogus2Entity>of(Amogus2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Amogus2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Amogus3Entity>> AMOGUS_3 = register("amogus_3",
			EntityType.Builder.<Amogus3Entity>of(Amogus3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(Amogus3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SplankEntity>> SPLANK = register("splank",
			EntityType.Builder.<SplankEntity>of(SplankEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SplankEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IkeaDeskEntity>> IKEA_DESK = register("ikea_desk",
			EntityType.Builder.<IkeaDeskEntity>of(IkeaDeskEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IkeaDeskEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<JOSIPEntity>> JOSIP = register("josip",
			EntityType.Builder.<JOSIPEntity>of(JOSIPEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(69).setUpdateInterval(3).setCustomClientFactory(JOSIPEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<JosipdvatockanulaEntity>> JOSIPDVATOCKANULA = register("josipdvatockanula", EntityType.Builder.<JosipdvatockanulaEntity>of(JosipdvatockanulaEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(JosipdvatockanulaEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<JosipPetEntity>> JOSIP_PET = register("josip_pet",
			EntityType.Builder.<JosipPetEntity>of(JosipPetEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(JosipPetEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<JosipPettEntity>> JOSIP_PETT = register("josip_pett", EntityType.Builder.<JosipPettEntity>of(JosipPettEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(JosipPettEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<MothOfAggrevationEntity>> MOTH_OF_AGGREVATION = register("moth_of_aggrevation",
			EntityType.Builder.<MothOfAggrevationEntity>of(MothOfAggrevationEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MothOfAggrevationEntity::new)

					.sized(0.3f, 0.6f));
	public static final RegistryObject<EntityType<CursedDogEntity>> CURSED_DOG = register("cursed_dog",
			EntityType.Builder.<CursedDogEntity>of(CursedDogEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CursedDogEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BlazEntity>> BLAZ = register("blaz",
			EntityType.Builder.<BlazEntity>of(BlazEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlazEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ShepEntity>> SHEP = register("shep",
			EntityType.Builder.<ShepEntity>of(ShepEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShepEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VikkivukEntity>> VIKKIVUK = register("vikkivuk",
			EntityType.Builder.<VikkivukEntity>of(VikkivukEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VikkivukEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<DreamEntity>> DREAM = register("dream",
			EntityType.Builder.<DreamEntity>of(DreamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DreamEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AdolfHitlerEntity>> ADOLF_HITLER = register("adolf_hitler", EntityType.Builder.<AdolfHitlerEntity>of(AdolfHitlerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(AdolfHitlerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WalterWightEntity>> WALTER_WIGHT = register("walter_wight",
			EntityType.Builder.<WalterWightEntity>of(WalterWightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WalterWightEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CodButBetterEntity>> COD_BUT_BETTER = register("cod_but_better",
			EntityType.Builder.<CodButBetterEntity>of(CodButBetterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CodButBetterEntity::new)

					.sized(0.6f, 0.5f));
	public static final RegistryObject<EntityType<StalinEntity>> STALIN = register("stalin",
			EntityType.Builder.<StalinEntity>of(StalinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StalinEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RickAstleyEntity>> RICK_ASTLEY = register("rick_astley",
			EntityType.Builder.<RickAstleyEntity>of(RickAstleyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RickAstleyEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LegsEntity>> LEGS = register("legs",
			EntityType.Builder.<LegsEntity>of(LegsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LegsEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LongLegChickenEntity>> LONG_LEG_CHICKEN = register("long_leg_chicken",
			EntityType.Builder.<LongLegChickenEntity>of(LongLegChickenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LongLegChickenEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FireflyEntity>> FIREFLY = register("firefly",
			EntityType.Builder.<FireflyEntity>of(FireflyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FireflyEntity::new)

					.sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<TPoseEntityEntity>> T_POSE_ENTITY = register("t_pose_entity", EntityType.Builder.<TPoseEntityEntity>of(TPoseEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TPoseEntityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<StroaterEntity>> STROATER = register("stroater",
			EntityType.Builder.<StroaterEntity>of(StroaterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StroaterEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AMOGUS3BLUEntity>> AMOGUS_3_BLU = register("amogus_3_blu", EntityType.Builder.<AMOGUS3BLUEntity>of(AMOGUS3BLUEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(AMOGUS3BLUEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AMOGUS3GRINEntity>> AMOGUS_3_GRIN = register("amogus_3_grin", EntityType.Builder.<AMOGUS3GRINEntity>of(AMOGUS3GRINEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(AMOGUS3GRINEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SpongebobBossEntity>> SPONGEBOB_BOSS = register("spongebob_boss",
			EntityType.Builder.<SpongebobBossEntity>of(SpongebobBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(SpongebobBossEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TheRockEntity>> THE_ROCK = register("the_rock",
			EntityType.Builder.<TheRockEntity>of(TheRockEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TheRockEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BigEntity>> BIG = register("big",
			EntityType.Builder.<BigEntity>of(BigEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BigEntity::new)

					.sized(0.9f, 0.9f));
	public static final RegistryObject<EntityType<TechnobladeEntity>> TECHNOBLADE = register("technoblade", EntityType.Builder.<TechnobladeEntity>of(TechnobladeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TechnobladeEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CupcakkeEntity>> CUPCAKKE = register("cupcakke",
			EntityType.Builder.<CupcakkeEntity>of(CupcakkeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CupcakkeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BaldiMinusEntity>> BALDI_MINUS = register("baldi_minus",
			EntityType.Builder.<BaldiMinusEntity>of(BaldiMinusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BaldiMinusEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HerobrineEntity>> HEROBRINE = register("herobrine",
			EntityType.Builder.<HerobrineEntity>of(HerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HerobrineEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NerdEntity>> NERD = register("nerd",
			EntityType.Builder.<NerdEntity>of(NerdEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NerdEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IRSEntity>> IRS = register("irs",
			EntityType.Builder.<IRSEntity>of(IRSEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IRSEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FBIEntity>> FBI = register("fbi",
			EntityType.Builder.<FBIEntity>of(FBIEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FBIEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AmericanSoldatEntity>> AMERICAN_SOLDAT = register("american_soldat",
			EntityType.Builder.<AmericanSoldatEntity>of(AmericanSoldatEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AmericanSoldatEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MuricaEntity>> MURICA = register("murica",
			EntityType.Builder.<MuricaEntity>of(MuricaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MuricaEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KondomnepitajzastoovoradimalispoileralertonimarupuProjectileEntity>> KONDOMNEPITAJZASTOOVORADIMALISPOILERALERTONIMARUPU_PROJECTILE = register(
			"projectile_kondomnepitajzastoovoradimalispoileralertonimarupu_projectile",
			EntityType.Builder.<KondomnepitajzastoovoradimalispoileralertonimarupuProjectileEntity>of(KondomnepitajzastoovoradimalispoileralertonimarupuProjectileEntity::new, MobCategory.MISC)
					.setCustomClientFactory(KondomnepitajzastoovoradimalispoileralertonimarupuProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DeekProjectileEntity>> DEEK_PROJECTILE = register("projectile_deek_projectile",
			EntityType.Builder.<DeekProjectileEntity>of(DeekProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(DeekProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WaterCupProjectileEntity>> WATER_CUP_PROJECTILE = register("projectile_water_cup_projectile", EntityType.Builder.<WaterCupProjectileEntity>of(WaterCupProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(WaterCupProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<JosipRangeProjectileEntity>> JOSIP_RANGE_PROJECTILE = register("projectile_josip_range_projectile", EntityType.Builder.<JosipRangeProjectileEntity>of(JosipRangeProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(JosipRangeProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AK47ProjectileEntity>> AK_47_PROJECTILE = register("projectile_ak_47_projectile",
			EntityType.Builder.<AK47ProjectileEntity>of(AK47ProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(AK47ProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AmogusGunProjectileEntity>> AMOGUS_GUN_PROJECTILE = register("projectile_amogus_gun_projectile", EntityType.Builder.<AmogusGunProjectileEntity>of(AmogusGunProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(AmogusGunProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RockProjectileEntity>> ROCK_PROJECTILE = register("projectile_rock_projectile",
			EntityType.Builder.<RockProjectileEntity>of(RockProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(RockProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<JavelinLauncherProjectileEntity>> JAVELIN_LAUNCHER_PROJECTILE = register("projectile_javelin_launcher_projectile",
			EntityType.Builder.<JavelinLauncherProjectileEntity>of(JavelinLauncherProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(JavelinLauncherProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PensiveCubeEntity>> PENSIVE_CUBE = register("pensive_cube",
			EntityType.Builder.<PensiveCubeEntity>of(PensiveCubeEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PensiveCubeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GroggoEntity>> GROGGO = register("groggo",
			EntityType.Builder.<GroggoEntity>of(GroggoEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GroggoEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AentityEntity.init();
			TridentEntity.init();
			AmongUsEntity.init();
			Amogus2Entity.init();
			Amogus3Entity.init();
			SplankEntity.init();
			IkeaDeskEntity.init();
			JOSIPEntity.init();
			JosipdvatockanulaEntity.init();
			JosipPetEntity.init();
			JosipPettEntity.init();
			MothOfAggrevationEntity.init();
			CursedDogEntity.init();
			BlazEntity.init();
			ShepEntity.init();
			VikkivukEntity.init();
			DreamEntity.init();
			AdolfHitlerEntity.init();
			WalterWightEntity.init();
			CodButBetterEntity.init();
			StalinEntity.init();
			RickAstleyEntity.init();
			LegsEntity.init();
			LongLegChickenEntity.init();
			FireflyEntity.init();
			TPoseEntityEntity.init();
			StroaterEntity.init();
			AMOGUS3BLUEntity.init();
			AMOGUS3GRINEntity.init();
			SpongebobBossEntity.init();
			TheRockEntity.init();
			BigEntity.init();
			TechnobladeEntity.init();
			CupcakkeEntity.init();
			BaldiMinusEntity.init();
			HerobrineEntity.init();
			NerdEntity.init();
			IRSEntity.init();
			FBIEntity.init();
			AmericanSoldatEntity.init();
			MuricaEntity.init();
			PensiveCubeEntity.init();
			GroggoEntity.init();
		});
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
		event.put(CURSED_DOG.get(), CursedDogEntity.createAttributes().build());
		event.put(BLAZ.get(), BlazEntity.createAttributes().build());
		event.put(SHEP.get(), ShepEntity.createAttributes().build());
		event.put(VIKKIVUK.get(), VikkivukEntity.createAttributes().build());
		event.put(DREAM.get(), DreamEntity.createAttributes().build());
		event.put(ADOLF_HITLER.get(), AdolfHitlerEntity.createAttributes().build());
		event.put(WALTER_WIGHT.get(), WalterWightEntity.createAttributes().build());
		event.put(COD_BUT_BETTER.get(), CodButBetterEntity.createAttributes().build());
		event.put(STALIN.get(), StalinEntity.createAttributes().build());
		event.put(RICK_ASTLEY.get(), RickAstleyEntity.createAttributes().build());
		event.put(LEGS.get(), LegsEntity.createAttributes().build());
		event.put(LONG_LEG_CHICKEN.get(), LongLegChickenEntity.createAttributes().build());
		event.put(FIREFLY.get(), FireflyEntity.createAttributes().build());
		event.put(T_POSE_ENTITY.get(), TPoseEntityEntity.createAttributes().build());
		event.put(STROATER.get(), StroaterEntity.createAttributes().build());
		event.put(AMOGUS_3_BLU.get(), AMOGUS3BLUEntity.createAttributes().build());
		event.put(AMOGUS_3_GRIN.get(), AMOGUS3GRINEntity.createAttributes().build());
		event.put(SPONGEBOB_BOSS.get(), SpongebobBossEntity.createAttributes().build());
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
		event.put(PENSIVE_CUBE.get(), PensiveCubeEntity.createAttributes().build());
		event.put(GROGGO.get(), GroggoEntity.createAttributes().build());
	}
}
