package lab01.sample.solution.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lab01.sample.solution.ATMState;

public class ATMTest {
	
	@Test
	public void testPinException() {
		
		CardStub card = new CardStub("4242");
		
		ATMState atm = ATMStub.createATM(10000, System.out::println, System.out::println);
		
		atm.enterCard(card);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> atm.enterPin("42"), "Should throw exception!");
		
		Assertions.assertFalse(atm.enterPin("4040"),"This PIN should not be accepted");
		Assertions.assertFalse(atm.enterPin("4141"),"This PIN should not be accepted");
		Assertions.assertThrows(IllegalArgumentException.class, () -> atm.enterPin("4343"), "Should throw exception!");
	}
	
	@Test
	public void testMoneyRetreival() {
		
		CardStub card = new CardStub("4242");
		
		ATMState atm = ATMStub.createATM(10000, System.out::println, System.out::println);
		
		atm.enterCard(card);
		Assertions.assertEquals(0,atm.requestAmount(100),"An unverified Card should not dispense money");
		Assertions.assertTrue(atm.enterPin("4242"),"Should accept the correct PIN");
		Assertions.assertEquals(9000,atm.requestAmount(9000),"Should give us 9 Grand");
		
		Assertions.assertEquals(0,atm.requestAmount(1000),"Card is ejected, no money should be dispensed");
		
		atm.enterCard(card);
		Assertions.assertTrue(atm.enterPin("4242"),"Should accept the correct PIN");
		Assertions.assertEquals(1000,atm.requestAmount(1000),"Should give us 1 Grand that is left");
		
		atm.enterCard(card);
		Assertions.assertTrue(atm.enterPin("4242"),"Should accept the correct PIN");
		Assertions.assertEquals(0,atm.requestAmount(1),"Should be out of money");
		
	}

}
