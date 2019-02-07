/*
 * Human player that prompts the player for an input
 * methods:
 * - constructor: passed the scanner object and also creates the array via RPSComputerPlayer
 * - generateMove(): prompts the player for an input then returns an integer
 */

import java.util.Scanner;

/*
 * human player with input from scanner, child of ComputerPlayer
 * methods:
 * - constructor: takes the scanner instance and stores for future use
 * - generateMove(): Takes input from scanner, parses, and returns int
 * - receiveMove(playerMove, played): stores data from the last round into an array (inherited from ComputerPlayer
 */

public class RPSHumanPlayer extends RPSComputerPlayer {
	
	Scanner inSource;
	
	public RPSHumanPlayer(Scanner scan) {
		inSource = scan;
	}
	
	public int generateMove() {
		String input;
		
		do {
			System.out.println("What would you like to cast? (r,p,s)");
			input = inSource.next();
		} while (!(input.equals("r") || input.equals("p") || input.equals("s")));
		
		if (input.equals("r")) {
			return 0;
		} else if (input.equals("p")) {
			return 1;
		} else if (input.equals("s")){
			return 2;
		} else {
			return 0;
		}
	}
}
