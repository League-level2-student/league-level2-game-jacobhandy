package maingame.gameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import maingame.Game;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	
	public int score;
	
	public static BufferedImage alienImg;
	public static BufferedImage enemyImg;
	public static BufferedImage friendlyImg;
	public static BufferedImage commImg;
	public static BufferedImage terrainImg;
	public static BufferedImage hillImg;
	public static BufferedImage nightImg;
	
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
		try {

			  alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			
           

    } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

    }
		
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
						"W, A, S, D to move, F to stop, Space to shoot, don't die. Don't shoot fellow comrades. It has been reported that the generals are evacuating. Be sure to get them as well. It is also strongly advised that you maintain a high altitude");
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
		manager.enemyKills = 0;
		manager.allyKills = 0;
		manager.generalKills = 0;
		score = 0;
	}

	void updateGameState() {
		manager.alien.manageDirection();
		
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
		manager.manageFriends();
		manager.manageGenerals();
	}

	void drawEndState(Graphics g) {
	
		score = manager.enemyKills + manager.generalScore - manager.allyKills;
		System.out.println(score);
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.frameWidth, Game.frameHeight);
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("YOU DIED", 450, 200);
		g.setColor(Color.BLUE);
		g.drawString("You killed " + manager.enemyKills + " enemies", 150, 300);
		g.drawString("You killed " + manager.allyKills + " allies", 150, 400);
		g.drawString("You killed " + manager.generalKills + " commanders", 150, 500);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("Score: " + score, 200, 600);
		g.setColor(Color.WHITE);
		g.drawString("Press Enter to Restart.", 225, 700);
		
		
	}
}
