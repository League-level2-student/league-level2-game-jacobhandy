package maingame.gameObjects.Enemies;

import java.awt.Color;
import java.awt.Graphics;

import maingame.gameObjects.GamePanel;

public class EnemyGeneral extends EnemyAircraft{
	public int speed;
	//This enemy will quickly go across the screen. It will move VERY fast but it doesn't fire any projectiles
	public EnemyGeneral(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		// TODO Auto-generated constructor stub
		speed = 50;
	}
		public void draw(Graphics g) {
			g.setColor(Color.white);
			g.drawImage(GamePanel.commImg, x, y, width, height, null);
		}
		public void update() {
			super.update();
			collisionBox.setBounds(x, y, width, height);
			x-=speed;
			if(x <= -10) {
				isAlive = false;
				x = 2000;
			}
		}
}
