/**
 * This class represents a match to be played by two players.
 *
 */

class Game {
	private Board board;
	private Player player1;
	private Player player2;
	private int turn;

	Game() {
		board = new Board();
		turn = 0;
		//TODO: player init
	}

	public void doTurn(Piece piece, char direction) {
		piece.movePiece(direction);
	}

	public void EndGame() {
		//zzz
	}
}
