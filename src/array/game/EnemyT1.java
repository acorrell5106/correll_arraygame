package array.game;

public class EnemyT1 {
    
    //created Enemy class - 5 points
    
    public int enemyt1x;
    public int enemyt1y;
    public int enemyt1damage;
    //public int enemyt1hp;
    
    public EnemyT1 (int a, int b, int c/*, int d*/) {
        this.enemyt1x = a;
        this.enemyt1y = b;
        this.enemyt1damage = c;
    }

    public int getEnemyt1x() {
        return enemyt1x;
    }

    public int getEnemyt1y() {
        return enemyt1y;
    }

    public void setEnemyt1x(int enemyt1x) {
        this.enemyt1x = enemyt1x;
    }

    public void setEnemyt1y(int enemyt1y) {
        this.enemyt1y = enemyt1y;
    }

    public int getEnemyt1damage() {
        return enemyt1damage;
    }
    
    public void setEnemyt1damage(int enemyt1damage) {
        this.enemyt1damage = enemyt1damage;
    }

    /*public int getEnemyt1hp() {
        return enemyt1hp;
    }

    public void setEnemyt1hp(int enemyt1hp) {
        this.enemyt1hp = enemyt1hp;
    }*/
    
}

