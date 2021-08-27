class Board {
	private ArrayList<Piece> pieces;
	private Tile[] terrain;

	Board() {
		//all piece initiation goes here
		//TODO after finishing up Game class mayhaps

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

	public Piece[] getBoard() {
		return pieces;
	}

	public Tile[] getTerrain() {
		return terrain;
	}
}
