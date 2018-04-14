package me.markkanen.tarmo.components;

import java.awt.Graphics2D;

import me.markkanen.tarmo.gameobjects.GameObject;

public abstract class Component {
	
	protected GameObject holder;
	
	public Component(GameObject holder) {
		this.holder = holder;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public GameObject getHolder() {
		return holder;
	}
}