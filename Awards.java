package Paket4.C_5;

public class Awards {
    private int awardNumber;
    private String award;
    String[] awardsList={"3","3","3"};
    private Location location;
    public Awards(int awardNumber,String award){
        this.award=award;
        this.awardNumber=awardNumber;


    }

    public void keepAwards(int awardNumber,String award){
        awardsList[awardNumber-2]=award;
    }

    public void printAward(){
        int b=1;
        for (int i=0;i<3;i++){
            if (awardsList[i].equals("3")){
                System.out.println(b+"- "+awardsList[i]);
                b++;
            }
        }
    }
}
