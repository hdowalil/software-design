package challenge.solution.trainer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import solution.trainer.Board;
import solution.trainer.Board.BoardBuilder;
import solution.trainer.Direction;
import solution.trainer.Move;

public class BoardTest {
	
	@Test
	public void testBoardIsSolved() {
		
		BoardBuilder builder = new BoardBuilder();
		Board board = builder.build();
		
		board.move(new Move(0,3,Direction.FORWARD));
		System.out.println(board.toString());
		Assertions.assertFalse(board.isSovled());
		
		board.move(new Move(1,3,Direction.FORWARD));
		System.out.println(board.toString());
		Assertions.assertFalse(board.isSovled());
		
		board.move(new Move(2,3,Direction.FORWARD));
		System.out.println(board.toString());
		Assertions.assertFalse(board.isSovled());
		
		board.move(new Move(3,3,Direction.FORWARD));
		System.out.println(board.toString());
		board.print(System.out);
		Assertions.assertTrue(board.isSovled());
		
	}
	
}
