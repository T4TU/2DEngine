package me.markkanen.tarmo.gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import me.markkanen.tarmo.components.MovableComponent;
import me.markkanen.tarmo.main.Game;
import me.markkanen.tarmo.misc.Vector;

public class TestObject extends GameObject {
	
	public TestObject(Game game, float x, float y) {
		super(game, x, y);
		MovableComponent component = new MovableComponent(this, 1f, 0.1f, true);
		addComponent(component);
	}
	
	@Override
	public void tick() {
		
		MovableComponent component = (MovableComponent) components.get(0);
		
		if (y > 500) {
			y = 500;
			component.getVelocity().setY(0);
		}
		
		if (game.getKeyManager().isPressed(KeyEvent.VK_D)) {
			component.addForce(new Vector(1, 0));
		}
		if (game.getKeyManager().isPressed(KeyEvent.VK_A)) {
			component.addForce(new Vector(-1, 0));
		}
		if (game.getKeyManager().wasPressed(KeyEvent.VK_SPACE) && y == 500) {
			component.addForce(new Vector(0, -40));
		}
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.fillRect((int) x, (int) y, 100, 100);
	}
}