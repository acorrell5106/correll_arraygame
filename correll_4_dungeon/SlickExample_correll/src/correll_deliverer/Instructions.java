package correll_deliverer;

import static correll_deliverer.Level1.player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Instructions extends BasicGameState {
    private StateBasedGame game;
    public Image startimage;
    public Instructions(int xSize, int ySize) {

    }

    public void init(GameContainer container, StateBasedGame game)

            throws SlickException {
    	startimage = new Image("res/instructions.png");
        this.game = game;

    }


    public void render(GameContainer container, StateBasedGame game, Graphics g)

            throws SlickException {
        startimage.draw();

    }

    public void update(GameContainer container, StateBasedGame game, int delta)

            throws SlickException {

    }

    public int getID() {

        return 5;

    }



   

    public void keyReleased(int key, char c) {

        switch (key) {

            case Input.KEY_I:

                if (player.gameState == 1) {
                    game.enterState(1, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
                
                } else if (player.gameState == 2) {
                    game.enterState(2, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
                    
                }
                
                break;

            case Input.KEY_2:
                    
                break;

            case Input.KEY_3:

                break;

            default:

                break;
                

        }
    }
}
