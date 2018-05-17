package lab02.solution.trainer.blackjack.ui;

import java.io.PrintStream;
import java.util.Scanner;

import lab02.excercise.challenge.blackjack.BlackJackGame;
import lab02.solution.trainer.portal.GameConsole;
import lab02.solution.trainer.portal.Portal;

public class BlackJackConsole implements GameConsole {

	@Override
	public String getName() {
		return "Black Jack";
	}

	@Override
	public int run(PrintStream out, Scanner in, Portal portal) {

		BlackJackGame game = new BlackJackGame();

		while (game.getMoney() > 0) {

			out.print(String.format("How much do you want to bet? (Max: %d or enter 0 to quit): ", game.getMoney()));

			String entry = in.next();

			if (portal.isNumeric(entry)) {

				int betAmount = Integer.parseInt(entry);

				if (betAmount <= 0) {
					// player wants to quit, the amount of money is the acheived score!
					return game.getMoney();
				}

				if (betAmount <= game.getMoney()) {
					playOneRoundOfBlackJack(out, in, game, betAmount);
				}
			}
		}

		return game.getMoney();
	}

	private void playOneRoundOfBlackJack(PrintStream out, Scanner in, BlackJackGame game, int bet) {

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

		displayBlackJackResult(out, in, game);
	}

	private void displayBlackJackResult(PrintStream out, Scanner in, BlackJackGame game) {

		out.println(String.format("Dealers Deck: %s", game.getVisibleDealerCardsAsString()));
		out.println(String.format("Players Deck: %s", game.getPlayerCardsAsString()));
		if (game.isGameDraw()) {
			out.println("Game is a draw!");
		} else if (game.isGameWon()) {
			out.println("You won this round!");
		} else {
			out.println("You lost this round!");
		}
		out.println(String.format("You have %d left!", game.getMoney()));

	}

}
