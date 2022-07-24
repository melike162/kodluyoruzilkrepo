package Paket4.C_5;

public abstract class Obstacle {
    private int ID;
    private int hasar;
    private int health;
    private String name;
    private int obsAward;
    private  int orjinalHealth;

    public Obstacle(int ID, int hasar, int health, String name,int obsAward) {
        this.ID = ID;
        this.hasar = hasar;
        this.health = health;
        this.orjinalHealth = health;
        this.name = name;
        this.obsAward=obsAward;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public int getObsAward() {
        return obsAward;
    }

    public void setObsAward(int obsAward) {
        this.obsAward = obsAward;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getHasar() {
        return hasar;
    }

    public void setHasar(int hasar) {
        this.hasar = hasar;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
