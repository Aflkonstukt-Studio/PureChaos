package xyz.aflkonstukt.purechaos.network;

import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurechaosModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, PurechaosMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());
	public static boolean invert_controls = false;
	public static double mob_cap_multiplier = 15.0;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PurechaosMod.addNetworkMessage(PlayerVariablesSyncMessage.ID, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handleData);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.alcohol_addiction = original.alcohol_addiction;
			clone.meth_addiction = original.meth_addiction;
			if (!event.isWasDeath()) {
				clone.wrong_answers = original.wrong_answers;
				clone.sanity = original.sanity;
				clone.show_nikocado = original.show_nikocado;
				clone.nightmare_duration = original.nightmare_duration;
				clone.having_nightmare = original.having_nightmare;
				clone.jump_count = original.jump_count;
				clone.heart_attack_chance = original.heart_attack_chance;
				clone.dementia_chance = original.dementia_chance;
				clone.boolets = original.boolets;
				clone.last_depression = original.last_depression;
				clone.breakdown_chance = original.breakdown_chance;
				clone.depression_active = original.depression_active;
				clone.current_ad = original.current_ad;
				clone.amount_of_alcohol_drank = original.amount_of_alcohol_drank;
				clone.amount_of_meth_used = original.amount_of_meth_used;
				clone.mua_peu = original.mua_peu;
				clone.ada_peu = original.ada_peu;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public double wrong_answers = 0.0;
		public double sanity = 100.0;
		public boolean show_nikocado = false;
		public double nightmare_duration = 0;
		public boolean having_nightmare = false;
		public double jump_count = 0;
		public double heart_attack_chance = 0;
		public double dementia_chance = 0.0;
		public double boolets = 0;
		public double last_depression = 0;
		public double breakdown_chance = 0;
		public boolean depression_active = false;
		public double current_ad = 0;
		public double alcohol_addiction = -1.0;
		public double meth_addiction = -1.0;
		public double amount_of_alcohol_drank = 0;
		public double amount_of_meth_used = 0;
		public double mua_peu = 0;
		public double ada_peu = 0;

		@Override
		public CompoundTag serializeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("wrong_answers", wrong_answers);
			nbt.putDouble("sanity", sanity);
			nbt.putBoolean("show_nikocado", show_nikocado);
			nbt.putDouble("nightmare_duration", nightmare_duration);
			nbt.putBoolean("having_nightmare", having_nightmare);
			nbt.putDouble("jump_count", jump_count);
			nbt.putDouble("heart_attack_chance", heart_attack_chance);
			nbt.putDouble("dementia_chance", dementia_chance);
			nbt.putDouble("boolets", boolets);
			nbt.putDouble("last_depression", last_depression);
			nbt.putDouble("breakdown_chance", breakdown_chance);
			nbt.putBoolean("depression_active", depression_active);
			nbt.putDouble("current_ad", current_ad);
			nbt.putDouble("alcohol_addiction", alcohol_addiction);
			nbt.putDouble("meth_addiction", meth_addiction);
			nbt.putDouble("amount_of_alcohol_drank", amount_of_alcohol_drank);
			nbt.putDouble("amount_of_meth_used", amount_of_meth_used);
			nbt.putDouble("mua_peu", mua_peu);
			nbt.putDouble("ada_peu", ada_peu);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			wrong_answers = nbt.getDouble("wrong_answers");
			sanity = nbt.getDouble("sanity");
			show_nikocado = nbt.getBoolean("show_nikocado");
			nightmare_duration = nbt.getDouble("nightmare_duration");
			having_nightmare = nbt.getBoolean("having_nightmare");
			jump_count = nbt.getDouble("jump_count");
			heart_attack_chance = nbt.getDouble("heart_attack_chance");
			dementia_chance = nbt.getDouble("dementia_chance");
			boolets = nbt.getDouble("boolets");
			last_depression = nbt.getDouble("last_depression");
			breakdown_chance = nbt.getDouble("breakdown_chance");
			depression_active = nbt.getBoolean("depression_active");
			current_ad = nbt.getDouble("current_ad");
			alcohol_addiction = nbt.getDouble("alcohol_addiction");
			meth_addiction = nbt.getDouble("meth_addiction");
			amount_of_alcohol_drank = nbt.getDouble("amount_of_alcohol_drank");
			amount_of_meth_used = nbt.getDouble("amount_of_meth_used");
			mua_peu = nbt.getDouble("mua_peu");
			ada_peu = nbt.getDouble("ada_peu");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.PLAYER.with(serverPlayer).send(new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final ResourceLocation ID = new ResourceLocation(PurechaosMod.MODID, "player_variables_sync");

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this(new PlayerVariables());
			this.data.deserializeNBT(buffer.readNbt());
		}

		@Override
		public void write(final FriendlyByteBuf buffer) {
			buffer.writeNbt(data.serializeNBT());
		}

		@Override
		public ResourceLocation id() {
			return ID;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final PlayPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.workHandler().submitAsync(() -> Minecraft.getInstance().player.getData(PLAYER_VARIABLES).deserializeNBT(message.data.serializeNBT())).exceptionally(e -> {
					context.packetHandler().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
