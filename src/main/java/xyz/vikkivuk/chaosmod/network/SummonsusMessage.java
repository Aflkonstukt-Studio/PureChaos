
package xyz.vikkivuk.chaosmod.network;

import xyz.vikkivuk.chaosmod.ChaosmodMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SummonsusMessage {
	int type, pressedms;

	public SummonsusMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public SummonsusMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(SummonsusMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(SummonsusMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
		});
		context.setPacketHandled(true);
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ChaosmodMod.addNetworkMessage(SummonsusMessage.class, SummonsusMessage::buffer, SummonsusMessage::new, SummonsusMessage::handler);
	}
}
