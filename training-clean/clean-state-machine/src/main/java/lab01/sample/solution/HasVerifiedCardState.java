package lab01.sample.solution;

final class HasVerifiedCardState implements ATMState {

	private ATMContext atm;

	HasVerifiedCardState(ATMContext atm) {
		super();
		this.atm = atm;
	}

	@Override
	public void enterCard(Card card) {
		atm.callback.displayMessage("You have already entered a card!");
	}

	@Override
	public boolean enterPin(String pin) {
		atm.callback.displayMessage("The card is already verified!");
		return false;
	}

	@Override
	public void ejectCard() {
		atm.card = null;
		atm.changeState(atm.waitingState);
	}

	@Override
	public int requestAmount(int amount) {
		int givenAmount = atm.callback.dispenseMoney(amount);
		atm.changeState(atm.waitingState);
		return givenAmount;
	}

}
