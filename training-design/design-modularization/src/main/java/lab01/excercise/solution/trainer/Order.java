package lab01.excercise.solution.trainer;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<OrderPosition> positions;
	private String creditCard;
	
	public Order() {
		super();
		positions = new ArrayList<>();
	}
	
	public void setCreditCard(String creditCard) {
		
		if (!Shipment.isValidPayment(creditCard)) {
			throw new IllegalArgumentException();
		}
		
		this.creditCard = creditCard;
	}
	
	String getCreditCard() {
		return creditCard;
	}

	public boolean add(Product p, int amount) {
		
		if (!Stock.isAvailable(p, amount)) {
			return false;
		}
		
		Stock.reserveForOrder(p, amount);
		
		positions.add(new OrderPosition(p, amount));
		return true;
	}
	
	public void remove(int index) {
		
		Product p = getProductAtPosition(index);
		int amount = getAmountAtPosition(index);
		
		Stock.releaseFromOrder(p, amount);
		positions.remove(index);
	}
	
	public int getNoOfPositions() {
		return positions.size();
	}
	
	public Product getProductAtPosition(int index) {
		return positions.get(index).getP();
	}

	public int getAmountAtPosition(int index) {
		return positions.get(index).getAmount();
	}

	public void placeOrder(Customer customer) {
		
		Shipment.parcelAndShip(creditCard, this.positions, customer);
	}
}
