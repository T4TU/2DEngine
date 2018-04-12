package me.markkanen.tarmo.gamestates;

import java.util.ArrayList;
import java.util.List;

public class GameStateManager {
	
	private List<GameState> gameStates;
	private GameState activeGameState;
	
	public GameStateManager() {
		gameStates = new ArrayList<GameState>();
		activeGameState = null;
	}
	
	public List<GameState> getStates() {
		return gameStates;
	}
	
	public void addGameState(GameState gameState) {
		gameStates.add(gameState);
	}
	
	public void removeGameState(GameState gameState) {
		gameStates.remove(gameState);
	}
	
	public GameState getByName(String name) {
		for (GameState state : gameStates) {
			if (state.getName().equalsIgnoreCase(name)) {
				return state;
			}
		}
		return null;
	}
	
	public GameState getActiveState() {
		return activeGameState;
	}
	
	public void setActiveState(GameState active) {
		activeGameState = active;
	}
}