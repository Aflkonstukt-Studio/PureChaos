package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.CaptchaCode;

public class CaptchaProcedureProcedure {
	public static String execute() {
		return CaptchaCode.getChallengeText();
	}
}
