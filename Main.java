
class Main {
	public static void main(String[] args) {
			Game m = new Game();
			GameView v = new GameView();
			GameController g = new GameController(v, m);

			g.newGame();
	}
}
