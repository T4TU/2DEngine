package me.markkanen.tarmo.main;

import me.markkanen.tarmo.input.KeyManager;

public class Game {
	
	private static Game game;
	
	private String title;
	private int width;
	private int height;
	private Display display;
	private KeyManager keyManager;
	private Gameloop gameloop;
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		display = new Display(title, width, height);
		keyManager = new KeyManager();
		display.getFrame().addKeyListener(keyManager);
		gameloop = new Gameloop();
		gameloop.start();
	}
	
	public static void main(String[] args) {
		Game newGame = new Game("2DEngine", 1500, 1500 / 16 * 9);
		game = newGame;
	}
	
	public static Game getGame() {
		return game;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public Gameloop getGameloop() {
		return gameloop;
	}
}