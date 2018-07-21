package lab02.excercise.solution.trainer.portal;

import java.io.PrintStream;
import java.util.Scanner;

public interface GameConsole {
	
	public int run(PrintStream out, Scanner in, Portal portal);
	
	public String getName();

}
