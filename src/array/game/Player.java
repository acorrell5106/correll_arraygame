package array.game;

public class Player {
    public int playerx;
    public int playery;
    public int playerhp;
    public int playertotalhp;
    public int playerlevel;
    public int playergold;
    public String playername;
    public String playerskill;
    public boolean lvl1trapfinder;
    public boolean lvl1stoneskin;
    public boolean lvl1goldentouch;
    public boolean lvl2trapfinder;
    public boolean lvl2stoneskin;
    public boolean lvl2goldentouch;
    public boolean lvl3trapfinder;
    public boolean lvl3stoneskin;
    public boolean lvl3goldentouch;
    public char playersymbol = '@';
    
    public Player (int a, int b, int c, int q, int d, int e, String f, String g, boolean h, boolean i, boolean j, boolean k, boolean l, boolean m, boolean n, boolean o, boolean p) {
        this.playerx = a;
        this.playery = b;
        this.playerhp = c;
        this.playertotalhp = q;
        this.playerlevel = d;
        this.playergold = e;
        this.playername = f;
        this.playerskill = g;
        this.lvl1trapfinder = h;
        this.lvl1stoneskin = i;
        this.lvl1goldentouch = j;
        this.lvl2trapfinder = k;
        this.lvl2stoneskin = l;
        this.lvl2goldentouch = m;
        this.lvl3trapfinder = n;
        this.lvl3stoneskin = o;
        this.lvl3goldentouch = p;
    }

    public int getPlayerx() {
        return playerx;
    }

    public int getPlayery() {
        return playery;
    }

    public int getPlayerhp() {
        return playerhp;
    }

    public int getPlayertotalhp() {
        return playertotalhp;
    }

    public int getPlayerlevel() {
        return playerlevel;
    }

    public int getPlayergold() {
        return playergold;
    }

    public String getPlayername() {
        return playername;
    }

    public String getPlayerskill() {
        return playerskill;
    }

    public boolean isLvl1trapfinder() {
        return lvl1trapfinder;
    }

    public boolean isLvl1stoneskin() {
        return lvl1stoneskin;
    }

    public boolean isLvl1goldentouch() {
        return lvl1goldentouch;
    }

    public boolean isLvl2trapfinder() {
        return lvl2trapfinder;
    }

    public boolean isLvl2stoneskin() {
        return lvl2stoneskin;
    }

    public boolean isLvl2goldentouch() {
        return lvl2goldentouch;
    }

    public boolean isLvl3trapfinder() {
        return lvl3trapfinder;
    }

    public boolean isLvl3stoneskin() {
        return lvl3stoneskin;
    }

    public boolean isLvl3goldentouch() {
        return lvl3goldentouch;
    }

    public char getPlayersymbol() {
        return playersymbol;
    }

    public void setPlayerx(int playerx) {
        this.playerx = playerx;
    }

    public void setPlayery(int playery) {
        this.playery = playery;
    }

    public void setPlayerhp(int playerhp) {
        this.playerhp = playerhp;
    }

    public void setPlayertotalhp(int playertotalhp) {
        this.playertotalhp = playertotalhp;
    }

    public void setPlayerlevel(int playerlevel) {
        this.playerlevel = playerlevel;
    }

    public void setPlayergold(int playergold) {
        this.playergold = playergold;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public void setPlayerskill(String playerskill) {
        this.playerskill = playerskill;
    }

    public void setLvl1trapfinder(boolean lvl1trapfinder) {
        this.lvl1trapfinder = lvl1trapfinder;
    }

    public void setLvl1stoneskin(boolean lvl1stoneskin) {
        this.lvl1stoneskin = lvl1stoneskin;
    }

    public void setLvl1goldentouch(boolean lvl1goldentouch) {
        this.lvl1goldentouch = lvl1goldentouch;
    }

    public void setLvl2trapfinder(boolean lvl2trapfinder) {
        this.lvl2trapfinder = lvl2trapfinder;
    }

    public void setLvl2stoneskin(boolean lvl2stoneskin) {
        this.lvl2stoneskin = lvl2stoneskin;
    }

    public void setLvl2goldentouch(boolean lvl2goldentouch) {
        this.lvl2goldentouch = lvl2goldentouch;
    }

    public void setLvl3trapfinder(boolean lvl3trapfinder) {
        this.lvl3trapfinder = lvl3trapfinder;
    }

    public void setLvl3stoneskin(boolean lvl3stoneskin) {
        this.lvl3stoneskin = lvl3stoneskin;
    }

    public void setLvl3goldentouch(boolean lvl3goldentouch) {
        this.lvl3goldentouch = lvl3goldentouch;
    }

    public void setPlayersymbol(char playersymbol) {
        this.playersymbol = playersymbol;
    }
    
}

