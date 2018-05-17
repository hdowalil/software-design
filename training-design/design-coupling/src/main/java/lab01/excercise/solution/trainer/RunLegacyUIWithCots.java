package lab01.excercise.solution.trainer;

import java.util.Scanner;

import lab01.excercise.challenge.legacy.LegacyUserInterface;

public class RunLegacyUIWithCots {

	public static void main(String[] args) {
		
		SearchApiAdapter adapter = new SearchApiAdapter();
		LegacyUserInterface ui = new LegacyUserInterface(System.out, new Scanner(System.in), adapter);
		ui.runConsole();

	}

}
