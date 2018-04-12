package me.markkanen.tarmo.main;

import me.markkanen.tarmo.gamestates.GameStateManager;
import me.markkanen.tarmo.input.KeyManager;

public class Game {
	
	private String title;
	private int width;
	private int height;
	private Display display;
	private KeyManager keyManager;
	private GameStateManager gameStateManager;
	private Gameloop gameloop;
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		display = new Display(title, width, height);
		keyManager = new KeyManager();
		display.getFrame().addKeyListener(keyManager);
		gameStateManager = new GameStateManager();
		gameloop = new Gameloop(this);
		gameloop.start();
	}
	
	public static void main(String[] args) {
		new Game("2DEngine", 1500, 1500 / 16 * 9);
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
	
	public GameStateManager getGameStateManager() {
		return gameStateManager;
	}
	
	public Gameloop getGameloop() {
		return gameloop;
	}
}