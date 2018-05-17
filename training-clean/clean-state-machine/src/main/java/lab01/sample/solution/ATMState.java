package lab01.sample.solution;

import javax.annotation.MatchesPattern;
import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public interface ATMState {

	public void enterCard(@Nonnull Card card);
	public boolean enterPin(@MatchesPattern(Card.PIN_REGEX_PATTERN) String pin);
	public void ejectCard();
	public int requestAmount(@Nonnegative int amount);	
	
	public static ATMState createATMContext (ATMCallback callback) {
		return new ATMContext(callback);
	}
}
