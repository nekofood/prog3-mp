/**
 * This class represents the game of Animal Chess and handles all operations related to it.
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

		player1 = new Player(1);
		player2 = new Player(2);

		bag.shuffleBag();
	}

	/**
	 * Compares the ranks of two pieces (for new game).
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
		else if (whoseTurn == 2) {
			firstplayer = player2;
			secondplayer = player1;
		}
		//safety case
		else {
			firstplayer = player1;
			secondplayer = player2;
		}

		if (firstSide == 1) {
			whoseTurn = 1;
			for (int i = 0; i < 8; i++) {
				firstplayer.initializePiece(board.getPieces().get(i));
				System.out.println("[Game] initialized a " + board.getPieces().get(i));
			}
			for (int i = 8; i < 16; i++) {
				secondplayer.initializePiece(board.getPieces().get(i));
				System.out.println("[Game] initialized a " + board.getPieces().get(i));
			}
		}
		if (firstSide == 2) {
			whoseTurn = 2;
			for (int i = 0; i < 8; i++) {
				secondplayer.initializePiece(board.getPieces().get(i));
				System.out.println("[Game] initialized a " + board.getPieces().get(i));
			}
			for (int i = 8; i < 16; i++) {
				firstplayer.initializePiece(board.getPieces().get(i));
				System.out.println("[Game] initialized a " + board.getPieces().get(i));
			}
		}
	}

	/**
	 * Executes a piece's movePiece method.
	 */
	public boolean movePiece(Piece piece, char direction) {
		return piece.movePiece(direction);
	}

	/**
	 * Advances the turn counter and passes the turn to the other player.
	 */
	public void advanceTurn() {
		++turn;
		System.out.println("Turn advanced (now turn " + turn + ")");
		if (whoseTurn == 1) {
			whoseTurn = 2;
			return;
		}
		if (whoseTurn == 2)
			whoseTurn = 1;
	}

	/**
	 * Draws a piece from the bag.
	 * @return a piece from the bag
	 */
	public Piece drawFromBag() {
		return bag.drawPiece();
	}

	/**
	 * Retrieves the piece at the specified x, y coordinates
	 * @param x the x
	 * @param y the y
	 * @return the piece at x,y, null if there is no piece at given x,y
	 */
	public Piece getFromBoard(int x, int y) {
		return board.getPieceAt(x, y);
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
		return this.board.checkEnd();
	}

	/**
	 * Returns whose turn it is
	 * @return whose turn it is
	 */
	public int getWhoseTurn() {
		return whoseTurn;
	}

	/**
	 * Returns the player 1 object.
	 * @return player 1
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * Returns the player 2 object.
	 * @return player 2
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * Returns the bag.
	 * @return bag
	 */
	public Bag getBag() {
		return bag;
	}

	public Board getBoard() {
		return board;
	}
}
