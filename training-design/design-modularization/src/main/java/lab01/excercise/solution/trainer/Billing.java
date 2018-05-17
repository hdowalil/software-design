package lab01.excercise.solution.trainer;

public class Billing {
	
	public static boolean isValidCreditCard(String cc) {
		return cc != null && cc.length() == 16;
	}

	public static void chargeCreditCard(String cc, int sum) {
		
		if (!isValidCreditCard(cc)) {
			throw new IllegalArgumentException();
		}
		
		System.out.println(String.format("Charging CC %s with %d",cc,sum));
	}
}
