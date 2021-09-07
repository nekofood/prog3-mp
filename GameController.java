
class GameController() {
	private GameView view;
	private Game model;

	GameController(GameView v, Game g) {
		view = v;
		model = g;

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				v.addButtonListener(getBoard()[i][j], new BoardListener());
			}
		}
	}

	/**
	 * Initiates a new game.
	 */
	public void newGame() {
		NewGameWindow ngView = new NewGameWindow();
		Bag bag = model.getBag();

		bag.shuffleBag();

		Piece p1piece = bag.drawPiece();
		Piece p2piece = bag.drawPiece();
		//bandaid fix to prevent both players from drawing the same piece type
		if (p1piece.getType().equals(p2.piece.getType()))
			p2piece = bag.drawPiece();

		ngView.setPlayerDrawLabel(1, p1piece.getType());
		ngView.setPlayerDrawLabel(2, p2piece.getType());

		int higher = model.comparePieces(p1piece.getRank(), p2piece.getRank());
		ngView.setHigherLabel("Player " + higher);

		//halt code while waiting for user input lmao
		while (ngView.getSelectedSide() = null)
			assert true;

		model.initializePlayers(ngView.getSelectedSide());

		//TODO: disable board during the NG process

		ngView.closeWindow();
	}

	class BoardListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Board gb = model.getBoard();
			Piece pc; //current space being checked
			Piece spc; //selected piece

			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 9; j++) {
					//for getting the button x,y
					if (e.getSource() == view.getBoard()[i][j]) {
						pc = gb.getPieceAt(j, i);
						if (pc != null && pc.getOwner() == whoseTurn) {
							spc = pc;
						}
					}
				}
			}
		}
	}

}
