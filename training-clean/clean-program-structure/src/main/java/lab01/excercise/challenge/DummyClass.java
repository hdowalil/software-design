package lab01.excercise.challenge;

import java.io.PrintStream;

public class DummyClass {

	public static void cyccomplex(int x, int[] values, int parity, boolean result) {

		while (x < 100) { 						// 1

			if (values[x] % 2 == 0) { 			// 2
				parity = 0; 					// 3
			} else {
				parity = 1; 					// 4
			} 									// 5

			switch (parity) {					// 6
			case 0:
				System.out.println("Even");		// 7
				break;
			case 1:
				System.out.println("Odd");		// 8
				break;
			default:
				System.out.println("Weird");	// 9
				break;
			}
			x++;								// 10
		}
		result = true;							// 11

	}

	public static void printManual(PrintStream out) {

		out.println("**************************************************");
		out.println("* This is the manual, please read before using   *");
		out.println("* this software!                                 *");
		out.println("**************************************************");
		out.println("");
		out.println("Chapters");
		out.println("1 ... How to install the pizza bunny software");
		out.println("2 ... How to uninstall the pizza bunny software");
		out.println("3 ... Troubleshooting");
		out.println("4 ... FAQ");
		out.println("");
		out.println("|￣￣￣￣￣￣￣ |");
		out.println("|   Pizza     |");
		out.println("|＿＿＿＿＿ _＿_|");
		out.println("(\\__/) ||");
		out.println("(•ㅅ•) ||");
		out.println(" / 　 づ");
		out.println("");
		out.println("1. How to install the pizza bunny software");
		out.println("System requirements: you will have to have Java installed.");

		out.println("...");

	}

	public static void main(String[] args) {

		printManual(System.out);
	}

}
