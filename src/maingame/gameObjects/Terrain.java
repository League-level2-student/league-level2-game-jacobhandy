package maingame.gameObjects;
import java.awt.Color;
import java.awt.Graphics;

public class Terrain{
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
		g.drawImage(GamePanel.terrainImg, baseX, baseY, 2000, 200, null);
		// hills 
		//g.drawImage(GamePanel.hillImg, hillX, hillY, 300, 150, null);
	}
	public void update() {
		
		//hillX -= speed;
		
		
		
	}
}
