package array.game;

import java.util.Scanner;
import java.util.Random;

public class ArrayGame {
    
    static Random randomNumber = new Random();
    
    //object declarations
    public static Player protagonist; //converted player to an object - 10 points
    public static EnemyT1 enemyt11; //converted enemy to an object (with class) - 5 points
    public static EnemyT1 enemyt12;
    public static EnemyT2 enemyt21; //product of a second enemy class - 5 points
    public static Trap trap1;
    public static Trap trap2;
    public static Trap trap3;
    public static Trap trap4;
    public static Trap trap5;
    public static Treasure tr1;
    public static Treasure tr2;     //products of a Treasure class - 5 points
    public static Treasure tr3;
    public static Health hp1;
    public static Health hp2;
    public static Health hp3;
    public static Health hp4;
    
    //weapon, which is NOT in a class, and it is NOT an object
    public static boolean weapon = false;
    public static int weaponx;
    public static int weapony;
    public static int weapons = 3;
    
    //exit
    public static int exitx = randomNumber.nextInt(18) + 1;
    public static int exity = randomNumber.nextInt(18) + 1;
    
    //the number of turns the player goes through
    public static int turns;
    
    //player's name
    public static String name;
    
    //player's skill
    public static String skill;
    
    //different skill booleans
    /*public static boolean lvl2trapfinder = false;
    public static boolean lvl2stoneskin = false;
    public static boolean lvl2goldentouch = false;
    public static boolean lvl3trapfinder = false;
    public static boolean lvl3stoneskin = false;
    public static boolean lvl3goldentouch = false;*/
    
    //scanner strings
    public static String symbol;
    public static String intro2;
    public static String move;
    public static String w;
    public static String l;
    public static String shop;
    public static String lvl2tf;
    public static String lvl2ss;
    public static String lvl2gt;
    public static String lvl3tf;
    public static String lvl3ss;
    public static String lvl3gt;
    
    //win and lose booleans
    public static boolean win = false;
    public static boolean lose = false;

    public static void main(String[] args) {
        
        intro1();
        
    }
    
    static void intro1() {
        
        //player object initialization
        protagonist = new Player(9, 9, 100, 100, 1, 0, name, skill, false, false, false, false, false, false, false, false, false); //converted player to an object - 10 points
        
        System.out.println("'|| '||'  '|'         '||                                     \n" +
" '|. '|.  .'    ....   ||    ....    ...   .. .. ..     ....  \n" +
"  ||  ||  |   .|...||  ||  .|   '' .|  '|.  || || ||  .|...|| \n" +
"   ||| |||    ||       ||  ||      ||   ||  || || ||  ||      \n" +
"    |   |      '|...' .||.  '|...'  '|..|' .|| || ||.  '|...'");
        
        System.out.println("Welcome to the Crypts! You have come to rob the dead of their possessions, but you have awoken them in the process.\nMake it out alive, you get to take the treasure home. Fall into the hands of the dead, and you will never again see the light of day.\n");
        
        name();
        
    }
    
    static void name() {
        
        System.out.println("What is your name, young explorer?");
        Scanner Name = new Scanner(System.in);
        name = Name.nextLine();
        
        //player name is equal to scanner string
        protagonist.playername = name;
        
        skill();
        
    }
    
    static void skill() {
        
        enemyt11 = new EnemyT1(14, 5, 5);
        enemyt12 = new EnemyT1(13, 16, 5);
        enemyt21 = new EnemyT2(2, 12, 10);
        tr1 = new Treasure(randomNumber.nextInt(18) + 1, randomNumber.nextInt(18) + 1, randomNumber.nextInt(50) + 1, randomNumber.nextInt(3) + 1);
        tr2 = new Treasure(randomNumber.nextInt(18) + 1, randomNumber.nextInt(18) + 1, randomNumber.nextInt(50) + 1, randomNumber.nextInt(3) + 1);   //treasure that has varied 'loot', in this case gold and weapons (amount), with randoms for gold and amount of weapons - 5 points
        tr3 = new Treasure(randomNumber.nextInt(18) + 1, randomNumber.nextInt(18) + 1, randomNumber.nextInt(50) + 1, randomNumber.nextInt(3) + 1);
        
        //player has and can use skills - 5 points
        
        System.out.println("\nGreetings, " + protagonist.playername + ". What would you like your skill to be?\nYou can only have one skill, so choose wisely.\nTrap Finder | Stone Skin | Golden Touch");
        Scanner Skill = new Scanner(System.in);
        skill = Skill.nextLine();
        
        //player skill is equal to scanner skill
        protagonist.playerskill = skill;
        
        //changes the input to all lower case
        skill = skill.toLowerCase();
        
        if (skill.contains("trap")) {
            //makes the player's skill trap finder
            System.out.println("\nA wise choice, and a very useful skill. Trap Finder allows you to detect hidden traps on the level, and could possibly save your life when navigating these tombs.");
            protagonist.lvl1trapfinder = true;
            intro2();
        } else if (skill.contains("stone")) {
            //makes the player's skill stone skin
            System.out.println("\nWanting some protection? Stone Skin reduces the amount of damage taken from enemies and traps, keeping your health pool high.");
            protagonist.lvl1stoneskin = true;
            intro2();
        } else if (skill.contains("golden")) {
            //makes the player's skill golden touch
            System.out.println("\nThe skill for the greedy. Golden Touch increases the amount of gold found in chests, and could make you wealthier than you had first believed to be possible.");
            protagonist.lvl1goldentouch = true;
            intro2();
        } else {    
            System.out.println("This really isn't a hard question.\n");
            skill();
        }
        
    }
    
    static void intro2() {
        
        //object initializations
        trap1 = new Trap(randomNumber.nextInt(18) + 1, randomNumber.nextInt(18) + 1, false);
        trap2 = new Trap(randomNumber.nextInt(18) + 1, randomNumber.nextInt(18) + 1, false);
        trap3 = new Trap(randomNumber.nextInt(18) + 1, randomNumber.nextInt(18) + 1, false);
        trap4 = new Trap(randomNumber.nextInt(18) + 1, randomNumber.nextInt(18) + 1, false);
        trap5 = new Trap(randomNumber.nextInt(18) + 1, randomNumber.nextInt(18) + 1, false);
        hp1 = new Health(1, 1);
        hp2 = new Health(1, 18);
        hp3 = new Health(18, 18);
        hp4 = new Health(18, 1);
        
        
        //story elements - 5 points
        if (protagonist.playerlevel == 5) {
            System.out.print("'||' '|'                  \n" +
"  || |     ...   ... ...  \n" +
"   ||    .|  '|.  ||  ||  \n" +
"   ||    ||   ||  ||  ||  \n" +
"  .||.    '|..|'  '|..'|.");
            System.out.println(" seem to be getting farther than the novice explorers that wandered in here, as their corpses litter the ground at your feet.\nWill you end up like them, or will you make it out victorious?");
        } else if (protagonist.playerlevel == 10) {
            System.out.print("'||' '|'                  \n" +
"  || |     ...   ... ...  \n" +
"   ||    .|  '|.  ||  ||  \n" +
"   ||    ||   ||  ||  ||  \n" +
"  .||.    '|..|'  '|..'|.");
            System.out.println(" begin to see less of the fallen and more of the awaken. You gaze at the corpses of those that were strong and brave.\nWill you last longer than them, or will you rest by their side?");
        } else if (protagonist.playerlevel == 20) {
            System.out.print("'||' '|'                  \n" +
"  || |     ...   ... ...  \n" +
"   ||    .|  '|.  ||  ||  \n" +
"   ||    ||   ||  ||  ||  \n" +
"  .||.    '|..|'  '|..'|.");
            System.out.println(" have proven yourself to be quite powerful, yet you begin to fear the growing darkness.\nIs the gold worth it? How long before these halls of the dead drive you mad?");
        } else if (protagonist.playerlevel == 50) {
            System.out.println("|''||''| '||              \n" +
"   ||     || ..     ....  \n" +
"   ||     ||' ||  .|...|| \n" +
"   ||     ||  ||  ||      \n" +
"  .||.   .||. ||.  '|...' ");
            System.out.println(" halls get more narrow, and it is hard to breath. You do not know if you will be able to find your way out of this maze.\nWill there be one whose bravery and strength is greater than yours, or will no one ever find your corpse in this crypt?");
        }
        
        System.out.println("\nIt seems you are ready to go, " + protagonist.playername + ". Do you wish to delve deeper into the Crypt? [Yes/No]");
        Scanner Intro = new Scanner(System.in);
        intro2 = Intro.nextLine();
        
        //changes the input to all lower case
        intro2 = intro2.toLowerCase();
        
        if (intro2.contains("y")) {
            //goes to map method to draw the map and start the game
            System.out.println("What a brave soul. Good luck...\n");
            map();
        } else if (intro2.contains("n")) {
            //ends the game
            System.out.println("A smart choice, but also a poor one.\n");
            System.exit(protagonist.playerx);
        } else {
            System.out.println("This really isn't a hard question.\n");
            intro2();
        }
        
    }
    
    static void map() {
        
        //the level the player is currently on
        System.out.println("Level " + protagonist.playerlevel + "\n"); //multiple levels - 10 points
        
        //the array/map
        char[][] map = new char[21][21];
        
        //where the player is located
        map[protagonist.playery][protagonist.playerx] = protagonist.playersymbol;
        
        //places the weapon if the player calls it in game, making the boolean weapon true
        if (weapon) {
            map[weapony][weaponx] = 'X';
        }
        
        //where the exit is located
        map[exity][exitx] = '^';
        
        //calls the trap method to see if the player steps on a trap
        trap();
        
        //where the traps are located, and will change its symbol if it is stepped on by the player or 
        //hidden traps, appear when stepped on - 5 points
        //trap finding skill - 5 points
        if (protagonist.lvl1trapfinder) {
            
            map[trap1.trapy][trap1.trapx] = ',';
            map[trap2.trapy][trap2.trapx] = ',';
            map[trap3.trapy][trap3.trapx] = ',';
            map[trap4.trapy][trap4.trapx] = ',';
            map[trap5.trapy][trap5.trapx] = ',';
            
        } else if (protagonist.lvl2trapfinder) {
            
            map[trap1.trapy][trap1.trapx] = '-';
            map[trap2.trapy][trap2.trapx] = '-';
            map[trap3.trapy][trap3.trapx] = '-';
            map[trap4.trapy][trap4.trapx] = '-';
            map[trap5.trapy][trap5.trapx] = '-';
        
        } else if (protagonist.lvl3trapfinder) {
            
            map[trap1.trapy][trap1.trapx] = '*';
            map[trap2.trapy][trap2.trapx] = '*';
            map[trap3.trapy][trap3.trapx] = '*';
            map[trap4.trapy][trap4.trapx] = '*';
            map[trap5.trapy][trap5.trapx] = '*';
            
        } else {
            
        if (trap1.trapintersected) {
            map[trap1.trapy][trap1.trapx] = '*';
        } else {
            map[trap1.trapy][trap1.trapx] = '.';
        }
        
        if (trap2.trapintersected) {
            map[trap2.trapy][trap2.trapx] = '*';
        } else {
            map[trap2.trapy][trap2.trapx] = '.';
        }
        
        if (trap3.trapintersected) {
            map[trap3.trapy][trap3.trapx] = '*';
        } else {
            map[trap3.trapy][trap3.trapx] = '.';
        }
        
        if (trap4.trapintersected) {
            map[trap4.trapy][trap4.trapx] = '*';
        } else {
            map[trap4.trapy][trap4.trapx] = '.';
        } 
        
        if (trap5.trapintersected) {
            map[trap5.trapy][trap5.trapx] = '*';
        } else {
            map[trap5.trapy][trap5.trapx] = '.';
        }
        
        }
        
        //where the chests are located
        map[tr1.treasurey][tr1.treasurex] = 'T';
        map[tr2.treasurey][tr2.treasurex] = 'T';
        map[tr3.treasurey][tr3.treasurex] = 'T';
        
        //where the health is located
        map[hp1.hpy][hp1.hpx] = '+';
        map[hp2.hpy][hp2.hpx] = '+';
        map[hp3.hpy][hp3.hpx] = '+';
        map[hp4.hpy][hp4.hpx] = '+';
        
        //calls enemy method to determine the enemies' coordinates
        enemy();
        
        //where the enemies are located
        map[enemyt11.enemyt1y][enemyt11.enemyt1x] = 'e';
        map[enemyt12.enemyt1y][enemyt12.enemyt1x] = 'e';
        map[enemyt21.enemyt2y][enemyt21.enemyt2x] = 'E';
        
        
        //draws the map
        for (int i = 0; i <= map[0].length - 1; i++) {
            for (int j = 0; j <= map[1].length - 1; j++) {
                if (j < map[1].length - 1) {
                    //checks for the different symbols before placing a '.'
                    if (map[i][j] != '@' && map[i][j] != '*' && map[i][j] != '-' && map[i][j] != ',' && map[i][j] != 'T' && map[i][j] != 'e' && map[i][j] != 'E' && map[i][j] != '+' && map[i][j] != 'X' && map[i][j] != '^') {
                        System.out.print(".");
                    } else {
                        System.out.print(map[i][j]);
                    }
                } else {
                    //checks for the different symbols before placing a '.'
                    if (map[i][j] != '@' && map[i][j] != '*' && map[i][j] != '-' && map[i][j] != ',' && map[i][j] != 'T' && map[i][j] != 'e' && map[i][j] != 'E' && map[i][j] != '+' && map[i][j] != 'X' && map[i][j] != '^') {
                        System.out.println("");
                    } else {
                        System.out.println(map[i][j]);
                    }
                }
            }
        } 
        
        //calls movement method after drawing the map
        movement();
        
    }
    
    static void movement() {
        
        turns++;
        
        //if the player reaches the exit, they 'win', or advance to the next level
        if (protagonist.playerx == exitx && protagonist.playery == exity) {
            win = true;
        }
        
        //if the player gets to a chest, they will receive a certain amount of gold based on their skill
        if (protagonist.lvl1goldentouch) {
            if (protagonist.playerx == tr1.treasurex && protagonist.playery == tr1.treasurey) {        
                protagonist.playergold = protagonist.playergold + tr1.treasuregold * 2;
                weapons = weapons + tr1.weapons;
            } else if (protagonist.playerx == tr2.treasurex && protagonist.playery == tr2.treasurey) {
                protagonist.playergold = protagonist.playergold + tr2.treasuregold * 2;
                weapons = weapons + tr2.weapons;
            } else if (protagonist.playerx == tr3.treasurex && protagonist.playery == tr3.treasurey) {
                protagonist.playergold = protagonist.playergold + tr3.treasuregold * 2;
                weapons = weapons + tr3.weapons;
            }
        } else if (protagonist.lvl2goldentouch) {
            if (protagonist.playerx == tr1.treasurex && protagonist.playery == tr1.treasurey) {        
                protagonist.playergold = protagonist.playergold + tr1.treasuregold * 4;
                weapons = weapons + tr1.weapons;
            } else if (protagonist.playerx == tr2.treasurex && protagonist.playery == tr2.treasurey) {
                protagonist.playergold = protagonist.playergold + tr2.treasuregold * 4;
                weapons = weapons + tr2.weapons;
            } else if (protagonist.playerx == tr3.treasurex && protagonist.playery == tr3.treasurey) {
                protagonist.playergold = protagonist.playergold + tr3.treasuregold * 4;
                weapons = weapons + tr3.weapons;
            }
        } else if (protagonist.lvl3goldentouch) {
            if (protagonist.playerx == tr1.treasurex && protagonist.playery == tr1.treasurey) {        
                protagonist.playergold = protagonist.playergold + tr1.treasuregold * 8;
                weapons = weapons + tr1.weapons;
            } else if (protagonist.playerx == tr2.treasurex && protagonist.playery == tr2.treasurey) {
                protagonist.playergold = protagonist.playergold + tr2.treasuregold * 8;
                weapons = weapons + tr2.weapons;
            } else if (protagonist.playerx == tr3.treasurex && protagonist.playery == tr3.treasurey) {
                protagonist.playergold = protagonist.playergold + tr3.treasuregold * 8;
                weapons = weapons + tr3.weapons;
            }
        } else {
            if (protagonist.playerx == tr1.treasurex && protagonist.playery == tr1.treasurey) {        
                protagonist.playergold = protagonist.playergold + tr1.treasuregold;
                weapons = weapons + tr1.weapons;
            } else if (protagonist.playerx == tr2.treasurex && protagonist.playery == tr2.treasurey) {
                protagonist.playergold = protagonist.playergold + tr2.treasuregold;
                weapons = weapons + tr2.weapons;
            } else if (protagonist.playerx == tr3.treasurex && protagonist.playery == tr3.treasurey) {
                protagonist.playergold = protagonist.playergold + tr3.treasuregold;
                weapons = weapons + tr3.weapons;
            }
        }
        
        //if the player reaches a health pack, they will receive 25 health points unless their health + 25 hp would go over their total health pool - 5 points (unique)
        if (protagonist.playerhp + 25 < protagonist.playertotalhp) {
            if (protagonist.playerx == hp1.hpx && protagonist.playery == hp1.hpy || protagonist.playerx == hp2.hpx && protagonist.playery == hp2.hpy || protagonist.playerx == hp3.hpx && protagonist.playery == hp3.hpy || protagonist.playerx == hp4.hpx && protagonist.playery == hp4.hpy) {
                protagonist.playerhp = protagonist.playerhp + 25;
            }
        } else if (protagonist.playerhp + 25 >= protagonist.playertotalhp) {
            if (protagonist.playerx == hp1.hpx && protagonist.playery == hp1.hpy || protagonist.playerx == hp2.hpx && protagonist.playery == hp2.hpy || protagonist.playerx == hp3.hpx && protagonist.playery == hp3.hpy || protagonist.playerx == hp4.hpx && protagonist.playery == hp4.hpy) {
                protagonist.playerhp = protagonist.playerhp + (protagonist.playertotalhp - protagonist.playerhp);
            }
        }
        
        //if the player gets hit by an enemy, they will lose a certain amount of health based on their skill
        if (protagonist.lvl1stoneskin) {
            if ((protagonist.playerx == enemyt11.enemyt1x && protagonist.playery == enemyt11.enemyt1y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt11.enemyt1damage / 2;
            } else if ((protagonist.playerx == enemyt12.enemyt1x && protagonist.playery == enemyt12.enemyt1y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt12.enemyt1damage / 2;
            } else if ((protagonist.playerx == enemyt21.enemyt2x && protagonist.playery == enemyt21.enemyt2y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt21.enemyt2damage / 2;
            }
        } else if (protagonist.lvl2stoneskin) {
            if ((protagonist.playerx == enemyt11.enemyt1x && protagonist.playery == enemyt11.enemyt1y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt11.enemyt1damage / 4;
            } else if ((protagonist.playerx == enemyt12.enemyt1x && protagonist.playery == enemyt12.enemyt1y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt12.enemyt1damage / 4;
            } else if ((protagonist.playerx == enemyt21.enemyt2x && protagonist.playery == enemyt21.enemyt2y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt21.enemyt2damage / 4;
            }
        } else if (protagonist.lvl3stoneskin) {
            if ((protagonist.playerx == enemyt11.enemyt1x && protagonist.playery == enemyt11.enemyt1y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt11.enemyt1damage / 8;
            } else if ((protagonist.playerx == enemyt12.enemyt1x && protagonist.playery == enemyt12.enemyt1y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt12.enemyt1damage / 8;
            } else if ((protagonist.playerx == enemyt21.enemyt2x && protagonist.playery == enemyt21.enemyt2y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt21.enemyt2damage / 8;
            }
        } else { 
            if ((protagonist.playerx == enemyt11.enemyt1x && protagonist.playery == enemyt11.enemyt1y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt11.enemyt1damage;
            } else if ((protagonist.playerx == enemyt12.enemyt1x && protagonist.playery == enemyt12.enemyt1y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt12.enemyt1damage;
            } else if ((protagonist.playerx == enemyt21.enemyt2x && protagonist.playery == enemyt21.enemyt2y)) {
                protagonist.playerhp = protagonist.playerhp - enemyt21.enemyt2damage;
            }
        }
        
        //if the player loses all of their health, they will lose the game
        if (protagonist.playerhp <= 0) {
            lose = true;
        }
            
        //if the player wins, their level will increase and it will go to the win method
        if (win) {
            System.out.println("'|| '||'  '|'  ||           \n" +
" '|. '|.  .'  ...  .. ...   \n" +
"  ||  ||  |    ||   ||  ||  \n" +
"   ||| |||     ||   ||  ||  \n" +
"    |   |     .||. .||. ||.");
            protagonist.playerlevel++; //multiple levels - 10 points
            win();
        //if the player loses, it will go to the lose method
        } else if (lose) {
            System.out.println("'||'                             \n" +
" ||         ...    ....    ....  \n" +
" ||       .|  '|. ||. '  .|...|| \n" +
" ||       ||   || . '|.. ||      \n" +
".||.....|  '|..|' |'..|'  '|...'");
            lose();
        }
        
        Scanner Movement = new Scanner(System.in);
        
        //will only run if both win and lose are false
        if (!win && !lose) {
            
            //random events that advance the story - 10 points
            if (turns == randomNumber.nextInt(100) + 1) {
                System.out.println("\nYou trip on a rock and fall to the ground. Luckily you were agile enough to escape the dead\n");
                protagonist.playerhp = protagonist.playerhp - 3;
            } else if (turns == randomNumber.nextInt(200) + 1) {
                System.out.println("\nYou find a pouch of gold next to a corpses' sword.\n");
                protagonist.playergold = protagonist.playergold + 12;
            } else if (turns == randomNumber.nextInt(500) + 1) {
                System.out.println("\nAs you walk, you see a mysterious door. When approaching, you see that it is locked. You move past, but remember where you found it.\n");
            } else if (turns == randomNumber.nextInt(150) + 1) {
                System.out.println("\nThe dead seem to be getting more... on edge. It's harder to catch them off guard, and one slices your arm as you try to dodge.\n");
                protagonist.playerhp = protagonist.playerhp - 15;
            } else if (turns == randomNumber.nextInt(200) + 1) {
                System.out.println("\nAs you grope through the darkness, rusted metal catches your eye. You find a pile of traps on the ground, and you place them in your backpack.\n");
                weapons = weapons + 5;
            } else if (turns == randomNumber.nextInt(300) + 1) {
                System.out.println("\nYou begin to wonder if this was such a good idea. The rooms are dank and dreary, and the dead find no rest. Was the gold worth it?\n");
            } else if (turns == randomNumber.nextInt(150) + 1) {
                System.out.println("\nYou walk past a large, cavernous room. You see a faint outline of a throne, but do not investigate.\n");
            } else if (turns == randomNumber.nextInt(350) + 1) {
                System.out.println("\nThroughout the rooms, braziers have littered the way, unlit and cold. \nHowever, as you continue, faint wisps of smoke rise from the ashes of a brazier, worsening your vision. \nWho would have lit this?\n");
            }
            
            //prints out the player's health and gold
            System.out.println("Player HP: " + protagonist.playerhp + "/" + protagonist.playertotalhp + "\nGold: " + protagonist.playergold + "\nWeapons: " + weapons + "\n");
            
            System.out.println("Where do you wish to go?\nNorth [N], East [E], South [S], West [W],\nNortheast [NE], Southeast [SE], Northwest [NW], or Southwest [SW]?\nDouble Jump: [2n], [2e], [2s], [2w]\n\nTrap: [X]\nShop: [$]\n\nIf you wish to travel to the next level, make it to the ^ on the floor.");
            move = Movement.nextLine();
        
            //changes to the input to all lower case
            move = move.toLowerCase();
        
        //checks to see which direction the player wants to go in, and will alter their coordinates accordingly
        //will call oob to see if the player needs to loop to the other side of the map
        //after changing the coordinates, the map method is called to redraw the map
        if (move.contains("2n")) { //double jump - 5 points (unique)
            oob();
            trap();
            protagonist.playery = protagonist.playery - 2;
            map();
        } else if (move.contains("2e")) {
            oob();
            trap();
            protagonist.playerx = protagonist.playerx + 2;
            map();
        } else if (move.contains("2s")) {
            oob();
            trap();
            protagonist.playery = protagonist.playery + 2;
            map();
        } else if (move.contains("2w")) {
            oob();
            trap();
            protagonist.playerx = protagonist.playerx - 2;
            map();
        } else if (move.contains("n") && move.contains("e")) {
            oob();
            trap();
            protagonist.playery--;
            protagonist.playerx++;
            map();
        } else if (move.contains("s") && move.contains("e")) {
            oob();
            trap();
            protagonist.playery++;
            protagonist.playerx++;            
            map();
        } else if (move.contains("n") && move.contains("w")) {
            oob();
            trap();
            protagonist.playery--;
            protagonist.playerx--;
            map();            
        } else if (move.contains("s") && move.contains("w")) {
            oob();
            trap();
            protagonist.playery++;
            protagonist.playerx--;
            map();
        } else if (move.contains("n")) {
            oob();
            trap();
            protagonist.playery--;
            map();
        } else if (move.contains("e")) {
            oob();
            trap();
            protagonist.playerx++;
            map();
        } else if (move.contains("s")) {
            oob();
            trap();
            protagonist.playery++;
            map();
        } else if (move.contains("w")) {
            oob();
            trap();
            protagonist.playerx--;
            map();
        } else if (move.contains("x") && weapons > 0) {
            weapons--;
            weaponx = protagonist.playerx;
            weapony = protagonist.playery;
            weapon = true;
            enemy();
            map();
        } else if (move.contains("$")) {
            skillup();
        } else {
            System.out.println("Please choose an appropriate direction.\n");
            movement();
        }
        }
        
    }
    
    static void oob() {
        
        //if the player is on the edge of the map and wishes to go to the other side, this will check that and move the player accordingly
        if (move.contains("w") && protagonist.playerx == 0) {
            protagonist.playerx = 20;
        } else if (move.contains("e") && protagonist.playerx == 20) {
            protagonist.playerx = 0;
        } else if (move.contains("n") && protagonist.playery == 0) {
            protagonist.playery = 20;
        } else if (move.contains("s") && protagonist.playery == 20) {
            protagonist.playery = 0;
        }
        
    }
    
    static void trap() {
        
        //if the player reaches a trap, they will lose 25 health points
        if (protagonist.playerx == trap1.trapx && protagonist.playery == trap1.trapy) {
            trap1.trapintersected = true;
            protagonist.playerhp = protagonist.playerhp - 5;
        } else if (protagonist.playerx == trap2.trapx && protagonist.playery == trap2.trapy) {
            trap2.trapintersected = true;
            protagonist.playerhp = protagonist.playerhp - 5;
        } else if (protagonist.playerx == trap3.trapx && protagonist.playery == trap3.trapy) {
            trap3.trapintersected = true;
            protagonist.playerhp = protagonist.playerhp - 5;
        } else if (protagonist.playerx == trap4.trapx && protagonist.playery == trap4.trapy) {
            trap4.trapintersected = true;
            protagonist.playerhp = protagonist.playerhp - 5;
        } else if (protagonist.playerx == trap5.trapx && protagonist.playery == trap5.trapy) {
            trap5.trapintersected = true;
            protagonist.playerhp = protagonist.playerhp - 5;
        }
        
    }
    
    static void enemy() {
        
        //will check the relationship between the player's coordinates and the enemies' coordinates, changing the enemies' coordinates when neccesary
        
        /*if (enemyt11.enemyt1x == weaponx && enemyt11.enemyt1y == weapony) {
            enemyt11.enemyt1x = weaponx;
            enemyt11.enemyt1y = weapony;
        } else if (enemyt12.enemyt1x == weaponx && enemyt12.enemyt1y == weapony) {
            enemyt12.enemyt1x = weaponx;
            enemyt12.enemyt1y = weapony;
        } else if (enemyt21.enemyt2x == weaponx && enemyt21.enemyt2y == weapony) {
            enemyt21.enemyt2x = weaponx;
            enemyt21.enemyt2y = weapony;
        }*/
        
        /*if (enemyt11.enemyt1x == enemyt12.enemyt1x && enemyt11.enemyt1y == enemyt12.enemyt1y) {
            enemyt12.enemyt1x = randomNumber.nextInt(18) + 1;
            enemyt12.enemyt1y = randomNumber.nextInt(18) + 1;
        } else if (enemyt11.enemyt1x == enemyt21.enemyt2x && enemyt11.enemyt1y == enemyt21.enemyt2y) {
            enemyt21.enemyt2x = randomNumber.nextInt(18) + 1;
            enemyt21.enemyt2y = randomNumber.nextInt(18) + 1;
        } else if (enemyt12.enemyt1x == enemyt21.enemyt2x && enemyt12.enemyt1y == enemyt21.enemyt2y) {
            enemyt21.enemyt2x = randomNumber.nextInt(18) + 1;
            enemyt21.enemyt2y = randomNumber.nextInt(18) + 1;
        }*/
        
        //enemy 1
        if (enemyt11.enemyt1x == weaponx && enemyt11.enemyt1y == weapony) {
            enemyt11.enemyt1x = weaponx;
            enemyt11.enemyt1y = weapony;
        } else if (enemyt11.enemyt1x == enemyt12.enemyt1x && enemyt11.enemyt1y == enemyt12.enemyt1y) {
            enemyt12.enemyt1x = randomNumber.nextInt(18) + 1;
            enemyt12.enemyt1y = randomNumber.nextInt(18) + 1;
        } else if (enemyt11.enemyt1x == enemyt21.enemyt2x && enemyt11.enemyt1y == enemyt21.enemyt2y) {
            enemyt21.enemyt2x = randomNumber.nextInt(18) + 1;
            enemyt21.enemyt2y = randomNumber.nextInt(18) + 1;
        } else {
            if (protagonist.playerx > enemyt11.enemyt1x) {
                enemyt11.enemyt1x++;
            } else if (protagonist.playery > enemyt11.enemyt1y) {
                enemyt11.enemyt1y++;
            } else if (protagonist.playerx < enemyt11.enemyt1x) {
                enemyt11.enemyt1x--;
            } else if (protagonist.playery < enemyt11.enemyt1y) {
                enemyt11.enemyt1y--; 
            }
         }
        
        //enemy 2
        if (enemyt12.enemyt1x == weaponx && enemyt12.enemyt1y == weapony) {
            enemyt12.enemyt1x = weaponx;
            enemyt12.enemyt1y = weapony;
        } else if (enemyt11.enemyt1x == enemyt12.enemyt1x && enemyt11.enemyt1y == enemyt12.enemyt1y) {
            enemyt12.enemyt1x = randomNumber.nextInt(18) + 1;
            enemyt12.enemyt1y = randomNumber.nextInt(18) + 1;
        } else if (enemyt12.enemyt1x == enemyt21.enemyt2x && enemyt12.enemyt1y == enemyt21.enemyt2y) {
            enemyt21.enemyt2x = randomNumber.nextInt(18) + 1;
            enemyt21.enemyt2y = randomNumber.nextInt(18) + 1;
        } else {
            if (protagonist.playerx > enemyt12.enemyt1x) {
                enemyt12.enemyt1x++;
            } else if (protagonist.playery > enemyt12.enemyt1y) {
                enemyt12.enemyt1y++;
            } else if (protagonist.playerx < enemyt12.enemyt1x) {
                enemyt12.enemyt1x--;
            } else if (protagonist.playery < enemyt12.enemyt1y) {
                enemyt12.enemyt1y--; 
            }
         }
        
        //enemy 3
        if (enemyt21.enemyt2x == weaponx && enemyt21.enemyt2y == weapony) {
            enemyt21.enemyt2x = weaponx;
            enemyt21.enemyt2y = weapony;
        } else if (enemyt11.enemyt1x == enemyt21.enemyt2x && enemyt11.enemyt1y == enemyt21.enemyt2y) {
            enemyt21.enemyt2x = randomNumber.nextInt(18) + 1;
            enemyt21.enemyt2y = randomNumber.nextInt(18) + 1;
        } else if (enemyt12.enemyt1x == enemyt21.enemyt2x && enemyt12.enemyt1y == enemyt21.enemyt2y) {
            enemyt21.enemyt2x = randomNumber.nextInt(18) + 1;
            enemyt21.enemyt2y = randomNumber.nextInt(18) + 1;
        } else {
            if (protagonist.playerx > enemyt21.enemyt2x) {
                enemyt21.enemyt2x++;
            } else if (protagonist.playery > enemyt21.enemyt2y) {
                enemyt21.enemyt2y++;
            } else if (protagonist.playerx < enemyt21.enemyt2x) {
                enemyt21.enemyt2x--;
            } else if (protagonist.playery < enemyt21.enemyt2y) {
                enemyt21.enemyt2y--; 
            }
         }
        
    }
    
    static void skillup() {
        
        //"leveling up" occurs when the player gains a certain amount of gold, and can then purchase their chosen skill upgrades - 10 
        //shop - 5 points
        
        System.out.println("You might have enough gold to buy some upgrades, " + protagonist.playername + ".\nWould you like to check them out? [Yes/No]\n");
        Scanner Shop = new Scanner(System.in);
            shop = Shop.nextLine();
                
            shop = shop.toLowerCase();
        
        if (shop.contains("y")) {
            
        if (protagonist.lvl1trapfinder) {
            if (protagonist.playergold >= 500) {
                System.out.println("\n" + protagonist.playername + ", you have gained enough gold to purchase a skill upgrade!\nWould you like to upgrade Trap Finder for 500 gold? [Yes/No]\n");
                Scanner Lvl2tf = new Scanner(System.in);
                lvl2tf = Lvl2tf.nextLine();
                
                lvl2tf = lvl2tf.toLowerCase();
                
                if (lvl2tf.contains("y")) {
                    System.out.println("Good choice.\n");
                    protagonist.lvl1trapfinder = false;
                    protagonist.lvl2trapfinder = true;
                    protagonist.playergold = protagonist.playergold - 500;
                } else if (lvl2tf.contains("n")) {
                    System.out.println("You can always buy the upgrade later.\n");
                    map();
                } else {
                    System.out.println("This really isn't a hard question.\n");
                    skillup();
                }
            } else {
                System.out.println("You don't have enough gold to buy this skill upgrade yet.\n");
                map();
            }
        } else if (protagonist.lvl1stoneskin) {
            if (protagonist.playergold >= 500) {
                System.out.println("\n" + protagonist.playername + ", you have gained enough gold to purchase a skill upgrade!\nWould you like to upgrade Stone Skin for 500 gold? [Yes/No]\n");
                Scanner Lvl2ss = new Scanner(System.in);
                lvl2ss = Lvl2ss.nextLine();
                
                lvl2ss = lvl2ss.toLowerCase();
                
                if (lvl2ss.contains("y")) {
                    System.out.println("Good choice.\n");
                    protagonist.lvl1stoneskin = false;
                    protagonist.lvl2stoneskin = true;
                    protagonist.playergold = protagonist.playergold - 500;
                } else if (lvl2ss.contains("n")) {
                    System.out.println("You can always buy the upgrade later.\n");
                    map();
                } else {
                    System.out.println("This really isn't a hard question.\n");
                    skillup();
                }
            } else {
                System.out.println("You don't have enough gold to buy this skill upgrade yet.\n");
                map();
            }
        } else if (protagonist.lvl1goldentouch) {
            if (protagonist.playergold >= 500) {
                System.out.println("\n" + protagonist.playername + ", you have gained enough gold to purchase a skill upgrade!\nWould you like to upgrade Golden Touch for 500 gold? [Yes/No]\n");
                Scanner Lvl2gt = new Scanner(System.in);
                lvl2gt = Lvl2gt.nextLine();
                
                lvl2gt = lvl2gt.toLowerCase();
                
                if (lvl2gt.contains("y")) {
                    System.out.println("Good choice.\n");
                    protagonist.lvl1goldentouch = false;
                    protagonist.lvl2goldentouch = true;
                    protagonist.playergold = protagonist.playergold - 500;
                } else if (lvl2gt.contains("n")) {
                    System.out.println("You can always buy the upgrade later.\n");
                    map();
                } else {
                    System.out.println("This really isn't a hard question.\n");
                    skillup();
                }
            } else {
                System.out.println("You don't have enough gold to buy this skill upgrade yet.\n");
                map();
            }
        }
        
        if (protagonist.lvl2trapfinder) {
            if (protagonist.playergold >= 5000) {
                System.out.println("\n" + protagonist.playername + ", you have gained enough gold to purchase a skill upgrade!\nWould you like to upgrade Trap Finder for 5000 gold? [Yes/No]\n");
                Scanner Lvl3tf = new Scanner(System.in);
                lvl3tf = Lvl3tf.nextLine();
                
                lvl3tf = lvl3tf.toLowerCase();
                
                if (lvl3tf.contains("y")) {
                    System.out.println("Good choice.\n");
                    protagonist.lvl2trapfinder = false;
                    protagonist.lvl3trapfinder = true;
                    protagonist.playergold = protagonist.playergold - 5000;
                } else if (lvl3tf.contains("n")) {
                    System.out.println("You can always buy the upgrade later.\n");
                    map();
                } else {
                    System.out.println("This really isn't a hard question.\n");
                    skillup();
                }
            } else {
                System.out.println("You don't have enough gold to buy this yet.\n");
                map();
            }
        } else if (protagonist.lvl2stoneskin) {
            if (protagonist.playergold >= 5000) {
                System.out.println("\n" + protagonist.playername + ", you have gained enough gold to purchase a skill upgrade!\nWould you like to upgrade Stone Skin for 5000 gold? [Yes/No]\n");
                Scanner Lvl3ss = new Scanner(System.in);
                lvl3ss = Lvl3ss.nextLine();
                
                lvl3ss = lvl3ss.toLowerCase();
                
                if (lvl3ss.contains("y")) {
                    System.out.println("Good choice.\n");
                    protagonist.lvl2stoneskin = false;
                    protagonist.lvl3stoneskin = true;
                    protagonist.playergold = protagonist.playergold - 5000;
                } else if (lvl3ss.contains("n")) {
                    System.out.println("You can always buy the upgrade later.\n");
                    map();
                } else {
                    System.out.println("This really isn't a hard question.\n");
                    skillup();
                }
            } else {
                System.out.println("You don't have enough gold to buy this yet.\n");
                map();
            }
        } else if (protagonist.lvl2goldentouch) {
            if (protagonist.playergold >= 5000) {
                System.out.println("\n" + protagonist.playername + ", you have gained enough gold to purchase a skill upgrade!\nWould you like to upgrade Golden Touch for 5000 gold? [Yes/No]\n");
                Scanner Lvl3gt = new Scanner(System.in);
                lvl3gt = Lvl3gt.nextLine();
                
                lvl3gt = lvl3gt.toLowerCase();
                
                if (lvl3gt.contains("y")) {
                    System.out.println("Good choice.\n");
                    protagonist.lvl2goldentouch = false;
                    protagonist.lvl3goldentouch = true;
                    protagonist.playergold = protagonist.playergold - 5000;
                } else if (lvl3gt.contains("n")) {
                    System.out.println("You can always buy the upgrade later.\n");
                    map();
                } else {
                    System.out.println("This really isn't a hard question.\n");
                    skillup();
                }
            } else {
                System.out.println("You don't have enough gold to buy this yet.\n");
                map();
            }
        }
        } else if (shop.contains("n")) {
            System.out.println("You can always buy something later.\n");
            map();
        } else {
            System.out.println("This really isn't a hard question.\n");
            skillup();
        }
        
    }
    
    static void win() {
        
        //resets the win boolean so the player can win again
        win = false;
        
        //increases the total hp pool of the player when they reach the next level
        protagonist.playertotalhp = protagonist.playertotalhp + 25;
        
        //increases amount of gold in chests       
        tr1.treasuregold = tr1.treasuregold * 2;
        tr2.treasuregold = tr2.treasuregold * 2;
        tr3.treasuregold = tr3.treasuregold * 2;
        
        tr1.weapons = randomNumber.nextInt(3) + 1;
        tr2.weapons = randomNumber.nextInt(3) + 1;
        tr3.weapons = randomNumber.nextInt(3) + 1;
        
        //increases the damage done by the enemies
        enemyt11.enemyt1damage = enemyt11.enemyt1damage + 10;
        enemyt12.enemyt1damage = enemyt12.enemyt1damage + 10;    //when the player goes to the next level, the enemies increase the amount of damage they deal, making the levels more difficult as you continue - 5 points
        enemyt21.enemyt2damage = enemyt21.enemyt2damage + 10;
        
        Scanner Response = new Scanner(System.in);
        System.out.println("Do you wish to enter the crypt once more? [Yes/No]");
        w = Response.nextLine();
        
        w = w.toLowerCase();
        
        if (w.contains("y")) {
            System.out.println("Wanted some more gold, huh?\n");
            //resets the player's coordinates, weapon boolean, exit location, and enemy coordinates
            //will go back to intro method to re-run the game
            protagonist.playerx = 9;
            protagonist.playery = 9;
            
            weapon = false;
            
            exitx = randomNumber.nextInt(18) + 1;
            exity = randomNumber.nextInt(18) + 1;
            
            enemyt11.enemyt1x = 14;
            enemyt11.enemyt1y = 5;
            enemyt12.enemyt1x = 13;
            enemyt12.enemyt1y = 16;
            enemyt21.enemyt2x = 2;
            enemyt21.enemyt2y = 12;
            
            intro2();
        } else if (w.contains("n")) {
            //ends the game
            System.out.println("A smart choice, but also a poor one.\nYou leave with " + protagonist.playergold + " gold.\n");
            System.exit(protagonist.playerx);
        } else {
            System.out.println("This really isn't a hard question.\n");
            win();
        }
        
    }
    
    static void lose() {
        
        //resets the lose boolean so the player can lose again
        lose = false;
        
        //resets the player's level
        protagonist.playerlevel = 1;
        
        //resets the gold amount
        tr1.treasuregold = randomNumber.nextInt(50) + 1;
        tr2.treasuregold = randomNumber.nextInt(50) + 1;
        tr3.treasuregold = randomNumber.nextInt(50) + 1;
        
        //resets the damage done by enemies
        enemyt11.enemyt1damage = 5;
        enemyt12.enemyt1damage = 5;
        enemyt21.enemyt2damage = 10;
        
        Scanner Response = new Scanner(System.in);
        System.out.println("Do you wish to be reincarnated as a new explorer? [Yes/No]");
        l = Response.nextLine();
        
        l = l.toLowerCase();
        
        if (l.contains("y")) {
            System.out.println("Welcome back...\n");
            //resets the player's coordinates, health, gold, weapon boolean, and enemy coordinates
            //will go back to the name method to completely restart the game
            protagonist.playerx = 9;
            protagonist.playery = 9;
            protagonist.playerhp = 100;
            protagonist.playergold = 0;
            
            weapon = false;
            
            enemyt11.enemyt1x = 14;
            enemyt11.enemyt1y = 5;
            enemyt12.enemyt1x = 13;
            enemyt12.enemyt1y = 16;
            enemyt21.enemyt2x = 2;
            enemyt21.enemyt2y = 12;
            
            name();
        } else if (l.contains("n")) {
            //ends the game
            System.out.println("Turning down reincarnation? If that's what you want...\nYou collected " + protagonist.playergold + " gold, but lost it all.\n");
            System.exit(protagonist.playerx);
        } else {
            System.out.println("This really isn't a hard question.\n");
            lose();
        }
        
    }
    
}

