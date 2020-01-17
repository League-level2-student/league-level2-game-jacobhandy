import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
Player alien;

ArrayList<Lasers> lasers = new ArrayList<Lasers>();
public ObjectManager(Player p) {
	alien = new Player(250,70,50,50);
	
}
public void update() {
	alien.update();
	for(Lasers p: lasers) {
		p.update();
	}
}
public void draw(Graphics g) {
	alien.draw(g);
	for (Lasers p : lasers) {
		p.draw(g);

	}

}

public void addProjectile(Lasers l) {
	lasers.add(l);
}
}