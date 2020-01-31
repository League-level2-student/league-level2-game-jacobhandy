package maingame.gameObjects;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import maingame.Game;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
Timer timer;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;
Font titleFont;
Player alien = new Player (250,70,50,50);
Terrain t = new Terrain();
ObjectManager manager = new ObjectManager(alien);

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
	    if(currentState == MENU_STATE){

            updateMenuState();

    }else if(currentState == GAME_STATE){

            updateGameState();

    }else if(currentState == END_STATE){

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
		if(keyCode == KeyEvent.VK_ENTER) {
			
			System.out.println("dbtgfrgdtg");
			
					currentState++;
					System.out.println(currentState);
				
				
			 if(currentState > END_STATE){
				System.out.println(currentState);
	            currentState = MENU_STATE;

			}
			 
		}
		if(keyCode == KeyEvent.VK_W) {
			alien.moveUp();
		}
		if(keyCode == KeyEvent.VK_A) {
			alien.moveLeft();
		}
		if(keyCode == KeyEvent.VK_S) {
			alien.moveDown();
		}
		if(keyCode == KeyEvent.VK_D) {
			alien.moveRight();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_SPACE) {
			manager.addProjectile(new Lasers(alien.x + 20, alien.y, 10, 10)); 
		}
	}
	@Override

	public void paintComponent(Graphics g){
	    if(currentState == MENU_STATE){

            drawMenuState(g);

    }else if(currentState == GAME_STATE){

            drawGameState(g);

    }else if(currentState == END_STATE){

            drawEndState(g);

    }


		

	        }
	void updateMenuState() {
		
	}
	void updateGameState() {
		
		manager.update();
	}
	void updateEndState() {
		
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
		
	}
	void drawGameState(Graphics g){
		//set up screen
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.frameWidth, Game.frameHeight); 
		g.setFont(titleFont);
		//create alien
		manager.manageHills();
		
		alien.draw(g);
		manager.draw(g);
		t.draw(g);
		
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.frameWidth, Game.frameHeight);  
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("YOU DIED", 450, 400);
	}
}

