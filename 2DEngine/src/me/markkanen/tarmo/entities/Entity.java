package me.markkanen.tarmo.entities;

import java.awt.Graphics2D;

public abstract class Entity {
	
	protected float x;
	protected float y;
	
	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
}