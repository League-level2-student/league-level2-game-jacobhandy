import java.awt.Color;
import java.awt.Graphics;

public class Terrain {
	int speed;
	int baseX;
	int baseY;
	int hillX;
	int hillY;
	public Terrain() {
	speed = 5;
	baseX = 0;
	baseY = 800;
	hillX = 1200;
	hillY = 750;
	
	}
	public void draw (Graphics g) {
		g.setColor(Color.GREEN);
		//g.fillOval(x, y, width, height);
		//draw primary ground
		g.fillRect(baseX, baseY, 2000, 100);
		g.fillOval(hillX, 750, 300, 150);
	}
	public void update() {
		hillX -= speed;
		System.out.println(hillX);
		
	}
}
