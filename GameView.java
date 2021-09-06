import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class GameView extends JFrame {
	private JButton[][] gameBoard;

	GameView() {
		gameBoard = new JButton[7][9];

		this.setTitle("Animal Chess");
		this.setSize(720, 560); //piece icons = 80px
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel center = new JPanel(new GridLayout(7, 9));
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				gameBoard[i][j] = new JButton();
				gameBoard[i][j].setBackground(Color.white);
                		center.add(gameBoard[i][j]);
			}
		}
		add(center, BorderLayout.CENTER);
        	initIcons();
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
                		gameBoard[i][j].setIcon(new ImageIcon("River.png"));
            		}
        	}

        	for (int i = 2; i>=1; i--) {
            		for (int j = 3; j<=5;j++) {
                		gameBoard[i][j].setIcon(new ImageIcon("River.png"));
            		}
        	}
    	}
	
	private void initDenTraps()
    	{
        	//left side
        	gameBoard[2][0].setIcon(new ImageIcon(/*"Some trap pic"*/));
        	gameBoard[3][1].setIcon(new ImageIcon(/*"Some trap pic"*/));
        	gameBoard[4][0].setIcon(new ImageIcon(/*"Some trap pic"*/));
        	gameBoard[3][0].setIcon(new ImageIcon(/*"Some den pic"*/));

        	//right side
        	gameBoard[2][8].setIcon(new ImageIcon(/*"Some trap pic"*/));
        	gameBoard[3][7].setIcon(new ImageIcon(/*"Some trap pic"*/));
        	gameBoard[4][8].setIcon(new ImageIcon(/*"Some trap pic"*/));
        	gameBoard[3][8].setIcon(new ImageIcon(/*"Some den pic"*/));
    	}

}
