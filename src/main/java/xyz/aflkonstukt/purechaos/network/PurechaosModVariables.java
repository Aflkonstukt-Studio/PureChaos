package xyz.aflkonstukt.purechaos.network;

import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurechaosModVariables {
	public static boolean invert_controls = false;
	public static boolean show_sanity_label = false;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PurechaosMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			if (!event.isWasDeath()) {
				clone.wrong_answers = original.wrong_answers;
				clone.sanity = original.sanity;
				clone.bl9 = original.bl9;
				clone.bl8 = original.bl8;
				clone.bl7 = original.bl7;
				clone.bl6 = original.bl6;
				clone.bl5 = original.bl5;
				clone.bl4 = original.bl4;
				clone.bl3 = original.bl3;
				clone.bl2 = original.bl2;
				clone.bl12 = original.bl12;
				clone.bl11 = original.bl11;
				clone.bl10 = original.bl10;
				clone.bl1 = original.bl1;
				clone.bl = original.bl;
				clone.show_nikocado = original.show_nikocado;
				clone.nightmare_duration = original.nightmare_duration;
				clone.having_nightmare = original.having_nightmare;
				clone.jump_count = original.jump_count;
				clone.heart_attack_chance = original.heart_attack_chance;
				clone.dementia_chance = original.dementia_chance;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("purechaos", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double wrong_answers = 0.0;
		public double sanity = 100.0;
		public boolean bl9 = false;
		public boolean bl8 = false;
		public boolean bl7 = false;
		public boolean bl6 = false;
		public boolean bl5 = false;
		public boolean bl4 = false;
		public boolean bl3 = false;
		public boolean bl2 = false;
		public boolean bl12 = false;
		public boolean bl11 = false;
		public boolean bl10 = false;
		public boolean bl1 = false;
		public boolean bl = false;
		public boolean show_nikocado = false;
		public double nightmare_duration = 0;
		public boolean having_nightmare = false;
		public double jump_count = 0;
		public double heart_attack_chance = 0;
		public double dementia_chance = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PurechaosMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("wrong_answers", wrong_answers);
			nbt.putDouble("sanity", sanity);
			nbt.putBoolean("bl9", bl9);
			nbt.putBoolean("bl8", bl8);
			nbt.putBoolean("bl7", bl7);
			nbt.putBoolean("bl6", bl6);
			nbt.putBoolean("bl5", bl5);
			nbt.putBoolean("bl4", bl4);
			nbt.putBoolean("bl3", bl3);
			nbt.putBoolean("bl2", bl2);
			nbt.putBoolean("bl12", bl12);
			nbt.putBoolean("bl11", bl11);
			nbt.putBoolean("bl10", bl10);
			nbt.putBoolean("bl1", bl1);
			nbt.putBoolean("bl", bl);
			nbt.putBoolean("show_nikocado", show_nikocado);
			nbt.putDouble("nightmare_duration", nightmare_duration);
			nbt.putBoolean("having_nightmare", having_nightmare);
			nbt.putDouble("jump_count", jump_count);
			nbt.putDouble("heart_attack_chance", heart_attack_chance);
			nbt.putDouble("dementia_chance", dementia_chance);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			wrong_answers = nbt.getDouble("wrong_answers");
			sanity = nbt.getDouble("sanity");
			bl9 = nbt.getBoolean("bl9");
			bl8 = nbt.getBoolean("bl8");
			bl7 = nbt.getBoolean("bl7");
			bl6 = nbt.getBoolean("bl6");
			bl5 = nbt.getBoolean("bl5");
			bl4 = nbt.getBoolean("bl4");
			bl3 = nbt.getBoolean("bl3");
			bl2 = nbt.getBoolean("bl2");
			bl12 = nbt.getBoolean("bl12");
			bl11 = nbt.getBoolean("bl11");
			bl10 = nbt.getBoolean("bl10");
			bl1 = nbt.getBoolean("bl1");
			bl = nbt.getBoolean("bl");
			show_nikocado = nbt.getBoolean("show_nikocado");
			nightmare_duration = nbt.getDouble("nightmare_duration");
			having_nightmare = nbt.getBoolean("having_nightmare");
			jump_count = nbt.getDouble("jump_count");
			heart_attack_chance = nbt.getDouble("heart_attack_chance");
			dementia_chance = nbt.getDouble("dementia_chance");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.wrong_answers = message.data.wrong_answers;
					variables.sanity = message.data.sanity;
					variables.bl9 = message.data.bl9;
					variables.bl8 = message.data.bl8;
					variables.bl7 = message.data.bl7;
					variables.bl6 = message.data.bl6;
					variables.bl5 = message.data.bl5;
					variables.bl4 = message.data.bl4;
					variables.bl3 = message.data.bl3;
					variables.bl2 = message.data.bl2;
					variables.bl12 = message.data.bl12;
					variables.bl11 = message.data.bl11;
					variables.bl10 = message.data.bl10;
					variables.bl1 = message.data.bl1;
					variables.bl = message.data.bl;
					variables.show_nikocado = message.data.show_nikocado;
					variables.nightmare_duration = message.data.nightmare_duration;
					variables.having_nightmare = message.data.having_nightmare;
					variables.jump_count = message.data.jump_count;
					variables.heart_attack_chance = message.data.heart_attack_chance;
					variables.dementia_chance = message.data.dementia_chance;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
