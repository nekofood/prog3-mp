public class ElephantPiece extends Piece {
	/**
	 * This constructor creates an Elephant piece.
	 * @param x starting x-position
	 * @param y starting y-position
	 * @param owner player that owns this piece
	 */
	ElephantPiece(int x, int y, int owner, Board b) {
		super("Elephant", x, y, owner, 8, b);
	}


	/**
	 * Checks if the targeted piece can be captured. 
	 * Elephants cannot capture mice.
	 * @param target the target piece
	 * @return true if the piece is capturable, false otherwise
	 */
	@Override
	public boolean capturePiece(Piece target) {
    	//TODO: traps
    		if (target.getOwner() == this.getOwner())
      			return false;
		if (target.getType() == "Mouse")
			return false;
    		if (target.getTileUnder().getType().equals("Trap") && target.getTileUnder().getOwner() == this.getOwner());
    			return true;
    		return this.rank >= target.rank;
  	}
	
}
