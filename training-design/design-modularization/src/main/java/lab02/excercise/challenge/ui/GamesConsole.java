package lab02.excercise.challenge.ui;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lab02.excercise.challenge.blackjack.BlackJackGame;
import lab02.excercise.challenge.numberguess.GuessResult;
import lab02.excercise.challenge.numberguess.NumberGuessingGame;

public class GamesConsole {
	
	private PrintStream out;
	private Scanner in;
	
	private Map<String, Integer> highScores = new HashMap<>();
	
	public GamesConsole(PrintStream out, Scanner in) {
		super();
		this.out = out;
		this.in = in;
	}

	public void play() {
		
		String entry = null;
		
		while (!"0".equals(entry)) {
			
			printHighScores();
			out.println("0 .. Quit");
			out.println("Or fancy playing one of these great games:");
			out.println("1 .. Black Jack");
			out.println("2 .. Number Guessing");
			
			entry = in.next();
			
			if (isNumeric(entry)) {
				
				int menuChoice = Integer.parseInt(entry);

				if (menuChoice == 1) {
					
					int score = playBlackJack();
					highScore("Black Jack",score);
					
				} else if (menuChoice == 2) {
					
					int score = playNumberGuessing();
					highScore("Number Guessing",score);
					
				}
			}

			out.println();
		}
		
	}
	
	private void printHighScores() {
		
		if (!highScores.isEmpty()) {
			out.println("Highscores:");
			highScores.keySet().stream().forEach( game -> 
			out.println(String.format("%s: %d",game,highScores.get(game)))
		);
		}
	}
	
	private void highScore(String game, int score) {
		if (highScores.containsKey(game)) {
			if (score > highScores.get(game)) {
				highScores.put(game, score);
			}
		} else {
			highScores.put(game, score);
		}
	}
	
	private int playBlackJack() {

		BlackJackGame game = new BlackJackGame();
		
		while (game.getMoney() > 0) {

			out.print(String.format("How much do you want to bet? (Max: %d or enter 0 to quit): ",game.getMoney()));
			
			String entry = in.next();
			
			if (isNumeric(entry)) {
				
				int betAmount = Integer.parseInt(entry);
				
				if (betAmount <= 0) {
					// player wants to quit, the amount of money is the acheived score!
					return game.getMoney();
				}
				
				if (betAmount<=game.getMoney()) {
					playOneRoundOfBlackJack(game, betAmount);
				}
			}
		}
		
		return game.getMoney();
	}
	
	private void playOneRoundOfBlackJack (BlackJackGame game, int bet) {
		
		game.startNewGame(bet);
		
		while (game.isGameRunning()) {
			
			out.println(String.format("Dealer: %s", game.getVisibleDealerCardsAsString()));
			out.println(String.format("Player: %s", game.getPlayerCardsAsString()));
			
			out.print("One more card (Y/N)?");
			
			String entry = "";
			while (!"Y".equals(entry) && !"N".equals(entry)) {
				entry = in.next().toUpperCase();
			}
			
			if ("Y".equals(entry)) {
				game.hit();
			} else {
				game.stand();
			}
		}
		
		displayBlackJackResult(game);
	}
	
	private void displayBlackJackResult(BlackJackGame game) {
		
		out.println(String.format("Dealers Deck: %s", game.getVisibleDealerCardsAsString()));
		out.println(String.format("Players Deck: %s", game.getPlayerCardsAsString()));
		if (game.isGameDraw()) {
			out.println("Game is a draw!");
		} else if (game.isGameWon()) {
			out.println("You won this round!");
		} else {
			out.println("You lost this round!");
		}
		out.println(String.format("You have %d left!",game.getMoney()));
		
	}
	
	private int playNumberGuessing() {
		
		NumberGuessingGame game = new NumberGuessingGame(1, 99);
		
		String entry = "";
		
		while (!"0".equals(entry) && !game.isGameOver()) {
			
			out.println("Guess my number that is somewhere from 1 to 99. You have %d tries left!");
			out.print("Enter your next guess, or 0 to quit:");
			
			do {
				entry = in.next();
			} while (!isNumeric(entry));
			
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
	
	private boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  

	public static void main(String[] args) {
		GamesConsole console = new GamesConsole(System.out, new Scanner(System.in));
		console.play();
	}
	
}
