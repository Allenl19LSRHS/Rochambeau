import java.util.*;

/*
 * basic computer player with random guessing
 * methods:
 * - constructor: creates the array for receiveMove of the correct length
 * - generateMove(): generates a random guess from 0 to 2
 * - receiveMove(playerMove, played): stores data from the last round into an array
 */


public class RPSComputerPlayer {
	List<Integer> opponentMoves = new ArrayList<Integer>();
	int round;
	
	public int generateMove() {
		return (int)(Math.random() * 3);
	}
	
	public void receiveMove(int playerMove, int played) {
		// store the data from the round after generating a new move
		opponentMoves.add(played, playerMove);
		round = played;
	}
}
