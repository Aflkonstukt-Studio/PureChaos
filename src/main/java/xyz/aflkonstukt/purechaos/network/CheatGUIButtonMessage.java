
package xyz.aflkonstukt.purechaos.network;

import xyz.aflkonstukt.purechaos.world.inventory.CheatGUIMenu;
import xyz.aflkonstukt.purechaos.procedures.DoNotPressPressedProcedure;
import xyz.aflkonstukt.purechaos.procedures.CheatGUISwitchGamemodeProcedure;
import xyz.aflkonstukt.purechaos.procedures.CheatGUISwitchDimensionProcedure;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record CheatGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<CheatGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "cheat_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, CheatGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CheatGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new CheatGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<CheatGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final CheatGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = CheatGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CheatGUISwitchGamemodeProcedure.execute(entity);
		}
		if (buttonID == 1) {

			CheatGUISwitchDimensionProcedure.execute(entity);
		}
		if (buttonID == 2) {

			DoNotPressPressedProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PurechaosMod.addNetworkMessage(CheatGUIButtonMessage.TYPE, CheatGUIButtonMessage.STREAM_CODEC, CheatGUIButtonMessage::handleData);
	}
}
