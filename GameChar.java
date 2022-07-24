package Paket4.C_5;

public abstract class GameChar {
    private int ID;
    private String name;
    private int damage;
    private int health;
    private int money;
    private int locControl1;
    private int locControl2;
    private int locControl3;


    public GameChar(int ID,String name, int damage, int health, int money,int locControl1, int locControl2,int locControl3) {
        this.name=name;
        this.ID = ID;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.locControl1=locControl1;
        this.locControl2=locControl2;
        this.locControl3=locControl3;

    }



    public int getLocControl3() {
        return locControl3;
    }

    public void setLocControl3(int locControl3) {
        this.locControl3 = locControl3;
    }

    public int getLocControl2() {
        return locControl2;
    }

    public void setLocControl2(int locControl2) {
        this.locControl2 = locControl2;
    }

    public int getLocControl1() {
        return locControl1;
    }

    public void setLocControl1(int locControl1) {
        this.locControl1 = locControl1;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
