package maingame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	public int speed;
	public int downSpeed = 15;
	public int direction = 0;
	public Player(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		speed = 10;
		
	}

	public void update() {
		super.update();
		collisionBox.setLocation(x, y);
		//System.out.println(isAlive);
	}

	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}

	public void manageDirection() {
		if(direction == 1) {
			moveLeft();
		}
		if(direction == 2) {
			moveRight();
		}
		if(direction == 3) {
			moveDown();
		}
		if(direction == 4) {
			moveUp();
		}
	if(x < width) {
		x = width;
		
	}
	if(x > 1350) {
		x = 1350;
	}
	if(y < 0) {
		y = 0;
	}
		if(y > 695) {
			y = 695;
		}

	
	}
	
	public void moveLeft() {
		
		x = x - speed;
	
	}
	public void moveRight() {
		
		x = x + speed;
	
	}
	public void moveUp() {
		
		y = y - speed;
	
	}
	public void moveDown() {
		
		y = y + downSpeed;
	}
}

