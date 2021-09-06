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
		
		initRiver();
		initDenTraps();

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
	
	private void initRiver()
    	{  
        	for (int i = 5; i>=4; i--) {
            		for (int j = 3; j<=5;j++) {
                		gameBoard[i][j].add(new JLabel(new ImageIcon("River.png")));
            		}
        	}

        	for (int i = 2; i>=1; i--) {
            		for (int j = 3; j<=5;j++) {
                		gameBoard[i][j].add(new JLabel(new ImageIcon("River.png")));
            		}
        	}
    	}
	
	private void initDenTraps()
    	{
        	//left side
        	gameBoard[2][0].add(new JLabel(new ImageIcon(/*"Some trap pic"*/)));
        	gameBoard[3][1].add(new JLabel(new ImageIcon(/*"Some trap pic"*/)));
        	gameBoard[4][0].add(new JLabel(new ImageIcon(/*"Some trap pic"*/)));
        	gameBoard[3][0].add(new JLabel(new ImageIcon(/*"Some den pic"*/)));

        	//right side
        	gameBoard[2][8].add(new JLabel(new ImageIcon(/*"Some trap pic"*/)));
        	gameBoard[3][7].add(new JLabel(new ImageIcon(/*"Some trap pic"*/)));
        	gameBoard[4][8].add(new JLabel(new ImageIcon(/*"Some trap pic"*/)));
        	gameBoard[3][8].add(new JLabel(new ImageIcon(/*"Some den pic"*/)));
    	}

}
