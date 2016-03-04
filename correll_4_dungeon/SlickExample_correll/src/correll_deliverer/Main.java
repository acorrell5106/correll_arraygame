package correll_deliverer;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame{

   public static final String gamename = "Deliverer";
   public static final int play = 0;
   public static final int xSize = 400;
   public static final int ySize = 400;
   
   public Main(String gamename){
       
      super(gamename);
      this.addState(new Menu(xSize, ySize));
      this.addState(new Level1(800, ySize));
      this.addState(new Level2(800, ySize));
      this.addState(new Instructions(xSize, ySize));
      this.addState(new Lose(xSize, ySize));      
      this.addState(new Win(xSize, ySize));

   }

   public void initStatesList(GameContainer gc) throws SlickException{

      this.getState(play).init(gc, this);
      this.enterState(play);

   }

   public static void main(String[] args) {

      AppGameContainer appgc;
      
      try{

         appgc = new AppGameContainer(new Main(gamename));
         appgc.setDisplayMode(xSize, ySize, false);         
         int maxFPS = 60;        
         appgc.setTargetFrameRate(maxFPS);
         appgc.setTargetFrameRate(60);
         appgc.start();

      }catch(SlickException e){
         e.printStackTrace();

      }
   }
}