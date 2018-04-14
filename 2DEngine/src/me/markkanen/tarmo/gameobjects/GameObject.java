package me.markkanen.tarmo.gameobjects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import me.markkanen.tarmo.components.Component;
import me.markkanen.tarmo.main.Game;

public abstract class GameObject {
	
	protected Game game;
	protected String id;
	protected float x, y, z;
	protected List<Component> components;
	
	public GameObject(Game game, float x, float y) {
		this.game = game;
		id = null;
		this.x = x;
		this.y = y;
		z = 0;
		components = new ArrayList<Component>();
	}
	
	public GameObject(Game game, float x, float y, float z) {
		this.game = game;
		id = null;
		this.x = x;
		this.y = y;
		this.z = z;
		components = new ArrayList<Component>();
	}
	
	public GameObject(Game game, String id, float x, float y) {
		this.game = game;
		this.id = id;
		this.x = x;
		this.y = y;
		z = 0;
		components = new ArrayList<Component>();
	}
	
	public GameObject(Game game, String id, float x, float y, float z) {
		this.game = game;
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
		components = new ArrayList<Component>();
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public void tickComponents() {
		for (Component component : components) {
			component.tick();
		}
	}
	
	public void renderComponents(Graphics2D g) {
		for (Component component : components) {
			component.render(g);
		}
	}
	
	public String getId() {
		return id;
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getZ() {
		return z;
	}
	
	public void setZ(float z) {
		this.z = z;
	}
	
	public List<Component> getComponents() {
		return components;
	}
	
	public void addComponent(Component component) {
		components.add(component);
	}
	
	public void removeComponent(Component component) {
		components.remove(component);
	}
}