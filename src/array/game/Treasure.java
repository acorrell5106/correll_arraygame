package array.game;

public class Treasure {
    public int treasurex;
    public int treasurey;
    public int treasuregold;
    public int weapons;
    
    public Treasure (int a, int b, int c, int d) {
        this.treasurex = a;
        this.treasurey = b;
        this.treasuregold = c;
        this.weapons = d;
    }

    public int getTreasurex() {
        return treasurex;
    }

    public int getTreasurey() {
        return treasurey;
    }

    public int getTreasuregold() {
        return treasuregold;
    }

    public int getWeapons() {
        return weapons;
    }

    public void setTreasurex(int treasurex) {
        this.treasurex = treasurex;
    }

    public void setTreasurey(int treasurey) {
        this.treasurey = treasurey;
    }

    public void setTreasuregold(int treasuregold) {
        this.treasuregold = treasuregold;
    }

    public void setWeapons(int weapons) {
        this.weapons = weapons;
    }
    
}

