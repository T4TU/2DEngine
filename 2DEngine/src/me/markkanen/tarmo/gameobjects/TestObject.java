package me.markkanen.tarmo.gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;

import com.sun.glass.events.KeyEvent;

import me.markkanen.tarmo.main.Game;

public class TestObject extends GameObject {
	
	public TestObject(Game game, float x, float y) {
		super(game, x, y);
	}
	
	@Override
	public void tick() { }
	
	@Override
	public void render(Graphics2D g) {
		if (game.getKeyManager().isPressed(KeyEvent.VK_SPACE)) {
			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.ORANGE);
		}
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
	}
}