package maingame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;

public class tree extends GameObject{

	public tree(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		// TODO Auto-generated constructor stub
	}
	public void update() {
		x-=10;
		if(x < 0) {
			isAlive = false;
		}
	}
	public void draw(Graphics g) {
	//	g.setColor(Color.PINK);
		//g.fillRect(x, y, width, height);
		g.drawImage(GamePanel.treeImg, x, y, width, height, null);
	}
}
