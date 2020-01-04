import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
Player alien;
Lasers projectile;
ArrayList lasers = new ArrayList<Lasers>();
public ObjectManager(Player p) {
	alien = new Player(250,70,50,50);
	projectile = new Lasers(Player.x,Player.y,5,10);
}
public void update() {
	alien.update();
}
public void draw(Graphics g) {
	alien.draw(g);
}
public void addProjectile() {
	lasers.add(projectile);
}
}
