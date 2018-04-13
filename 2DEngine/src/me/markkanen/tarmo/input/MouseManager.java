package me.markkanen.tarmo.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
	
	private int mouseX, mouseY;
	private boolean leftDown, middleDown, rightDown, leftClicked, middleClicked, rightClicked;
	
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftDown = true;
			leftClicked = true;
		}
		else if (e.getButton() == MouseEvent.BUTTON2) {
			middleDown = true;
			middleClicked = true;
		}
		else if (e.getButton() == MouseEvent.BUTTON3) {
			rightDown = true;
			rightClicked = true;
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftDown = false;
			leftClicked = false;
		}
		else if (e.getButton() == MouseEvent.BUTTON2) {
			middleDown = false;
			middleClicked = false;
		}
		else if (e.getButton() == MouseEvent.BUTTON3) {
			rightDown = false;
			rightClicked = false;
		}
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	public boolean isLeftDown() {
		return leftDown;
	}
	
	public boolean isMiddleDown() {
		return middleDown;
	}
	
	public boolean isRightDown() {
		return rightDown;
	}
	
	public boolean wasLeftClicked() {
		return leftClicked;
	}
	
	public boolean wasMiddleClicked() {
		return middleClicked;
	}
	
	public boolean wasRightClicked() {
		return rightClicked;
	}
	
	public void clearClicked() {
		leftClicked = false;
		middleClicked = false;
		rightClicked = false;
	}
}