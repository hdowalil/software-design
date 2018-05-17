package lab01.excercise.solution.trainer;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.WillNotClose;

public class InputAndOutput {
	
	private static boolean isNumeric(@Nullable String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	public static @Nonnull String chooseFromList(@Nonnull List<? extends CharSequence> options, @Nonnegative int from, @Nonnegative int to, 
			@WillNotClose @Nonnull PrintStream out, @WillNotClose @Nonnull Scanner in) {
		
		Objects.requireNonNull(options);
		Objects.requireNonNull(out);
		Objects.requireNonNull(in);
		if (from < 0) {
			throw new IllegalArgumentException("From Parameter must not be negative");
		}
		if (options.size() < to) {
			throw new IllegalArgumentException("Not enough items in List supplied");
		}
		
		int range = to-from;
		int chosen=-1;
		
		while (chosen <= 0 || chosen > range) {
			
			for (int i=1; i<=range; i++) {
				
				CharSequence option = options.get(from+i-1);
				Objects.requireNonNull(option);
						
				out.println(Integer.toString(i)+": "+options.get(from+i-1).toString());
			}
			
			String input=null;
			while (!isNumeric(input)) {
				input = in.next();
			}
			chosen = Integer.valueOf(input);
			
		}
		
		CharSequence result = options.get(from+chosen-1);
		
		assert result != null;
		
		return result.toString();
	}

	public static void main(String[] args) {
		
		List<String> options = Arrays.asList("Apple","Banana","Strawberry","PineApple");
		String chosenOption = chooseFromList(options, 2, 4, System.out,  new Scanner(System.in));
		System.out.println(chosenOption);
	}
	
}
