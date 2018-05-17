package lab01.excercise.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaceOrderTest {

	@Test
	public void placingAnOrderAndReceivingItems() {
		
		Customer c = new Customer();
		
		// we ain´t got nuffin yet
		Assertions.assertEquals(0, c.getAmountOfMyProducts(Product.A));
		Assertions.assertEquals(0, c.getAmountOfMyProducts(Product.B));
		Assertions.assertEquals(0, c.getAmountOfMyProducts(Product.C));
		Assertions.assertEquals(0, c.getAmountOfMyProducts(Product.D));
		
		// there should be 10 in stock
		Assertions.assertTrue(Stock.isAvailable(Product.A, 10));
		Assertions.assertTrue(Stock.isAvailable(Product.B, 10));
		Assertions.assertTrue(Stock.isAvailable(Product.C, 10));
		Assertions.assertTrue(Stock.isAvailable(Product.D, 10));
		// but not 11
		Assertions.assertFalse(Stock.isAvailable(Product.A, 11));
		Assertions.assertFalse(Stock.isAvailable(Product.B, 11));
		Assertions.assertFalse(Stock.isAvailable(Product.C, 11));
		Assertions.assertFalse(Stock.isAvailable(Product.D, 11));
	
		c.placeAnOrder(new OrderPosition(Product.A,4),new OrderPosition(Product.C, 3),new OrderPosition(Product.A, 6));
		
		// no we have some stuff
		Assertions.assertEquals(10, c.getAmountOfMyProducts(Product.A));
		Assertions.assertEquals(0, c.getAmountOfMyProducts(Product.B));
		Assertions.assertEquals(3, c.getAmountOfMyProducts(Product.C));
		Assertions.assertEquals(0, c.getAmountOfMyProducts(Product.D));
		
		// we should have in stock now
		Assertions.assertTrue(Stock.isAvailable(Product.A, 0));
		Assertions.assertTrue(Stock.isAvailable(Product.B, 10));
		Assertions.assertTrue(Stock.isAvailable(Product.C, 7));
		Assertions.assertTrue(Stock.isAvailable(Product.D, 10));
		// but not:
		Assertions.assertFalse(Stock.isAvailable(Product.A, 1));
		Assertions.assertFalse(Stock.isAvailable(Product.B, 11));
		Assertions.assertFalse(Stock.isAvailable(Product.C, 8));
		Assertions.assertFalse(Stock.isAvailable(Product.D, 11));
		
	}
}
