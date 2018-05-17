package lab01.sample.challenge;

public class ContractViolation {

	public static void main(String[] args) {
		
		Rectangle rec = new Square();
		
		rec.setHeight(42);
		rec.setWidth(23);
		
		// false:
		System.out.println(
				Boolean.toString(42 == rec.getHeight()));

	}

}
