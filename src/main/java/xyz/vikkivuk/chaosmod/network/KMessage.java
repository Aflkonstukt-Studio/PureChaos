
package xyz.vikkivuk.chaosmod.network;

import xyz.vikkivuk.chaosmod.ChaosmodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KMessage {

	int type, pressedms;

	public KMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public KMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(KMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(KMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;

		if (type == 0) {

			KOnKeyPressedProcedure.execute(entity);
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ChaosmodMod.addNetworkMessage(KMessage.class, KMessage::buffer, KMessage::new, KMessage::handler);
	}

}
