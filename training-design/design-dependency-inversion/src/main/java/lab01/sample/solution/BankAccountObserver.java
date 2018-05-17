package lab01.sample.solution;

@FunctionalInterface
public interface BankAccountObserver {

	public void availableAmountUpdated (long newAvailableAmount);
	
}
