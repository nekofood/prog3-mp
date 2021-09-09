import java.util.*;
/**
 * This class represents a bag for shuffling pieces.
 */
class Bag {
	private ArrayList<Piece> pieces;

	Bag(ArrayList<Piece> boardPieces) {
		pieces = new ArrayList<>();
		for (int i = 0; i < boardPieces.size(); i++) {
			pieces.add(boardPieces.get(i));
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
		if (pieces.size() == 0) {
			System.out.println("[Bag] list size 0, drawing null");
			return null;
		}
		Piece piece =  pieces.get(0);
		pieces.remove(0);
		System.out.println("[Bag] Drew a " + piece.getType());
		return piece;
	}


}
