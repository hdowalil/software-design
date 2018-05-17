package lab01.excercise.challenge;

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
		this.creditCard = creditCard;
	}
	
	String getCreditCard() {
		return creditCard;
	}

	public void add(Product p, int amount) {
		positions.add(new OrderPosition(p, amount));
	}
	
	public void remove(int index) {
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

	public int getSum() {
		return positions.stream().map(p -> p.getAmount() * p.getP().getPrice()).mapToInt(i -> i.intValue()).sum();
	}
}
