package lab04.excercise.common;

public class Food {
	
	private boolean organic;
	private String name;
	private double price=0.0d;
	
	public Food() {
		super();
	}

	public Food(boolean organic, String name) {
		this(organic, name, 0.0d);
	}

	public Food(boolean organic, String name, double price) {
		super();
		this.organic = organic;
		this.name = name;
		this.price = price;
	}

	public boolean isOrganic() {
		return organic;
	}

	public void setOrganic(boolean organic) {
		this.organic = organic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return Boolean.toString(organic) + " " + name + " " + Double.toString(price);
	}

}
