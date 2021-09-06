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
	private int whoseTurn;

	Game() {
		board = new Board();
		bag = new Bag(board.getPieces());
		turn = 0;
		//todo: player init
	}

	/**
	 * Sets up a new game (piece selection, color, etc).
	 */
	public void newGame() {
		int side;

		bag.shuffleBag();
		//TODO: how to receive input from controller? (might have to split this newGame function up)

		Piece p1piece = bag.drawPiece();
		Piece p2piece = bag.drawPiece();
		//bandaid fix to prevent both players from drawing the same piece type
		if (p1piece.getType().equals(p2.piece.getType()))
			p2piece = bag.drawPiece();

		//set first player to whoever drew the higher piece

		/*Player n, pick a color, etc etc*/
		//TODO: assign pieces to the players


	}

	/**
	 * Executes a turn by moving a piece in a given direction.
	 */
	public boolean doTurn(Piece piece, char direction) {
		return piece.movePiece(direction);
	}

	/**
	 * Checks win condition.
	 * @return no. of winning player, 0 otherwise
	 */
	public int checkEnd() {
		if (player1.getLivePieces() == 0)
			return 2;
		if (player2.getLivePieces() == 0)
			return 1;
		if (this.board.checkEnd != 0)
			return checkEnd;
		return 0;
	}

	public void endGame() {
		//zzz
	}

	/**
	 * Resets the board to its default state. By making a new fucking board lol.
	 */
	public void resetGame() {

	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
}
