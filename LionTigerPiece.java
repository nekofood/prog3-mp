import java.util.*;
/**
* Represents a Tiger or Lion.
*/
class LionTigerPiece extends Piece {

  /**
  * This constructor creates a Lion/Tiger Piece object with a type, owner, and position.
  * @param t Tile type
  * @param x x-position
  * @param y y-position
  * @param owner Piece owner (0 = none, 1 = player 1, 2 = player 2)
  * @param b Board
  */
  LionTigerPiece(String t, int x, int y, int o, int r, Board b) {
    super(t, x, y, o, r, b);
  }

  /**
  * Moves the piece in one direction.
  * <p>
  * Tigers and Lions can jump across rivers, given that there is no mouse along the way.
  * @param  direction The desired direction to move in (N/S/E/W).
  * @return false if movement fails, true otherwise.
  */
  public boolean movePiece(char direction) {
    //all of this copy-pasted wholesale from the Piece superclass
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
      default: return false;
    }

    if (this.getX() + checkX == 0 || this.getX() + checkX == 10 || this.getY() + checkY == 0 || this.getY() + checkY == 8) {
      return false;
    }

    int collisionIndex = 0;
    boolean collision = false;
    //collision boolean only for piece-to-piece collision

    //terrain collision checking
    //tigers can jump over water
    for (int i = 0; i < terrain.length; i++) {
      if (terrain[i].getX() == (this.getX() + checkX) && terrain[i].getY() == (this.getY() + checkY)) {
        if (terrain[i].getType().matches("Water")) {
          if (checkX != 0) {
            checkX = waterCheck(checkX, checkY);
          }
          if (checkY != 0) {
            checkY = waterCheck(checkX, checkY);
          }
        }


        if (terrain[i].getType().matches("Den") && terrain[i].getOwner() ==  this.getOwner()) {
        	return false;
	}

      }
    }

    //iterate through entire piece array for piece collision checking
    for (int i = 0; i < pieces.size(); i++) {
      if (pieces.get(i).getX() == (this.getX() + checkX) && pieces.get(i).getY() == (this.getY() + checkY)) {
        collision = true;
        collisionIndex = i;
      }
    }

    //capture checking
    if (collision && capturePiece(pieces.get(collisionIndex))) {
      this.x += checkX;
      this.y += checkY;
      pieces.get(collisionIndex).getCaptured();
      System.out.println("Captured an enemy " + pieces.get(collisionIndex).getType());
      return true;
    } else {
      return false;
    }


    //make the move if the desired space is clear of any pieces
    this.x += checkX;
    this.y += checkY;

    return true;
  }

  /**
  * Checks if the piece has a clear path to jump across the water.
  * <p> This function assumes that the tile being moved into is already a water tile.
  * @param directionX whether the piece is moving east (1) or west (-1)
  * @param directionY whether the piece is moving north (1) or south (-1)
  * @param terrain the array of terrain tiles
  * @return the amount of water tiles to jump, 0 if the movement is invalid.
  */
  public int waterCheck(int directionX, int directionY) {
    //search for a water tile in the desired direction until no more water tile
    //while checking if there's a mouse along the way
    int movementY = directionY;
    int movementX = directionX;
    Tile[] terrain = this.getBoard().getTerrain();
    ArrayList<Piece> pieces = this.getBoard().getPieces();
    MousePiece mouse1;
    MousePiece mouse2;
    //int[][] mousePositions = new int[2][2];

    //weirdchamp mouse check method: get the mice from Board
    for (int j = 0; j < pieces.size(); j++) {
        if (pieces.get(j).getType().equals("Mouse") && pieces.get(j) instanceof MousePiece && mouse1 == null)
		mouse1 = (MousePiece) pieces.get(j);
	else if (pieces.get(j).getType().equals("Mouse") && pieces.get(j) instanceof MousePiece)
		mouse2 = (MousePiece) pieces.get(j);
    }

    int[][] mousePositions = {
	    {mouse1.getX(), mouse1.getY()},
	    {mouse2.getX(), mouse2.getY()}
    };

    boolean doneChecking = false;

    while (!doneChecking) {
      doneChecking = true;
      for (int i = 0; i < terrain.length; i++) {
        if (terrain[i].getType().equals("Water")) {
          //checking along the x-axis
          if (movementX != 0 && this.getX() + movementX == terrain[i].getX()) {
	    //if there is a maus along the way then return 0
	    if (this.getX() + movementX == mousePositions[0][0] || this.getX() + movementX == mousePositions[1][0])
		    return 0;
            movementX += directionX;
            doneChecking = false;
            break;
          }
          //checking along the y-axis
          if (movementY != 0 && this.getY() + movementY == terrain[i].getY()) {
	    //if theres mouse return 0
	    if (this.getY() + movementY == mousePositions[0][1] || this.getY() + movementY == mousePositions[1][1])
		    return 0;
            movementY += directionY;
            doneChecking = false;
            break;
          }
        }
      }
    }


  return movementX + movementY;
  }
}
