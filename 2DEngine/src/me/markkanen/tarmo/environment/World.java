package me.markkanen.tarmo.environment;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import me.markkanen.tarmo.gameobjects.GameObject;

public class World {
	
	private List<GameObject> gameObjects;
	
	public World() {
		gameObjects = new ArrayList<GameObject>();
	}
	
	public void tick() {
		for (GameObject gameObject : gameObjects) {
			gameObject.tick();
		}
	}
	
	public void render(Graphics2D g) {
		for (GameObject gameObject : gameObjects) {
			gameObject.render(g);
		}
	}
	
	public List<GameObject> getGameObjects() {
		return gameObjects;
	}
	
	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void removeGameObject(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}
	
	public GameObject findGameObject(String id) {
		for (GameObject gameObject : gameObjects) {
			if (gameObject.getId().equals(id)) {
				return gameObject;
			}
		}
		return null;
	}
}