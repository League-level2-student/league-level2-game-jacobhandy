package maingame.gameObjects.Enemies;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import maingame.gameObjects.Bullet;
import maingame.gameObjects.GameObject;
import maingame.gameObjects.ObjectManager;

public class EnemyAircraft extends GameObject{
//This enemy will stay on the screen and will move back and forth until it is destroyed. It will fire a bullet when it shares the same X value as the player
	public int speed;
	public int direction;
	public ArrayList<Bullet> ammunition = new ArrayList<Bullet>();
	public EnemyAircraft(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		// TODO Auto-generated constructor stub
		speed = 15;
		direction = 0;
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
			direction++;
			
		}
		else if(x > 1800){
			direction++;
		}
		if(direction % 2 == 0) {
			x+=speed;
		}
		if(direction % 2 == 1) {
			x-=speed;
		}
		if(x > ObjectManager.alien.x-0.25 && x < ObjectManager.alien.x+50 && ObjectManager.alien.y < y) { //need to get player's x
			
		fire();
			
			System.out.println("bang");
		}
			
		

		for(Bullet b : ammunition) {
			b.update();
			
		}
	
	}
	
	public void fire() {
		Bullet b = new Bullet(x, y, 10, 10);
		ammunition.add(b);
	}
}
