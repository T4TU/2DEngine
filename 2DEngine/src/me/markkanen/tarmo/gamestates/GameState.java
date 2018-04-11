package me.markkanen.tarmo.gamestates;

import java.awt.Graphics2D;
import java.util.List;

public abstract class GameState {
	
	private static List<GameState> gameStates;
	private static GameState activeGameState;
	
	protected String name;
	
	public GameState(String name) {
		this.name = name;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public String getName() {
		return name;
	}
	
	public static List<GameState> getStates() {
		return gameStates;
	}
	
	public static GameState getByName(String name) {
		for (GameState state : gameStates) {
			if (state.getName().equalsIgnoreCase(name)) {
				return state;
			}
		}
		return null;
	}
	
	public static GameState getActiveState() {
		return activeGameState;
	}
	
	public static void setActiveState(GameState active) {
		activeGameState = active;
	}
}