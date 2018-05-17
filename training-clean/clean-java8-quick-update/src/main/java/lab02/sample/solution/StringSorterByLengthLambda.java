package lab02.sample.solution;

import java.util.Arrays;
import java.util.Comparator;

public class StringSorterByLengthLambda {
	
	public static void main(String[] args) {
		
		String[] peanuts = { "Charlie Brown", "Peppermint Patty", "Snoopy", "Schroeder", "Lucy", "Linus" };
		
		Arrays.sort(peanuts, Comparator.comparing(String::length));
		
		for (String peanut : peanuts) {
			System.out.println(peanut);
		}
	}

}
