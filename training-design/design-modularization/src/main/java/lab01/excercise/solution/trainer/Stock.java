package lab01.excercise.solution.trainer;

import java.util.HashMap;
import java.util.Map;

public class Stock {
	
	private static Map<Product,Integer> stock;
	
	static {
		stock = new HashMap<>();
		stock.put(Product.A, 10);
		stock.put(Product.B, 10);
		stock.put(Product.C, 10);
		stock.put(Product.D, 10);
	}

	public static synchronized boolean isAvailable(Product p, int amount) {
		
		if (!stock.containsKey(p)) {
			return false;
		} else {
			return (stock.get(p).intValue() >= amount);
		}
	}
	
	public static synchronized boolean reserveForOrder(Product p, int amount) {
		
		if (!isAvailable(p, amount)) {
			return false;
		} else {
			stock.put(p, stock.get(p).intValue() - amount);
			return true;
		}
	}
	
	public static synchronized void releaseFromOrder(Product p, int amount) {
		
		stock.put(p, stock.get(p).intValue() + amount);
	}
	
}
