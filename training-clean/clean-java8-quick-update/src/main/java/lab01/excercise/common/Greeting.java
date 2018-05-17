package lab01.excercise.common;

import java.io.PrintStream;

@FunctionalInterface
public interface Greeting {

	public void sayHello (String name, PrintStream output);
	
}
