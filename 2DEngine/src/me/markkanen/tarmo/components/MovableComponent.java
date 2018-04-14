package me.markkanen.tarmo.components;

import java.awt.Graphics2D;

import me.markkanen.tarmo.gameobjects.GameObject;
import me.markkanen.tarmo.misc.Vector;

public class MovableComponent extends Component {
	
	public static final Vector GRAVITY = new Vector(0, 2);
	
	private Vector velocity;
	private float mass;
	private float drag;
	private boolean gravity;
	
	public MovableComponent(GameObject holder, float mass, float drag, boolean gravity) {
		super(holder);
		velocity = new Vector(0, 0);
		this.mass = mass;
		this.drag = drag;
		this.gravity = gravity;
	}
	
	@Override
	public void tick() {
		if (gravity) {
			addForce(Vector.multiply(GRAVITY, mass));
		}
		if (velocity.getLength() < 0.01f) {
			velocity.multiply(0);
		}
		else {
			addForce(Vector.multiply(velocity, -Math.min(drag, 1)));
		}
		holder.setX(holder.getX() + velocity.getX());
		holder.setY(holder.getY() + velocity.getY());
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
	
	public void addForce(Vector force) {
		velocity.add(Vector.multiply(force, 1 / mass));
	}
}