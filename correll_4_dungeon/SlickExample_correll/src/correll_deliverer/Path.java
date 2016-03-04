package correll_deliverer;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Path {
    
        public int x;
	public int y;
	public static boolean isvisible = true;
	Image currentImage;
	Shape hitbox;
	Image pathImage = new Image("res/vision.png");
        
        Path(int a, int b) throws SlickException {
            
		this.x = a;
		this.y = b;
		this.hitbox = new Rectangle(this.x, this.y, 32, 32);
		this.currentImage = pathImage;
                
        }
    
}
