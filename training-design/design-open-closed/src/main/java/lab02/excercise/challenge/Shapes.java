package lab02.excercise.challenge;

import java.io.PrintStream;
import java.util.Scanner;

public class Shapes {

	private PrintStream out;
	private Scanner in;
	
	public Shapes(PrintStream out, Scanner in) {
		super();
		this.out = out;
		this.in = in;
	}
	
	public void run() {
		
		String entry = null;
		
		while (!"0".equals(entry)) {
			
			out.println("Information about geometrical shapes");
			out.println("0 .. Quit");
			out.println("1 .. Circle");
			out.println("2 .. Square");
			
			entry = in.next();

			if ("1".equals(entry)) {
				circlePrintInfo();
				circleDraw();
			} else if ("2".equals(entry)) {
				squareInfo();
				squareDraw();
			} 
			
		}
		
	}

	public void circlePrintInfo() {
		out.println("A circle is the set of all points in a plane that are at a given distance from a given point, the centre.");
	}
	
	public void circleDraw() {
        out.println(" ___");
        out.println("/   \\");
        out.println("\\___/");
	}
	
	public void squareInfo() {
		out.println("A square is a regular quadrilateral, which means that it has four equal sides and four equal angles (90-degree angles).");
	}
	
	public void squareDraw() {
		out.println(" ___");
		out.println("|   |");
		out.println("|___|");
	}
	
	public static void main(String[] args) {
		
		(new Shapes(System.out, new Scanner(System.in))).run();
	}

}
