package me.markkanen.tarmo.components;

import java.awt.Graphics2D;

import me.markkanen.tarmo.gameobjects.GameObject;
import me.markkanen.tarmo.physics.Vector;

public class PhysicsComponent extends Component {
	
	private Vector velocity;
	private float mass;
	private float drag;
	private Vector gravity;
	private CollideableComponent collideableComponent;
	
	public PhysicsComponent(GameObject holder, float mass, float drag, Vector gravity) {
		super(holder);
		velocity = new Vector(0, 0);
		this.mass = mass;
		this.drag = drag;
		this.gravity = gravity;
		collideableComponent = null;
	}
	
	public PhysicsComponent(GameObject holder, float mass, float drag, Vector gravity, CollideableComponent collideableComponent) {
		super(holder);
		velocity = new Vector(0, 0);
		this.mass = mass;
		this.drag = drag;
		this.gravity = gravity;
		this.collideableComponent = collideableComponent;
	}
	
	@Override
	public void tick() {
		
		if (gravity != null) {
			addForce(Vector.multiply(gravity, mass));
		}
		
		if (velocity.getLength() < 0.01f) {
			velocity.multiply(0);
		}
		else {
			addForce(Vector.multiply(velocity, -Math.min(drag, 1)));
		}
		
		if (collideableComponent != null) {
			collideableComponent.calculateCollision(velocity);
		}
		else {
			holder.setX(holder.getX() + velocity.getX());
			holder.setY(holder.getY() + velocity.getY());
		}
	}
	
	@Override
	public void render(Graphics2D g) {
	}
	
	public Vector getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}
	
	public float getMass() {
		return mass;
	}
	
	public float getDrag() {
		return drag;
	}
	
	public boolean hasGravityEnabled() {
		return gravity != null;
	}
	
	public boolean hasCollisionEnabled() {
		return collideableComponent != null;
	}
	
	public void addForce(Vector force) {
		velocity.add(Vector.multiply(force, 1 / mass));
	}
}