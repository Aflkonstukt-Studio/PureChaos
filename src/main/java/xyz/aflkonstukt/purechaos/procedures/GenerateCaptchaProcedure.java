package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class GenerateCaptchaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double random_challenge_index = 0;
		if (Mth.nextInt(RandomSource.create(), 1, 10) <= 5) {
			random_challenge_index = Mth.nextDouble(RandomSource.create(), 0, PurechaosModVariables.word_challenges.size());
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.captcha_challenge = PurechaosModVariables.word_challenges.get((int) random_challenge_index) instanceof String _s ? _s : "";
				_vars.syncPlayerVariables(entity);
			}
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.captcha_answer = PurechaosModVariables.word_answers.get((int) random_challenge_index) instanceof String _s ? _s : "";
				_vars.syncPlayerVariables(entity);
			}
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.captcha_type = "word_challenge";
				_vars.syncPlayerVariables(entity);
			}
		} else {
			random_challenge_index = Mth.nextDouble(RandomSource.create(), 0, PurechaosModVariables.math_challenges.size());
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.captcha_challenge = PurechaosModVariables.math_challenges.get((int) random_challenge_index) instanceof String _s ? _s : "";
				_vars.syncPlayerVariables(entity);
			}
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.captcha_answer = PurechaosModVariables.math_answers.get((int) random_challenge_index) instanceof String _s ? _s : "";
				_vars.syncPlayerVariables(entity);
			}
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.captcha_type = "math_challenge";
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
