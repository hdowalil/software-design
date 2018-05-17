package lab01.excercise.challenge;

public enum Product {

    A(42), B(23), C(815), D(4711);

    private int price;

    Product(int price) {
        this.price = price;
    }

	public int getPrice() {
		return price;
	}
    
}
