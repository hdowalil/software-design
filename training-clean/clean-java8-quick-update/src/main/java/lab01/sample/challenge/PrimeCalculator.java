package lab01.sample.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PrimeCalculator {

	Map<Integer, Boolean> values = new HashMap<Integer,Boolean>();
	
	private boolean _isPrime(int input) {
		//2 is a special case of prime number
		if (input == 2) return true;
	    //check if n is a multiple of 2
	    if (input % 2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=input;i+=2) {
	        if(input % i==0)
	            return false;
	    }
	    return true;
	}
	
	public boolean isPrime(int input) {
		
		Function<Integer, Boolean> squareFunction = new Function<Integer, Boolean>() {
			public Boolean apply(Integer value) {
			    return _isPrime(value);
			}
		};
		
		return values.computeIfAbsent(input, squareFunction);
	}

	public static void main(String[] args) {
		
		PrimeCalculator calc = new PrimeCalculator();
		
		for (int i=1; i<100; i++) {
			System.out.println(Integer.toString(i)+": "+Boolean.toString(calc.isPrime(i)));
		}
	}
	
}
 