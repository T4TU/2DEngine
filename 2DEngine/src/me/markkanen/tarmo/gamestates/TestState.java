package me.markkanen.tarmo.gamestates;

import java.awt.Graphics2D;

import me.markkanen.tarmo.environment.World;
import me.markkanen.tarmo.gameobjects.Obstacle;
import me.markkanen.tarmo.gameobjects.TestObject;
import me.markkanen.tarmo.main.Game;

public class TestState extends GameState {
	
	private World world;
	
	public TestState(Game game, String name) {
		super(game, name);
		world = new World(this, false);
		TestObject testObject = new TestObject(world, 200, 10);
		world.addGameObject(testObject);
		Obstacle obstacle1 = new Obstacle(world, 0, 0, 1500, 0);
		world.addGameObject(obstacle1);
		Obstacle obstacle2 = new Obstacle(world, 1500, 0, 0, 1500 / 16 * 9);
		world.addGameObject(obstacle2);
		Obstacle obstacle3 = new Obstacle(world, 0, 1500 / 16 * 9, 1500, 0);
		world.addGameObject(obstacle3);
		Obstacle obstacle4 = new Obstacle(world, 0, 0, 0, 1500 / 16 * 9);
		world.addGameObject(obstacle4);
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