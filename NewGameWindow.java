import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.swing.BoxLayout;

class NewGameWindow extends JFrame {
	JLabel p1label;
	JLabel p2label;
	JLabel instructionLabel;
	JLabel movesFirstLabel;
	JButton redButton;
	JButton blueButton;
	int selectedSide;
	//TODO: hook this to the game somehow

	NewGameWindow() {
		selectedSide = 0;

		this.setTitle("Animal Chess: New Game");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(new BoxLayout());

		instructionLabel = new JLabel("Higher piece moves first and gets to pick a side");
		p1label = new JLabel("P1 drew a: ");
		p2label = new JLabel("P2 drew a: ");
		movesFirstLabel = new JLabel(" drew higher! Pick a color:");
		redButton = new JButton("Red (left)");
		blueButton = new JButton("Blue (right)");

		redButton.addActionListener(new NewGameListener());
		blueButton.addActionListener(new NewGameListener());

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
	 * Sets the "drew higher!" label.
	 * @param s the string to prepend to "drew higher!"
	 */
	public void setHigherLabel(String s) {
		movesFirstLabel.setText(s + " drew higher! Pick a color:");
	}

	/**
	 * Returns the side selected by the user in the window.
	 * @return 1 if the player selected red, 2 if right
	 */
	public int getSelectedSide() {
		return selectedSide;
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
				selectedSide = 2;
			}
			if (e.getSource() == redButton) {
				selectedSide = 1;
			}
		}
	}
}
