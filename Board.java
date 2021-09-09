import java.util.*;

class Board {
	private ArrayList<Piece> pieces;
	private Tile[] terrain;

	Board() {
		//all piece initiation goes here
		//TODO after finishing up Game class mayhaps
		pieces = new ArrayList<>();
		terrain = new Tile[20];
		initPieces();

		//player tiles
		terrain[0] = new Tile("Den", 1, 4, 1, this);
		terrain[1] = new Tile("Den", 9, 4, 2, this);

		terrain[2] = new Tile("Trap", 1, 3, 1, this);
		terrain[3] = new Tile("Trap", 1, 5, 1, this);
		terrain[4] = new Tile("Trap", 2, 4, 1, this);

		terrain[5] = new Tile("Trap", 9, 3, 2, this);
		terrain[6] = new Tile("Trap", 9, 5, 2, this);
		terrain[7] = new Tile("Trap", 8, 4, 2, this);

		//IDEA: Board() can accept an array containing the positions of water tiles
		//for customizability and modularity
		terrain[8] = new Tile("Water", 4, 6, 0, this);
		terrain[9] = new Tile("Water", 5, 6, 0, this);
		terrain[10] = new Tile("Water", 6, 6, 0, this);
		terrain[11] = new Tile("Water", 4, 5, 0, this);
		terrain[12] = new Tile("Water", 5, 5, 0, this);
		terrain[13] = new Tile("Water", 6, 5, 0, this);
		terrain[14] = new Tile("Water", 4, 3, 0, this);
		terrain[15] = new Tile("Water", 5, 3, 0, this);
		terrain[16] = new Tile("Water", 6, 3, 0, this);
		terrain[17] = new Tile("Water", 4, 2, 0, this);
		terrain[18] = new Tile("Water", 5, 2, 0, this);
		terrain[19] = new Tile("Water", 6, 2, 0, this);
	}

	public void initPieces() {
		//left-side pieces (0-7)
		pieces.add(new LionTigerPiece("Lion", 1, 1, 1, 7, this));
		pieces.add(new Piece("Dog", 2, 2, 1, 4, this));
	  	pieces.add(new Piece("Leopard", 3, 3, 1, 5, this));
		pieces.add(new MousePiece(3, 1, 1, this));
		pieces.add(new Piece("Wolf", 3, 6, 1, 3, this));
		pieces.add(new Piece("Cat", 2, 6, 1, 2, this));
		pieces.add(new LionTigerPiece("Tiger", 1, 7, 1, 6, this));
	  	pieces.add(new ElephantPiece(3, 7, 1, this));
		//right side pieces (8-15)
		pieces.add(new LionTigerPiece("Lion", 9, 7, 2, 7, this));
		pieces.add(new Piece("Dog", 8, 6, 2, 4, this));
		pieces.add(new Piece("Leopard", 7, 7, 2, 5, this));
		pieces.add(new MousePiece(3, 1, 2, this));
		pieces.add(new Piece("Wolf", 7, 3, 2, 3, this));
		pieces.add(new Piece("Cat", 8, 2, 2, 2, this));
		pieces.add(new LionTigerPiece("Tiger", 9, 1, 2, 6, this));
		pieces.add(new ElephantPiece(7, 1, 2, this));
	}

	/**
	 * Removes a piece from the board.
	 */
	public void removePiece(Piece piece) {
		pieces.remove(piece);
	}

	/**
	 * Checks if any player has achieved the "den" win condition.
	 * @return the number of the player that won (left or right), 0 otherwise
	 */
	public int checkEnd() {
		for (int i=0; i < pieces.size(); i++) {
			//p1's den check
			Piece current = pieces.get(i);
			if (current.getOwner() == 1 && current.getX() == terrain[1].getX() && current.getY() == terrain[1].getY()) {
					return 1;
			}
			//p2's den check
			if (current.getOwner() == 2 && current.getX() == terrain[0].getX() && current.getY() == terrain[0].getY()) {
					return 2;
			}
		}
		return 0;
	}

	/**
	 * Returns the piece at a certain board x,y coordinate, null otherwise.
	 */
	public Piece getPieceAt(int x, int y) {
		//this is what i get for not using a 2D array
		for (int i=0; i < pieces.size(); i++) {
			if (pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
				System.out.println("Located " + pieces.get(i));
				return pieces.get(i);
			}
		}
		return null;
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public Tile[] getTerrain() {
		return terrain;
	}
}
