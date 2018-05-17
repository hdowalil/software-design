package lab01.sample.challenge;

public class BankAccount {

	private long availableAmount;

	public void receiveMoney(long amount) {
		availableAmount += amount;
	}

	public void spendMoney(long amount) {
		availableAmount -= amount;
		if (availableAmount < 100) {
			BankAccountWarning.warn();
		}
	}
}
