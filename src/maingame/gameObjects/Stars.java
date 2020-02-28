package maingame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;

public class Stars extends GameObject{
	public int speed;
	public Stars(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		// TODO Auto-generated constructor stub
		speed = 10;
	}
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, width, height);
	}
	public void update() {
		x--;
		if(x < 0) {
			isAlive = false;
		}
	}
}
