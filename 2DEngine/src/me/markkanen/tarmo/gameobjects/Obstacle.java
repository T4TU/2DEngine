package me.markkanen.tarmo.gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;

import me.markkanen.tarmo.components.CollideableComponent;
import me.markkanen.tarmo.environment.World;
import me.markkanen.tarmo.physics.CollisionBox;

public class Obstacle extends GameObject {
	
	private float width, height;
	
	public Obstacle(World world, float x, float y, float width, float height) {
		super(world, x, y);
		this.width = width;
		this.height = height;
		CollideableComponent collideableComponent = new CollideableComponent(this, new CollisionBox(0, 0, width, height));
		addComponent(collideableComponent);
	}
	
	@Override
	public void tick() {
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, (int) width, (int) height);
	}
}