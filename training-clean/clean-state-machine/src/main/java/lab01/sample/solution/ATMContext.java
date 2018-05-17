package lab01.sample.solution;

import java.util.Objects;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * In the original pattern, the Context does NOT implement State interface as well.
 * <br>
 * This is usually not the case, as the context itself is part of the parameters in the state methods,
 * whereas the context is NOT part in the event-methods in the context for the client of the context.
 * <br>
 * We implement a slightly different version of the pattern.
 * As our events of the machine match the State-Events we let the states access the context class,
 * and therefore we do not need the context as param in the state-event-methods in the state-interface,
 * and therefore we can implement the same interface also by the context
 * <br>
 * Another effect that this adaptation of the original pattern has ist, that we can hide the context,
 * and only externalize the state-interface itself, with a default factory method to create a context implementation!
 */
final class ATMContext implements ATMState {

	ATMState waitingState;
	ATMState hasUniverifiedCardState;
	ATMState hasVerfiedCardState;
	
	private ATMState currentState;
	
	Card card;
	ATMCallback callback;

	ATMContext(@Nonnull ATMCallback callback) {
		super();
		
		this.waitingState = new WaitingState(this);
		this.hasUniverifiedCardState = new HasUnverifiedCardState(this);
		this.hasVerfiedCardState = new HasVerifiedCardState(this);
		this.currentState = waitingState;
		
		Objects.requireNonNull(callback);
		this.callback = callback;
	}
	
	void changeState(ATMState newATMEvents) { 
		this.currentState = newATMEvents; 
	}
	
	@Override
	public void enterCard(Card card) { 
	
		Objects.requireNonNull(card);
		currentState.enterCard(card); 
	}
	
	@Override
	public boolean enterPin(String pin) {
		
		if (pin == null || !pin.matches(Card.PIN_REGEX_PATTERN)) {
			throw new IllegalArgumentException("Please allow only 4 digit pins in the console!");
		}
		
		return currentState.enterPin(pin); 
	}
	
	@Override
	public void ejectCard() { 
		currentState.ejectCard(); 
	}
	
	@Override
	public int requestAmount(@Nonnegative int amount) {
		
		if (amount < 0) {
			throw new IllegalArgumentException("only positive values are accepted");
		}
		
		return currentState.requestAmount(amount); 
	}

}
