package maingame.gameObjects;
import java.awt.Graphics;


import java.util.ArrayList;
import java.util.Random;

import maingame.gameObjects.Enemies.EnemyAircraft;

public class ObjectManager extends Terrain {
	public static Player alien;
	public static EnemyAircraft sputnik;
	public int delay = 300;
	public long enemyTimer = 0;
	public int enemySpawnTime = 1000;
	ArrayList<Lasers> lasers = new ArrayList<Lasers>();
	ArrayList<Terrain> hills = new ArrayList<Terrain>();
	ArrayList<EnemyAircraft> army = new ArrayList<EnemyAircraft>();
	ArrayList<Bullet> ammo = new ArrayList<Bullet>();
	public ObjectManager(Player p) {
		alien = new Player(250, 70, 50, 50);
		addHill(t);
		
	}

	public void update() {
		
		alien.update();
		for (Lasers p : lasers) {
			p.update();
		}
		for (Terrain t : hills) {
			t.update();
		}
		for(EnemyAircraft ea : army) {
			ea.update();
			
			
		}
	}

	public void draw(Graphics g) {
		alien.draw(g);
		
		for (Lasers p : lasers) {
			p.draw(g);

		}

		for (Terrain t : hills) {
			t.draw(g);
		}
		for(EnemyAircraft ea : army) {
			ea.draw(g);
		}
	}

	public void addProjectile(Lasers l) {
		lasers.add(l);
	}

	public void addHill(Terrain p) {
		hills.add(p);
	}

	int a = 0;
	Terrain t = new Terrain();

	//manage enemy aircraft in game panel with the timer class
	
	EnemyAircraft ea = new EnemyAircraft(new Random().nextInt(2000), 1500, 50, 50); //Add random values for position later
	
	public void manageEnemyAircraft() {
		//System.out.println(army.size());
		 if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
			 addEnemyAircraft(new EnemyAircraft(new Random().nextInt(2000), new Random().nextInt(650 - 500) + 500, 50, 50));

             enemyTimer = System.currentTimeMillis();
     }
	}
	
	private void addEnemyAircraft(EnemyAircraft ea) {
		// TODO Auto-generated method stub
		if(army.size() <= 0) {
		army.add(0, ea);
	}
	}
	
	public void manageHills() {

		
	
		if (t.hillX < -300) {
			hills.remove(t);
			t.hillX = 2000;
			a = 0;
			addHill(t);
		}
		
		
	
		
	
	}
	public void checkCollision() {
		
		for(EnemyAircraft ea: army) {
			//when the player hits an enemy aircraft
			if(alien.collisionBox.intersects(ea.collisionBox)) {
				alien.isAlive = false;
				System.out.println("game over");
			}
			//when the player gets shot by anything
			for(Bullet b: ammo) {
				if(alien.collisionBox.intersects(b.collisionBox)) {
					alien.isAlive = false;
					System.out.println("game over");
				
				}
			}
			//if you shoot an enemy aircraft
			for(Lasers l : lasers) {
				if(ea.collisionBox.intersects(l.collisionBox)) {
					//ask about what to set it to
					System.out.println("kill");
				}
			}
		}
		
	}
	public void purgeObjects() {
		army.removeAll(army);
		lasers.removeAll(lasers);
		ammo.removeAll(ammo);
	}

}