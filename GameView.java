import java.swing.*;
import java.awt.event.*;

class GameView extends JFrame {
	JButton[][] gameBoard;

	GameView() {
		gameBoard = new JButton[9][7];
		
		this.setTitle("Animal Chess");

		this.setVisible(true);
	}

}
