package Paket5_SınıfCesitleri.D_7_Odev;

public class MyList <T> {
    public T[] list;
    public T[] list2;
    public T[] list3;
    public Integer Capacity =0;
    public Integer l=0;

    public MyList() {
        setCapacity(10);
        creatList(10,1);
    }

    public MyList(Integer capasity){
        setCapacity(capasity);
        creatList(capasity,1);
    }

    public void creatList(int capacity, int a){
        if(a==1){
            this.list=(T[]) new Object[capacity];
        }else{
            this.list2=(T[]) new Object[capacity];
        }

    }
    public MyList<T> subList(int start,int finish){
        MyList<T> altL = new MyList<>();
        int b=0;
        for (int i=start;i<=finish;i++){
            altL.add(list[i]);
        }
        return altL;
    }

    public void add(T data){
        if (getL()+1> getCapacity()){
            setCapacity(getCapacity()*2);
            creatList(getCapacity(),5);
            for(int i=0;i< list.length;i++){
                list2[i]=list[i];
            }
            creatList(getCapacity(),1);
            list=list2;
        }
        list[getL()]=data;
        setL(getL()+1);
    }

    public T get(int index){
        if (index+1> getCapacity()){
            return null;
        }
        return list[index];
    }
    public T[] set(int index,T data){
        if (index> getCapacity()-1){
            return null;
        }
        list[index]=data;
        return list;
    }
    public T[] remove(int index){
        if (index> getCapacity()-1){
            return null;
        }
        //creatList(getCapasity(),5);
        //list2=list;
        for (int i=index;i<list.length-1;i++){
            list[i]=list[i+1];
        }
        setL(getL()-1);
        return list;

    }
    @Override
    public String toString() {
        creatList(getL()-1,5);
        System.out.print("[");

        for (int i=0;i<=list2.length;i++){
            if(i!=0 && list[i]!=null){
                System.out.print(",");
            }
            if (list[i]!=null){
                System.out.print(list[i]);
            }

        }
        return "]";
    }

    public int indexOf(T data){
        for (int i=0;i< list.length;i++){
            if (list[i]==data){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T data){
        for (int i=list.length-1;i>-1;i--){
            if (list[i]==data){
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty() {
        if (getL()==0){
            return true;
        }
        return false;
    }
    public T[] toArray() {
        return list;
    }

    public void clear(){
        creatList(getCapacity(),1);
    }





    public boolean contains(T data){
        for (int i=0;i<list.length;i++){
            if (data==list[i]){
                return true;
            }
        }

        return false;
    }
    public Integer size(){
        return this.getL();
    }

    public Integer getCapacity() {
        return Capacity;
    }

    public void setCapacity(Integer capacity) {
        Capacity = capacity;
    }

    public Integer getL() {
        return l;
    }

    public void setL(Integer l) {
        this.l = l;
    }
}
