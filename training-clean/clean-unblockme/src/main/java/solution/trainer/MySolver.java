package solution.trainer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

/**
 * The main API to solve an unblockme board!<br>
 * You can use:
 * <ul>
 * <li>The Object ({@link Board}) API ({@link MySolver#solveBoard(Board)}), that will return a {@link java.util.List} of {@link Move}</li>
 * <li>The String API ({@link MySolver#solveBoard(String)}) that will also return a String of Moves</li>
 * </ul>
 * For explanation of the String Patterns please see: {@link solution.your.Solver} 
 */
public final class MySolver {
	
	private static List<Move> _solveBoardRecursive(
			Set<String> alreadyCoveredBoardSituations,
			List<Move> possibleResult, 
			Board input) {

		// I did not split this up into multiple methods, as this is the recursion
		// and I think it needs to be understood in once piece
		
		List<Move> possibleMoves = input.findPossibleMoves();
		
		for (Move move : possibleMoves) {
			
			List<Move> clonedPossibleResult = possibleResult.stream().map(m -> m.clone()).collect(Collectors.toList());
			clonedPossibleResult.add(move);
			
			Board clonedBoard = input.clone();
			clonedBoard.move(move);
			
			String clonedBoardAsString = clonedBoard.toString();
			// otherwise we have an endless recursion, finding the same situations again and again
			if (!alreadyCoveredBoardSituations.contains(clonedBoardAsString)) {

				alreadyCoveredBoardSituations.add(clonedBoardAsString);
				
				if (clonedBoard.isSovled()) {
					return clonedPossibleResult;
				} else {
					List<Move> isThisAResult = _solveBoardRecursive(alreadyCoveredBoardSituations, clonedPossibleResult, clonedBoard);
					if (isThisAResult != null) {
						return isThisAResult;
					}
				}
			}
		}
		
		return null;
	}
	
	public static List<Move> solveBoard (Board input) {
		
		Set<String> alreadyCoveredBoardSituations = new HashSet<>();
		
		List<Move> result = new ArrayList<>();
		
		return _solveBoardRecursive(alreadyCoveredBoardSituations, result, input);
	}
	
	public static String solveBoard (@Nonnull String boardTxt) {
		Board board = Board.fromString(boardTxt);
		List<Move> moves = solveBoard(board);
		if (moves != null) {
			return Move.movesToString(moves);
		} else {
			return null;
		}
	}


	/**
	 * give it a try and run this main method! 
	 * @param args default string args of java main method
	 */
	public static void main(String[] args) {
		
//		BoardBuilder builder = new BoardBuilder();
//		builder.
//			addBlock(new Block(2,1,"H",3)).
//			addBlock(new Block(3,2,"V",3)).
//			addBlock(new Block(2,2,"V",2)).
//			addBlock(new Block(5,2,"V",2)).
//			addBlock(new Block(4,5,"H",2));
		
		//Board board = Board.fromString("N,2#1,H,3 N,2#2,V,2 N,3#2,V,3 N,5#2,V,2 R,0#3,H,2 N,4#5,H,2");
		//Board board = Board.fromString("R,0#3,H,2 N,1#4,V,2 N,2#2,V,3 N,3#1,H,2 N,4#0,H,2 N,4#2,V,2 N,5#3,V,3");
		//Board board = Board.fromString("R,0#3,H,2 N,1#2,H,2 N,2#1,H,3 N,3#0,H,3 N,3#2,V,3 N,2#3,V,2 N,2#5,H,3");
		Board board = Board.fromString("R,0#3,H,2 N,0#4,H,2 N,2#0,V,2 N,3#0,H,3 N,3#1,H,3 N,4#3,V,3");
		
		// string delimiter auf ; und , statt ! und /
		String boardAsString = board.toString();
		System.out.println(boardAsString);
		
		board = Board.fromString(boardAsString);
		board.print(System.out);
		
		List<Move> moves = board.findPossibleMoves();
		System.out.println(Move.movesToString(moves));
		
		// The solution is: 2#1,B 1#1,B 2#2,F 2#3,F 3#2,B 3#1,B 5#2,B 0#3,F 1#3,F 2#3,F 3#3,F
		List<Move> solved = MySolver.solveBoard(board);
		System.out.println(Move.movesToString(solved));
		
	}
	
}
