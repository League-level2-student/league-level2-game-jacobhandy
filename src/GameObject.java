import java.awt.Graphics;



public class GameObject {
	 static int x;
     static int y;
     int width;
     int height;
     boolean isAlive;
     
     public GameObject(int X, int Y, int Width, int Height) {
    	   x = X;
    	 y = Y;
    	 width = Width;
    	 height = Height;
    	 isAlive = true;
     }
     void update() {
    	 y++;
    	 x++;
    
    	 
     }
     void draw(Graphics g) {
    	 g.fillRect(x, y, width, height);


     }
}
