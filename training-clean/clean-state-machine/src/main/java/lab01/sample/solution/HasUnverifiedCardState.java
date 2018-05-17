package lab01.sample.solution;

final class HasUnverifiedCardState implements ATMState {

	private ATMContext atm;

	HasUnverifiedCardState(ATMContext atm) {
		super();
		this.atm = atm;
	}

	@Override
	public void enterCard(Card card) {
		atm.callback.displayMessage("You have already entered a card!");
	}

	@Override
	public boolean enterPin(String pin) {
		if (atm.card.verifyPin(pin)) {
			atm.changeState(atm.hasVerfiedCardState);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void ejectCard() {
		atm.card = null;
		atm.changeState(atm.waitingState);
	}

	@Override
	public int requestAmount(int amount) {
		atm.callback.displayMessage("Please enter your pin first!");
		return 0;
	}

}
