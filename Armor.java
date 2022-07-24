package Paket4.C_5;

public class Armor {
    private int ID;
    private String name;
    private int block;
    private int price;

    public Armor(int ID, String name, int block, int price) {
        this.ID = ID;
        this.name = name;
        this.block = block;
        this.price = price;
    }


    public static Armor[] Armors(){
        Armor[] armorList=new Armor[3];
        armorList[0]=new Armor(1,"Hafif",1,15);
        armorList[1]=new Armor(2,"Orta",3,25);
        armorList[2]=new Armor(3,"Ağır",5,45);
        return armorList;

    }

    public static Armor getArmorObjID(int id){

        for (Armor a: Armor.Armors()) {
            if (a.getID()==id){
                return a;
            }
        }
        return null;
    }














    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
