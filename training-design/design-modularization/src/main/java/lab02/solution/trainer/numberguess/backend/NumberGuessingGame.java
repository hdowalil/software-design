package lab02.solution.trainer.numberguess.backend;

import java.util.Random;

public class NumberGuessingGame {
	
	private boolean gameOver = false;
	private int number2Guess;
	private int from;
	private int to;
	private int roundsLeft = 25;
	
	/**
	 * the number that the player will have to guess, will be in the range from - to
	 * <br>
	 * that means, if you provide a range from=2 and to=3, the number 2 guess can be 2 or 3
	 * 
	 * @param from
	 * @param to
	 */
	public NumberGuessingGame(int from, int to) {
		
		super();
		
		if (to<=from) {
			throw new IllegalArgumentException();
		}
		
		this.from = from;
		this.to = to;
		
		Random rnd = new Random();
		this.number2Guess = from + rnd.nextInt( (to-from)+1);
		
	}
	
	public GuessResult guess(int nr) {

		if (gameOver) {
			throw new IllegalStateException();
		}
		
		if (roundsLeft <= 0) {
			throw new IllegalStateException();
		}

		roundsLeft --;
		
		if (number2Guess == nr) {
			gameOver = true;
			return GuessResult.BINGO;
		} else if (nr > number2Guess) {
			return GuessResult.YOUR_INPUT_WAS_TOO_HIGH;
		} else {
			return GuessResult.YOUR_INPUT_WAS_TOO_LOW;
		}
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	public int getRoundsLeft() {
		return roundsLeft;
	}
	
	

}
