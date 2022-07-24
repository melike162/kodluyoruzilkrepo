package Paket4.C_5;

import java.util.Random;

public class Snake extends Obstacle{
    private  int hasar2=randomHasar();
    private  int award2=randomAward();

    public Snake() {
        super(4,0 ,12,"yılan",0);
        setHasar(hasar2);
        setObsAward(award2);

    }

    public int randomHasar(){
        Random a = new Random();

        return a.nextInt(3)+3;
    }
    public int randomAward(){
        Random a = new Random();
        int awards=a.nextInt(99);
        int selec=a.nextInt(99);
        if (awards<=15){// silah
            if (selec<=20){//tüfek
                return 1;
            }else if(selec<=50){// kılıç
                return 2;
            }else{// tabanca
                return 3;
            }

        }if(awards>15 && awards<=30){// Zırh
            if (selec<=20){//ağır
                return 4;

            }else if(selec<=50){//orta
                return 5;

            }else{// hafif
                return 6;
            }


        }else if (awards>30 && awards<=55){ // para
            if (selec<=20){//10
                return 7;

            }else if(selec<=50){//5
                return 8;

            }else{//1
                return 9;
            }

        }else{// hiçbir şey
            return 0;

        }
    }

}
