import java.swing.*;
import java.awt.event.*;

class GameView extends JFrame {
	private JButton[][] gameBoard;

	GameView() {
		gameBoard = new JButton[7][9];

		this.setTitle("Animal Chess");
		this.setSize(720, 560); //piece icons = 80px
		this.setLayout(new GridLayout(7, 9));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				gameBoard[i][j] = new JButton();
			}
		}

		this.setVisible(true);
	}

	/**
	 * Initializes the icons on each button.
	 */
	public void initIcons() {

	}

	/**
	 * Transfers the visuals from one square to another.
	 * The source square is cleared in the process.
	 * @param src the source square
	 * @param src the destination square
	 */
	public void movePiece(JButton src, JButton destination) {
		destination.setIcon(src.getIcon());
		//TODO: water
		src.setIcon(null);
	}

	public JButton[][] getBoard() {
		return gameBoard;
	}

	public void addButtonListener(JButton b, ActionListener al) {
		b.addActionListener(al);
	}

}
