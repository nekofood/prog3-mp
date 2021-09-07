/**
 * This class represents a single game of Animal Chess.
 *
 */

class Game {
	private Board board;
	private Bag bag;
	private Player player1;
	private Player player2;
	private int turn;
	private int whoseTurn;

	/**
	 * This constructor creates a new game instance with a board and bag.
	 * It also sets the turn counter to 0.
	 */
	Game() {
		board = new Board();
		bag = new Bag(board.getPieces());
		turn = 0;
		whoseTurn = 0;
	}

	/**
	 * Compares the ranks of two pieces (for new game) and sets the first player accordingly.
	 * @param p1 p1's piece rank
	 * @param p2 p2's piece rank
	 * @return the player who drew the higher piece
	 */
	public int comparePieces(int p1, int p2) {
		//set first player to whoever drew the higher piece
		if (p1 > p2) {
			whoseTurn = 1;
			return 1;
		}
		whoseTurn = 2;
		return 2;
		//pass control back to the controller
	}

	/**
	 * Adds the board pieces to each player's array.
	 * @param firstSide the side chosen by the first player (in accordance to Owner no.)
	 */
	public void initializePlayers(int firstSide) {
		//USE WHOSETURN!!!
		Player firstplayer;
		Player secondplayer;
		if (whoseTurn == 1) {
			firstplayer = player1;
			secondplayer = player2;
		}
		if (whoseTurn == 2) {
			firstplayer = player2;
			secondplayer = player1;
		}

		if (firstSide = 1) {
			for (int i = 0; i < 8; i++)
				firstplayer.initializePiece(board.getPieces().get(i));
			for (i = 8; i < 16; i++)
				secondplayer.initializePiece(board.getPieces().get(i));
		}
		if (firstSide = 2) {
			for (int i = 0; i < 8; i++)
				secondplayer.initializePiece(board.getPieces().get(i));
			for (i = 8; i < 16; i++)
				firstplayer.initializePiece(board.getPieces().get(i));
		}
	}

	/**
	 * Executes a piece's movePiece method.
	 */
	public boolean movePiece(Piece piece, char direction) {
		return piece.movePiece(direction);
	}

	public void advanceTurn() {
		++turn;
		if (whoseTurn == 1)
			whoseTurn = 2;
		if (whoseTurn == 2)
			whoseTurn = 1;
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

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Bag getBag() {
		return bag;
	}
}
