package me.markkanen.tarmo.gameobjects;

import java.awt.Graphics2D;

import me.markkanen.tarmo.main.Game;

public abstract class GameObject {
	
	protected Game game;
	protected String id;
	protected float x;
	protected float y;
	
	public GameObject(Game game, float x, float y) {
		this.game = game;
		this.x = x;
		this.y = y;
		id = null;
	}
	
	public GameObject(Game game, String id, float x, float y) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public String getId() {
		return id;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
}