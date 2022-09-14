package Paket10_Thread.Odev;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main_Thread {
    public static class SelectNumber implements Runnable{
        private ArrayList<Integer> listT=new ArrayList<>();
        private ArrayList<Integer> listC=new ArrayList<>();
        private ArrayList<Integer> list1=new ArrayList<>();
        private ArrayList<Integer> list2=new ArrayList<>();
        private ArrayList<Integer> list3=new ArrayList<>();
        private ArrayList<Integer> list4=new ArrayList<>();
        private Integer number=1;
        private Object LOCK=new Object();


        @Override
        public void run() {
            synchronized (LOCK){
                //System.out.println(number+"- "+Thread.currentThread().getName());

                if (number<=2500){
                    list1.add(number);
                }else if (number<=5000){
                    list2.add(number);
                }else if (number<=7500){
                    list3.add(number);
                }else if (number<10001){
                    list4.add(number);
                }

                if (number%2==0){
                    listC.add(number);
                }else {
                    listT.add(number);
                }

                number++;
            }


        }

        public ArrayList<Integer> getListT() {
            return listT;
        }

        public ArrayList<Integer> getListC() {
            return listC;
        }

        public ArrayList<Integer> getList1() {
            return list1;
        }

        public void setList1(ArrayList<Integer> list1) {
            this.list1 = list1;
        }

        public ArrayList<Integer> getList2() {
            return list2;
        }

        public void setList2(ArrayList<Integer> list2) {
            this.list2 = list2;
        }

        public ArrayList<Integer> getList3() {
            return list3;
        }

        public void setList3(ArrayList<Integer> list3) {
            this.list3 = list3;
        }

        public ArrayList<Integer> getList4() {
            return list4;
        }

        public void setList4(ArrayList<Integer> list4) {
            this.list4 = list4;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Object getLOCK() {
            return LOCK;
        }

        public void setLOCK(Object LOCK) {
            this.LOCK = LOCK;
        }

        public void setListT(ArrayList<Integer> listT) {
            this.listT = listT;
        }

        public void setListC(ArrayList<Integer> listC) {
            this.listC = listC;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        SelectNumber s1 = new SelectNumber();

        ExecutorService executor = Executors.newFixedThreadPool(4);


        for (int i = 0;i<10000;i++){
            executor.execute(s1);

        }


        executor.shutdown();
        try {
            executor.awaitTermination(1000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tek sayıların bulunduğu dizinin eleman sayısı: "+s1.getListT().size());
        System.out.println("Çift sayıların bulunduğu dizinin eleman sayısı: "+s1.getListC().size());


        /*int i=1;
        for (Integer a: s1.getListT()){
            System.out.println(i+"- "+a);
            i++;
        }
        System.out.println("------------------------------------");

        i=1;
        for (Integer a: s1.getListC()){
            System.out.println(i+"- "+a);
            i++;
        }*/
        
    }
}
