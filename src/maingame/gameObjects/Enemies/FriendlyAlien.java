package maingame.gameObjects.Enemies;

import java.awt.Color;
import java.awt.Graphics;

import maingame.gameObjects.GameObject;

public class FriendlyAlien extends GameObject{
public FriendlyAlien(int X, int Y, int Width, int Height) {
	super(X, Y, Width, Height);
}
	public void draw(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(x, y, width, height);
}
	public void update() {
		super.update();
		collisionBox.setLocation(x,y);
		x -= 10;
		if(x <= 0 ) {
			isAlive = false;
		}
	}
}
