package Paket4.C_5;


import java.util.Scanner;

public class Player {
    private String name;
    private String charName;
    private int ID;
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private int locControl1;
    private int locControl2;
    private int locControl3;


    private Scanner input = new Scanner(System.in);
    private Invantory invantory;




    public Player(String name) {
        this.name = name;
        this.invantory = new Invantory();

    }

    public void selectChar() {
        System.out.println("======================================================================================");
        System.out.println("Karakterler:");
        GameChar[] charList = {new Samuray(), new Sovalye(), new Okcu()};
        for (int i = 0; i < charList.length; i++) {
            System.out.println("ID: " + charList[i].getID() + "\t\tKarakter: " + charList[i].getName() + "\t\tHasar: " + charList[i].getDamage() +
                    "\t\tSağlık: " + charList[i].getHealth() + "\t\tPara: " + charList[i].getMoney());
        }
        System.out.print("Bir karakter ID si seçiniz: ");
        int selectaChar = input.nextInt();

        /* 1 2 3 girilmezse aşağıdaki hata verir.
        System.out.println("Karakter: "+charList[selectaChar-1].getName()+"\t\tHasar: "+charList[selectaChar-1].getDamage()+
                "\t\tSağlık: "+charList[selectaChar-1].getHealth()+"\t\tPara: "+charList[selectaChar-1].getMoney()); */

        switch (selectaChar) {
            case 1:
                initPlayer(new Samuray());
                break;
            case 2:
                initPlayer(new Sovalye());
                break;
            case 3:
                initPlayer(new Okcu());
                break;
            default:
                System.out.println("Geçerli bir rakam girilmediği için karakter samuray olarak alınmıştır! ");
                initPlayer(new Samuray());
        }
        System.out.println("ID: " + this.ID + "\t\tKarakter: " + this.getCharName() + "\t\tHasar: " + this.getDamage() +
                "\t\tSağlık: " + this.getHealth() + "\t\tPara: " + this.getMoney());
        System.out.println("======================================================================================");
    }



    public void initPlayer(GameChar gameChar) {
        setDamage(gameChar.getDamage());
        setHealth(gameChar.getHealth());
        setMoney(gameChar.getMoney());
        setID(gameChar.getID());
        setCharName(gameChar.getName());
        setOrjinalHealth(gameChar.getHealth());
        setLocControl1(gameChar.getLocControl1());
        setLocControl2(gameChar.getLocControl2());
        setLocControl3(gameChar.getLocControl3());

    }

    public void printPlayerInfo() {
        System.out.println("Hasarınız: " + this.getTotalDamage() + "\t\tSağlığınız: " + this.getHealth() +
                "\t\tParanız: " + this.getMoney() + "\t\tSilahınız: " + this.getInvantory().getWeapon().getName() +
                "\t\tZırhınız: " + this.getInvantory().getArmor().getName() +
                "\t\tBloclama: " + this.getInvantory().getArmor().getBlock());
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getTotalDamage() {
        return damage + this.getInvantory().getWeapon().getDamage();
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
    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Invantory getInvantory() {
        return invantory;
    }

    public void setInvantory(Invantory invantory) {
        this.invantory = invantory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }


}


