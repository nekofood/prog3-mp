import java.util.Collections;
/**
 * This class represents a bag for shuffling pieces.
 */
class Bag {
	Bag(ArrayList<Piece> boardPieces) {
		pieces = new ArrayList<>();
		for (int i = 0; i < pieces.size(); i++) {
			pieces.add(boardPieces.get(i))
		}

	}

	/**
	 * Shuffles the order of the pieces ArrayList.
	 */
	public void shuffleBag() {
		Collections.shuffle(pieces);
	}

	/**
	 * Draws a piece from the bag.
	 * @return The first piece in the list, null if empty
	 */
	public Piece drawPiece() {
		if (pieces.size() == 0)
			return null;
		Piece piece =  pieces.get(0);
		pieces.remove(0);
		return piece;
	}

	private ArrayList<Piece> pieces; 
	
}
