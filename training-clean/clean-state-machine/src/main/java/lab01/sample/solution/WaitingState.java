package lab01.sample.solution;

final class WaitingState implements ATMState {

	private ATMContext atm;

	WaitingState(ATMContext atm) {
		super();
		this.atm = atm;
	}

	public void enterCard(Card card) {
		atm.card = card;
		atm.changeState(atm.hasUniverifiedCardState);
	}

	public boolean enterPin(String pin) {
		atm.callback.displayMessage("Please enter a card first!");
		return false;
	}

	public void ejectCard() {
		atm.callback.displayMessage("No card inserted!");
	}

	public int requestAmount(int amount) {
		atm.callback.displayMessage("No card inserted!");
		return 0;
	}

}
