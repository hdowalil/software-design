package lab02.sample.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class StringSorterByLength {
	
	public static void main(String[] args) {
		
		String[] peanuts = { "Charlie Brown", "Peppermint Patty", "Snoopy", "Schroeder", "Lucy", "Linus" };
		
		Arrays.sort(peanuts, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				
				Objects.requireNonNull(arg0);
				Objects.requireNonNull(arg1);
				
				return Integer.compare(arg0.length(), arg1.length());
			}
		});
		
		for (String peanut : peanuts) {
			System.out.println(peanut);
		}
	}

}
