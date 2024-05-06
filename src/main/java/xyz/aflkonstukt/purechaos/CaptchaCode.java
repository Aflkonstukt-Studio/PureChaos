package xyz.aflkonstukt.purechaos;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import java.util.Random;

public class CaptchaCode {
    private static ChallengeType type;
    private static String challengeText;
    private static String correctAnswer;
    private static boolean challengeInProgress = false;
    private static boolean captchaInProgress = false;

	public CaptchaCode() {}

    private static final Random random = new Random();

    private static final String[] mathChallenges = {
            "2 + 2", "5 * 3", "10 - 7", "8 / 2", "9 * 9", "12 / 4", "3 + 5", "7 * 7", "10 - 3", "6 / 2", "4 * 4", "9 / 3", "5 + 7", "8 * 8", "12 - 5", "10 / 2", "100 - 21"
    };
    private static final String[] mathAnswers = {
            "4", "15", "3", "4", "81", "3", "8", "49", "7", "3", "16", "3", "12", "64", "7", "5", "79"
    };

    private static final String[] wordChallenges = {
            "hello", "world", "programming", "minecraft", "forge", "blockbench", "yourmom", "java", "modding", "fabric", "chaos", "giggity", "poggers", "pogchamp", "pog", "champ", "meow", "boykisser", "kawaii", "onii-chan", "captcha", "I am not a robot"
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
        int wrongAnswers = (int) entity.getData(PurechaosModVariables.PLAYER_VARIABLES).wrong_answers;
        if (!correct) {
            PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
            _vars.wrong_answers += 1;
            _vars.syncPlayerVariables(entity);

            _player.displayClientMessage(Component.nullToEmpty("Incorrect. " + (3 - wrongAnswers) + " attempt" + ((3 - wrongAnswers) != 1 ? "s" : "") +  " remaining."), true);
            challengeInProgress = false;
        } else {
            captchaInProgress = false;
            challengeInProgress = false;

            PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
            _vars.wrong_answers = 0;
            _vars.syncPlayerVariables(entity);

            _player.closeContainer();
        }

        PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
        if (_vars.wrong_answers >= 4) {
            captchaInProgress = false;
            _vars.wrong_answers = 0;
            _vars.syncPlayerVariables(entity);
            challengeInProgress = false; // Reset the flag
            _player.kill();
        }

        return true;
    }
}
