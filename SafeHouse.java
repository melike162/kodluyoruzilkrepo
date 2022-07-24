package Paket4.C_5;


public class SafeHouse extends normalLocation {
    private int awardName;
    public SafeHouse(Player player,int awardName) {
        super(player, "Güvenli ev",1);
        this.awardName=awardName;

    }


    @Override
    public boolean onLocation() {
        if (awardName==3){
            System.out.println("Oyunu kazandınız!!!");
            return false;
        }

        System.out.println("Güvenli evdesiniz! ");
        System.out.println("Canınız yenilendi! ");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        return true;
    }

}