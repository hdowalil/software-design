package lab01.sample.solution;

public class BankAccountObserverWarning implements BankAccountObserver {

	private boolean warning=false;
	
	@Override
	public void availableAmountUpdated(long newAvailableAmount) {
		
		this.warning = newAvailableAmount < 100;
		
		if (this.warning) {
			System.out.println("oops, we are below 100 bucks, go find a job ;-)");
		}
		
	}

	public boolean isWarning() {
		return warning;
	}
	
}
