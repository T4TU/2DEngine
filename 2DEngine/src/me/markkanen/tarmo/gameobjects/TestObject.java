package me.markkanen.tarmo.gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import me.markkanen.tarmo.main.Game;

public class TestObject extends GameObject {
	
	public TestObject(Game game, float x, float y, float z) {
		super(game, x, y, z);
	}
	
	@Override
	public void tick() {
	}
	
	@Override
	public void render(Graphics2D g) {
		if (game.getMouseManager().isLeftDown()) {
			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.ORANGE);
		}
		g.fillRect((int) x, (int) y, 100, 100);
	}
}