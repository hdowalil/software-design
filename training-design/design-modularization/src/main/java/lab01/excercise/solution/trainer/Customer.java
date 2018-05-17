package lab01.excercise.solution.trainer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Customer {
	
	private final static String CC_NO = "1234123456785678";
	
	private int ccLimitLeft = 2000;
	
	private Map<Product, Integer> myProducts = new HashMap<>();

	public void placeAnOrder(OrderPosition... pos) {

		final Order order = new Order();
		
		Arrays.stream(pos).forEach( p -> order.add(p.getP(), p.getAmount()));
		order.setCreditCard(CC_NO);
		order.placeOrder(this);
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
