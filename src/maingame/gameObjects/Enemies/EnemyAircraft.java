package maingame.gameObjects.Enemies;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import maingame.gameObjects.Bullet;
import maingame.gameObjects.GameObject;
import maingame.gameObjects.ObjectManager;

public class EnemyAircraft extends GameObject{
//This enemy will stay on the screen and will move back and forth until it is destroyed. It will fire a bullet when it shares the same X value as the player
	public int speed;
	public ArrayList<Bullet> ammunition = new ArrayList<Bullet>();
	public EnemyAircraft(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		// TODO Auto-generated constructor stub
		speed = 15;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 50, 50);
		for(Bullet b: ammunition) {
			 b.draw(g);
		}
	}
	public void update() {
		if(x < 10) {
			x -=speed; 
		}
		else if(x > 1800) {
			x+=speed;
		}
		
		if(x == ObjectManager.alien.x) { //need to get player's x
			fire();
		}
			
		

		for(Bullet b : ammunition) {
			b.update();
			
		}
	
	}
	Bullet b = new Bullet(x, y, 10, 10);
	public void fire() {
		ammunition.add(0, b);
	}
}
