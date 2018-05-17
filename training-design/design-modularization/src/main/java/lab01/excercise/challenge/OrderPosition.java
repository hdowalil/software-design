package lab01.excercise.challenge;

public class OrderPosition {

	private Product p;
	private int amount;
	
	public OrderPosition(Product p, int amount) {
		super();
		this.p = p;
		this.amount = amount;
	}
	
	public Product getP() {
		return p;
	}
	public int getAmount() {
		return amount;
	}
	
}
