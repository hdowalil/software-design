package lab01.sample.solution;

import javax.annotation.MatchesPattern;

/**
 * Can have multiple implementations, from maestro to visa and mastercard
 */
public interface Card {

	public final static String PIN_REGEX_PATTERN = "\\d{4}";
	
	public boolean verifyPin(@MatchesPattern(PIN_REGEX_PATTERN) String pin2Verify);
	
}
