public class MousePiece extends Piece {

  MousePiece(int x, int y, int o, Board b) {
    super("Mouse", x, y, o, 1, b);
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
    for (int i = 0; i < pieces.length; i++) {
      if (pieces.get(i).getX() == (this.getX() + checkX) && pieces.get(i).getY() == (this.getY() + checkY)) {
        collision = true;
        collisionIndex = i;
      }
    }

    //terrain collision checking
    //mouse can move onto water
    for (int i = 0; i < terrain.length; i++) {
      if (terrain[i].getX() == (this.getX() + checkX) && terrain[i].getY() == (this.getY() + checkY)) {
        if (terrain[i].getType().matches("Den") && this.getOwner() != terrain[i].getOwner()) {
          terrain[i].setType("DenCaptured");
        }

        if (terrain[i].getType().matches("Den") && terrain[i].getOwner() == this.getOwner()) {
          return false;
        }

      }
    }

    //capture checking
    if (collision && capturePiece(pieces[collisionIndex])) {
      this.x += checkX;
      this.y += checkY;
      pieces[collisionIndex].getCaptured();
      System.out.println("Captured an enemy " + pieces[collisionIndex].getType());
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

}
