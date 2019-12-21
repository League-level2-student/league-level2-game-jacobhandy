import java.awt.Graphics;

public class GameObject {
	 int x;
     int y;
     int width;
     int height;
     public GameObject(int X, int Y, int Width, int Height) {
    	   x = X;
    	 y = Y;
    	 width = Width;
    	 height = Height;
     }
     void update() {
    	 y++;
    	 x++;
    
    	 
     }
     void draw(Graphics g) {
    	 g.fillRect(x, y, width, height);


     }
}
