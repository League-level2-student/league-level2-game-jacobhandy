package maingame;
import javax.swing.JFrame;

public class Runner {

	JFrame frame = new JFrame();
	
public static void main(String[] args) {
	Game g = new Game();
	g.setup();
}
}
