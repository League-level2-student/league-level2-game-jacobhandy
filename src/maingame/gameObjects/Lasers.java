package maingame.gameObjects;
import java.awt.Color;
import java.awt.Graphics;

public class Lasers extends GameObject {
public int speed;
	public Lasers(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		// TODO Auto-generated constructor stub
		speed = 30;
	}
	public void update() {
		super.update();
		collisionBox.setLocation(x,y);
		y+=speed;
		if(y > 1800) {
			setAlive(false);
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect(x, y, 5, 10);
	}
}


