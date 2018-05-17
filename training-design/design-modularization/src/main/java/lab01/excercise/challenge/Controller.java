package lab01.excercise.challenge;

public class Controller {
	
	private Customer customer;
	private Order order;

	public Controller(Customer customer) {
		super();
		this.customer = customer;
		this.order = new Order();
	}
	
	public boolean add2Order(Product p, int amount) {
		
		if (!Stock.isAvailable(p, amount)) {
			return false;
		}
		
		Stock.reserveForOrder(p, amount);
		order.add(p, amount);
		return true;
	}
	
	public void removeFromOrder(int index) {
	
		Product p = getProductAtPosition(index);
		int amount = getAmountAtPosition(index);
		
		Stock.releaseFromOrder(p, amount);
		order.remove(index);
	}

	public int getNumberOfOrderPositions() {
		return order.getNoOfPositions();
	}
	
	public void setCreditCard(String creditCard) {
		
		if (!Billing.isValidCreditCard(creditCard)) {
			throw new IllegalArgumentException();
		}
			
		order.setCreditCard(creditCard);
	}

	public Product getProductAtPosition(int index) {
		return order.getProductAtPosition(index);
	}

	public int getAmountAtPosition(int index) {
		return order.getAmountAtPosition(index);
	}

	public void placeOrder() {
		
		Billing.chargeCreditCard(order.getCreditCard(), order.getSum());
		
		Shipment.parcelAndShip(order, customer);
	}
}
