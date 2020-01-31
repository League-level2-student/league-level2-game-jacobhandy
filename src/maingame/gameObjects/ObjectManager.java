package maingame.gameObjects;
import java.awt.Graphics;


import java.util.ArrayList;

public class ObjectManager extends Terrain {
	public static Player alien;
	public int delay = 300;
	ArrayList<Lasers> lasers = new ArrayList<Lasers>();
	ArrayList<Terrain> hills = new ArrayList<Terrain>();
	

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
	}

	public void draw(Graphics g) {
		alien.draw(g);
		for (Lasers p : lasers) {
			p.draw(g);

		}

		for (Terrain t : hills) {
			t.draw(g);
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

	public void manageHills() {

		System.out.println(speed);
	
		if (t.hillX < -300) {
			hills.remove(t);
			t.hillX = 2000;
			a = 0;
			addHill(t);
		}

		
	
		
	
	}
}