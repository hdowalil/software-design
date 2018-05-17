package lab01.sample.solution;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

	@Test
	public void testWarningObserver() {
		
		BankAccount account = new BankAccount();
		account.receiveMoney(10000);
		
		BankAccountObserverWarning observer = new BankAccountObserverWarning();
		account.registerObserver(observer);
		
		Assertions.assertFalse(observer.isWarning(),"There should not be a warning yet!");
		
		account.receiveMoney(1000);
		Assertions.assertFalse(observer.isWarning(),"There should not be a warning yet!");
		
		account.spendMoney(9000);
		Assertions.assertFalse(observer.isWarning(),"There should not be a warning yet!");
		
		account.spendMoney(1901);
		Assertions.assertTrue(observer.isWarning(),"There should be a warning now, as we have only 99 bucks left!");
		
	}
	
	@Test
	public void testObserver() {
	
		final AtomicInteger counter = new AtomicInteger(0);
		
		BankAccount account = new BankAccount();
		account.receiveMoney(10000);
		
		account.registerObserver(amount -> counter.incrementAndGet());
		
		Assertions.assertEquals(0, counter.get(), "Should not have been called, just because of adding it!");
		
		account.spendMoney(10);
		Assertions.assertEquals(1, counter.get(), "Should have been called once now!");
		
	}
}
