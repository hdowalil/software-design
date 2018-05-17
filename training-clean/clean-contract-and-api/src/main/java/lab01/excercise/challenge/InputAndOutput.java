package lab01.excercise.challenge;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputAndOutput {
	
	private static boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	public static String chooseFromList(List<String> options, int from, int to, PrintStream out, Scanner in) {
		
		int range = to-from;
		int chosen=-1;
		
		while (chosen <= 0 || chosen > range) {
			
			String input=null;
			
			for (int i=0; i<range; i++) {
				out.println(Integer.toString(i+1)+": "+options.get(from+i).toString());
			}
			
			while (!isNumeric(input)) {
				input = in.next();
			}
			
			chosen = Integer.valueOf(input);
		}
		
		return options.get(chosen+from-1);
	}

	public static void main(String[] args) {
		
		List<String> options = Arrays.asList("Apple","Banana","Strawberry","PineApple");
		String chosenOption = chooseFromList(options, 2, 4, System.out,  new Scanner(System.in));
		System.out.println(chosenOption);
	}
}
