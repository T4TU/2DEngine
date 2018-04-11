package me.markkanen.tarmo.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] isPressed;
	private boolean[] wasPressed;
	
	public KeyManager() {
		isPressed = new boolean[256];
		wasPressed = new boolean[256];
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() >= 256)
			return;
		isPressed[e.getKeyCode()] = true;
		wasPressed[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() >= 256)
			return;
		isPressed[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e) {
	}
	
	public boolean isPressed(int keyCode) {
		return isPressed[keyCode];
	}
	
	public boolean wasPressed(int keyCode) {
		return wasPressed[keyCode];
	}
	
	public void clearPressed() {
		for (int i = 0; i < wasPressed.length; i++) {
			wasPressed[i] = false;
		}
	}
}