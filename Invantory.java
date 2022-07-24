package Paket4.C_5;




public class Invantory {
    private Weapon weapon;
    private Armor armor;

    public Invantory() {
        this.weapon = new Weapon("Yumruk",-1,0,0);
        this.armor=new Armor(-1,"YOK",0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}

