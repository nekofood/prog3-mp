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
		this.setLayout(new BoxLayout());

		instructionLabel = new JLabel("Higher piece moves first and gets to pick a side");
		p1label = new JLabel("P1 drew a: ");
		p2label = new JLabel("P2 drew a: ");
		movesFirstLabel = new JLabel(" drew higher! Pick a color:");
		redButton = new JButton("Red (left)");
		blueButton = new JButton("Blue (right)");

		redButton.addButtonListener(new NewGameListener());
		blueButton.addButtonListener(new NewGameListener());

		add(instructionLabel);
		add(p1label);
		add(p2label);
		add(movesFirstLabel);
		add(redButton);
		add(blueButton);

		this.setVisible(true);
	}

	/**
	 * Appends the piece name to the player draw message.
	 * @param p the player whose message to edit
	 * @param s the string to append
	 */
	public void setPlayerDrawLabel(int p, String s) {
		if (p == 1)
			p1label.setText("P1 drew a: " + s);
		if (p == 2)
			p2label.setText("P2 drew a: " + s);
	}

	/**
	 * Closes this window.
	 */
	public void closeWindow() {
		this.setVisible(false);
		dispose();
	}

	class NewGameListener implements ActionListener {
		//return the side the first player chose to the GameController
		//only question is, how?
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == blueButton) {

			}
			if (e.getSource() == redButton) {

			}
		}
	}
}
