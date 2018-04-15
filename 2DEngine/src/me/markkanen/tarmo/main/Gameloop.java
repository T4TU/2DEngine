package me.markkanen.tarmo.main;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

import me.markkanen.tarmo.gamestates.TestState;
import me.markkanen.tarmo.images.ImageContainer;

public class Gameloop implements Runnable {
	
	private Game game;
	private int tps, rps;
	private Thread thread;
	private BufferStrategy bs;
	
	public Gameloop(Game game, int tps, int rps) {
		this.game = game;
		this.tps = tps;
		this.rps = rps;
	}
	
	public void run() {
		
		init();
		
		final int TICKS_PER_SECOND = tps;
		final int TICKS_PER_RENDER = rps;
		final double TIME_PER_TICK = 1000000000 / TICKS_PER_SECOND;
		final double TIME_PER_RENDER = 1000000000 / TICKS_PER_RENDER;
		double dt = 0;
		double dr = 0;
		long n;
		long l = System.nanoTime();
		
		while (true) {
			n = System.nanoTime();
			dt += (n - l) / TIME_PER_TICK;
			dr += (n - l) / TIME_PER_RENDER;
			l = n;
			
			if (dt >= 1) {
				tick();
				dt--;
			}
			
			if (dr >= 1) {
				render();
				dr--;
			}
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	private void init() {
		ImageContainer.loadImages();
		TestState testState = new TestState(game, "test_state");
		game.getGameStateManager().addGameState(testState);
		game.getGameStateManager().setActiveState(testState);
	}
	
	private void tick() {
		game.getGameStateManager().getActiveState().tick();
		game.getKeyManager().clearPressed();
		game.getMouseManager().clearClicked();
	}
	
	private void render() {
		
		bs = game.getDisplay().getCanvas().getBufferStrategy();
		
		if (bs == null) {
			game.getDisplay().getCanvas().createBufferStrategy(2);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHints(hints);
		
		g.clearRect(0, 0, game.getWidth(), game.getHeight());
		
		//
		
		game.getGameStateManager().getActiveState().render(g);
		
		//
		
		bs.show();
		g.dispose();
	}
	
	public Thread getThread() {
		return thread;
	}
}