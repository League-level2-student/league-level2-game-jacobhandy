package maingame.gameObjects;
import java.awt.Graphics;


import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

import maingame.gameObjects.Enemies.EnemyAircraft;
import maingame.gameObjects.Enemies.EnemyGeneral;
import maingame.gameObjects.Enemies.FriendlyAlien;

public class ObjectManager extends Terrain {
	public static Player alien;
	public static EnemyAircraft sputnik;
	public int delay = 300;
	public long enemyTimer = 0;
	public int enemySpawnTime = 1000;
	public long allyTimer = 0;
	public int allySpawnTime = 1000;
	public int generalSpawnTime = 10000;
	public long generalTimer = 0;
	public int enemyKills;
	public int allyKills;
	public int generalKills;
	public int generalScore;
	public long starTimer = 0;
	public int starSpawnTime = 1000;
	public int treeSpawnTime = 200;
	public long treeTimer = 0;
	public static int spread = 2;
	public int enemyCap = 0;
	
	ArrayList<Lasers> lasers = new ArrayList<Lasers>();
	ArrayList<Terrain> hills = new ArrayList<Terrain>();
	ArrayList<FriendlyAlien> friends = new ArrayList<FriendlyAlien>();
	ArrayList<EnemyGeneral> leadership = new ArrayList<EnemyGeneral>();
	ArrayList<EnemyAircraft> army = new ArrayList<EnemyAircraft>();
	ArrayList<Stars> galaxy = new ArrayList<Stars>();
	ArrayList<tree> forest = new ArrayList<tree>();
	//ArrayList<Bullet> ammo = new ArrayList<Bullet>();
	public ObjectManager(Player p) {
		alien = new Player(250, 70, 50, 50);
		addHill(t);
		enemyKills = 0;
		allyKills = 0;
		generalKills = 0;
		generalScore = 0;
	}
	public void update() {
		
		
		alien.update();
		for(tree z : forest) {
			z.update();
		}
		for(Stars s : galaxy) {
			s.update();
		}
		for(FriendlyAlien a : friends) {
			a.update();
		}
		
		for (Lasers p : lasers) {
			p.update();
		}
		for (Terrain t : hills) {
			t.update();
		}
		for(EnemyAircraft ea : army) {
			ea.update();
			
			
		}
		for(EnemyGeneral eg : leadership) {
			eg.update();
		}
	}

	public void draw(Graphics g) {
		alien.draw(g);
		for(tree z : forest) {
			z.draw(g);
		}
		for(Stars s : galaxy) {
			s.draw(g);
		}
		for(FriendlyAlien a : friends) {
			a.draw(g);
		}
		
		
		for (Lasers p : lasers) {
			p.draw(g);

		}

		for (Terrain t : hills) {
			t.draw(g);
		}
		for(EnemyAircraft ea : army) {
			ea.draw(g);
		}
		for(EnemyGeneral eg : leadership) {
			eg.draw(g);
		}
		
		
	}

	public void addProjectile(Lasers l) {
		lasers.add(l);
		spread++;
	}

	public void addHill(Terrain p) {
		hills.add(p);
	}
	public void addStars(Stars s) {
		if(galaxy.size() <= 300) {
		galaxy.add(s);
	}
	}
	public void addTree(tree z) {
		forest.add(z);
	}
	int a = 0;
	Terrain t = new Terrain();

	//manage enemy aircraft in game panel with the timer class
	
	EnemyAircraft ea = new EnemyAircraft(new Random().nextInt(2000), 1500, 50, 50); //Add random values for position later
	public void manageTrees() {
		if(System.currentTimeMillis() - treeTimer >= treeSpawnTime) {
			addTree(new tree(2000, 750, 25, 50));
			treeTimer = System.currentTimeMillis();
		}
	}
	public void manageEnemyAircraft() {
		//System.out.println(army.size());
		 if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
			 addEnemyAircraft(new EnemyAircraft(new Random().nextInt(2000), new Random().nextInt(650 - 500) + 500, 50, 50));

             enemyTimer = System.currentTimeMillis();
     }
	}
	public void manageStars() {
		if(System.currentTimeMillis() - starTimer >= starSpawnTime) {
			addStars(new Stars(new Random().nextInt(2000), new Random().nextInt(1000), 1, 1));
		}
	}
	public void manageFriends() {
		if(System.currentTimeMillis() - allyTimer >= allySpawnTime) {
			
			addAllies(new FriendlyAlien(new Random().nextInt(2000), 775, 25, 25));
			allyTimer = System.currentTimeMillis();
		}
	}
	public void manageGenerals() {
		if(System.currentTimeMillis() - generalTimer >= generalSpawnTime) {
			addEnemyGeneral(new EnemyGeneral(2000, new Random().nextInt(750 - 450) + 450, 40, 40));
			generalTimer = System.currentTimeMillis();
		}
	}
	private void addEnemyAircraft(EnemyAircraft ea) {
		// TODO Auto-generated method stub
		if(army.size() <= enemyCap) {
		army.add(0, ea);
	}
	}
		private void addEnemyGeneral(EnemyGeneral eg) {
			if(leadership.size() <= 0) {
				leadership.add(0, eg);
			}
		}
	
	
	private void addAllies(FriendlyAlien a) {
			if(friends.size() <= 10) {
				friends.add(0, a);
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
		//System.out.println(ea.ammunition.size());
		
			
		for(EnemyAircraft ea: army) {
			//when the player hits an enemy aircraft
			if(ea.collisionBox.intersects(alien.collisionBox)) {
				alien.isAlive = false;
				
				
			}
			
			//when the player gets shot by anything
			for(Bullet b: ea.ammunition) {
				
				if(b.collisionBox.intersects(alien.collisionBox)) {
					alien.isAlive = false;
					
					
				}
			}
			//if you shoot an enemy aircraft
			for(Lasers l : lasers) {
				if(ea.collisionBox.intersects(l.collisionBox)) {
					ea.isAlive = false;
					l.isAlive = false;
					enemyKills++;
					ea.speed++;
					//if(enemyKills % 5 == 0) {
						enemyCap++;
					//}
				}
				for(FriendlyAlien a : friends) {
					if(l.collisionBox.intersects(a.collisionBox)) {
						a.isAlive = false;
						l.isAlive = false;
						allyKills++;
					}
				}
				for(EnemyGeneral eg : leadership) {
					if(l.collisionBox.intersects(eg.collisionBox)) {
					eg.isAlive = false;
					l.isAlive = false;
					generalKills++;
					generalScore+=10;
					}
				}
			}
		}
		
	}
		
		
		
	
	
		public void purgeObjects() {
			
			for(int a = 0; a < galaxy.size(); a++) {
				if(galaxy.get(a).isAlive() == false)
				{
					galaxy.remove(a);
				}
				}
			
			for(int a = 0; a < army.size(); a++) {
				if(army.get(a).isAlive() == false) {
					army.remove(a);
					
					for(int x = 0; x < lasers.size(); x ++) {
						if(lasers.get(x).isAlive() == false) {
							lasers.remove(x);
							
						}
					}
				
				}
			}
				for(int a = 0; a < friends.size(); a++) {
					if(friends.get(a).isAlive() == false) {
						friends.remove(a);
					}
				}
				for(int a = 0; a < leadership.size(); a++) {
					if(leadership.get(a).isAlive == false) {
						leadership.remove(a);
					}
				}
		}
		public void removeAll() {
			army.removeAll(army);
			lasers.removeAll(lasers);
			ea.ammunition.removeAll(ea.ammunition);
			friends.removeAll(friends);
			leadership.removeAll(leadership);
			galaxy.removeAll(galaxy);
		}
		
}

