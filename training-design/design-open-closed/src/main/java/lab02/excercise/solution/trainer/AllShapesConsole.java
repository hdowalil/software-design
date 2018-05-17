package lab02.excercise.solution.trainer;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class AllShapesConsole {

	private PrintStream out;
	private Scanner in;
	
	public AllShapesConsole(PrintStream out, Scanner in) {
		super();
		this.out = out;
		this.in = in;
	}
	
	public void run() {
		
		ServiceLoader<Shape> shapesLoader = ServiceLoader.load(Shape.class);
		List<Shape> shapes = shapesLoader.stream().map(l -> l.get()).collect(Collectors.toList());
		
		String entry = null;
		
		while (!"0".equals(entry)) {
			
			out.println("Information about geometrical shapes");
			out.println("0 .. Quit");
			for (int i=0; i<shapes.size(); i++) {
				out.println(String.format("%d .. %s", i+1, shapes.get(i).getName()));
			}
			
			entry = in.next();
			
			if (isNumeric(entry)) {
				
				int menuChoice = Integer.parseInt(entry);
				
				if (menuChoice <= shapes.size() && menuChoice > 0) {
					int indexOfShapeInList = menuChoice - 1;
					out.println(shapes.get(indexOfShapeInList).getDescription());
					shapes.get(indexOfShapeInList).draw(out);
				}
			}

		}
		
	}
	
	private boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  

	public static void main(String[] args) {
		
		(new AllShapesConsole(System.out, new Scanner(System.in))).run();
	}

}
