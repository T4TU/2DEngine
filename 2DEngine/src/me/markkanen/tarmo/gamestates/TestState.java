package me.markkanen.tarmo.gamestates;

import java.awt.Graphics2D;

import me.markkanen.tarmo.environment.World;

public class TestState extends GameState {
	
	private World world;
	
	public TestState(String name) {
		super(name);
		world = new World();
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