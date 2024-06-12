package xyz.aflkonstukt.purechaos;

import xyz.aflkonstukt.purechaos.world.features.StructureFeature;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModTabs;
import xyz.aflkonstukt.purechaos.init.PurechaosModSounds;
import xyz.aflkonstukt.purechaos.init.PurechaosModPotions;
import xyz.aflkonstukt.purechaos.init.PurechaosModParticleTypes;
import xyz.aflkonstukt.purechaos.init.PurechaosModPaintings;
import xyz.aflkonstukt.purechaos.init.PurechaosModMobEffects;
import xyz.aflkonstukt.purechaos.init.PurechaosModMenus;
import xyz.aflkonstukt.purechaos.init.PurechaosModItems;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;
import xyz.aflkonstukt.purechaos.init.PurechaosModFluidTypes;
import xyz.aflkonstukt.purechaos.init.PurechaosModFeatures;
import xyz.aflkonstukt.purechaos.init.PurechaosModEntities;
import xyz.aflkonstukt.purechaos.init.PurechaosModBlocks;
import xyz.aflkonstukt.purechaos.init.PurechaosModBlockEntities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.neoforge.network.handling.IPlayPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.util.Tuple;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

import java.lang.reflect.Field;

import java.io.StringWriter;
import java.io.PrintWriter;

@Mod("purechaos")
public class PurechaosMod {
	public static final Logger LOGGER = LogManager.getLogger(PurechaosMod.class);
	public static final String MODID = "purechaos";

	public PurechaosMod(IEventBus modEventBus) {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		NeoForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::registerNetworking);
		PurechaosModSounds.REGISTRY.register(modEventBus);
		PurechaosModBlocks.REGISTRY.register(modEventBus);
		PurechaosModBlockEntities.REGISTRY.register(modEventBus);
		PurechaosModItems.register(modEventBus);
		PurechaosModEntities.REGISTRY.register(modEventBus);
		PurechaosModTabs.REGISTRY.register(modEventBus);
		PurechaosModVariables.ATTACHMENT_TYPES.register(modEventBus);
		PurechaosModFeatures.REGISTRY.register(modEventBus);
		StructureFeature.REGISTRY.register(modEventBus);
		PurechaosModPaintings.REGISTRY.register(modEventBus);
		PurechaosModPotions.REGISTRY.register(modEventBus);
		PurechaosModMobEffects.REGISTRY.register(modEventBus);

		PurechaosModMenus.REGISTRY.register(modEventBus);
		PurechaosModParticleTypes.REGISTRY.register(modEventBus);

		PurechaosModFluids.REGISTRY.register(modEventBus);
		PurechaosModFluidTypes.REGISTRY.register(modEventBus);
		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	public static class TextboxSetMessage implements CustomPacketPayload {
		public static final ResourceLocation ID = new ResourceLocation(PurechaosMod.MODID, "textbox_set_value");
		private final String textboxid;
		private final String data;

		public TextboxSetMessage(FriendlyByteBuf buffer) {
			this.textboxid = buffer.readUtf();
			this.data = buffer.readUtf();
		}

		public TextboxSetMessage(String textboxid, String data) {
			this.textboxid = textboxid;
			this.data = data;
		}

		@Override
		public void write(final FriendlyByteBuf buffer) {
			buffer.writeUtf(textboxid);
			buffer.writeUtf(data);
		}

		@Override
		public ResourceLocation id() {
			return ID;
		}

		public static void handleData(final TextboxSetMessage message, final PlayPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.workHandler().submitAsync(() -> {
					Screen currentScreen = Minecraft.getInstance().screen;
					Map<String, EditBox> textFieldsMap = new HashMap<>();
					if (currentScreen != null) {
						Field[] fields = currentScreen.getClass().getDeclaredFields();
						for (Field field : fields) {
							if (EditBox.class.isAssignableFrom(field.getType())) {
								try {
									field.setAccessible(true);
									EditBox textField = (EditBox) field.get(currentScreen);
									if (textField != null) {
										textFieldsMap.put(field.getName(), textField);
									}
								} catch (IllegalAccessException ex) {
									StringWriter sw = new StringWriter();
									PrintWriter pw = new PrintWriter(sw);
									ex.printStackTrace(pw);
									String exceptionAsString = sw.toString();
									PurechaosMod.LOGGER.error(exceptionAsString);
								}
							}
						}
					}
					if (textFieldsMap.get(message.textboxid) != null) {
						textFieldsMap.get(message.textboxid).setValue(message.data);
					}
				}).exceptionally(e -> {
					context.packetHandler().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Inittextbox {
		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			PurechaosMod.addNetworkMessage(TextboxSetMessage.ID, TextboxSetMessage::new, TextboxSetMessage::handleData);
		}
	}

	private static boolean networkingRegistered = false;
	private static final Map<ResourceLocation, NetworkMessage<?>> MESSAGES = new HashMap<>();

	private record NetworkMessage<T extends CustomPacketPayload>(FriendlyByteBuf.Reader<T> reader, IPlayPayloadHandler<T> handler) {
	}

	public static <T extends CustomPacketPayload> void addNetworkMessage(ResourceLocation id, FriendlyByteBuf.Reader<T> reader, IPlayPayloadHandler<T> handler) {
		if (networkingRegistered)
			throw new IllegalStateException("Cannot register new network messages after networking has been registered");
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void registerNetworking(final RegisterPayloadHandlerEvent event) {
		final IPayloadRegistrar registrar = event.registrar(MODID);
		MESSAGES.forEach((id, networkMessage) -> registrar.play(id, ((NetworkMessage) networkMessage).reader(), networkMessage.handler()));
		networkingRegistered = true;
	}

	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new Tuple<>(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setB(work.getB() - 1);
				if (work.getB() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getA().run());
			workQueue.removeAll(actions);
		}
	}
}
