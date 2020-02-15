package maingame.gameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import maingame.Game;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	int currentState = MENU_STATE;
	Font titleFont;
	// Player alien = new Player(250, 70, 50, 50);
	// game is currently in impossible mode
	Terrain t = new Terrain();
	ObjectManager manager = new ObjectManager(ObjectManager.alien);

	public void startGame() {
		timer.start();
	}

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.BOLD, 100);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();

		if (currentState == MENU_STATE) {
			if (keyCode == KeyEvent.VK_I) {
				JOptionPane.showInputDialog(null,
						"W, A, S, D to move, F to stop, Space to shoot, don't die. Feel free to leave any thoughts here. They will never be heard");
			}
		}
		if(currentState == MENU_STATE || currentState == END_STATE) {
		if (keyCode == KeyEvent.VK_ENTER) {

			currentState++;

			if (currentState > END_STATE) {

				currentState = MENU_STATE;

			}

		}
		}
		if (keyCode == KeyEvent.VK_W) {
			// ObjectManager.alien.moveUp();
			ObjectManager.alien.direction = 4;
		}
		if (keyCode == KeyEvent.VK_A) {
			ObjectManager.alien.direction = 1;
		}
		if (keyCode == KeyEvent.VK_S) {
			ObjectManager.alien.direction = 3;
		}
		if (keyCode == KeyEvent.VK_D) {
			ObjectManager.alien.direction = 2;
		}
		if (keyCode == KeyEvent.VK_F) {
			ObjectManager.alien.direction = 0;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE) {
			manager.addProjectile(new Lasers(ObjectManager.alien.x + 20, ObjectManager.alien.y, 10, 10));
		}
	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}

	}

	void updateMenuState() {
		ObjectManager.alien.setAlive(true);
	}

	void updateGameState() {
		manager.alien.manageDirection();
		System.out.println(manager.score);
		manager.update();
		manager.checkCollision();
		manager.purgeObjects();

		if (ObjectManager.alien.isAlive() == false) {
			currentState++;
		}

	}

	void updateEndState() {
		manager.removeAll();

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.frameWidth, Game.frameHeight);
		g.setFont(titleFont);
		g.setColor(Color.GREEN);
		g.drawString("The End of the World", 230, 175);
		g.setColor(Color.RED);
		g.drawString("DEFINITIVE EDITION", 240, 255);
		g.setColor(Color.YELLOW);
		g.drawString("Press Enter to play game", 175, 830);
		g.setColor(Color.MAGENTA);
		g.drawString("Press 'I' for instructions", 170, 500);
		manager.alien = new Player(250, 70, 50, 50);
	}

	void drawGameState(Graphics g) {
		// set up screen
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.frameWidth, Game.frameHeight);
		g.setFont(titleFont);
		// create alien
		manager.manageHills();

		ObjectManager.alien.draw(g);
		manager.draw(g);
		t.draw(g);
		manager.manageEnemyAircraft();

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.frameWidth, Game.frameHeight);
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("YOU DIED", 450, 400);
		g.setColor(Color.BLUE);
		
		g.setColor(Color.WHITE);
		g.drawString("Press Enter to Restart.", 225, 700);
		g.setColor(Color.CYAN);
		g.drawString("Play my games", 0, 100);
		g.drawString("instead of going to school!", 150, 200);
	}
}
