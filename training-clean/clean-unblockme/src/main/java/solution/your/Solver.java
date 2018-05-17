package solution.your;

/**
 * Implement your solution here!
 * <br>
 * A board consists of n blocks, one of them is the block that the user should bring 
 * to the exit of the board. This is the red block "R", the other ones are the normal blocks "N"
 * <br>
 * A bord is represented by a string that contains all blocks represented as strings, separated by blank
 * <br>
 * A block is representetd by a string like the following:<br>
 * R,0#3,H,2 ... the players red blocks, the left most position is at x=0 and y=3, it is of horizontal alignment and the width is 2 fields wide<br>
 * N,3#2,V,3 ... one of the other blocks, the bottom position is at x=3 and y=2 and it is of vertical alignment. The height is 3 fields
 * <br>
 * A board would looks something like this:<br>
 * R,0#3,H,2 N,2#1,H,3 N,2#2,V,2 N,3#2,V,3 N,5#2,V,2 N,4#5,H,2
 * <br>
 * The moves you should create, that bring the red block to the exit, are represented by a String where every move is separated by blank
 * <br>
 * A single move looks something like this:
 * 2#1,B ... the block with the origin (bottom left most) position at x=2 and y=1 is moved backwards to (left or bottom depending on alignment)<br>
 * 2#2,F ... the block with the origin (bottom left most) position at x=2 and y=2 is moved forwad (left or bottom depending on alignment)<br>
 * <br>
 * Alignment means:<br>
 * A block with origin x=2 and y=2 that is horizontal and moved forward will then be at x=3 and y=2<br>
 * A block with origin x=2 and y=2 that is vertical and moved backward will then be at X=2 and y=1
 * <br>
 * So for this board:<br>
 * R,0#3,H,2 N,2#1,H,3 N,2#2,V,2 N,3#2,V,3 N,5#2,V,2 N,4#5,H,2
 * <br>
 * This would be a solution:<br>
 * 2#1,B 1#1,B 2#2,F 2#3,F 3#2,B 3#1,B 5#2,B 0#3,F 1#3,F 2#3,F 3#3,F
 */
public class Solver {
	
	public static String solve(String boardInput) {
		return "";
	}

	
	private static boolean solveAndVerify(String boardTxt) {
		return SolutionVerifier.verifySolution(boardTxt, solve(boardTxt));
	}
	
	public static void main(String[] args) {
		
		boolean result = solveAndVerify("R,0#3,H,2 N,2#1,H,3 N,2#2,V,2 N,3#2,V,3 N,5#2,V,2 N,4#5,H,2");
		System.out.println(Boolean.toString(result));
		
		result = solveAndVerify("R,0#3,H,2 N,1#4,V,2 N,2#2,V,3 N,3#1,H,2 N,4#0,H,2 N,4#2,V,2 N,5#3,V,3");
		System.out.println(Boolean.toString(result));
		
		result = solveAndVerify("R,0#3,H,2 N,1#2,H,2 N,2#1,H,3 N,3#0,H,3 N,3#2,V,3 N,2#3,V,2 N,2#5,H,3");
		System.out.println(Boolean.toString(result));
		
		result = solveAndVerify("R,0#3,H,2 N,0#4,H,2 N,2#0,V,2 N,3#0,H,3 N,3#1,H,3 N,4#3,V,3");
		System.out.println(Boolean.toString(result));
		
	}
}
