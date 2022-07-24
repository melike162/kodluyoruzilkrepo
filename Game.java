package Paket4.C_5;


import java.util.Scanner;

public class Game {
    private Scanner input= new Scanner(System.in);
    private int awardName;

    public void start(){
        System.out.println("Macera oyununa hoş geldiniz! ");
        System.out.print("Lütfen adınızı giriniz: ");
        String playerName=input.nextLine();
        Player player= new Player(playerName);
        System.out.println(player.getName()+" hoşgeldiniz! ");
        player.selectChar();


        while(true){
            awardName=0;
            if (player.getLocControl1()!=1 || player.getLocControl2()!=1  || player.getLocControl3()!=1){
                System.out.println("Kazanılan Ödüller: ");
                if (player.getLocControl1()!=1 ){
                    awardName++;
                    System.out.println(awardName+"- Ödül: Yemek");
                }
                if (player.getLocControl2()!=1 ){
                    awardName++;
                    System.out.println(awardName+"- Ödül: Odun");
                }
                if (player.getLocControl3()!=1){
                    awardName++;
                    System.out.println(awardName+"- Ödül: Su");
                }
            }

            player.printPlayerInfo();
            Location location=null;
            System.out.println("Yerler: ");
            Location[] locList={new SafeHouse(player,awardName),new ToolStore(player),new Cave(player),new Forest(player),new River(player),new Coal(player)};
            for(int i=0; i<locList.length; i++){


                if (i<2){
                    System.out.println("ID: "+locList[i].getLocID()+"\t\tYer: "+locList[i].getLocationName());
                }else if (i==2){
                    System.out.println("ID: "+locList[i].getLocID()+"\t\tYer: "+locList[i].getLocationName()+"\t\tCanavar: Zombi"+"\t\tÖdül: Yemek");
                }
                else if (i==3){
                    System.out.println("ID: "+locList[i].getLocID()+"\t\tYer: "+locList[i].getLocationName()+"\t\tCanavar: Vampir"+"\t\tÖdül: Odun");
                }else if(i==4){
                    System.out.println("ID: "+locList[i].getLocID()+"\t\tYer: "+locList[i].getLocationName()+"\t\tCanavar: Ayı"+"\t\tÖdül: Su");

                }  else{

                    System.out.println("ID: "+locList[i].getLocID()+"\t\tYer: "+locList[i].getLocationName()+"\t\tCanavar: Yılan"+"\t\tÖdül: Silah/oyun/para/hiçbir şey");
                }

            }
            System.out.println("ID: 0\t\tÇıkış yap");
            System.out.print("Gitmek istediğiniz yerin ID sini yazınız: ");
            int selectaloc=input.nextInt();
            switch (selectaloc){
                case 0:
                    location=null;
                    break;
                case 1:
                    location= new SafeHouse(player,awardName);
                    break;
                case 2:
                    location= new ToolStore(player);
                    break;
                case 3:
                    location= new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);

                    break;
                case 5:
                    location=new River(player);
                    break;
                case 6:
                    location=new Coal(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz!! ");
            }

            System.out.println("======================================================================================");

            if (location==null){
                System.out.println("Oyun bitti görüşmek üzere! ");
                break;
            }
            // location.onLocation();
            if(!location.onLocation()){
                System.out.println("Oyun bitti....");
                break;
            }

        }









    }
}
