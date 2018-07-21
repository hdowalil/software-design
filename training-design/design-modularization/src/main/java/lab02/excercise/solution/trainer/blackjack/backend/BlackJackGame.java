package lab02.excercise.solution.trainer.blackjack.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Classic game of black jack. Player will draw at 16 and stay at 17.
 * <br>
 * Black Jack (Jack, Queen or King and an Ace) is treated better than a sum of 21 any other way  
 */
public class BlackJackGame {
	
	private final static int DEALER_DRAWING_LIMIT = 16;
	
	private final static int WINNING_VALUE = 21;
	
	private final static int INITIAL_AMOUNT_OF_MONEY = 1000;
	
	// initial amount of money is 1000 bucks
	private boolean gameRunning = false;
	private boolean gameWon = false;
	private boolean gameDraw = false;
	
	private int money = INITIAL_AMOUNT_OF_MONEY;
	private int bet = -1;
	private List<Card> dealerCards = null;
	private List<Card> playerCards = null;
	
	private Random rnd = new Random();
	
	public boolean isGameRunning() {
		return gameRunning;
	}
	
	public void startNewGame(int bet4newGame) {
		
		assertGameRunning(false);
		
		if (bet4newGame <=0 || bet4newGame>this.money) {
			throw new IllegalArgumentException();
		}
		
		this.gameRunning = true;
		this.gameWon = false;
		this.gameDraw = false;
		
		this.bet = bet4newGame;
		
		dealerCards = new ArrayList<>();
		dealerCards.add(randomCard());
		
		playerCards = new ArrayList<>();
		playerCards.add(randomCard());
		playerCards.add(randomCard());
		
		checkPlayersStatus();
	}
	
	public boolean isGameDraw() {
		
		assertGameRunning(false);
		
		return gameDraw;
	}

	public boolean isGameWon() {
		
		assertGameRunning(false);
		
		return gameWon;
	}

	public int getMoney() {
		
		assertGameRunning(false);
		
		return money;
	}

	/**
	 * i got enough cards, now let the dealer continue
	 *
	 * @return will return amount of money (= score) that player has after this game
	 */
	public int stand() {
		
		assertGameRunning(true);
		
		finishGame();
		
		return this.money;
	}
	
	/**
	 * gimme one more card!
	 */
	public void hit() {
		
		assertGameRunning(true);
		
		if (getPlayerValueSum() >= WINNING_VALUE) {
			throw new IllegalStateException();
		}
		
		playerCards.add(randomCard());
		
		checkPlayersStatus();
	}
	
	public int getPlayerValueSum() {
		
		return getValueSum(playerCards);
	}

	public String getVisibleDealerCardsAsString() {
		
		return getCardsAsString(dealerCards);
	}

	public String getPlayerCardsAsString() {
		
		return getCardsAsString(playerCards);
	}
	
	private void checkPlayersStatus() {
		
		int playerValueSum = getPlayerValueSum();
		boolean canPlayerContinue = playerValueSum < WINNING_VALUE;
		boolean tooMuch = playerValueSum > WINNING_VALUE;
		
		if (!canPlayerContinue && !tooMuch) {
			finishGame();
		} else if (tooMuch) {
			playerHasLost();
		}
	}
	
	private void assertGameRunning(boolean shouldBeRunning) {
		if (!gameRunning && shouldBeRunning) {
			throw new IllegalStateException("game finished, start a new one calling startNewGame");
		} else if (gameRunning && !shouldBeRunning) {
			throw new IllegalStateException("the game is still running!");
		}
	}
	
	private void playerHasDrawWithDealer() {
		this.gameRunning = false;
		this.gameDraw = true;
		this.gameWon = false;
		this.bet = -1;
	}
	
	private void playerHasLost() {
		this.money -= this.bet;
		this.gameRunning = false;
		this.gameDraw = false;
		this.gameWon = false;
		this.bet = -1;
	}
	
	private void playerHasWon() {
		this.money += this.bet;
		this.gameRunning = false;
		this.gameDraw = false;
		this.gameWon = true;
		this.bet = -1;
	}
	
	/*
	 * Dealer will draw until is over limit
	 */
	private void finishGame() {

		int dealerValueSum = getValueSum(dealerCards);
		while (dealerValueSum <= DEALER_DRAWING_LIMIT) {
			dealerCards.add(randomCard());
			dealerValueSum = getValueSum(dealerCards);
		}
		
		if (isBlackJack(dealerCards) && isBlackJack(playerCards)) {
			playerHasDrawWithDealer();
		} else if (isBlackJack(dealerCards) && !isBlackJack(playerCards)) {
			playerHasLost();
		} else if (!isBlackJack(dealerCards) && isBlackJack(playerCards)) {
			playerHasWon();
		}

		// No Black Jack!
		int dealerValue = getValueSum(dealerCards);
		int playerValue = getPlayerValueSum();
		
		if (dealerValue > WINNING_VALUE) {
			// dealer has too much, player not as game would be over already
			playerHasWon();
		} else if (dealerValue == playerValue) {
			playerHasDrawWithDealer();
		} else if (dealerValue > playerValue) {
			playerHasLost();
		} else {
			playerHasWon();
		}
		
	}

	private String getCardsAsString(List<Card> cards) {
		
		StringBuilder result = new StringBuilder(
				cards.stream().map(c -> c.name()).collect(Collectors.joining(","))
				);
		result.append(" / ");
		if (isBlackJack(cards)) {
			result.append("Black Jack!");
		} else {
			result.append(String.format("Sum: %d",getValueSum(cards)));
		}
		
		return result.toString();
	}
	
	private boolean isBlackJack(List<Card> cards) {
		
		if (cards.size() == 2) {
			if (cards.get(0).isJackQueenOrKing() && cards.get(1).equals(Card.ACE)) {
				return true;
			} else if (cards.get(1).isJackQueenOrKing() && cards.get(0).equals(Card.ACE)) {
				return true;
			}
		}
		
		return false;
	}
	
	private int getValueSum(List<Card> cards) {
		
		// first sum up first values
		int sum = cards.stream().mapToInt(c -> c.getNumVal(0)).sum();
		if (sum <= WINNING_VALUE) {
			return sum;
		}

		// if we are to high, we try other values, if any
		sum = cards.stream().mapToInt(c -> 
		{ if (c.getNoOfValues() > 1) {
			return c.getNumVal(1);
		} else {
			return c.getNumVal(0);
		}
		}
		).sum();
		
		return sum;
	}
	
	private Card randomCard() {
		
		int cardIndex = rnd.nextInt(Card.values().length);
		
		return Card.values()[cardIndex];
	}
}
