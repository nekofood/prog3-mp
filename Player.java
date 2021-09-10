import java.util.*;
/**
 * Represents a player in the game.
 */
class Player {
	Player(int number) {
		pieces = new ArrayList<>();
		this.number = number;
	}

	/**
	 * Add's a piece to the player's piece list.
	 */
	public void initializePiece(Piece piece) {
		pieces.add(piece);
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public int getNumber() {
		return number;
	}

	/**
	 * Returns the amount of living pieces the player has left.
	 */
	public int getLivePieces() {
		int alive = 0;
		for (int i = 0; i < pieces.size(); i++) {
			if (!pieces.get(i).getCaptureStatus())
				++alive;
		}
		return alive;
	}

	private ArrayList<Piece> pieces;
	private Tile[] denTiles;
	private int number;
}
