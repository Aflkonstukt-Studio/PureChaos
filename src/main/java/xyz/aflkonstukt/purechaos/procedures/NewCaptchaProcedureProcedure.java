package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.CaptchaCode;

public class NewCaptchaProcedureProcedure {
	public static void execute() {
		CaptchaCode.generateChallenge();
	}
}
