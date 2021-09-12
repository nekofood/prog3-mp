import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 * This class is a JFrame that handles the game's graphical user interface.
 */
class GameView extends JFrame {
	private JButton[][] gameBoard;
	private JLabel turn;
	private ImageIcon[] tileIcons;
	private ImageIcon[] pieceIcons;

	/**
	 * This constructor creates a new Game View.
	 */
	GameView() {
		gameBoard = new JButton[7][9];
		tileIcons = new ImageIcon[5];
		pieceIcons = new ImageIcon[16];
    	initIcons();
		initTerrain();

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
		setVisible(true);
	}

	/**
	 * Initializes River, Den and Trap icons.
	 */
	private void initTerrain() {
		tileIcons[0] = new ImageIcon("img/River.png");
		tileIcons[1] = new ImageIcon("img/den_red.png");
		tileIcons[2] = new ImageIcon("img/trap_red.png");
		tileIcons[3] = new ImageIcon("img/den_blue.png");
		tileIcons[4] = new ImageIcon("img/trap_blue.png");
	}

	/**
	 * Initializes the array of piece icons.
	 */
	public void initIcons() {

		//red pieces
		pieceIcons[0] = new ImageIcon("img/tiger_red.png");
		pieceIcons[1] = new ImageIcon("img/elephant_red.png");
		pieceIcons[2] = new ImageIcon("img/cat_red.png");
		pieceIcons[3] = new ImageIcon("img/wolf_red.png");
		pieceIcons[4] = new ImageIcon("img/leopard_red.png");
		pieceIcons[5] = new ImageIcon("img/dog_red.png");
		pieceIcons[6] = new ImageIcon("img/lion_red.png");
		pieceIcons[7] = new ImageIcon("img/mouse_red.png");

		//blue pieces
		pieceIcons[8] = new ImageIcon("img/tiger_blue.png");
		pieceIcons[9] = new ImageIcon("img/elephant_blue.png");
		pieceIcons[10] = new ImageIcon("img/cat_blue.png");
		pieceIcons[11] = new ImageIcon("img/wolf_blue.png");
		pieceIcons[12] = new ImageIcon("img/leopard_blue.png");
		pieceIcons[13] = new ImageIcon("img/dog_blue.png");
		pieceIcons[14] = new ImageIcon("img/lion_blue.png");
		pieceIcons[15] = new ImageIcon("img/mouse_blue.png");

	}

	/**
	 * Wipes the board, then redraws everything according to their x,y positions.
	 */
	public void drawBoard(ArrayList<Piece> pieces, Tile[] tiles) {
		//wipe the board
		for (int e = 0; e < 7; e++) {
			for (int f = 0; f < 9; f++) {
				gameBoard[e][f].setIcon(null);
			}
		}

		//start with tiles
		for (int i = 0; i < tiles.length; i++) {
			gameBoard[7 - tiles[i].getY()][tiles[i].getX() - 1].setIcon(tileIcons[tiles[i].getIconIndex()]);
		}
		//piece rendering
		for (int j = 0; j < pieces.size(); j++) {
			gameBoard[7 - pieces.get(j).getY()][pieces.get(j).getX() - 1].setIcon(pieceIcons[pieces.get(j).getIconIndex()]);
		}
	}

	public JButton[][] getBoard() {
		return gameBoard;
	}

	public void addButtonListener(JButton b, ActionListener al) {
		b.addActionListener(al);
	}

	/**
	 * Sets the button color to green in a cross from an x,y point.
	 * Used to show valid movement positions.
	 * @param x the x of the point
	 * @param y the y of the point
	 */
	public void showValidDir(int x, int y) {
		if (y + 1 < 7)
			gameBoard[y+1][x].setBackground(Color.green);
		if (y - 1 >= 0)
			gameBoard[y-1][x].setBackground(Color.green);
		if (x + 1 < 9)
			gameBoard[y][x+1].setBackground(Color.green);
		if (x - 1 >= 0)
			gameBoard[y][x-1].setBackground(Color.green);
    }

	/**
	 * Resets the button colors to white in a cross from an x,y point.
	 * @param x the x of the point
	 * @param y the y of the point
	 */
	public void hideValidDir(int x, int y) {
		System.out.println("hidden " + y + ", " + x);
		if (y + 1 < 7)
			gameBoard[y+1][x].setBackground(Color.white);
		if (y - 1 >= 0)
			gameBoard[y-1][x].setBackground(Color.white);
		if (x + 1 < 9)
			gameBoard[y][x+1].setBackground(Color.white);
		if (x - 1 >= 0)
			gameBoard[y][x-1].setBackground(Color.white);
	}

	/**
	 * Sets the label to the color of the current player's turn
	 * @param t whose turn it is
	 */
	public void setPlayerTurninfo(int t)
	{
		if (t == 1)
			turn.setText("Red player's turn");
		if (t == 2)
			turn.setText("Blue player's turn");
	}

	/**
	 * Sets the label to the winner
	 * @param player text describing the player who wins
	 */
	public void setWinnerInfo(String player)
	{
		turn.setText(player + " wins!");
	}

	/**
	 * Enables all the buttons on the board.
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
	 * Disables all the buttons on the board.
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
