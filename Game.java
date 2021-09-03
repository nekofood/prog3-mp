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
		//TODO: player init
	}

	/**
	 * Sets up a new game (piece selection, color, etc).
	 */
	public void newGame() {
		bag.shuffleBag();
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
