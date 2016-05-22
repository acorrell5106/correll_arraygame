package array.game;

public class Trap {
    public int trapx;
    public int trapy;
    public boolean trapintersected;
    
    public Trap (int a, int b, boolean c) {
        this.trapx = a;
        this.trapy = b;
        this.trapintersected = c;
    }

    public int getTrapx() {
        return trapx;
    }

    public int getTrapy() {
        return trapy;
    }

    public boolean isTrapintersected() {
        return trapintersected;
    }
    

    public void setTrapx(int trapx) {
        this.trapx = trapx;
    }

    public void setTrapy(int trapy) {
        this.trapy = trapy;
    }

    public void setTrapintersected(boolean trapintersected) {
        this.trapintersected = trapintersected;
    }
    
}

