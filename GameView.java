import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class GameView extends JFrame {
	private JButton[][] gameBoard;
	private JLabel turn;

	GameView() {
		gameBoard = new JButton[7][9];

		setTitle("Animal Chess");
		setSize(760, 650); //piece icons = 80px
		setResizable(false);
	    setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel center = new JPanel(new GridLayout(7, 9));
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				gameBoard[i][j] = new JButton();
                		gameBoard[i][j].setBackground(Color.white);
                		center.add(gameBoard[i][j]);
			}
		}

    	JPanel top = new JPanel(new FlowLayout());
    	turn = new JLabel();
    	top.add(turn);

    	add(top, BorderLayout.NORTH);
    	add(center, BorderLayout.CENTER);
    	initIcons();
		setVisible(true);
	}

	/**
	 * Initializes the icons on each button.
	 */
	public void initIcons() {

		initTerrain();

		//red pieces
		gameBoard[0][0].setIcon(new ImageIcon("img/tiger_red.png"));
		gameBoard[0][2].setIcon(new ImageIcon("img/elephant_red.png"));
		gameBoard[1][1].setIcon(new ImageIcon("img/cat_red.png"));
		gameBoard[2][2].setIcon(new ImageIcon("img/wolf_red.png"));
		gameBoard[4][2].setIcon(new ImageIcon("img/leopard_red.png"));
		gameBoard[5][1].setIcon(new ImageIcon("img/dog_red.png"));
		gameBoard[6][0].setIcon(new ImageIcon("img/lion_red.png"));
		gameBoard[6][2].setIcon(new ImageIcon("img/mouse_red.png"));

		//blue pieces
		gameBoard[6][8].setIcon(new ImageIcon("img/tiger_blue.png"));
		gameBoard[6][6].setIcon(new ImageIcon("img/elephant_blue.png"));
		gameBoard[5][7].setIcon(new ImageIcon("img/cat_blue.png"));
		gameBoard[4][6].setIcon(new ImageIcon("img/wolf_blue.png"));
		gameBoard[2][6].setIcon(new ImageIcon("img/leopard_blue.png"));
		gameBoard[1][7].setIcon(new ImageIcon("img/dog_blue.png"));
		gameBoard[0][8].setIcon(new ImageIcon("img/lion_blue.png"));
		gameBoard[0][6].setIcon(new ImageIcon("img/mouse_blue.png"));

	}

	/**
	 * Transfers the visuals from one square to another.
	 * The source square is cleared in the process.
	 * @param src the source square
	 * @param src the destination square
	 */
	public void movePiece(JButton src, JButton destination) {
		System.out.println("[View] Updating piece display");
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

	/**
	 * Initializes River, Den and Trap icons in their positions
	 */
	private void initTerrain()
    	{
		//Rivers
        	for (int i = 5; i>=4; i--) {
            		for (int j = 3; j<=5;j++) {
                		gameBoard[i][j].setIcon(new ImageIcon("img/River.png"));
            		}
        	}

        	for (int i = 2; i>=1; i--) {
            		for (int j = 3; j<=5;j++) {
                		gameBoard[i][j].setIcon(new ImageIcon("img/River.png"));
            		}
        	}

		//left side terrains
        	gameBoard[2][0].setIcon(new ImageIcon("img/trap_red.png"));
        	gameBoard[3][1].setIcon(new ImageIcon("img/trap_red.png"));
        	gameBoard[4][0].setIcon(new ImageIcon("img/trap_red.png"));
        	gameBoard[3][0].setIcon(new ImageIcon("img/den_red.png"));

        	//right side terrains
        	gameBoard[2][8].setIcon(new ImageIcon("img/trap_blue.png"));
        	gameBoard[3][7].setIcon(new ImageIcon("img/trap_blue.png"));
        	gameBoard[4][8].setIcon(new ImageIcon("img/trap_blue.png"));
        	gameBoard[3][8].setIcon(new ImageIcon("img/den_blue.png"));
    	}

	/**
	 * Sets the button color to green when valid direction
	 * @param btn the button that is a valid direction
	 */
	public void showValidDir(JButton btn) {
		//TODO: this along with hideValidDir() is causing errors for some reason, will come back to later
		int i = 1;
		int j = 1;
		//get surrounding buttons
    	for (i = 1; i < 7; i++) {
			for (j = 1; j < 9; j++) {
				if (gameBoard[i][j] == btn) {
					break;
				}
			}
			break;
		}
		//i and j are the button's y,x
		if (i + 1 < 7)
			gameBoard[i+1][j].setBackground(Color.green);
		if (i - 1 >= 0)
			gameBoard[i-1][j].setBackground(Color.green);
		if (j + 1 < 9)
			gameBoard[i][j+1].setBackground(Color.green);
		if (j - 1 >= 0)
			gameBoard[i][j-1].setBackground(Color.green);
    }

	/**
	 * Resets the button colors to white
	 */
	public void hideValidDir(JButton btn) {
		int i = 1;
		int j = 1;
		//get surrounding buttons
    	for (i = 1; i < 7; i++) {
			for (j = 1; j < 9; j++) {
				if (gameBoard[i][j] == btn) {
					break;
				}
			}
			break;
		}
		//i and j are the button's y,x
		if (i + 1 < 7)
			gameBoard[i+1][j].setBackground(Color.white);
		if (i - 1 >= 0)
			gameBoard[i-1][j].setBackground(Color.white);
		if (j + 1 < 9)
			gameBoard[i][j+1].setBackground(Color.white);
		if (j - 1 >= 0)
			gameBoard[i][j-1].setBackground(Color.white);
	}

	/**
	 * Sets the label to the color of the current player's turn
	 * @param player the current player
	 */
	public void setPlayerTurninfo(String s)
	{
    	turn.setText(s);
	}

	/**
	 * Sets the label to the winner
	 * @param player the player who wins
	 */
	public void setWinnerInfo(Player player)
	{
		turn.setText(player.getNumber() + " Wins!");
	}

	/**
	 * Enables all the buttons on the board
	 */
	public void enableAllButtons()
	{
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				gameBoard[i][j].setEnabled(true);
			}
		}
	}

	/**
	 * Disables all the buttons on the board
	 */
	public void disableAllButtons()
	{
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				gameBoard[i][j].setEnabled(false);
			}
		}
	}

}
