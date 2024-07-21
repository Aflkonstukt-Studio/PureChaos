package xyz.aflkonstukt.purechaos.network;

import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import java.util.function.Supplier;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PurechaosModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, PurechaosMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());
	public static double mob_cap_multiplier = 10.0;
	public static List<Object> word_challenges = new ArrayList<>();
	public static List<Object> math_challenges = new ArrayList<>();
	public static List<Object> word_answers = new ArrayList<>();
	public static List<Object> math_answers = new ArrayList<>();

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PurechaosMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		PurechaosMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
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
			clone.sanity_enabled = original.sanity_enabled;
			clone.kidnapped = original.kidnapped;
			clone.accumulated_rizz = original.accumulated_rizz;
			if (!event.isWasDeath()) {
				clone.wrong_answers = original.wrong_answers;
				clone.sanity = original.sanity;
				clone.show_nikocado = original.show_nikocado;
				clone.nightmare_duration = original.nightmare_duration;
				clone.having_nightmare = original.having_nightmare;
				clone.jump_count = original.jump_count;
				clone.invert_controls = original.invert_controls;
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
				clone.captcha = original.captcha;
				clone.disable_backrooms = original.disable_backrooms;
				clone.captcha_challenge = original.captcha_challenge;
				clone.captcha_answer = original.captcha_answer;
				clone.captcha_type = original.captcha_type;
				clone.captcha_player_antwort = original.captcha_player_antwort;
				clone.text_captcha = original.text_captcha;
				clone.constipated = original.constipated;
				clone.rizz = original.rizz;
				clone.announced_rizzed = original.announced_rizzed;
				clone.arthritis = original.arthritis;
				clone.thirst = original.thirst;
				clone.speed = original.speed;
				clone.arthritis_time = original.arthritis_time;
				clone.healthiness = original.healthiness;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "purechaos_worldvars";
		public double last_event = 0;
		public HashMap<String, Vec3> meteor = new HashMap<String, Vec3>();
		public double meteor_announce = 20.0;

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			last_event = nbt.getDouble("last_event");
			{
				this.meteor = new HashMap<>();
				CompoundTag compoundTag = nbt.getCompound("meteor");
				for (String name : compoundTag.getAllKeys()) {
					ListTag listTag = compoundTag.getList(name, 6);
					this.meteor.put(name, new Vec3(listTag.getDouble(0), listTag.getDouble(1), listTag.getDouble(2)));
				}
			}
			meteor_announce = nbt.getDouble("meteor_announce");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("last_event", last_event);
			{
				CompoundTag compoundTag = new CompoundTag();
				for (Map.Entry<String, Vec3> entry : this.meteor.entrySet()) {
					Vec3 vec3 = entry.getValue();
					vec3 = vec3 == null ? Vec3.ZERO : vec3;
					ListTag listTag = new ListTag();
					listTag.addTag(0, DoubleTag.valueOf(vec3.x()));
					listTag.addTag(1, DoubleTag.valueOf(vec3.y()));
					listTag.addTag(2, DoubleTag.valueOf(vec3.z()));
					compoundTag.put(entry.getKey(), listTag);
				}
				nbt.put("meteor", compoundTag);
			}
			nbt.putDouble("meteor_announce", meteor_announce);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "purechaos_mapvars";
		public double ypx = 0;
		public double ypz = 0;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			ypx = nbt.getDouble("ypx");
			ypz = nbt.getDouble("ypz");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("ypx", ypx);
			nbt.putDouble("ypz", ypz);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(new ResourceLocation(PurechaosMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public double wrong_answers = 0.0;
		public double sanity = 100.0;
		public boolean show_nikocado = false;
		public double nightmare_duration = 0;
		public boolean having_nightmare = false;
		public double jump_count = 0;
		public boolean invert_controls = false;
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
		public boolean captcha = false;
		public boolean disable_backrooms = false;
		public String captcha_challenge = "\"\"";
		public String captcha_answer = "\"\"";
		public String captcha_type = "\"\"";
		public String captcha_player_antwort = "\"\"";
		public boolean sanity_enabled = true;
		public double text_captcha = 0;
		public double constipated = -1.0;
		public double rizz = 0;
		public boolean kidnapped = false;
		public double accumulated_rizz = 0;
		public boolean announced_rizzed = false;
		public boolean arthritis = false;
		public double thirst = 100.0;
		public double speed = 0;
		public double arthritis_time = 0;
		public double healthiness = 100.0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("wrong_answers", wrong_answers);
			nbt.putDouble("sanity", sanity);
			nbt.putBoolean("show_nikocado", show_nikocado);
			nbt.putDouble("nightmare_duration", nightmare_duration);
			nbt.putBoolean("having_nightmare", having_nightmare);
			nbt.putDouble("jump_count", jump_count);
			nbt.putBoolean("invert_controls", invert_controls);
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
			nbt.putBoolean("captcha", captcha);
			nbt.putBoolean("disable_backrooms", disable_backrooms);
			nbt.putString("captcha_challenge", captcha_challenge);
			nbt.putString("captcha_answer", captcha_answer);
			nbt.putString("captcha_type", captcha_type);
			nbt.putString("captcha_player_antwort", captcha_player_antwort);
			nbt.putBoolean("sanity_enabled", sanity_enabled);
			nbt.putDouble("text_captcha", text_captcha);
			nbt.putDouble("constipated", constipated);
			nbt.putDouble("rizz", rizz);
			nbt.putBoolean("kidnapped", kidnapped);
			nbt.putDouble("accumulated_rizz", accumulated_rizz);
			nbt.putBoolean("announced_rizzed", announced_rizzed);
			nbt.putBoolean("arthritis", arthritis);
			nbt.putDouble("thirst", thirst);
			nbt.putDouble("speed", speed);
			nbt.putDouble("arthritis_time", arthritis_time);
			nbt.putDouble("healthiness", healthiness);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			wrong_answers = nbt.getDouble("wrong_answers");
			sanity = nbt.getDouble("sanity");
			show_nikocado = nbt.getBoolean("show_nikocado");
			nightmare_duration = nbt.getDouble("nightmare_duration");
			having_nightmare = nbt.getBoolean("having_nightmare");
			jump_count = nbt.getDouble("jump_count");
			invert_controls = nbt.getBoolean("invert_controls");
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
			captcha = nbt.getBoolean("captcha");
			disable_backrooms = nbt.getBoolean("disable_backrooms");
			captcha_challenge = nbt.getString("captcha_challenge");
			captcha_answer = nbt.getString("captcha_answer");
			captcha_type = nbt.getString("captcha_type");
			captcha_player_antwort = nbt.getString("captcha_player_antwort");
			sanity_enabled = nbt.getBoolean("sanity_enabled");
			text_captcha = nbt.getDouble("text_captcha");
			constipated = nbt.getDouble("constipated");
			rizz = nbt.getDouble("rizz");
			kidnapped = nbt.getBoolean("kidnapped");
			accumulated_rizz = nbt.getDouble("accumulated_rizz");
			announced_rizzed = nbt.getBoolean("announced_rizzed");
			arthritis = nbt.getBoolean("arthritis");
			thirst = nbt.getDouble("thirst");
			speed = nbt.getDouble("speed");
			arthritis_time = nbt.getDouble("arthritis_time");
			healthiness = nbt.getDouble("healthiness");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(new ResourceLocation(PurechaosMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
