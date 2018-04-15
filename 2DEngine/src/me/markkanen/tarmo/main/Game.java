package me.markkanen.tarmo.main;

import me.markkanen.tarmo.gamestates.GameStateManager;
import me.markkanen.tarmo.input.KeyManager;
import me.markkanen.tarmo.input.MouseManager;

public class Game {
	
	private String title;
	private int width;
	private int height;
	private Display display;
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private GameStateManager gameStateManager;
	private Gameloop gameloop;
	
	public Game(String title, int width, int height, int tps, int rps) {
		this.title = title;
		this.width = width;
		this.height = height;
		display = new Display(title, width, height);
		keyManager = new KeyManager();
		display.getFrame().addKeyListener(keyManager);
		display.getCanvas().addKeyListener(keyManager);
		mouseManager = new MouseManager();
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		gameStateManager = new GameStateManager();
		gameloop = new Gameloop(this, tps, rps);
		gameloop.start();
	}
	
	public static void main(String[] args) {
		new Game("2DEngine", 1500, 1500 / 16 * 9, 60, 60);
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
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameStateManager getGameStateManager() {
		return gameStateManager;
	}
	
	public Gameloop getGameloop() {
		return gameloop;
	}
}