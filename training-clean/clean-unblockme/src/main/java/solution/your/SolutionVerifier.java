package solution.your;

import java.util.List;

import solution.trainer.Board;
import solution.trainer.Move;

/**
 * 
 * This class uses my Implementation to verify your solution.
 * <br>
 * Ignore what I have written, and write your own solution
 *
 */
public class SolutionVerifier {

	public static boolean verifySolution (String boardTxt, String movesTxt) {
		
		Board board = Board.fromString(boardTxt);
		board.print(System.out);
		System.out.println(board.toString());
		
		List<Move> moves = Move.movesFromString(movesTxt);
		System.out.println(Move.movesToString(moves));
		
		moves.stream().forEach(m -> board.move(m));
		
		return board.isSovled();
	}
	
}
