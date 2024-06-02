package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupCaptchaWordChallengesProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		PurechaosModVariables.word_challenges.add("hello");
		PurechaosModVariables.word_answers.add("olleh");
		PurechaosModVariables.word_challenges.add("world");
		PurechaosModVariables.word_answers.add("dlrow");
		PurechaosModVariables.word_challenges.add("programming");
		PurechaosModVariables.word_answers.add("gnimmargorp");
		PurechaosModVariables.word_challenges.add("minecraft");
		PurechaosModVariables.word_answers.add("tfarcenim");
		PurechaosModVariables.word_challenges.add("forge");
		PurechaosModVariables.word_answers.add("egrof");
		PurechaosModVariables.word_challenges.add("blockbench");
		PurechaosModVariables.word_answers.add("hcnebkcolb");
		PurechaosModVariables.word_challenges.add("yourmom");
		PurechaosModVariables.word_answers.add("momruoy");
		PurechaosModVariables.word_challenges.add("java");
		PurechaosModVariables.word_answers.add("avaj");
		PurechaosModVariables.word_challenges.add("modding");
		PurechaosModVariables.word_answers.add("gniddom");
		PurechaosModVariables.word_challenges.add("fabric");
		PurechaosModVariables.word_answers.add("cirbaf");
		PurechaosModVariables.word_challenges.add("chaos");
		PurechaosModVariables.word_answers.add("soahc");
		PurechaosModVariables.word_challenges.add("giggity");
		PurechaosModVariables.word_answers.add("ytiggig");
		PurechaosModVariables.word_challenges.add("poggers");
		PurechaosModVariables.word_answers.add("sreggop");
		PurechaosModVariables.word_challenges.add("pogchamp");
		PurechaosModVariables.word_answers.add("pmahcgop");
		PurechaosModVariables.word_challenges.add("meow");
		PurechaosModVariables.word_answers.add("woem");
		PurechaosModVariables.word_challenges.add("boykisser");
		PurechaosModVariables.word_answers.add("ressikyob");
		PurechaosModVariables.word_challenges.add("kawaii");
		PurechaosModVariables.word_answers.add("iiawak");
		PurechaosModVariables.word_challenges.add("onii-chan");
		PurechaosModVariables.word_answers.add("nahc-iino");
		PurechaosModVariables.word_challenges.add("captcha");
		PurechaosModVariables.word_answers.add("ahctpac");
		PurechaosModVariables.word_challenges.add("I am not a robot");
		PurechaosModVariables.word_answers.add("tobor a ton ma I");
	}
}
