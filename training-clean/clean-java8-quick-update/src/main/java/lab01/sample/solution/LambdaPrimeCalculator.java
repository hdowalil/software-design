package lab01.sample.solution;

import java.util.HashMap;
import java.util.Map;

public class LambdaPrimeCalculator {

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
		
		// long version:
		//return values.computeIfAbsent(input, value -> {
		//	return _isPrime(value);
		//});
		
		// short version (no curly braces for just 1 statement, will be returned automatically
		return values.computeIfAbsent(input, value -> _isPrime(value));
	}

	public static void main(String[] args) {
		
		LambdaPrimeCalculator calc = new LambdaPrimeCalculator();
		
		for (int i=1; i<100; i++) {
			System.out.println(Integer.toString(i)+": "+Boolean.toString(calc.isPrime(i)));
		}
	}
	
}
 