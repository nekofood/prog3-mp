/**
 * Represents a player in the game.
 */
class Player {
	Player(int number, String color) {
		this.number = number;
		this.color = color;
		pieces = new ArrayList<>();
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

	/**
	 * Returns the amount of living pieces the player has left.
	 */
	public int getLivePieces() {
		int alive = 0;
		for (int i = 0; i < pieces.size(); i++) {
			if (!pieces.get(i).getCaptureStatus)
				++alive;
		}
		return alive;
	}

	public Tile[] getTiles() {
		return tiles;
	}

	public String getColor() {
		return color;
	}

	public int getNumber() {
		return number;
	}

	private ArrayList<Piece> pieces;
	private Tile[] denTiles;
	private int number;
	private String color;
}
