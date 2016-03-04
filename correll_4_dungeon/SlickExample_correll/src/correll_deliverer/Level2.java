package correll_deliverer;

import static correll_deliverer.Level1.player;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

public class Level2 extends BasicGameState {

    public GoodPortal gportal;
    public Orb blue;
    public OrbRed red;
    public OrbYellow yellow;
    public static Marble damage;

    public static boolean blueb;
    public static boolean redb;
    public static boolean yellowb;
    public static boolean orbb;
    public static boolean win;

    public ArrayList<GoodPortal> gp = new ArrayList();
    public ArrayList<Orb> orbz = new ArrayList();
    public ArrayList<OrbRed> orbzz = new ArrayList();
    public ArrayList<OrbYellow> orbzzz = new ArrayList();
    public ArrayList<Item> stuff = new ArrayList();
    
    private static TiledMap grassMap;
    private static AppGameContainer app;
    private static Camera camera;
    public static int counter = 40000;
    private static final int SIZE = 32;
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 750;
    
    public static Player player;

    public Level2(int xSize, int ySize) {

    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {

        gc.setTargetFrameRate(60);
        gc.setShowFPS(false);
        grassMap = new TiledMap("res/final.tmx");
        camera = new Camera(gc, grassMap);
        Blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];
        
        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                
                int tileID = grassMap.getTileId(xAxis, yAxis, 0);
                String value = grassMap.getTileProperty(tileID,
                        "blocked", "false");
                
                if ("true".equals(value)) {
                    
                    Blocked.blocked[xAxis][yAxis] = true;
                    
                }
            }
        }
        
        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!Blocked.blocked[xBlock][yBlock]) {
                    if (yBlock % 7 == 0 && xBlock % 15 == 0) {

                    }
                }
            }
        }

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!Blocked.blocked[xBlock][yBlock]) {
                    if (xBlock % 9 == 0 && yBlock % 25 == 0) {

                    }
                }
            }
        }

        player = new Player();
        player.gameState = 2;
        
        gportal = new GoodPortal(55, 670);
        blue = new Orb(705, 190);
        red = new OrbRed(60, 700);
        yellow = new OrbYellow(180, 480);
        damage = new Marble((int) player.x, (int) player.y);

        gp.add(gportal);
        orbz.add(blue);
        orbzz.add(red);
        orbzzz.add(yellow);

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {

        camera.centerOn((int) player.x, (int) player.y);
        camera.drawMap();
        camera.translateGraphics();
        player.sprite.draw((int) player.x, (int) player.y);
                //coordinates
		g.drawString("x: " + (int)player.x + "y: " +(int)player.y , player.x, player.y - 10);
        g.drawString("Time Passed: " + counter / 1000, camera.cameraX + 10, camera.cameraY);

        if (damage.isVisible) {
            
            damage.currentImage.draw(damage.getX(), damage.getY());
            //g.draw(damage.hitbox);
            
        }
        
        for (GoodPortal p : gp) {
                if (p.isvisible) {
                
                    p.currentImage.draw(p.x, p.y);
                    //g.draw(s.hitbox);

            }
        }

        for (Orb o : orbz) {
            if (o.isvisible) {
                
                o.currentImage.draw(o.x, o.y);
                //g.draw(o.hitbox);

            }
        }

        for (OrbRed o : orbzz) {
            if (o.isvisible) {
                
                o.currentImage.draw(o.x, o.y);
                //g.draw(o.hitbox);

            }
        }

        for (OrbYellow o : orbzzz) {
            if (o.isvisible) {
                
                o.currentImage.draw(o.x, o.y);
                //g.draw(o.hitbox);

            }
        }
        
        /*for (Altar a : altarz) {
            if (a.isvisible) {
                
                a.currentImage.draw(a.x, a.y);
                //g.draw(a.hitbox);

        }
    }*/
        
        if (orbb) {
            
            g.drawString("To escape: Press Q to\n summon the final orb and\n activate the altar blocking the\n entrance, before time runs out: " + counter / 1000, camera.cameraX + 10, camera.cameraY + 15);
            
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {

        counter -= delta;
        Input input = gc.getInput();
        float fdelta = delta * player.speed;
        player.setpdelta(fdelta);
        double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);
        float projectedright = player.x + fdelta + SIZE;
        boolean cangoright = projectedright < rightlimit;
        
        if (input.isKeyDown(Input.KEY_UP)) {
            
            player.setDirection(0);
            player.sprite = player.up;
            float fdsc = (float) (fdelta - (SIZE * .15));

            if (!(isBlocked(player.x, player.y - fdelta) || isBlocked((float) (player.x + SIZE + 1.5), player.y + fdelta))) {
                
                player.sprite.update(delta);
                player.y -= fdelta;
                
            }
            
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            
            player.setDirection(2);
            player.sprite = player.down;

            if (!isBlocked(player.x, player.y + SIZE + fdelta)
                    || !isBlocked(player.x + SIZE - 1, player.y + SIZE + fdelta)) {
                
                player.sprite.update(delta);
                player.y += fdelta;

            }
            
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            
            player.setDirection(3);
            player.sprite = player.left;

            if ((player.getPlayersX() > 5) && (!(isBlocked(player.x - fdelta, player.y) || isBlocked(player.x
                    - fdelta, player.y + SIZE - 1)) || isBlocked(player.x - SIZE / 2 - fdelta, player.y
                            + SIZE - 1))) {
                
                player.sprite.update(delta);
                player.x -= fdelta;

            }
            
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            
            player.setDirection(1);
            player.sprite = player.right;

            if (cangoright
                    && (!(isBlocked(player.x + SIZE + fdelta,
                            player.y) || isBlocked(player.x + SIZE + fdelta, player.y
                            + SIZE - 1)))) {
                
			//player.sprite.update(delta);
                player.x += fdelta;

            }
            
        } else if (input.isKeyDown(Input.KEY_Q) && (blueb && redb && yellowb)) {     
            
            damage.setX((int) player.x);
            damage.setY((int) player.y);
            damage.hitbox.setX(damage.getX());
            damage.hitbox.setY(damage.getY());
            damage.setIsVisible(!damage.isIsVisible());
            
        } else if (input.isKeyDown(Input.KEY_I)) {     
            
            sbg.enterState(5, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
            
        }
        
        if (blueb && redb && yellowb) {
            
            orbb = true;
            
        }

        Level2.player.rect.setLocation(Level2.player.getPlayershitboxX(),
                Level2.player.getPlayershitboxY() + 50);

        for (GoodPortal p : gp) {
            if (Level2.player.rect.intersects(p.hitbox)) {
                if (p.isvisible) {
                    
                    sbg.enterState(1, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
                    
                }
            }
        }
        
        
        for (Orb o : orbz) {
            if (Level2.player.rect.intersects(o.hitbox)) {
                if (o.isvisible) {
                    
                    blueb = true;
                    o.isvisible = false;
                    
                }
            }
        }

        for (OrbRed o : orbzz) {
            if (Level2.player.rect.intersects(o.hitbox)) {
                if (o.isvisible) {
                    
                    redb = true;
                    o.isvisible = false;
                    
                }
            }
        }

        for (OrbYellow o : orbzzz) {
            if (Level2.player.rect.intersects(o.hitbox)) {
                if (o.isvisible) {
                    
                    yellowb = true;
                    o.isvisible = false;
                    
                }
            }
        }
        
        /*for (Altar a : altarz) {
            if (damage.hitbox.intersects(a.hitbox)) {
                
                    win = true;
                    a.isvisible = false;
                    
            }
        }*/
        
        if (damage.isIsVisible()) {
            if (player.getDirection() == 0) {

                    damage.setX((int) player.x);
                    damage.setY(damage.getY() - 5);
                    
                } else if (player.getDirection() == 2) {
                    
                    damage.setX((int) player.x);
                    damage.setY(damage.getY() + 5);
                    
                } else if (player.getDirection() == 3) {
                    
                    damage.setX(damage.getX() - 5);
                    damage.setY(damage.getY());
                    
                } else if (player.getDirection() == 1) {
                    
                    damage.setX(damage.getX() + 5);
                    damage.setY(damage.getY());
                    
                }
                
                damage.hitbox.setX(damage.getX());
                damage.hitbox.setY(damage.getY());
                
            } else {
                
                damage.setIsVisible(false);
            
            }
    
        if (counter <= 0) {
            
            makevisible();
            sbg.enterState(4, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
            
        }

        if (win && orbb) {
            
            sbg.enterState(3, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
            
        }
    
    }

    public int getID() {
        
        return 2;

    }

    public void makevisible() {
        for (Item i : stuff) {
            
            i.isvisible = true;
            
        }
    }

    private boolean isBlocked(float tx, float ty) {
        
        int xBlock = (int) tx / SIZE;
        int yBlock = (int) ty / SIZE;
        return Blocked.blocked[xBlock][yBlock];

    }



}