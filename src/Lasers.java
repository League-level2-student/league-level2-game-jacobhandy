import java.awt.Graphics;

public class Lasers extends GameObject {
public int speed;
	public Lasers(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		// TODO Auto-generated constructor stub
		speed = 30;
	}
	public void update() {
		y+=speed;
		if(y > 1800) {
			isAlive = false;
		}
	}
	public void draw(Graphics g) {
		g.drawRect(Player.x, Player.y, 5, 10);
	}
}


