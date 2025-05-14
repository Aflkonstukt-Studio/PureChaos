
package xyz.aflkonstukt.purechaos.network;

import xyz.aflkonstukt.purechaos.world.inventory.JGWarningMenu;
import xyz.aflkonstukt.purechaos.procedures.StartJudgmentDayProcedure;
import xyz.aflkonstukt.purechaos.procedures.ExitJudgmentDayProcedure;
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
public record JGWarningButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<JGWarningButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PurechaosMod.MODID, "jg_warning_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, JGWarningButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, JGWarningButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new JGWarningButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<JGWarningButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final JGWarningButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = JGWarningMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ExitJudgmentDayProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			StartJudgmentDayProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PurechaosMod.addNetworkMessage(JGWarningButtonMessage.TYPE, JGWarningButtonMessage.STREAM_CODEC, JGWarningButtonMessage::handleData);
	}
}
