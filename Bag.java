import java.util.Random;
/**
 * This class represents a bag for shuffling pieces.
 */
class Bag {
	Bag(ArrayList<Piece> boardPieces) {
		for (int i = 0; i < pieces.size(); i++) {
			piece[i] = boardPieces.get(i)
		}
	}

	/**
	 * Draws a random piece from the bag.
	 */
	public Piece drawPiece() {
		Random rand = new Random();
		return pieces[rand.nextInt(16)];	
	}

	private Piece[] pieces[16];
	
}
