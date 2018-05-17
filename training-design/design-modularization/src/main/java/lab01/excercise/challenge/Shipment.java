package lab01.excercise.challenge;

import java.util.HashMap;
import java.util.Map;

public class Shipment {
	
	public static void parcelAndShip(Order order, Customer customer) {
		
		Map<Product, Integer> parcel = new HashMap<>();
		
		for (int i=0; i<order.getNoOfPositions(); i++) {
			Product product = order.getProductAtPosition(i);
			parcel.computeIfAbsent(product, p -> 0);
			parcel.put(product, parcel.get(product) + order.getAmountAtPosition(i));
		}
		
		System.out.println("Shipping: " + parcel);
		customer.receiveProducts(parcel);
	}

}
