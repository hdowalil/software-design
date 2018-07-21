package lab02.excercise.solution.trainer.portal;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class AllGamesConsole implements Portal {

	private PrintStream out;
	private Scanner in;
	
	private Map<String, Integer> highScores = new HashMap<>();
	
	public AllGamesConsole(PrintStream out, Scanner in) {
		super();
		this.out = out;
		this.in = in;
	}
	
	public void run() {
		
		ServiceLoader<GameConsole> gamesLoader = ServiceLoader.load(GameConsole.class);
		List<GameConsole> games = gamesLoader.stream().map(g -> g.get()).collect(Collectors.toList());
		
		String entry = null;
		
		while (!"0".equals(entry)) {
			
			printHighScores();
			out.println("0 .. Quit");
			out.println("Or fancy playing one of these games?");
			for (int i=0; i<games.size(); i++) {
				out.println(String.format("%d .. %s", i+1, games.get(i).getName()));
			}
			
			entry = in.next();
			
			if (isNumeric(entry)) {
				
				int menuChoice = Integer.parseInt(entry);
				
				if (menuChoice <= games.size() && menuChoice > 0) {
					int indexOfGameInList = menuChoice - 1;
					GameConsole console = games.get(indexOfGameInList);
					int score = console.run(out, in, this);
					highScore(console.getName(),score);
				}
			}

		}
		
	}
	
	@Override
	public boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
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
	
	public static void main(String[] args) {
		
		(new AllGamesConsole(System.out, new Scanner(System.in))).run();
	}

}
