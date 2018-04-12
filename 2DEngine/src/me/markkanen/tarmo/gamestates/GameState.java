package me.markkanen.tarmo.gamestates;

import java.awt.Graphics2D;

import me.markkanen.tarmo.main.Game;

public abstract class GameState {
	
	protected Game game;
	protected String name;
	
	public GameState(Game game, String name) {
		this.game = game;
		this.name = name;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public String getName() {
		return name;
	}
}