
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.entity.TridentEntity;
import xyz.vikkivuk.chaosmod.entity.DeekEntity;
import xyz.vikkivuk.chaosmod.entity.AmongUsEntity;
import xyz.vikkivuk.chaosmod.entity.Amogus2Entity;
import xyz.vikkivuk.chaosmod.entity.AentityEntity;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

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
public class ChaosmodModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, ChaosmodMod.MODID);
	public static final RegistryObject<EntityType<DeekEntity>> DEEK = register("projectile_deek",
			EntityType.Builder.<DeekEntity>of(DeekEntity::new, MobCategory.MISC).setCustomClientFactory(DeekEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AentityEntity>> AENTITY = register("aentity",
			EntityType.Builder.<AentityEntity>of(AentityEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(100)
					.setUpdateInterval(3).setCustomClientFactory(AentityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TridentEntity>> TRIDENT = register("trident",
			EntityType.Builder.<TridentEntity>of(TridentEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(TridentEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AmongUsEntity>> AMONG_US = register("among_us",
			EntityType.Builder.<AmongUsEntity>of(AmongUsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(69)
					.setUpdateInterval(3).setCustomClientFactory(AmongUsEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Amogus2Entity>> AMOGUS_2 = register("amogus_2",
			EntityType.Builder.<Amogus2Entity>of(Amogus2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(Amogus2Entity::new).fireImmune().sized(0.6f, 1.8f));

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
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AENTITY.get(), AentityEntity.createAttributes().build());
		event.put(TRIDENT.get(), TridentEntity.createAttributes().build());
		event.put(AMONG_US.get(), AmongUsEntity.createAttributes().build());
		event.put(AMOGUS_2.get(), Amogus2Entity.createAttributes().build());
	}
}
