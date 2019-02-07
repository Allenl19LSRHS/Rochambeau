import java.util.Random;

/*
 * predictive player that should use the data stored in opponentMoves[] to smartly guess the best move
 * methods:
 * - constructor: just the same as RPSComputerPlayer
 * - generateMove(): will parse the array and figure out what to guess next
 */


public class RPSPredictivePlayer extends RPSComputerPlayer {
	
	public int generateMove() {
		Random random = new Random();
		int out;
		float r = 0;
		float s = 0;
		float p = 0;
		
		if (opponentMoves.size() == 0) {
			return 0;
		}
		
		// trying to create a weighted average based on the percentage guessed by the player
		for (int i: opponentMoves) {
			if (i == 0) {
				r++;
			} else if (i  == 1) {
				p++;
			} else {
				s++;
			}
		}
		
		// calculate the percentage of each guess the player guessed
		float pR = r/(round+1);
		float pP = p/(round+1);
		float pS = s/(round+1);
		//System.out.println(pR + " " + pS + " " + pP);
		
		float rand = random.nextFloat();
		
		//basically use a weighted random number to figure out what the player guesses most often,
		//and make the move that would beat it
		if (rand <= pR) {
			out = 1;
		} else if (rand > pR && rand <= (pR + pP)) {
			out = 2;
		} else {
			out = 0;
		}

		return out;
	}
}
