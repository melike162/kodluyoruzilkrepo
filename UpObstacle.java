package Paket4.C_5;

public class

UpObstacle extends Obstacle{

    private int upAward;
    public UpObstacle(int ID, int hasar, int health, String name, int obsAward,int upAward) {
        super(ID, hasar, health, name, obsAward);
        this.upAward=upAward;
    }

    public int getUpAward() {
        return upAward;
    }

    public void setUpAward(int upAward) {
        this.upAward = upAward;
    }
}
