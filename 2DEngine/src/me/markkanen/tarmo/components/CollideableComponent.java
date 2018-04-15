package me.markkanen.tarmo.components;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import me.markkanen.tarmo.gameobjects.GameObject;
import me.markkanen.tarmo.physics.CollisionBox;
import me.markkanen.tarmo.physics.Vector;

public class CollideableComponent extends Component {
	
	private CollisionBox collisionBox;

	public CollideableComponent(GameObject holder, CollisionBox collisionBox) {
		super(holder);
		this.collisionBox = collisionBox;
	}
	
	@Override
	public void tick() {
	}
	
	@Override
	public void render(Graphics2D g) {
	}
	
	public CollisionBox getCollisionBox() {
		return collisionBox;
	}
	
	public void calculateCollision(Vector velocity) {
		
		List<CollideableComponent> collideableComponents = getCollideableComponents();
		
		for (CollideableComponent collideableComponent : collideableComponents) {
			
			CollisionBox collisionBox = collideableComponent.getCollisionBox();
			
			float x1 = holder.getX() + this.collisionBox.getX();
			float y1 = holder.getY() + this.collisionBox.getY();
			float x2 = x1 + this.collisionBox.getWidth();
			float y2 = y1 + this.collisionBox.getHeight();
			float x3 = collideableComponent.getHolder().getX() + collisionBox.getX();
			float y3 = collideableComponent.getHolder().getY() + collisionBox.getY();
			float x4 = x3 + collisionBox.getWidth();
			float y4 = y3 + collisionBox.getHeight();
			
			if (velocity.getX() > 0 && x2 <= x3 && x2 + velocity.getX() > x3 && y1 < y4 && y2 > y3) {
				holder.setX(holder.getX() + velocity.getX() - 2 * (x2 + velocity.getX() - x3));
				velocity.setX(-velocity.getX());
				return;
			}
			else if (velocity.getX() < 0 && x1 >= x4 && x1 + velocity.getX() < x4 && y1 < y4 && y2 > y3) {
				holder.setX(holder.getX() + velocity.getX() - 2 * (x1 + velocity.getX() - x4));
				velocity.setX(-velocity.getX());
				return;
			}
			
			if (velocity.getY() > 0 && y2 <= y3 && y2 + velocity.getY() > y3 && x1 < x4 && x2 > x3) {
				holder.setY(holder.getY() + velocity.getY() - 2 * (y2 + velocity.getY() - y3));
				velocity.setY(-velocity.getY());
				return;
			}
			else if (velocity.getY() < 0 && y1 >= y4 && y1 + velocity.getY() < y4 && x1 < x4 && x2 > x3) {
				holder.setY(holder.getY() + velocity.getY() - 2 * (y1 + velocity.getY() - y4));
				velocity.setY(-velocity.getY());
				return;
			}
		}
		
		holder.setX(holder.getX() + velocity.getX());
		holder.setY(holder.getY() + velocity.getY());
	}
	
	private List<CollideableComponent> getCollideableComponents() {
		List<CollideableComponent> collideableComponents = new ArrayList<CollideableComponent>();
		List<GameObject> gameObjects = holder.getWorld().getGameObjects();
		for (GameObject gameObject : gameObjects) {
			if (gameObject != holder) {
				List<Component> components = gameObject.getComponents();
				for (Component component : components) {
					if (component instanceof CollideableComponent) {
						collideableComponents.add((CollideableComponent) component);
					}
				}
			}
		}
		return collideableComponents;
	}
}