
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

	//Initiates a new game.
	public void newGame() {
		NewGameWindow ngView = new NewGameWindow();
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
