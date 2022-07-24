package Paket4.C_5;


import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;



    public BattleLoc(Player player, String locationName, int LocID, Obstacle obstacle, String award, int maxObstacle) {
        super(player, locationName, LocID);
        this.award=award;
        this.obstacle=obstacle;
        this.maxObstacle=maxObstacle;

    }
    
    @Override
    public boolean onLocation() {
        boolean con=true;
        if(controlHit() && con){
            int obsNumber=randomObstacleNumber();
            System.out.println("Şuan buradasınız: "+this.getLocationName());
            System.out.println("Dikkatli ol!! Burada "+obsNumber+" tane "+this.getObstacle().getName()+" yaşıyor. ");
            System.out.print("S- Savaş\t\tK- Kaç: ");
            String selectCase=input.nextLine();
            selectCase=selectCase.toUpperCase();// küçük harf girerse büyütüyor, büyükse aynı
            if (selectCase.equals("K")){
                con=false;
            }
            if (selectCase.equals("S")){// Stringlerde böyle
                System.out.println("Savaş işlemleri olacak");
                if (combat(obsNumber)){
                    System.out.println(this.getPlayer().getName()+" tüm düşmanları yendiniz! ");
                    if (getLocID()==6){
                        switch (getObstacle().getObsAward()){
                            case 1:
                                System.out.println("Kazanç: Tüfek");
                                getPlayer().setDamage(getPlayer().getTotalDamage()+7);
                                break;
                            case 2:
                                System.out.println("Kazanç: Kılıç ");
                                getPlayer().setDamage(getPlayer().getTotalDamage()+3);
                                break;
                            case 3:
                                System.out.println("Kazanç: Tabanca");
                                getPlayer().setDamage(getPlayer().getTotalDamage()+2);
                                break;
                            case 4:
                                System.out.println("Kazanç: Ağır kalkan");
                                this.getPlayer().getInvantory().getArmor().setBlock(this.getPlayer().getInvantory().getArmor().getBlock()+5);
                                break;
                            case 5:
                                System.out.println("Kazanç: Orta kalkan");
                                this.getPlayer().getInvantory().getArmor().setBlock(this.getPlayer().getInvantory().getArmor().getBlock()+3);
                                break;
                            case 6:
                                System.out.println("Kazanç: Hafif kalkan");
                                this.getPlayer().getInvantory().getArmor().setBlock(this.getPlayer().getInvantory().getArmor().getBlock()+1);
                                break;
                            case 7:
                                System.out.println("Kazanç: 10");
                                getPlayer().setMoney(getPlayer().getMoney()+10);
                                break;
                            case 8:
                                System.out.println("Kazanç: 5");
                                getPlayer().setMoney(getPlayer().getMoney()+5);
                                break;
                            case 9:
                                System.out.println("Kazanç: 1");
                                getPlayer().setMoney(getPlayer().getMoney()+1);
                                break;
                            default:
                                System.out.println("Kazanç: Hiçbir şey");
                        }
                    }
                    changeControl();
                    return true;
                }
            }
        }else{
            System.out.println("Burda daha önce savaştınız ve ödülü aldınız artık savaşamazsınız!!!!!");
        }






        if (getPlayer().getHealth()<=0){
            System.out.println("ÖLdünüz! ");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber){

        for (int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(getObstacle().getOrjinalHealth());
            System.out.println("-------------------------------------------------------------------------");
            playerStarts();
            obstacleStarts(i);
            int selectedRandomHit=randomHit();
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){

                if (selectedRandomHit == 1){
                    System.out.print("v- Vur\t\tK- Kaç: ");
                    String selectCombat=input.nextLine().toUpperCase();// küçük harf girerse büyütüyor, büyükse aynı
                    if (selectCombat.equals("V")){
                        System.out.println("Siz vurdunuz! ");
                        this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                        if (this.getObstacle().getHealth()>0){
                            System.out.println("Canavar size vurdu! ");
                            int obtacleDamage=this.getObstacle().getHasar()-this.getPlayer().getInvantory().getArmor().getBlock();
                            if (obtacleDamage<0){
                                obtacleDamage=0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-obtacleDamage);
                        }
                        afterHit();
                    }else{
                        return false;
                    }
                }if (selectedRandomHit == 0){

                    System.out.print("v- Vur\t\tK- Kaç: ");
                    String selectCombat=input.nextLine().toUpperCase();// küçük harf girerse büyütüyor, büyükse aynı
                    if (selectCombat.equals("V")){
                        if (this.getObstacle().getHealth()>0){
                            System.out.println("Canavar size vurdu! ");
                            int obtacleDamage=this.getObstacle().getHasar()-this.getPlayer().getInvantory().getArmor().getBlock();
                            if (obtacleDamage<0){
                                obtacleDamage=0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-obtacleDamage);
                        }
                        System.out.println("Siz vurdunuz! ");
                        this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                        afterHit();

                    }else{
                        return false;
                    }

                }
            }
            if (getObstacle().getHealth()<this.getPlayer().getHealth() ){
                if (getLocID()!=6){
                    System.out.println("Düşmanı yendiniz! ");
                    System.out.println("Kazanılan para: "+this.getObstacle().getObsAward());
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getObsAward());
                    System.out.println("Güncel paranız: "+this.getPlayer().getMoney());
                }

            }else{
                return false;
            }

        }
        return true;
    }

    public void afterHit(){
        System.out.println("Sağlığınız: "+getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" sağlığı: "+this.getObstacle().getHealth());
        System.out.println("-------------------------------------------------------------------------");
    }

    private boolean controlHit(){
        if (this.getLocID()-2==1 ){
            if (getPlayer().getLocControl1()==1){
                return true;
            }else{
                return false;
            }
        }else if(this.getLocID()-2==2){
            if (getPlayer().getLocControl2()==1){
                return true;
            }else{
                return false;
            }
        }else if(this.getLocID()-2==3){
            if (getPlayer().getLocControl3()==1){
                return true;
            }else{
                return false;
            }
        } else{
            return true;
        }


    }

    public void changeControl(){
        if (this.getLocID()-2==1 ){
            this.getPlayer().setLocControl1(2);
        }else if(this.getLocID()-2==2){
            this.getPlayer().setLocControl2(2);

        }else if(this.getLocID()-2==3){
            this.getPlayer().setLocControl3(2);
        }

    }





    public void playerStarts(){
        System.out.println("Oyuncu değerleri: ");
        System.out.println("Karakter: "+getPlayer().getCharName()+"\t\tHasar: "+getPlayer().getTotalDamage()+
                "\t\tSağlık: "+getPlayer().getHealth()+"\t\tPara: "+getPlayer().getMoney()+
                "\t\tSilah: "+getPlayer().getInvantory().getWeapon().getName()+
                "\t\tZırh: "+getPlayer().getInvantory().getArmor().getName()+
                "\t\tBloklama: "+getPlayer().getInvantory().getArmor().getBlock());

    }
    public void obstacleStarts(int i){
        System.out.println(i+". "+this.getObstacle().getName()+" değerleri: ");
        System.out.println("Sağlık: "+this.getObstacle().getHealth()+"\t\tHasar: "+this.getObstacle().getHasar()+
                "\t\tÖdül: "+this.getObstacle().getObsAward());
    }


    public int randomHit(){
        Random r=new Random();
        return r.nextInt(2);// içerisine 3 yazarsan 0-2 arasında değer üretir
    }

    public int randomObstacleNumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxObstacle())+1;// içerisine 3 yazarsan 0-2 arasında değer üretir
    }


    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


}