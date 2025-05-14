package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SetupCaptchaMathChallengesProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		PurechaosModVariables.math_challenges.add("2 + 2");
		PurechaosModVariables.math_answers.add("4");
		PurechaosModVariables.math_challenges.add("5 * 3");
		PurechaosModVariables.math_answers.add("15");
		PurechaosModVariables.math_challenges.add("10 - 7");
		PurechaosModVariables.math_answers.add("3");
		PurechaosModVariables.math_challenges.add("8 / 2");
		PurechaosModVariables.math_answers.add("4");
		PurechaosModVariables.math_challenges.add("9 * 9");
		PurechaosModVariables.math_answers.add("81");
		PurechaosModVariables.math_challenges.add("12 / 4");
		PurechaosModVariables.math_answers.add("3");
		PurechaosModVariables.math_challenges.add("3 + 5");
		PurechaosModVariables.math_answers.add("8");
		PurechaosModVariables.math_challenges.add("7 * 7");
		PurechaosModVariables.math_answers.add("49");
		PurechaosModVariables.math_challenges.add("10 - 3");
		PurechaosModVariables.math_answers.add("7");
		PurechaosModVariables.math_challenges.add("6 / 2");
		PurechaosModVariables.math_answers.add("3");
		PurechaosModVariables.math_challenges.add("4 * 4");
		PurechaosModVariables.math_answers.add("16");
		PurechaosModVariables.math_challenges.add("9 / 3");
		PurechaosModVariables.math_answers.add("3");
		PurechaosModVariables.math_challenges.add("5 + 7");
		PurechaosModVariables.math_answers.add("12");
		PurechaosModVariables.math_challenges.add("8 * 8");
		PurechaosModVariables.math_answers.add("64");
		PurechaosModVariables.math_challenges.add("12 - 5");
		PurechaosModVariables.math_answers.add("7");
		PurechaosModVariables.math_challenges.add("10 / 2");
		PurechaosModVariables.math_answers.add("5");
		PurechaosModVariables.math_challenges.add("100 - 21");
		PurechaosModVariables.math_answers.add("79");
	}
}
