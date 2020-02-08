package maingame.gameObjects;
import java.awt.Graphics;
import java.awt.Rectangle;



public class GameObject {
	 public int x;
     public int y;
     public int width;
     public int height;
     boolean isAlive;
     public Rectangle collisionBox;
     
     public GameObject(int X, int Y, int Width, int Height) {
    	   x = X;
    	 y = Y;
    	 width = Width;
    	 height = Height;
    	 isAlive = true;
    	 collisionBox = new Rectangle(x,y,width,height);
     }
     public void update() {
    	 //y++;
    	// x++;
    
    	 
     }
     public void draw(Graphics g) {
    	 g.fillRect(x, y, width, height);


     }
}
