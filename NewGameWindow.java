import java.swing.*;
import java.awt.*;
import java.awt.event.*;

class NewGameWindow extends JFrame {
	JLabel p1label;
	JLabel p2label;
	JLabel instructionLabel;
	JLabel movesFirstLabel;
	JButton redButton;
	JButton blueButton;
	//TODO: hook this to the game somehow

	NewGameWindow() {
		this.setTitle("Animal Chess: New Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		instructionLabel = new JLabel("Higher piece moves first and gets to pick a side");
		p1label = new JLabel("P1 drew a: ");
		p2label = new JLabel("P2 drew a: ");
		movesFirstLabel = new JLabel(" drew higher! Pick a color:");
		redButton = new JButton("Red (left)");
		blueButton = new JButton("Blue (right)");

		redButton.addButtonListener(NewGameListener());

	}

	class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == blueButton)
		}
	}
}
