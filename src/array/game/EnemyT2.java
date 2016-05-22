package array.game;

public class EnemyT2 {
    
    //second Enemy class - 5 points
    
    public int enemyt2x;
    public int enemyt2y;
    public int enemyt2damage;
    //public int enemyt2hp;
    
    public EnemyT2 (int a, int b, int c/*, int d*/) {
        this.enemyt2x = a;
        this.enemyt2y = b;
        this.enemyt2damage = c;
    }

    public int getEnemyt2x() {
        return enemyt2x;
    }

    public int getEnemyt2y() {
        return enemyt2y;
    }

    public void setEnemyt2x(int enemyt2x) {
        this.enemyt2x = enemyt2x;
    }

    public void setEnemyt2y(int enemyt2y) {
        this.enemyt2y = enemyt2y;
    }

    public int getEnemyt2damage() {
        return enemyt2damage;
    }
    
    public void setEnemyt2damage(int enemyt2damage) {
        this.enemyt2damage = enemyt2damage;
    }
    
    /*public int getEnemyt2hp() {
        return enemyt2hp;
    }

    public void setEnemyt2hp(int enemyt2hp) {
        this.enemyt2hp = enemyt2hp;
    }*/

}

