import java.util.*;

/**
 * This class represents a Mouse piece. Mice can move onto and out of the river.
 */
public class MousePiece extends Piece {
/**
	 * This constructor creates a Mouse piece.
	 * @param x starting x-position
	 * @param y starting y-position
	 * @param owner player that owns this piece
	 * @param b the board this piece belongs in
     * @param ii the index of its icon in the piece/tile icon array
	 */
  MousePiece(int x, int y, int o, Board b, int ii) {
    super("Mouse", x, y, o, 1, b, ii);
  }

  /**
  * Moves the piece in one direction. Mice can move onto water.
  * @param  direction The desired direction to move in (N/S/E/W).
  * @return false if movement fails, true otherwise.
  */
  @Override
  public boolean movePiece(char direction) {
    int checkX = 0;
    int checkY = 0;

    ArrayList<Piece> pieces = this.getBoard().getPieces();
    Tile[] terrain = this.getBoard().getTerrain();

    switch (direction) {
      case 'N':
        checkY = 1;
        break;
      case 'S':
        checkY = -1;
        break;
      case 'E':
        checkX = 1;
        break;
      case 'W':
        checkX = -1;
        break;
      default:
        return false;
    }


    int collisionIndex = 0;
    boolean collision = false;


    //iterate through entire piece array for piece collision checking
    for (int i = 0; i < pieces.size(); i++) {
      if (pieces.get(i).getX() == (this.getX() + checkX) && pieces.get(i).getY() == (this.getY() + checkY)) {
        collision = true;
        collisionIndex = i;
      }
    }

    //terrain collision checking
    //mouse can move onto water
    for (int i = 0; i < terrain.length; i++) {
      if (terrain[i].getX() == (this.getX() + checkX) && terrain[i].getY() == (this.getY() + checkY)) {

        if (terrain[i].getType().matches("Den") && terrain[i].getOwner() == this.getOwner()) {
          return false;
        }

      }
    }

    //capture checking
    if (collision && capturePiece(pieces.get(collisionIndex))) {
      this.x += checkX;
      this.y += checkY;
      System.out.println("Captured an enemy " + pieces.get(collisionIndex).getType());
      pieces.get(collisionIndex).getCaptured();
      return true;
    }

    if (collision) {
      return false;
    }

   //check if movement is inbounds after water check
    if (this.getX() + checkX == 0 || this.getX() + checkX == 10 || this.getY() + checkY == 0 || this.getY() + checkY == 8) {
      return false;
    }

    //make the move if the desired space is clear of any pieces
    this.x += checkX;
    this.y += checkY;

    return true;
  }

 /**
  * Checks if this piece can capture the piece it is moving onto. Mice can capture elephants, but cannot capture pieces on land while in the river (and vice versa).
  * @param target the piece to compare ranks against
  * @return true if capturing fails, false otherwise.
  */
  public boolean capturePiece(Piece target) {
    if (target.getOwner() == this.getOwner())
      return false;
    //prevent capturing land -> water
    if (target.getTileUnder() != null && target.getTileUnder().getType().equals("Water") && this.getTileUnder() == null)
    	return false;
    //prevent capturing water -> land
    if (target.getTileUnder() != null && this.getTileUnder().getType().equals("Water"))
		return false;
    if (target.getTileUnder() != null && target.getTileUnder().getType().equals("Trap") && target.getTileUnder().getOwner() == this.getOwner())
    	return true;
    if (target.getType().equals("Elephant"))
		return true;
    return this.rank >= target.getRank();
  }

}
