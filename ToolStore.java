package Paket4.C_5;


public class ToolStore extends normalLocation {
    public ToolStore(Player player) {
        super(player,"Mağaza",2);

    }
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz! ");
        boolean showMenu=true;
        while (showMenu){
            System.out.println("1-Silahlar ");
            System.out.println("2-Zırhlar ");
            System.out.println("3-Çıkış ");
            System.out.print("Lütfen birisini seçiniz: ");
            int selectCase=input.nextInt();
            while (selectCase<1 || selectCase>3){
                System.out.print("Geçersiz değer, ütfen tekrar seçiniz: ");
                selectCase=input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz! ");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon(){//??????????????????
        System.out.println("Silahlar: ");
        Weapon[] weapon= Weapon.weapons();
        for (int i = 0; i < weapon.length; i++) {
            Weapon w = weapon[i];
            System.out.println("ID: "+w.getId()+"\t\tİsim: " + w.getName() +
                    "\t\tHasar: " + w.getDamage() + "\t\tÜcret: " + w.getPrice());
        }
        System.out.println("0- Çıkış yap");
    }

    public void buyWeapon(){
        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID= input.nextInt();
        while (selectWeaponID<0 || selectWeaponID> Weapon.weapons().length){
            System.out.print("Geçersiz değer, lütfen tekrar seçiniz: ");
            selectWeaponID=input.nextInt();
        }

        if (selectWeaponID!=0){
            Weapon selectedWeapon= Weapon.getWeaponObjID(selectWeaponID);
            if(selectedWeapon!=null){
                if (selectedWeapon.getPrice()> getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır!! ");
                }else{
                    System.out.println(selectedWeapon.getName()+" silahını satın aldınız. ");
                    getPlayer().setMoney(getPlayer().getMoney()-selectedWeapon.getPrice());
                    System.out.println("Kalan bakiye: "+getPlayer().getMoney());

                    System.out.println("Önceki silehınız: "+this.getPlayer().getInvantory().getWeapon().getName());
                    this.getPlayer().getInvantory().setWeapon(selectedWeapon);
                    System.out.println("Şuanki silehınız: "+this.getPlayer().getInvantory().getWeapon().getName());

                }
            }
        }
    }


    public void printArmor(){
        System.out.println("Zırhlar: ");
        for (Armor a: Armor.Armors()) {
            System.out.println("ID: "+a.getID()+"\t\tİsim: " + a.getName() + "\t\tHasar: " +
                    a.getBlock() + "\t\tÜcret: " + a.getPrice());
        }
        System.out.println("0- Çıkış yap");

    }

    public void buyArmor(){
        System.out.print("Bir zırh seçiniz: ");
        int selectArmorID= input.nextInt();
        while (selectArmorID<0 || selectArmorID> Armor.Armors().length){
            System.out.print("Geçersiz değer, ütfen tekrar seçiniz: ");
            selectArmorID=input.nextInt();
        }
        if (selectArmorID!=0){
            Armor selectedArmor= Armor.getArmorObjID(selectArmorID);
            if (selectedArmor!=null){
                if (selectedArmor.getPrice()> this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır!! ");
                }else{
                    System.out.println(selectedArmor.getName()+" zırhını satın aldınız! ");
                    int balance=this.getPlayer().getMoney()-selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInvantory().setArmor(selectedArmor);
                    System.out.println("Kalan bakiye: "+getPlayer().getMoney());


                }
            }
        }


    }



}