package me.markkanen.tarmo.misc;

public class Vector {
	
	private float x, y;
	
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void multiply(float factor) {
		x *= factor;
		y *= factor;
	}
	
	public void add(Vector vector) {
		x += vector.getX();
		y += vector.getY();
	}
	
	public float getLength() {
		return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public static Vector multiply(Vector vector1, float factor) {
		Vector vector = new Vector(vector1.getX(), vector1.getY());
		vector.multiply(factor);
		return vector;
	}
	
	public static Vector add(Vector vector1, Vector vector2) {
		return new Vector(vector1.getX() + vector2.getX(), vector1.getY() + vector2.getY());
	}
}