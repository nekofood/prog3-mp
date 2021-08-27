/**
* Represents a Tiger or Lion.
*/
public class LionTigerPiece extends Piece {
  
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
  public boolean movePiece(char direction, Piece[] pieces, Tile[] terrain) {
    //all of this copy-pasted wholesale from the Piece superclass
    int checkX = 0;
    int checkY = 0;
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
            checkX = waterCheck(checkX, checkY, terrain);
          }
          if (checkY != 0) {
            checkY = waterCheck(checkX, checkY, terrain);
          }
        }

        if (terrain[i].getType().matches("Den") && this.getOwner() != terrain[i].getOwner()) {
          terrain[i].setType("DenCaptured");
        }

        if (terrain[i].getType().matches("Den") && terrain[i].getOwner() ==  this.getOwner()) {
        collision = true;
        }

      }
    }

    //iterate through entire piece array for piece collision checking
    for (int i = 0; i < pieces.length; i++) {
      if (pieces[i].getX() == (this.getX() + checkX) && pieces[i].getY() == (this.getY() + checkY)) {
        collision = true;
        collisionIndex = i;
      }
    }

    //capture checking
    if (collision && capturePiece(pieces[collisionIndex])) {
      this.x += checkX;
      this.y += checkY;
      pieces[collisionIndex].getCaptured();
      System.out.println("Captured an enemy " + pieces[collisionIndex].getType());
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
  public int waterCheck(int directionX, int directionY, Tile[] terrain) {
    //search for a water tile in the desired direction until no more water tile
    //while checking if there's a mouse along the way
    //(for the sake of my sanity, i won't do mouse check until MC02)
    int movementY = directionY;
    int movementX = directionX;

    boolean doneChecking = false;

    while (!doneChecking) {
      doneChecking = true;
      for (int i = 0; i < terrain.length; i++) {
        if (terrain[i].getType().equals("Water")) {
          //checking along the x-axis
          if (movementX != 0 && this.getX() + movementX == terrain[i].getX()) {
            movementX += directionX;
            doneChecking = false;
            break;
          }
          //checking along the y-axis
          if (movementY != 0 && this.getY() + movementY == terrain[i].getY()) {
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
