/**
* Represents anything on the board that is not a blank tile.
*/
public class Tile {

  /**
  * This constructor creates a Tile object with a type, owner, and position.
  * @param t Tile type
  * @param x x-position
  * @param y y-position
  * @param owner Piece owner (0 = none, 1 = player 1, 2 = player 2)
  * @param board The board this piece belongs to
  * @param ii the index of its icon in the piece/tile icon array
  */
  Tile (String t, int x, int y, int owner, Board board, int ii) {
    type = t;
    this.x = x;
    this.y = y;
    ownedBy = owner;
    this.board = board;
	iconIndex = ii;
  }

  /**
  * Returns the X-position of this tile.
  */
  public int getX() {
    return x;
  }
  /**
  * Returns the Y-position of this tile.
  */
  public int getY() {
    return y;
  }

  /**
  * Returns the type of this tile.
  */
  public String getType() {
    return type;
  }

  /**
  * Modifies the type of this tile.
  */
  public void setType(String t) {
    this.type = t;
  }

  /**
  * Returns the owner of this tile.
  * @return 0 if the tile is unowned, or 1 or 2 if the tile is owned by player 1 or 2, respectively.
  */
  public int getOwner() {
    return ownedBy;
  }

  public Board getBoard() {
    return board;
  }

  public int getIconIndex() {
	  return iconIndex;
  }


  protected String type;
  protected int x;
  protected int y;
  protected int iconIndex; //index of icon in the pieces/icons array
  private int ownedBy; //0 = none, 1 = player 1, 2 = player 2
                       //might be useful for GUI phase
		       //
  protected Board board;
}
