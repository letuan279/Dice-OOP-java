package app;

import game.Game;

public class App {
	private Game game;
	
	public App(Game game) {
		this.game = game;
	}
	
	public static void main(String[] args) {
		Game game = new Game(4, 4);
		App app = new App(game);
		app.game.run();
	}
}
