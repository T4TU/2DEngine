package me.markkanen.tarmo.main;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

import me.markkanen.tarmo.gamestates.GameState;
import me.markkanen.tarmo.gamestates.TestState;
import me.markkanen.tarmo.images.ImageContainer;

public class Gameloop implements Runnable {
	
	private Thread thread;
	private BufferStrategy bs;
	
	public void run() {
		
		init();
		
		final int TICKS_PER_SECOND = 60;
		final double TIME_PER_TICK = 1000000000 / TICKS_PER_SECOND;
		double d = 0;
		long n;
		long l = System.nanoTime();
		
		while (true) {
			n = System.nanoTime();
			d += (n - l) / TIME_PER_TICK;
			l = n;
			
			if (d >= 1) {
				tick();
				render();
				d--;
			}
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	private void init() {
		ImageContainer.loadImages();
		TestState testState = new TestState("test_state");
		GameState.setActiveState(testState);
	}
	
	private void tick() {
		GameState.getActiveState().tick();
		Game.getGame().getKeyManager().clearPressed();
	}
	
	private void render() {
		
		bs = Game.getGame().getDisplay().getCanvas().getBufferStrategy();
		
		if (bs == null) {
			Game.getGame().getDisplay().getCanvas().createBufferStrategy(2);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHints(hints);
		
		g.clearRect(0, 0, Game.getGame().getWidth(), Game.getGame().getHeight());
		
		//
		
		GameState.getActiveState().render(g);
		
		//
		
		bs.show();
		g.dispose();
	}
	
	public Thread getThread() {
		return thread;
	}
}