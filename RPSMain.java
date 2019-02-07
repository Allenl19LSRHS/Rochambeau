import java.util.Scanner;

public class RPSMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean repeat = true;
		String input = "";
		int rounds = 0;
		int played = 0;
		int p1Move;
		int p2Move;
		int p1Wins = 0;
		int p2Wins = 0;
		
		// Get the number of rounds to play
		do {
			write("How many rounds do you want to play?");
			input = scan.next();
			try {
				rounds = Integer.parseInt(input);
			} catch (Exception e) {
				write("Please enter only numbers");
			}
		} while (rounds == 0);
		
		// Create the 2 players
		RPSHumanPlayer p1 = new RPSHumanPlayer(scan);
		RPSPredictivePlayer p2 = new RPSPredictivePlayer();
		
		//until the rounds have been completed
		do {
			
			//Each player generates a move
			p2Move = p2.generateMove();
			p1Move = p1.generateMove();
			
			// Print out their moves
			if (p1Move == 0) {
				write("Player 1 cast a rock");
				write("    _______\n" + 
						"---'   ____)\n" + 
						"      (_____)\n" + 
						"      (_____)\n" + 
						"      (____)\n" + 
						"---.__(___)");
			} else if (p1Move == 1) {
				write("Player 1 cast paper");
				write("     _______\n" + 
						"---'    ____)____\n" + 
						"           ______)\n" + 
						"          _______)\n" + 
						"         _______)\n" + 
						"---.__________)");
			} else {
				write("Player 1 cast scissors");
				write("    _______\n" + 
						"---'   ____)____\n" + 
						"          ______)\n" + 
						"       __________)\n" + 
						"      (____)\n" + 
						"---.__(___)");
			}
			if (p2Move == 0) {
				write("Player 2 cast a rock");
				write("    _______\n" + 
						"---'   ____)\n" + 
						"      (_____)\n" + 
						"      (_____)\n" + 
						"      (____)\n" + 
						"---.__(___)");
			} else if (p2Move == 1) {
				write("Player 2 cast paper");
				write("     _______\n" + 
						"---'    ____)____\n" + 
						"           ______)\n" + 
						"          _______)\n" + 
						"         _______)\n" + 
						"---.__________)");
			} else {
				write("Player 2 cast scissors");
				write("    _______\n" + 
						"---'   ____)____\n" + 
						"          ______)\n" + 
						"       __________)\n" + 
						"      (____)\n" + 
						"---.__(___)");
			}
			
			// Each player receives the other player's move for storage
			p2.receiveMove(p1Move, played);
			p1.receiveMove(p2Move, played);
			
			// Round is incremented
			played++;
			if (played >= rounds) {
				repeat = false;
			}
			
			// Then check to see who wins
			if (p1Move == p2Move) {
				write("It's a tie!");
				continue;
			}
			if ((p1Move + 2)%3 == p2Move) {
				write("Player 1 wins!");
				p1Wins++;
			} else {
				write("Player 2 wins!");
				p2Wins++;
			}
			
		} while(repeat);

		write("Well, that's " + played + " rounds, good game!");
		write("Player 1 won " + p1Wins + " rounds, and Player 2 won " + p2Wins + " rounds.");
	}
	
	public static void write(String s) {
		System.out.println(s);
	}
}
