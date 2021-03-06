package maingame.gameObjects.Enemies;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import maingame.gameObjects.Bullet;
import maingame.gameObjects.GameObject;
import maingame.gameObjects.GamePanel;
import maingame.gameObjects.ObjectManager;

public class EnemyAircraft extends GameObject{
//This enemy will stay on the screen and will move back and forth until it is destroyed. It will fire a bullet when it shares the same X value as the player
	public int speed;
	public int direction;
	public ArrayList<Bullet> ammunition = new ArrayList<Bullet>();
	public EnemyAircraft(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		// TODO Auto-generated constructor stub
		speed = 25;
		direction = 0;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawImage(GamePanel.enemyImg, x, y, 50, 50, null);
		for(Bullet b: ammunition) {
			 b.draw(g);
		}
	}
	public void update() {
		super.update();
		collisionBox.setLocation(x,y);
		if(x < 0) { 
			direction++;
			
		}
		else if(x > 2000){
			direction++;
		}
		if(direction % 2 == 0) {
			x+=speed;
		}
		if(direction % 2 == 1) {
			x-=speed;
		}
		double impossible = 0.25;
		if(x > ObjectManager.alien.x-impossible && x < ObjectManager.alien.x+50&& ObjectManager.alien.y < y) { //need to get player's x
			
		fire(new Bullet (x,y, 10, 10));
		 
			
		}
			
		

		for(Bullet b : ammunition) {
			b.update();
		
		}
	
	}
	
	public void fire(Bullet b) {
		ammunition.add(0, b);
		
		
	}
}
