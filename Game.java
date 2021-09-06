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

	Game() {
		board = new Board();
		bag = new Bag(board.getPieces());
		turn = 0;
		whoseTurn = 0;
	}

	/**
	 * Executes the "draw animal piece and select color" section of starting a new game.
	 * @return the player who will select their color and move first
	 */
	public int drawAnimalPiece() {
		bag.shuffleBag();

		Piece p1piece = bag.drawPiece();
		Piece p2piece = bag.drawPiece();
		//bandaid fix to prevent both players from drawing the same piece type
		if (p1piece.getType().equals(p2.piece.getType()))
			p2piece = bag.drawPiece();

		System.out.println("Bag pieces drawn");

		//set first player to whoever drew the higher piece
		if (p1piece.getRank() > p2piece.getRank()) {
			whoseTurn = 1;
			return 1;
		}
		whoseTurn = 2;
		return 2;
		//pass control back to the controller
	}

	/**
	 * Adds the board pieces to each player's array.
	 * @param firstSide the side chosen by the first player
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

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
}
