package lab01.sample.solution;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

	private long availableAmount;

	private List<BankAccountObserver> observers = new ArrayList<BankAccountObserver>();

	public void registerObserver(BankAccountObserver newObserver) {
		observers.add(newObserver);
	}

	public void removeObserver(BankAccountObserver observer2Remove) {
		observers.remove(observer2Remove);
	}

	private void notifyObservers() {
		for (BankAccountObserver concreteObserver : observers) {
			concreteObserver.availableAmountUpdated(availableAmount);
		}
	}

	public void receiveMoney(long amount) {
		availableAmount += amount;
		notifyObservers();
	}

	public void spendMoney(long amount) {
		availableAmount -= amount;
		notifyObservers();
	}
}
