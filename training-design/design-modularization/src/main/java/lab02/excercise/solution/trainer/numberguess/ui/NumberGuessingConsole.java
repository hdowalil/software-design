package lab02.excercise.solution.trainer.numberguess.ui;

import java.io.PrintStream;
import java.util.Scanner;

import lab02.excercise.solution.trainer.numberguess.backend.GuessResult;
import lab02.excercise.solution.trainer.numberguess.backend.NumberGuessingGame;
import lab02.excercise.solution.trainer.portal.GameConsole;
import lab02.excercise.solution.trainer.portal.Portal;

public class NumberGuessingConsole implements GameConsole {

	@Override
	public String getName() {
		return "Number Guessing";
	}
	
	@Override
	public int run(PrintStream out, Scanner in, Portal portal) {
		
		NumberGuessingGame game = new NumberGuessingGame(1, 99);
		
		String entry = "";
		
		while (!"0".equals(entry) && !game.isGameOver()) {
			
			out.println(String.format("Guess my number that is somewhere from 1 to 99. You have %d tries left!",game.getRoundsLeft()));
			out.print("Enter your next guess, or 0 to quit:");
			
			do {
				entry = in.next();
			} while (!portal.isNumeric(entry));
			
			int nr = Integer.parseInt(entry);
			
			if (nr != 0) {
				
				GuessResult result = game.guess(nr);
				if (GuessResult.BINGO.equals(result)) {
					out.println("That´s it, congratulations!");
				} else if (GuessResult.YOUR_INPUT_WAS_TOO_HIGH.equals(result)) {
					out.println("The number you should guess is lower than that!");
				} else {
					out.println("The number you should guess is higher than that!");
				}
				
			}
		}
		
		if (game.isGameOver()) {
			return game.getRoundsLeft();
		} else {
			// cancelled -> 0 points!
			return 0;
		}
	}

}
