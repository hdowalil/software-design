package lab01.excercise.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Customer {
	
	private final static String CC_NO = "1234123456785678";
	
	private int ccLimitLeft = 2000;
	
	private Map<Product, Integer> myProducts = new HashMap<>();

	public void placeAnOrder(OrderPosition... pos) {

		final Controller ctrl = new Controller(this);
		
		Arrays.stream(pos).forEach( p -> ctrl.add2Order(p.getP(), p.getAmount()));
		ctrl.setCreditCard(CC_NO);
		ctrl.placeOrder();
	}
	
	public void receiveProducts(Map<Product,Integer> products) {
		
		products.keySet().stream().forEach(
				p -> {
					myProducts.computeIfAbsent(p, v -> 0);
					myProducts.put(p, myProducts.get(p) + products.get(p));
				}
				);
	}
	
	public int getCcLimitLeft() {
		return ccLimitLeft;
	}

	public int getAmountOfMyProducts(Product p) {
		myProducts.computeIfAbsent(p, v -> 0);
		return myProducts.get(p);
	}
	
	public void chargeMyCC(int sum) {
		if (ccLimitLeft < sum) {
			throw new IllegalArgumentException("CC Card Limit reached");
		}
		this.ccLimitLeft -= sum;
	}
}
