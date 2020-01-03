import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
	public int speed;
	public int downSpeed = 30;
	public Player(int X, int Y, int Width, int Height) {
	super(X, Y, Width, Height);
	speed = 25;
	
}
public void update() {
	
}
public void draw(Graphics g) {
	g.setColor(Color.YELLOW);
    g.fillRect(x, y, width, height);
}
public void moveLeft() {
	x = x -speed;
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
