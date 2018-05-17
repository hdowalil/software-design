package lab01.excercise.solution.trainer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shipment {
	
	public static void parcelAndShip(String creditCard, List<OrderPosition> positions, Customer customer) {
		
		int sum = positions.stream().map(p -> p.getAmount() * p.getP().getPrice()).mapToInt(i -> i.intValue()).sum();
		Billing.chargeCreditCard(creditCard, sum);
		
		Map<Product, Integer> parcel = new HashMap<>();
		
		for (int i=0; i<positions.size(); i++) {
			Product product = positions.get(i).getP();
			parcel.computeIfAbsent(product, p -> 0);
			parcel.put(product, parcel.get(product) + positions.get(i).getAmount());
		}
		
		System.out.println("Modular shipping: " + parcel);
		customer.receiveProducts(parcel);
	}
	
	public static boolean isValidPayment(String cc) {
		return Billing.isValidCreditCard(cc);
	}

}
