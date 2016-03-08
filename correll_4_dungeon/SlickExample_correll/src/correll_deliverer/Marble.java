package correll_deliverer;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Marble {
    
        private int x;
	private int y;
        public static boolean isVisible = false;
        Image currentImage; 
        Shape hitbox;
        //private int time;
        
        
        public Marble(int a, int b) throws SlickException {
            
		this.x = a;
		this.y = b;
                Image marbleImage = new Image("res/finalorb.png");
		this.hitbox = new Rectangle(a, b, 32, 32);
		this.currentImage = marbleImage;
                //this.time = 0;
                
                /*
                Getters and Setters are a common concept in Java.
                A design guideline in Java, and object oriented
                programming in general, is to encapsulate/isolate
                values as much as possible.
                Getters - methods used to query the value of instance variables [this.getLocationX();]
                Setters - methods that set values for instance variables [orb1.setLocation(x, y);]
                */
                
	}

    /*public void settime(int t) {
        this.time = t;
        
    }*/
    
    /*public int gettime() {
        return this.time;
        
    }*/
    
    /*public void countdown() {
        this time
        
    }*/
        
    public int getX() {
        return x;
        
    }

    public void setX(int x) {
        this.x = x;
        
    }

    public int getY() {
        return y;
        
    }

    public void setY(int y) {
        this.y = y;
        
    }
    
    public boolean isIsVisible() {
        return isVisible;
        
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
        
    }

    public Image getCurrentImage() {
        return currentImage;
        
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
        
    }

    public Shape getHitbox() {
        return hitbox;
        
    }

    public void setHitbox(Shape hitbox) {
        this.hitbox = hitbox;
        
    }
    
}