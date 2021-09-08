import java.awt.event.*;

class GameController() {
	private GameView view;
	private Game model;
	private Piece spc; //selected piece for movement handling

	GameController(GameView v, Game g) {
		view = v;
		model = g;
		spc = null; //keep it outside movement handling to prevent it from getting overwritten

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				v.addButtonListener(v.getBoard()[i][j], new BoardListener());
			}
		}
	}

	/**
	 * Initiates a new game.
	 */
	public void newGame() {
		view.disableAllButtons();

		//Make sure you call this first in the main!!!
		NewGameWindow ngView = new NewGameWindow();
		Bag bag = model.getBag();

		bag.shuffleBag();

		Piece p1piece = bag.drawPiece();
		Piece p2piece = bag.drawPiece();
		//bandaid fix to prevent both players from drawing the same piece type
		if (p1piece.getType().equals(p2piece.getType()))
			p2piece = bag.drawPiece();

		ngView.setPlayerDrawLabel(1, p1piece.getType());
		ngView.setPlayerDrawLabel(2, p2piece.getType());

		int higher = model.comparePieces(p1piece.getRank(), p2piece.getRank());
		ngView.setHigherLabel("Player " + higher);

		//halt code while waiting for user input lmao
		while (ngView.getSelectedSide() = null)
			assert true;

		//insert pieces into the players' arraylists
		model.initializePlayers(ngView.getSelectedSide());

		ngView.closeWindow();
		view.enableAllButtons();
	}

	/**
	 * Checks if a given space is orthogonal to another. Also checks if there's anything in the way.
	 * Used to check if a movement click is valid.
	 * @param srcX the piece's X
	 * @param srcY the piece's Y
	 * @param destX the X-value that was clicked on
	 * @param destY the Y-value that was clicked on
	 * @return true if the x,y that was clicked is right next to the source x,y
	 */
	public boolean isMoveValid(int srcX, int srcY, int destX, int destY) {
		if ((srcX + destX == 1 || srcX + destX == -1) && (srcY + destY == 1 || srcY + destY == 1))
			return true;
		if (model.getBoard().getPieceAt(destX,destY) != null && model.getBoard().getPieceAt(destX,destY).getOwner() == model.getWhoseTurn())
			return false;
		return false;
	}

	/**
	 * Converts x,y movement to NSEW chars.
	 * Please input within the range of -1 <= x <= 1.
	 * @param X -1 or 1 (W/E)
	 * @param Y -1 or 1 (S/N)
	 * @return the compass direction to move in; null if invalid
	 */
	public char moveToChar(int X, int Y) {
			if (X == 1 && Y == 0)
				return 'E';
			if (X == -1 && Y == 0)
				return 'W';
			if (X == 0 && Y == 1)
				return 'N';
			if (X == 0 && Y == -1)
				return 'S';
			return null;
	}

	class BoardListener implements ActionListener {
		//TODO!!!!!
		public void actionPerformed(ActionEvent e) {
			Board gb = model.getBoard();
			Piece pc; //piece at the current space being checked

			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 9; j++) {
					//for getting the button x,y
					if (e.getSource() == view.getBoard()[i][j]) {
						pc = gb.getPieceAt(j, i);
						/*check if 1. there's no selected piece,
								   2. there's a piece at the button clicked
								   3. the piece is owned by the player who's taking their turn
						  if all passes, select that piece
								    */
						if (spc == null && pc != null && pc.getOwner() == model.getWhoseTurn()) {
							spc = pc;
							//TODO: highlight movement cross
							return;
						}
						/* if a piece IS selected, time to handle movement! */
						if (spc != null) {
							int spcX = spc.getX();
							int spcY = spc.getY();
							//check if the piece is orthogonal to the space just clicked
							if (isMoveValid(spcX, spcY, j, i) && ) {
								if (spc.movePiece(moveToChar(j - spcX, i - spcY))) {
									view.movePiece(view.getBoard()[spcY][spcX], view.getBoard()[i][j]);
									model.advanceTurn();
								}
								spc = null;
								return;
							}
							spc = null;
							return;
						}
					}
				}
			}
		}
	}

}
