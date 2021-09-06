
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

	class BoardListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		Board gb = g.getBoard();
		Piece pc; //current piece being checked

			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 9; j++) {
					if (e.getSource() == view.getBoard()[i][j]) {
						pc = gb.getPieceAt(j, i);
						if (pc != null && pc.getOwner() == whoseTurn) {
							/* movement handling goes here... */
						}
						model.advanceTurn();
					}
				}
			}
		}
	}
}
