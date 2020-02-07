package maingame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends GameObject{
	public int speed;
	public Bullet(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		// TODO Auto-generated constructor stub
		speed = 20;
	}
	public void update() {
		super.update();
		y-=speed;
		if(y < -10) {
			isAlive = false;
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 5, 10);
	}
}
