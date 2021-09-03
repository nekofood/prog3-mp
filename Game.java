/**
 * This class represents a match to be played by two players.
 *
 */

class Game {
	private Board board;
	private Bag bag;
	private Player player1;
	private Player player2;
	private int turn;

	Game() {
		board = new Board();
		bag = new Bag(board.getPieces());
		turn = 0;
	}

	/**
	 * Sets up a new game (piece selection, color, etc).
	 * @return the side that will play first (1 if left, 2 if right)
	 */
	public int newGame() {
		int side;

		bag.shuffleBag();
		//TODO: receive input from controller
		
		Piece p1piece = bag.drawPiece();
		Piece p2piece = bag.drawPiece();
		//bandaid fix to prevent both players from drawing the same piece type
		if (p1piece.getType().equals(p2.piece.getType()))
			p2piece = bag.drawPiece();

		//set first player to whoever drew the higher piece
		
		/*Player n, pick a side, etc etc*/

		return side;
		
	}

	/**
	 * Executes a turn by moving a piece in a given direction.
	 */
	public boolean doTurn(Piece piece, char direction) {
		return piece.movePiece(direction);
	}

	public void endGame() {
		//zzz
	}
}
