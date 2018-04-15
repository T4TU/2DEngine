package me.markkanen.tarmo.gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import me.markkanen.tarmo.components.CollideableComponent;
import me.markkanen.tarmo.components.PhysicsComponent;
import me.markkanen.tarmo.environment.World;
import me.markkanen.tarmo.physics.CollisionBox;
import me.markkanen.tarmo.physics.Vector;

public class TestObject extends GameObject {
	
	public TestObject(World world, float x, float y) {
		super(world, x, y);
		CollideableComponent collideableComponent = new CollideableComponent(this, new CollisionBox(0, 0, 100, 100));
		PhysicsComponent physicsComponent = new PhysicsComponent(this, 1, 0, new Vector(0, 2), collideableComponent);
		addComponent(collideableComponent);
		addComponent(physicsComponent);
		physicsComponent.addForce(new Vector(8, 8));
	}
	
	@Override
	public void tick() {
		
		PhysicsComponent component = (PhysicsComponent) components.get(1);
		
		if (world.getGameState().getGame().getKeyManager().isPressed(KeyEvent.VK_D)) {
			component.addForce(new Vector(2f, 0));
		}
		if (world.getGameState().getGame().getKeyManager().isPressed(KeyEvent.VK_A)) {
			component.addForce(new Vector(-2f, 0));
		}
		if (world.getGameState().getGame().getKeyManager().wasPressed(KeyEvent.VK_SPACE)) {
			component.addForce(new Vector(0, -50f));
		}
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.fillRect((int) x, (int) y, 100, 100);
	}
}