package lab01.sample.solution.test;

import java.util.function.Consumer;

import lab01.sample.solution.ATMCallback;
import lab01.sample.solution.ATMState;

/**
 * 
 * This class acts as a delegate
 *
 */
public class ATMStub implements ATMCallback {
	
	private int money;
	private Consumer<CharSequence> messageConsole;
	private Consumer<CharSequence> logger;
	private ATMState context;

	private ATMStub(int money, Consumer<CharSequence> messageConsole, 
			Consumer<CharSequence> logger) {
		super();
		this.money = money;
		this.messageConsole = messageConsole;
		this.logger = logger;
		context = ATMState.createATMContext(this);
	}
	
	public static ATMState createATM(int money, Consumer<CharSequence> messageConsole, 
			Consumer<CharSequence> logger) {
		ATMStub atm = new ATMStub(money, messageConsole, logger);
		return atm.context();
	}

	@Override
	public int dispenseMoney(int amount) {
		if (amount > money) {
			displayMessage(String.format("Cannot dispense %s, as we do not have enough left",Integer.toString(amount)));
			return 0;
		} else {
			money -= amount;
			logger.accept(String.format("Dispensed %s", Integer.toString(amount)));
			return amount;
		}
	}

	@Override
	public void displayMessage(CharSequence message) {
		messageConsole.accept(message);
		logger.accept(String.format("Message: %s", message));
	}

	public ATMState context() {
		return this.context;
	}
	
}
