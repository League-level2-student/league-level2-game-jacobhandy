package maingame;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import maingame.gameObjects.GamePanel;

public class Game {
	public static int frameWidth = 2000;
	public static int frameHeight = 1000;
	public static JFrame mainFrame;
	public static GamePanel window;
	public Game() {
		mainFrame = new JFrame();
		window = new GamePanel();
	}
	  public static void createWindow() {
  	    Dimension d = new Dimension(frameWidth, frameHeight);
		
		mainFrame.setSize(d);
		mainFrame.setTitle("The End is near . . .");
}
	  public  void setup() {
		  mainFrame.add(window);
		  mainFrame.getContentPane().setPreferredSize(new Dimension(frameWidth, frameHeight));
		  mainFrame.pack();
		  createWindow();
		  mainFrame.setVisible(true);
		  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  mainFrame.addKeyListener(window);
		  window.startGame();
	  }
}
