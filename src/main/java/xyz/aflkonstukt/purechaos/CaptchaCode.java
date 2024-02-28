package xyz.aflkonstukt.purechaos;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CaptchaCode {
    private static ChallengeType type;
    private static String challengeText;
    private static String correctAnswer;
    private static int wrongAnswers = 0;
    private static boolean challengeInProgress = false;
    private static boolean captchaInProgress = false;

	public CaptchaCode() {}

    private static final Random random = new Random();

    private static final String[] mathChallenges = {
            "2 + 2", "5 * 3", "10 - 7", "8 / 2", "9 * 9", "12 / 4", "3 + 5", "7 * 7", "10 - 3", "6 / 2", "4 * 4", "9 / 3", "5 + 7", "8 * 8", "12 - 5", "10 / 2"
    };
    private static final String[] mathAnswers = {
            "4", "15", "3", "4", "81", "3", "8", "49", "7", "3", "16", "3", "12", "64", "7", "5"
    };

    private static final String[] wordChallenges = {
            "hello", "world", "programming", "minecraft", "forge", "blockbench", "yourmom", "java", "modding", "fabric", "chaos", "giggity", "poggers", "pogchamp", "pog", "champ"
    };

    public enum ChallengeType {
        MATH, WORD
    }

    public static void generateChallenge() {
        if (random.nextBoolean()) {
            type = ChallengeType.MATH;
            generateMathChallenge();
        } else {
            type = ChallengeType.WORD;
            generateWordChallenge();
        }

        captchaInProgress = true;
    }

    private static void generateMathChallenge() {
        int index = random.nextInt(mathChallenges.length);
        String challenge = mathChallenges[index];
        challengeText = "What is " + challenge + "?";
        correctAnswer = mathAnswers[index];
    }

    private static void generateWordChallenge() {
        int index = random.nextInt(wordChallenges.length);
        challengeText = "Spell '" + wordChallenges[index] + "' backwards";
        correctAnswer = new StringBuilder(wordChallenges[index]).reverse().toString();
    }

    public static ChallengeType getType() {
        return type;
    }

    public static String getChallengeText() {
        return challengeText;
    }
    public static boolean isCaptchaInProgress() {return captchaInProgress;}

    public static boolean validateAnswer(String userAnswer, Entity entity) {
        if (!(entity instanceof Player _player) || challengeInProgress) //  Check flag
            return false;

        challengeInProgress = true; // Set the flag

        boolean correct = userAnswer.equals(correctAnswer);
        if (!correct) {
            wrongAnswers++;
            _player.displayClientMessage(Component.nullToEmpty("Incorrect. " + (4 - wrongAnswers) + " attempt" + ((4 - wrongAnswers) != 1 ? "s" : "") +  " remaining."), true);
            challengeInProgress = false; // Reset the flag
        } else {
            captchaInProgress = false;
            _player.closeContainer();
            challengeInProgress = false; // Reset the flag
            wrongAnswers = 0; // Reset the counter
        }

        if (wrongAnswers >= 3) {
            captchaInProgress = false;
            _player.kill();
            wrongAnswers = 0;
            challengeInProgress = false; // Reset the flag
        }

        return true;
    }
}
