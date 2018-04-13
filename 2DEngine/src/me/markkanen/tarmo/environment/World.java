package me.markkanen.tarmo.environment;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import me.markkanen.tarmo.gameobjects.GameObject;

public class World {
	
	private List<GameObject> gameObjects;
	private Comparator<GameObject> sorter;
	
	public World(boolean mimic3dRenderOrder) {
		gameObjects = new ArrayList<GameObject>();
		sorter = new Comparator<GameObject>() {
			@Override
			public int compare(GameObject object1, GameObject object2) {
				if (mimic3dRenderOrder) {
					if (object1.getY() + object1.getZ() < object2.getY() + object2.getZ()) {
						return -1;
					}
					return 1;
				}
				else {
					if (object1.getZ() < object2.getZ()) {
						return -1;
					}
					return 1;
				}
			}
		};
	}
	
	public void tick() {
		for (GameObject gameObject : gameObjects) {
			gameObject.tick();
		}
	}
	
	public void render(Graphics2D g) {
		gameObjects.sort(sorter);
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