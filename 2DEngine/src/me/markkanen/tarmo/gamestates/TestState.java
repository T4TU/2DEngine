package me.markkanen.tarmo.gamestates;

import java.awt.Graphics2D;

import me.markkanen.tarmo.environment.World;
import me.markkanen.tarmo.gameobjects.TestObject;
import me.markkanen.tarmo.main.Game;

public class TestState extends GameState {
	
	private World world;
	
	public TestState(Game game, String name) {
		super(game, name);
		world = new World(false);
		TestObject testObject = new TestObject(game, 200, 300);
		world.addGameObject(testObject);
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics2D g) {
		world.render(g);
	}
	
	public World getWorld() {
		return world;
	}
}