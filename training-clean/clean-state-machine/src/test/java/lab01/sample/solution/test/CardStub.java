package lab01.sample.solution.test;

import lab01.sample.solution.Card;

public class CardStub implements Card {
	
	private String pin;
	private int fails = 0;

	public CardStub(String pin) {
		super();
		this.pin = pin;
	}
	
	public boolean verifyPin(String pin2Verify) {
		boolean result = pin.equals(pin2Verify);
		if (!result) {
			fails++;
			if (fails >= 3) {
				throw new IllegalArgumentException("Card will be locked and kept by this ATM");
			}
		}
		return result;
	}

}
