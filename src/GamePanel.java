import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
Timer timer;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;

public void startGame() {
		timer.start();
		}
	public GamePanel() {
		timer = new Timer(1000 / 60, this);
	
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
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.frameWidth, Game.frameHeight);    


	}
	void drawGameState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Game.frameWidth, Game.frameHeight);  
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Game.frameWidth, Game.frameHeight);  
	}
}

