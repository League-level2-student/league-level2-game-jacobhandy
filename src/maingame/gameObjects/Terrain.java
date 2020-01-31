package maingame.gameObjects;
import java.awt.Color;
import java.awt.Graphics;

public class Terrain {
	int speed;
	int baseX;
	int baseY;
	int hillX;
	int hillY;
	public Terrain() {
	speed = 10;
	baseX = 0;
	baseY = 800;
	hillX = 2200;
	hillY = 750;
	
	}
	public void draw (Graphics g) {
		g.setColor(Color.GREEN);
		//g.fillOval(x, y, width, height);
		//draw primary ground
		g.fillRect(baseX, baseY, 2000, 200);
		// hills 
		g.fillOval(hillX, 750, 300, 150);
	}
	public void update() {
		hillX -= speed;
		
		
		
	}
}
